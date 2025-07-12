import http from 'k6/http';
import { check } from 'k6';

export const options = {
    stages: [
        { duration: '5s', target: 50 }, // Ramp-up to 50 users over 5 seconds
        { duration: '10s', target: 50 }, // Stay at 50 users for 10 seconds
        { duration: '5s', target: 0 },   // Ramp-down to 0 users
    ],
    thresholds: {
        'http_req_failed': ['rate<0.01'], // Fail the test if more than 1% of requests fail
        'http_req_duration': ['p(95)<200'], // Fail if 95% of requests are slower than 200ms
    },
};

export default function () {
    const url = 'http://localhost:8080/api/shorten';
    const payload = JSON.stringify({
        url: `https://example.com/${Math.random()}`,
    });

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const res = http.post(url, payload, params);

    check(res, {
        'status is 200': (r) => r.status === 200,
    });
}
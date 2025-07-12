import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 5, // 5 virtual users
    duration: '10s', // for 10 seconds
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

    sleep(1); // wait for 1 second between requests
}
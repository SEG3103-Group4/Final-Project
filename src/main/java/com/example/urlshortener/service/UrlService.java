package com.example.urlshortener.service;

import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Service
public class UrlService {

    private final Map<String, String> shortToLongUrl = new ConcurrentHashMap<>();
    private final Map<String, String> longToShortUrl = new ConcurrentHashMap<>();
    private final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

    @Value("${rate-limiting.enabled:false}")
    private boolean rateLimitingEnabled;

    @Value("${rate-limiting.permits:10}")
    private int maxPermits;

    private Semaphore semaphore;

    @PostConstruct
    public void init() {
        if (rateLimitingEnabled) {
            // Only create the semaphore if the feature is enabled
            this.semaphore = new Semaphore(maxPermits, true); // Use true for fairness
            System.out.println("✅ Rate limiting ENABLED with " + maxPermits + " permits.");
        } else {
            System.out.println("❌ Rate limiting DISABLED.");
        }
    }

    public String shortenUrl(String longUrl) {
        if (!urlValidator.isValid(longUrl)) {
            throw new IllegalArgumentException("Invalid URL provided: " + longUrl);
        }

        // The rate-limiting logic is now encapsulated in its own method for clarity.
        // This method will only have an effect if rateLimitingEnabled is true.
        applyRateLimiting();

        if (longToShortUrl.containsKey(longUrl)) {
            return longToShortUrl.get(longUrl);
        }

        String shortCode = generateUniqueShortCode();
        shortToLongUrl.put(shortCode, longUrl);
        longToShortUrl.put(longUrl, shortCode);
        return shortCode;
    }

    /**
     * Helper method to apply the rate-limiting logic.
     * It checks the 'rateLimitingEnabled' flag internally.
     */
    private void applyRateLimiting() {
        // This entire block of logic is now self-contained.
        // If the flag is false, this method does nothing.
        if (!rateLimitingEnabled) {
            return; // Exit immediately if not enabled
        }

        boolean permitAcquired = false;
        try {
            System.out.println("Applying rate limit delay...");
            // Try to acquire a permit, waiting a maximum of 500ms
            permitAcquired = semaphore.tryAcquire(500, TimeUnit.MILLISECONDS);
            if (!permitAcquired) {
                System.err.println("COULD NOT ACQUIRE SEMAPHORE PERMIT - SERVER TOO BUSY");
                throw new RuntimeException("Server is too busy to handle the request.");
            }

            // Simulate a slow operation (e.g., a slow database call)
            Thread.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Request was interrupted.", e);
        } finally {
            if (permitAcquired) {
                semaphore.release();
            }
        }
    }

    public Optional<String> getOriginalUrl(String shortCode) {
        return Optional.ofNullable(shortToLongUrl.get(shortCode));
    }

    public Map<String, String> getAllUrls() {
        return shortToLongUrl;
    }

    private String generateUniqueShortCode() {
        String shortCode;
        do {
            shortCode = RandomStringUtils.randomAlphanumeric(7);
        } while (shortToLongUrl.containsKey(shortCode));
        return shortCode;
    }
}

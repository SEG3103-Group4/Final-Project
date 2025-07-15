package com.example.urlshortener.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;
import java.util.concurrent.Semaphore;

import static org.junit.jupiter.api.Assertions.*;

class UrlServiceTester {
    private UrlService urlService;

    @BeforeEach
    void setUp() {
        urlService = new UrlService();
    }

    @Test
    void shortenUrl_validUrl_noRateLimiting() {
        ReflectionTestUtils.setField(urlService, "rateLimitingEnabled", false);
        urlService.init();

        //the urls used in this test are randomly chosen from online
        String longUrl = "https://dictionary.cambridge.org/grammar/british-grammar/formal-and-informal-language#google_vignette";
        String shortCode = urlService.shortenUrl(longUrl);

        assertNotNull(shortCode);
        assertEquals(Optional.of(longUrl), urlService.getOriginalUrl(shortCode));
        assertEquals(shortCode, urlService.shortenUrl(longUrl)); // same result on repeat
    }

    @Test
    void shortenUrl_invalidUrl_throwsException() {
        ReflectionTestUtils.setField(urlService, "rateLimitingEnabled", false);
        urlService.init();

        String invalidUrl = "htop:/invalid-url";
        assertThrows(IllegalArgumentException.class, () -> urlService.shortenUrl(invalidUrl));
    }

    @Test
    void getOriginalUrl_unknownShortCode_returnsEmptyOptional() {
        assertTrue(urlService.getOriginalUrl("nonexistent").isEmpty());
    }

    @Test
    void getAllUrls_returnsExpectedMappings() {
        ReflectionTestUtils.setField(urlService, "rateLimitingEnabled", false);
        urlService.init();

        String longUrl = "https://www.geeksforgeeks.org/operating-systems/what-is-command-line-interface-cli/";
        String shortCode = urlService.shortenUrl(longUrl);

        assertEquals(1, urlService.getAllUrls().size());
        assertEquals(longUrl, urlService.getAllUrls().get(shortCode));
    }

    @Test
    void shortenUrl_rateLimitingEnabled_permitAcquired() {
        ReflectionTestUtils.setField(urlService, "rateLimitingEnabled", true);
        ReflectionTestUtils.setField(urlService, "maxPermits", 1);
        urlService.init();

        String longUrl = "https://www.geeksforgeeks.org/operating-systems/what-is-command-line-interface-cli/";
        String shortCode = urlService.shortenUrl(longUrl);

        assertNotNull(shortCode);
    }

    @Test
    void shortenUrl_rateLimitingEnabled_permitTimeout() {
        ReflectionTestUtils.setField(urlService, "rateLimitingEnabled", true);
        ReflectionTestUtils.setField(urlService, "maxPermits", 1);
        urlService.init();

        Semaphore semaphore = (Semaphore) ReflectionTestUtils.getField(urlService, "semaphore");
        assertNotNull(semaphore);
        try {
            assertTrue(semaphore.tryAcquire());
            assertThrows(RuntimeException.class, () -> urlService.shortenUrl("https://www.geeksforgeeks.org/operating-systems/what-is-command-line-interface-cli/"));
        } finally {
            semaphore.release();
        }
    }
}
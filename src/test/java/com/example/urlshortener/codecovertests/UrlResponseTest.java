package com.example.urlshortener.codecovertests;

import com.example.urlshortener.model.UrlsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UrlResponseTest {

        private UrlsResponse instanceOfUrlResponse;
        private Map<String, String> sampleUrls;

        @BeforeEach
        public void setUp() {
            instanceOfUrlResponse = new UrlsResponse();
            sampleUrls = new HashMap<>();
            sampleUrls.put("Dictionary", "https://dictionary.cambridge.org/grammar/british-grammar/formal-and-informal-language#google_vignette");
            sampleUrls.put("openai", "https://www.geeksforgeeks.org/operating-systems/what-is-command-line-interface-cli/");
        }

        @Test
        public void testDefaultConstructor() {
            assertNotNull(instanceOfUrlResponse.getUrls());
            assertTrue(instanceOfUrlResponse.getUrls().isEmpty());
            assertEquals(0, instanceOfUrlResponse.getTotalCount());
        }

        @Test
        public void testFullArgConstructor() {
            UrlsResponse response = new UrlsResponse(sampleUrls, 2);
            assertEquals(sampleUrls, response.getUrls());
            assertEquals(2, response.getTotalCount());
        }

        @Test
        public void testSetAndGetUrls() {
            instanceOfUrlResponse.setUrls(sampleUrls);
            assertEquals(sampleUrls, instanceOfUrlResponse.getUrls());
        }

        @Test
        public void testSetAndGetTotalCount() {
            instanceOfUrlResponse.setTotalCount(5);
            assertEquals(5, instanceOfUrlResponse.getTotalCount());
        }
    }

package com.example.urlshortener.model;

import java.util.Map;

/**
 * A DTO (Data Transfer Object) for sending the list of URLs and the total count
 * to the frontend in a single response.
 */

public class UrlsResponse {
    private Map<String, String> urls;
    private int totalCount;

    public UrlsResponse(Map<String, String> urls, int totalCount) {
        this.urls = urls;
        this.totalCount = totalCount;
    }

    // Getters and Setters
    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}

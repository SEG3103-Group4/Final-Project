package com.example.urlshortener.model;

import jakarta.validation.constraints.NotEmpty;

public class ShortenRequest {
    @NotEmpty
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
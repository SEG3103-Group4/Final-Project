package com.example.urlshortener.controller;

import com.example.urlshortener.model.ShortenRequest;
import com.example.urlshortener.model.UrlsResponse;
import com.example.urlshortener.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*") // Allow any frontend to connect
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@Valid @RequestBody ShortenRequest request) {
        System.out.println("Received request to shorten URL: " + request.getUrl());
        try {
            String shortCode = urlService.shortenUrl(request.getUrl());
            System.out.println("Successfully shortened " + request.getUrl() + " to " + shortCode);
            return new ResponseEntity<Map<String, String>>(Collections.singletonMap("shortCode", shortCode), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            System.err.println("Error shortening URL " + request.getUrl() + ": " + e.getMessage());
            return new ResponseEntity<Map<String, String>>(Collections.singletonMap("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Updated endpoint to return both the map of all URLs and the total count.
     * The frontend will handle displaying only the most recent 100.
     */
    @GetMapping("/api/urls")
    public ResponseEntity<UrlsResponse> getAllUrls() {
        Map<String, String> allUrls = urlService.getAllUrls();
        int totalCount = allUrls.size();
        UrlsResponse response = new UrlsResponse(allUrls, totalCount);
        return new ResponseEntity<UrlsResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String code) {
        System.out.println("Received request to redirect for code: " + code);

        Optional<String> originalUrlOptional = urlService.getOriginalUrl(code);

        if (originalUrlOptional.isPresent()) {
            String url = originalUrlOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(url));
            System.out.println("Redirecting " + code + " to " + url);
            return new ResponseEntity<Void>(headers, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}

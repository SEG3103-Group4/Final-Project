package com.example.urlshortener.codecovertests;
import com.example.urlshortener.controller.UrlController;
import com.example.urlshortener.model.ShortenRequest;
import com.example.urlshortener.model.UrlsResponse;
import com.example.urlshortener.service.UrlService;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class UrlControllerTester {
    public static void main(String[] args) {
        UrlService urlService = new UrlService();

        UrlController controller = new UrlController(urlService);
        String baseUrl = "local host server";

        ShortenRequest request = new ShortenRequest();
        request.setUrl("https://en.wikipedia.org/wiki/Code_coverage");
        ResponseEntity<Map<String, String>> response = controller.shortenUrl(request);
        System.out.println("shortenUrl response: " + response.getBody());

        // getting the shortcode
        String shortCode = response.getBody().get("shortCode");
        System.out.println("Generated shortCode: " + shortCode);
        String fullShortenedUrl = baseUrl + shortCode;
        System.out.println("Full shortened URL: " + fullShortenedUrl);

        // test getAllUrls
        ResponseEntity<UrlsResponse> allUrlsResponse = controller.getAllUrls();
        System.out.println("getAllUrls response: " + allUrlsResponse.getBody());

        // test redirectToOriginalUrl
        ResponseEntity<Void> redirectResponse = controller.redirectToOriginalUrl(shortCode);
        System.out.println("redirectToOriginalUrl status: " + redirectResponse.getStatusCode());
    }
}
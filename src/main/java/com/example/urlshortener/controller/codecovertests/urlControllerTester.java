package com.example.urlshortener.controller.codecovertests;
import com.example.urlshortener.controller.UrlController;
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

public class urlControllerTester {
    public static void main(String[] args) {
        UrlService urlService = new UrlService();

        UrlController controller = new UrlController(urlService);

        ShortenRequest request = new ShortenRequest();
        request.setUrl("https://en.wikipedia.org/wiki/Code_coverage");
        ResponseEntity<Map<String, String>> response = controller.shortenUrl(request);
        System.out.println("shortenUrl response: " + response.getBody());

        // getting the shortcode
        String shortCode = response.getBody().get("shortCode");
        System.out.println("Generated shortCode: " + shortCode);

        // test getAllUrls
        ResponseEntity<UrlsResponse> allUrlsResponse = controller.getAllUrls();
        System.out.println("getAllUrls response: " + allUrlsResponse.getBody());

        // test redirectToOriginalUrl
        ResponseEntity<Void> redirectResponse = controller.redirectToOriginalUrl(shortCode);
        System.out.println("redirectToOriginalUrl status: " + redirectResponse.getStatusCode());
    }
}
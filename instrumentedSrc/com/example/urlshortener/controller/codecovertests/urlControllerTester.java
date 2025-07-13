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
  static {
    CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.ping();
  }

    public static void main(String[] args) {
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[1]++;
        UrlService urlService = new UrlService();
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[2]++;

        UrlController controller = new UrlController(urlService);
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[3]++;

        ShortenRequest request = new ShortenRequest();
        request.setUrl("https://en.wikipedia.org/wiki/Code_coverage");
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[4]++;
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[5]++;
        ResponseEntity<Map<String, String>> response = controller.shortenUrl(request);
        System.out.println("shortenUrl response: " + response.getBody());
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[6]++;
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[7]++;

        // getting the shortcode
        String shortCode = response.getBody().get("shortCode");
        System.out.println("Generated shortCode: " + shortCode);
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[8]++;
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[9]++;

        // test getAllUrls
        ResponseEntity<UrlsResponse> allUrlsResponse = controller.getAllUrls();
        System.out.println("getAllUrls response: " + allUrlsResponse.getBody());
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[10]++;
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[11]++;

        // test redirectToOriginalUrl
        ResponseEntity<Void> redirectResponse = controller.redirectToOriginalUrl(shortCode);
        System.out.println("redirectToOriginalUrl status: " + redirectResponse.getStatusCode());
CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp.statements[12]++;
    }
}

class CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp extends org.codecover.instrumentation.java.measurement.CounterContainer {

  static {
    org.codecover.instrumentation.java.measurement.ProtocolImpl.getInstance(org.codecover.instrumentation.java.measurement.CoverageResultLogFile.getInstance(null), "19466ebd-6dec-4703-8e9f-67f2dcbb430c").addObservedContainer(new CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp ());
  }
    public static long[] statements = new long[13];
    public static long[] branches = new long[0];
    public static long[] loops = new long[1];

  public CodeCoverCoverageCounter$r2hbnkxquva9hs0i9pux7l6o2qessr87x5kyp () {
    super("com.example.urlshortener.controller.codecovertests.urlControllerTester.java");
  }

  public static void ping() {/* nothing to do*/}

  public void reset() {
      for (int i = 1; i <= 12; i++) {
        statements[i] = 0L;
      }
      for (int i = 1; i <= -1; i++) {
        branches[i] = 0L;
      }
      for (int i = 1; i <= 0; i++) {
        loops[i] = 0L;
      }
  }

  public void serializeAndReset(org.codecover.instrumentation.measurement.CoverageCounterLog log) {
    log.startNamedSection("com.example.urlshortener.controller.codecovertests.urlControllerTester.java");
      for (int i = 1; i <= 12; i++) {
        if (statements[i] != 0L) {
          log.passCounter("S" + i, statements[i]);
          statements[i] = 0L;
        }
      }
      for (int i = 1; i <= -1; i++) {
        if (branches[i] != 0L) {
          log.passCounter("B"+ i, branches[i]);
          branches[i] = 0L;
        }
      }
      for (int i = 1; i <= 0; i++) {
        if (loops[i * 3 - 2] != 0L) {
          log.passCounter("L" + i + "-0", loops[i * 3 - 2]);
          loops[i * 3 - 2] = 0L;
        }
        if ( loops[i * 3 - 1] != 0L) {
          log.passCounter("L" + i + "-1", loops[i * 3 - 1]);
          loops[i * 3 - 1] = 0L;
        }
        if ( loops[i * 3] != 0L) {
          log.passCounter("L" + i + "-2", loops[i * 3]);
          loops[i * 3] = 0L;
        }
      }
  }
}

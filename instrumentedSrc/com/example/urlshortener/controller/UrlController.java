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
  static {
    CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.ping();
  }


    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[1]++;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<Map<String, String>> shortenUrl(@Valid @RequestBody ShortenRequest request) {
        System.out.println("Received request to shorten URL: " + request.getUrl());
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[2]++;
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[3]++;
boolean CodeCoverTryBranchHelper_Try1 = false;
        try {
CodeCoverTryBranchHelper_Try1 = true;
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[4]++;
            String shortCode = urlService.shortenUrl(request.getUrl());
            System.out.println("Successfully shortened " + request.getUrl() + " to " + shortCode);
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[5]++;
            return new ResponseEntity<Map<String, String>>(Collections.singletonMap("shortCode", shortCode), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
CodeCoverTryBranchHelper_Try1 = false;
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.branches[2]++;
            System.err.println("Error shortening URL " + request.getUrl() + ": " + e.getMessage());
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[6]++;
            return new ResponseEntity<Map<String, String>>(Collections.singletonMap("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        } finally {
    if ( CodeCoverTryBranchHelper_Try1 ) {
  CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.branches[1]++;
}
  }
    }

    /**
     * Updated endpoint to return both the map of all URLs and the total count.
     * The frontend will handle displaying only the most recent 100.
     */
    @GetMapping("/api/urls")
    public ResponseEntity<UrlsResponse> getAllUrls() {
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[7]++;
        Map<String, String> allUrls = urlService.getAllUrls();
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[8]++;
        int totalCount = allUrls.size();
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[9]++;
        UrlsResponse response = new UrlsResponse(allUrls, totalCount);
        return new ResponseEntity<UrlsResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String code) {
        System.out.println("Received request to redirect for code: " + code);
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[10]++;
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[11]++;

        Optional<String> originalUrlOptional = urlService.getOriginalUrl(code);
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[12]++;
int CodeCoverConditionCoverageHelper_C1;

        if ((((((CodeCoverConditionCoverageHelper_C1 = 0) == 0) || true) && (
(((CodeCoverConditionCoverageHelper_C1 |= (2)) == 0 || true) &&
 ((originalUrlOptional.isPresent()) && 
  ((CodeCoverConditionCoverageHelper_C1 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.conditionCounters[1].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C1, 1) || true)) || (CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.conditionCounters[1].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C1, 1) && false)) {
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.branches[3]++;
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[13]++;
            String url = originalUrlOptional.get();
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[14]++;
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(url));
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[15]++;
            System.out.println("Redirecting " + code + " to " + url);
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.statements[16]++;
            return new ResponseEntity<Void>(headers, HttpStatus.FOUND);

        } else {
CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d.branches[4]++;
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}

class CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d extends org.codecover.instrumentation.java.measurement.CounterContainer {

  static {
    org.codecover.instrumentation.java.measurement.ProtocolImpl.getInstance(org.codecover.instrumentation.java.measurement.CoverageResultLogFile.getInstance(null), "79dd2941-3adb-4d33-b746-35ee6f9d0da2").addObservedContainer(new CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d ());
  }
    public static long[] statements = new long[17];
    public static long[] branches = new long[5];

  public static final org.codecover.instrumentation.java.measurement.ConditionCounter[] conditionCounters = new org.codecover.instrumentation.java.measurement.ConditionCounter[2];
  static {
    final String SECTION_NAME = "com.example.urlshortener.controller.UrlController.java";
    final byte[] CONDITION_COUNTER_TYPES = {0,1};
    for (int i = 1; i <= 1; i++) {
      switch (CONDITION_COUNTER_TYPES[i]) {
        case 0 : break;
        case 1 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.SmallOneConditionCounter(SECTION_NAME, "C" + i); break;
        case 2 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.SmallTwoConditionCounter(SECTION_NAME, "C" + i); break;
        case 3 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.MediumConditionCounter(SECTION_NAME, "C" + i); break;
        case 4 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.LargeConditionCounter(SECTION_NAME, "C" + i); break;
      }
    }
  }
    public static long[] loops = new long[1];

  public CodeCoverCoverageCounter$73t0t1qied8fkogmkm7f52dp8h9d () {
    super("com.example.urlshortener.controller.UrlController.java");
  }

  public static void ping() {/* nothing to do*/}

  public void reset() {
      for (int i = 1; i <= 16; i++) {
        statements[i] = 0L;
      }
      for (int i = 1; i <= 4; i++) {
        branches[i] = 0L;
      }
    for (int i = 1; i <= 1; i++) {
      if (conditionCounters[i] != null) {
        conditionCounters[i].reset();
      }
    }
      for (int i = 1; i <= 0; i++) {
        loops[i] = 0L;
      }
  }

  public void serializeAndReset(org.codecover.instrumentation.measurement.CoverageCounterLog log) {
    log.startNamedSection("com.example.urlshortener.controller.UrlController.java");
      for (int i = 1; i <= 16; i++) {
        if (statements[i] != 0L) {
          log.passCounter("S" + i, statements[i]);
          statements[i] = 0L;
        }
      }
      for (int i = 1; i <= 4; i++) {
        if (branches[i] != 0L) {
          log.passCounter("B"+ i, branches[i]);
          branches[i] = 0L;
        }
      }
    for (int i = 1; i <= 1; i++) {
      if (conditionCounters[i] != null) {
        conditionCounters[i].serializeAndReset(log);
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


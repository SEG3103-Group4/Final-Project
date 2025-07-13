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
  static {
    CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.ping();
  }


    private final Map<String, String> shortToLongUrl = new ConcurrentHashMap<String, String>();
  {
    CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[1]++;
  }
    private final Map<String, String> longToShortUrl = new ConcurrentHashMap<String, String>();
  {
    CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[2]++;
  }
    private final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
  {
    CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[3]++;
  }

    @Value("${rate-limiting.enabled:false}")
    private boolean rateLimitingEnabled;

    @Value("${rate-limiting.permits:10}")
    private int maxPermits;

    private Semaphore semaphore;

    @PostConstruct
    public void init() {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[4]++;
int CodeCoverConditionCoverageHelper_C1;
        if ((((((CodeCoverConditionCoverageHelper_C1 = 0) == 0) || true) && (
(((CodeCoverConditionCoverageHelper_C1 |= (2)) == 0 || true) &&
 ((rateLimitingEnabled) && 
  ((CodeCoverConditionCoverageHelper_C1 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[1].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C1, 1) || true)) || (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[1].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C1, 1) && false)) {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[1]++;
            this.semaphore = new Semaphore(maxPermits, true);
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[5]++;
            System.out.println("✅ Rate limiting ENABLED with " + maxPermits + " permits.");
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[6]++;

        } else {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[2]++;
            System.out.println("❌ Rate limiting DISABLED.");
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[7]++;
        }
    }

    public String shortenUrl(String longUrl) {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[8]++;
int CodeCoverConditionCoverageHelper_C2;
        if ((((((CodeCoverConditionCoverageHelper_C2 = 0) == 0) || true) && (!
(((CodeCoverConditionCoverageHelper_C2 |= (2)) == 0 || true) &&
 ((urlValidator.isValid(longUrl)) && 
  ((CodeCoverConditionCoverageHelper_C2 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[2].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C2, 1) || true)) || (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[2].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C2, 1) && false)) {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[3]++;
            throw new IllegalArgumentException("Invalid URL provided: " + longUrl);

        } else {
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[4]++;}

        applyRateLimiting();
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[9]++;
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[10]++;
int CodeCoverConditionCoverageHelper_C3;

        if ((((((CodeCoverConditionCoverageHelper_C3 = 0) == 0) || true) && (
(((CodeCoverConditionCoverageHelper_C3 |= (2)) == 0 || true) &&
 ((longToShortUrl.containsKey(longUrl)) && 
  ((CodeCoverConditionCoverageHelper_C3 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[3].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C3, 1) || true)) || (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[3].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C3, 1) && false)) {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[5]++;
            return longToShortUrl.get(longUrl);

        } else {
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[6]++;}
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[11]++;

        String shortCode = generateUniqueShortCode();
        shortToLongUrl.put(shortCode, longUrl);
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[12]++;
        longToShortUrl.put(longUrl, shortCode);
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[13]++;
        return shortCode;
    }

    private void applyRateLimiting() {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[14]++;
int CodeCoverConditionCoverageHelper_C4;
        if ((((((CodeCoverConditionCoverageHelper_C4 = 0) == 0) || true) && (!
(((CodeCoverConditionCoverageHelper_C4 |= (2)) == 0 || true) &&
 ((rateLimitingEnabled) && 
  ((CodeCoverConditionCoverageHelper_C4 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[4].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C4, 1) || true)) || (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[4].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C4, 1) && false)) {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[7]++;
            return;

        } else {
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[8]++;}
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[15]++;

        boolean permitAcquired = false;
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[16]++;
boolean CodeCoverTryBranchHelper_Try1 = false;
        try {
CodeCoverTryBranchHelper_Try1 = true;
            System.out.println("Applying rate limit delay...");
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[17]++;
            permitAcquired = semaphore.tryAcquire(500, TimeUnit.MILLISECONDS);
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[18]++;
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[19]++;
int CodeCoverConditionCoverageHelper_C5;
            if ((((((CodeCoverConditionCoverageHelper_C5 = 0) == 0) || true) && (!
(((CodeCoverConditionCoverageHelper_C5 |= (2)) == 0 || true) &&
 ((permitAcquired) && 
  ((CodeCoverConditionCoverageHelper_C5 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[5].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C5, 1) || true)) || (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[5].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C5, 1) && false)) {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[10]++;
                System.err.println("COULD NOT ACQUIRE SEMAPHORE PERMIT - SERVER TOO BUSY");
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[20]++;
                throw new RuntimeException("Server is too busy to handle the request.");

            } else {
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[11]++;}

            Thread.sleep(150);
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[21]++;
        } catch (InterruptedException e) {
CodeCoverTryBranchHelper_Try1 = false;
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[12]++;
            Thread.currentThread().interrupt();
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[22]++;
            throw new RuntimeException("Request was interrupted.", e);
        } finally {
if ( CodeCoverTryBranchHelper_Try1 ) {
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[9]++;
}
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[23]++;
int CodeCoverConditionCoverageHelper_C6;
            if ((((((CodeCoverConditionCoverageHelper_C6 = 0) == 0) || true) && (
(((CodeCoverConditionCoverageHelper_C6 |= (2)) == 0 || true) &&
 ((permitAcquired) && 
  ((CodeCoverConditionCoverageHelper_C6 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[6].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C6, 1) || true)) || (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[6].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C6, 1) && false)) {
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[13]++;
                semaphore.release();
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[24]++;

            } else {
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.branches[14]++;}
        }
    }

    public Optional<String> getOriginalUrl(String shortCode) {
        return Optional.<String>ofNullable(shortToLongUrl.get(shortCode));
    }

    public Map<String, String> getAllUrls() {
        return shortToLongUrl;
    }

    private String generateUniqueShortCode() {
        String shortCode;
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[25]++;
byte CodeCoverTryBranchHelper_L1 = 0;
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.loops[1]++;


int CodeCoverConditionCoverageHelper_C7;
        do {
if (CodeCoverTryBranchHelper_L1 == 0) {
  CodeCoverTryBranchHelper_L1++;
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.loops[1]--;
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.loops[2]++;
} else if (CodeCoverTryBranchHelper_L1 == 1) {
  CodeCoverTryBranchHelper_L1++;
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.loops[2]--;
  CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.loops[3]++;
}
            shortCode = RandomStringUtils.randomAlphanumeric(7);
CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.statements[26]++;
        } while ((((((CodeCoverConditionCoverageHelper_C7 = 0) == 0) || true) && (
(((CodeCoverConditionCoverageHelper_C7 |= (2)) == 0 || true) &&
 ((shortToLongUrl.containsKey(shortCode)) && 
  ((CodeCoverConditionCoverageHelper_C7 |= (1)) == 0 || true)))
)) && (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[7].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C7, 1) || true)) || (CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp.conditionCounters[7].incrementCounterOfBitMask(CodeCoverConditionCoverageHelper_C7, 1) && false));
        return shortCode;
    }
}

class CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp extends org.codecover.instrumentation.java.measurement.CounterContainer {

  static {
    org.codecover.instrumentation.java.measurement.ProtocolImpl.getInstance(org.codecover.instrumentation.java.measurement.CoverageResultLogFile.getInstance(null), "aa239ec1-ea68-4212-8cb5-67fbb16979de").addObservedContainer(new CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp ());
  }
    public static long[] statements = new long[27];
    public static long[] branches = new long[15];

  public static final org.codecover.instrumentation.java.measurement.ConditionCounter[] conditionCounters = new org.codecover.instrumentation.java.measurement.ConditionCounter[8];
  static {
    final String SECTION_NAME = "com.example.urlshortener.service.UrlService.java";
    final byte[] CONDITION_COUNTER_TYPES = {0,1,1,1,1,1,1,1};
    for (int i = 1; i <= 7; i++) {
      switch (CONDITION_COUNTER_TYPES[i]) {
        case 0 : break;
        case 1 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.SmallOneConditionCounter(SECTION_NAME, "C" + i); break;
        case 2 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.SmallTwoConditionCounter(SECTION_NAME, "C" + i); break;
        case 3 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.MediumConditionCounter(SECTION_NAME, "C" + i); break;
        case 4 : conditionCounters[i] = new org.codecover.instrumentation.java.measurement.LargeConditionCounter(SECTION_NAME, "C" + i); break;
      }
    }
  }
    public static long[] loops = new long[4];

  public CodeCoverCoverageCounter$plxwy3d5kocnpzxe5da9vmp () {
    super("com.example.urlshortener.service.UrlService.java");
  }

  public static void ping() {/* nothing to do*/}

  public void reset() {
      for (int i = 1; i <= 26; i++) {
        statements[i] = 0L;
      }
      for (int i = 1; i <= 14; i++) {
        branches[i] = 0L;
      }
    for (int i = 1; i <= 7; i++) {
      if (conditionCounters[i] != null) {
        conditionCounters[i].reset();
      }
    }
      for (int i = 1; i <= 3; i++) {
        loops[i] = 0L;
      }
  }

  public void serializeAndReset(org.codecover.instrumentation.measurement.CoverageCounterLog log) {
    log.startNamedSection("com.example.urlshortener.service.UrlService.java");
      for (int i = 1; i <= 26; i++) {
        if (statements[i] != 0L) {
          log.passCounter("S" + i, statements[i]);
          statements[i] = 0L;
        }
      }
      for (int i = 1; i <= 14; i++) {
        if (branches[i] != 0L) {
          log.passCounter("B"+ i, branches[i]);
          branches[i] = 0L;
        }
      }
    for (int i = 1; i <= 7; i++) {
      if (conditionCounters[i] != null) {
        conditionCounters[i].serializeAndReset(log);
      }
    }
      for (int i = 1; i <= 1; i++) {
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


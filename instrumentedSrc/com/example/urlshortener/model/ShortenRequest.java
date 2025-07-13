package com.example.urlshortener.model;

import jakarta.validation.constraints.NotEmpty;

/**
 * A DTO representing the incoming request to shorten a URL.
 */
public class ShortenRequest {
  static {
    CodeCoverCoverageCounter$1dbnooc1kyszgsrkonvo0rhfh0istd.ping();
  }


    @NotEmpty
    private String url;

    // No-argument constructor
    public ShortenRequest() {
        this.url = "";
CodeCoverCoverageCounter$1dbnooc1kyszgsrkonvo0rhfh0istd.statements[1]++;
    }

    // All-argument constructor
    public ShortenRequest(String url) {
        this.url = url;
CodeCoverCoverageCounter$1dbnooc1kyszgsrkonvo0rhfh0istd.statements[2]++;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
CodeCoverCoverageCounter$1dbnooc1kyszgsrkonvo0rhfh0istd.statements[3]++;
    }
}

class CodeCoverCoverageCounter$1dbnooc1kyszgsrkonvo0rhfh0istd extends org.codecover.instrumentation.java.measurement.CounterContainer {

  static {
    org.codecover.instrumentation.java.measurement.ProtocolImpl.getInstance(org.codecover.instrumentation.java.measurement.CoverageResultLogFile.getInstance(null), "79dd2941-3adb-4d33-b746-35ee6f9d0da2").addObservedContainer(new CodeCoverCoverageCounter$1dbnooc1kyszgsrkonvo0rhfh0istd ());
  }
    public static long[] statements = new long[4];
    public static long[] branches = new long[0];
    public static long[] loops = new long[1];

  public CodeCoverCoverageCounter$1dbnooc1kyszgsrkonvo0rhfh0istd () {
    super("com.example.urlshortener.model.ShortenRequest.java");
  }

  public static void ping() {/* nothing to do*/}

  public void reset() {
      for (int i = 1; i <= 3; i++) {
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
    log.startNamedSection("com.example.urlshortener.model.ShortenRequest.java");
      for (int i = 1; i <= 3; i++) {
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


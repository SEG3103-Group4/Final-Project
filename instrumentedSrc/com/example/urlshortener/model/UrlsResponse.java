package com.example.urlshortener.model;

import java.util.Map;
import java.util.HashMap;

/**
 * A DTO (Data Transfer Object) for sending the list of URLs and the total count
 * to the frontend in a single response.
 */
public class UrlsResponse {
  static {
    CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt.ping();
  }


    private Map<String, String> urls;
    private int totalCount;

    public UrlsResponse() {
        this.urls = new HashMap<String, String>();
CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt.statements[1]++;
        this.totalCount = 0;
CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt.statements[2]++;
    }

    // Full-arg constructor
    public UrlsResponse(Map<String, String> urls, int totalCount) {
        this.urls = urls;
CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt.statements[3]++;
        this.totalCount = totalCount;
CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt.statements[4]++;
    }

    // Getters and Setters
    public Map<String, String> getUrls() {
        return this.urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt.statements[5]++;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt.statements[6]++;
    }
}

class CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt extends org.codecover.instrumentation.java.measurement.CounterContainer {

  static {
    org.codecover.instrumentation.java.measurement.ProtocolImpl.getInstance(org.codecover.instrumentation.java.measurement.CoverageResultLogFile.getInstance(null), "79dd2941-3adb-4d33-b746-35ee6f9d0da2").addObservedContainer(new CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt ());
  }
    public static long[] statements = new long[7];
    public static long[] branches = new long[0];
    public static long[] loops = new long[1];

  public CodeCoverCoverageCounter$zz0oe2p5ebnmwlu164d99z5ftt () {
    super("com.example.urlshortener.model.UrlsResponse.java");
  }

  public static void ping() {/* nothing to do*/}

  public void reset() {
      for (int i = 1; i <= 6; i++) {
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
    log.startNamedSection("com.example.urlshortener.model.UrlsResponse.java");
      for (int i = 1; i <= 6; i++) {
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


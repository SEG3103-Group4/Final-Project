package com.example.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlshortenerApplication {
  static {
    CodeCoverCoverageCounter$12uuu3w7s0dd86wq9j85a6b3m93k2ua11333vky3t7j5.ping();
  }

    public static void main(String[] args) {
        SpringApplication.run(UrlshortenerApplication.class, args);
CodeCoverCoverageCounter$12uuu3w7s0dd86wq9j85a6b3m93k2ua11333vky3t7j5.statements[1]++;
    }
}

class CodeCoverCoverageCounter$12uuu3w7s0dd86wq9j85a6b3m93k2ua11333vky3t7j5 extends org.codecover.instrumentation.java.measurement.CounterContainer {

  static {
    org.codecover.instrumentation.java.measurement.ProtocolImpl.getInstance(org.codecover.instrumentation.java.measurement.CoverageResultLogFile.getInstance(null), "19466ebd-6dec-4703-8e9f-67f2dcbb430c").addObservedContainer(new CodeCoverCoverageCounter$12uuu3w7s0dd86wq9j85a6b3m93k2ua11333vky3t7j5 ());
  }
    public static long[] statements = new long[2];
    public static long[] branches = new long[0];
    public static long[] loops = new long[1];

  public CodeCoverCoverageCounter$12uuu3w7s0dd86wq9j85a6b3m93k2ua11333vky3t7j5 () {
    super("com.example.urlshortener.UrlshortenerApplication.java");
  }

  public static void ping() {/* nothing to do*/}

  public void reset() {
      for (int i = 1; i <= 1; i++) {
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
    log.startNamedSection("com.example.urlshortener.UrlshortenerApplication.java");
      for (int i = 1; i <= 1; i++) {
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

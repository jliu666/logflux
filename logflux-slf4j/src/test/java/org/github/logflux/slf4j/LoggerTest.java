package org.github.logflux.slf4j;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoggerTest {

  private static final Logger log = LoggerFactory.getLogger(LoggerTest.class);

  @Test
  public void getLogger() {
    org.slf4j.Logger logger = log.getLogger();
    assertNotNull(logger);
  }

  @Test
  public void getName() {
    String name = log.getName();
    log.info(name);
  }

  @Test
  public void info1() {
    log.info(() -> "Good");
  }

  @Test
  public void info2() {
    log.info("format {}", () -> "good");
  }

  @Test
  public void info3() {
    log.info(
        "format {} {}",
        () -> "string",
        () -> {
          int a = 1;
          return a + 2 + 3;
        });
  }

  @Test
  public void info4() {
    log.info(
        "format {} {} {} {}",
        () -> 1,
        () -> 2,
        () -> 3,
        () -> {
          int a = 1 + 1;
          int b = 1 + 2;
          return a + b;
        });
  }

  @Test
  public void info() {
    log.info(() -> "Throwable", new RuntimeException());
  }
}

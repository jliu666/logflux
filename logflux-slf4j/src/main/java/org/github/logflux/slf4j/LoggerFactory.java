package org.github.logflux.slf4j;

import org.slf4j.ILoggerFactory;

/**
 * 与 @{code org.slf4j.LoggerFactory}功能相同，对其进行包装
 *
 * @author liujichun
 * @see org.slf4j.LoggerFactory
 */
public class LoggerFactory {

  public static Logger getLogger(String name) {
    return new Logger(org.slf4j.LoggerFactory.getLogger(name));
  }

  public static Logger getLogger(Class<?> clazz) {
    return new Logger(org.slf4j.LoggerFactory.getLogger(clazz));
  }

  public static ILoggerFactory getILoggerFactory() {
    return org.slf4j.LoggerFactory.getILoggerFactory();
  }
}

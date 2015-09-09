package com.vainolo.phd.opp.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class OPPLogger {
  private static final Logger logger;

  static {
    logger = Logger.getLogger("OPM");
    logger.setUseParentHandlers(false);
    ConsoleHandler handler = new ConsoleHandler();
    Formatter formatter = new Formatter() {
      String format = "[%1$tF %1$tT] %2$s %3$s %5$s\n";
      private final Date dat = new Date();

      public synchronized String format(LogRecord record) {
        dat.setTime(record.getMillis());
        String source;
        if (record.getSourceClassName() != null) {
          source = record.getSourceClassName();
          if (record.getSourceMethodName() != null) {
            source += "." + record.getSourceMethodName();
          }
        } else {
          source = record.getLoggerName();
        }
        String message = formatMessage(record);
        String throwable = "";
        if (record.getThrown() != null) {
          StringWriter sw = new StringWriter();
          PrintWriter pw = new PrintWriter(sw);
          pw.println();
          record.getThrown().printStackTrace(pw);
          pw.close();
          throwable = sw.toString();
        }
        return String.format(format, dat, record.getLevel(), source, record.getLoggerName(), message, throwable);
      }
    };
    handler.setFormatter(formatter);
    handler.setLevel(Level.FINEST);
    logger.setLevel(Level.FINEST);
    logger.addHandler(handler);
  }

  private static String[] getClassNameAndMethodName(StackTraceElement[] stack) {
    String[] fullClassName = stack[3].getClassName().split("\\.");
    String className = fullClassName[fullClassName.length - 1];

    return new String[] { className, stack[3].getMethodName() };
  }

  private static void log(Level level, String msg, Object[] params) {
    String[] classAndMethod = getClassNameAndMethodName(Thread.currentThread().getStackTrace());
    logger.logp(level, classAndMethod[0], classAndMethod[1], msg, params);
  }

  public static void setLevel(Level level) {
    logger.setLevel(level);
  }

  public static void logInfo(String msg) {
    log(Level.INFO, msg, null);
  }

  public static void logInfo(String msg, Object... params) {
    log(Level.INFO, msg, params);
  }

  public static void logWarning(String msg) {
    log(Level.WARNING, msg, null);
  }

  public static void logWarning(String msg, Object... params) {
    log(Level.WARNING, msg, params);
  }

  public static void logSevere(String msg) {
    log(Level.SEVERE, msg, null);
  }

  public static void logSevere(String msg, Object... params) {
    log(Level.SEVERE, msg, params);
  }

  public static void logFine(String msg) {
    log(Level.FINE, msg, null);
  }

  public static void logFine(String msg, Object... params) {
    log(Level.FINE, msg, params);
  }

  public static void logFiner(String msg) {
    log(Level.FINER, msg, null);
  }

  public static void logFiner(String msg, Object... params) {
    log(Level.FINER, msg, params);
  }

  public static void logFinest(String msg) {
    log(Level.FINEST, msg, null);
  }

  public static void logFinest(String msg, Object... params) {
    log(Level.FINEST, msg, params);
  }

  public static void main(String args[]) {
    OPPLogger.logInfo("Hello");
    logger.setLevel(Level.FINEST);
    OPPLogger.logFinest("World");

    OPPLogger.logInfo("Hello {0}", "hello");
  }
}

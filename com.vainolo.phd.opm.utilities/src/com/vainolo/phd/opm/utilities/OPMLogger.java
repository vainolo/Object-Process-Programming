package com.vainolo.phd.opm.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class OPMLogger {
  private static final Logger logger;

  static {
    logger = Logger.getLogger("OPM");
    logger.setUseParentHandlers(false);
    System.out.println("Handlers: " + logger.getHandlers().length);
    System.out.println("Parent handlers: " + logger.getParent().getHandlers().length);
    ConsoleHandler handler = new ConsoleHandler();
    Formatter formatter = new Formatter() {
      String format = "[%1$tF %1$tT] %2$s %3$s %5$s\n";
      private final Date dat = new Date();

      public synchronized String format(LogRecord record) {
        dat.setTime(record.getMillis());
        String source;
        if(record.getSourceClassName() != null) {
          source = record.getSourceClassName();
          if(record.getSourceMethodName() != null) {
            source += "." + record.getSourceMethodName();
          }
        } else {
          source = record.getLoggerName();
        }
        String message = formatMessage(record);
        String throwable = "";
        if(record.getThrown() != null) {
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
    logger.addHandler(handler);
  }

  public static String[] getClassNameAndMethodName(StackTraceElement[] stack) {
    return new String[] { stack[3].getClassName(), stack[3].getMethodName() };
  }

  private static void log(Level level, String msg) {
    String[] classAndMethod = getClassNameAndMethodName(Thread.currentThread().getStackTrace());
    logger.logp(level, classAndMethod[0], classAndMethod[1], msg);
  }

  public static void info(String msg) {
    log(Level.INFO, msg);
  }

  public static void warning(String msg) {
    log(Level.WARNING, msg);
  }

  public static void severe(String msg) {
    log(Level.SEVERE, msg);
  }

  public static void fine(String msg) {
    log(Level.FINE, msg);
  }

  public static void finer(String msg) {
    log(Level.FINER, msg);
  }

  public static void finest(String msg) {
    log(Level.FINEST, msg);
  }

  public static void setLevel(Level level) {
    logger.setLevel(level);
  }

  public static void main(String args[]) {
    OPMLogger.info("Hello");
    logger.setLevel(Level.FINEST);
    OPMLogger.finest("World");
  }
}

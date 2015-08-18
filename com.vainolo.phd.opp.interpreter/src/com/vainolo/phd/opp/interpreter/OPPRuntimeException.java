package com.vainolo.phd.opp.interpreter;

/**
 * Generic {@link RuntimeException} thrown when the execution of an
 * {@link OPPProcessInstance} fails.
 */
public class OPPRuntimeException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 7505711158268398826L;

  public OPPRuntimeException(Throwable cause) {
    super(cause);
  }
}

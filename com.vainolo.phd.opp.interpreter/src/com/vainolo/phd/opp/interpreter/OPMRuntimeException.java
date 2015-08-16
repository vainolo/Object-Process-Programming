package com.vainolo.phd.opp.interpreter;

/**
 * Generic {@link RuntimeException} thrown when the execution of an
 * {@link OPMProcessInstance} fails.
 */
public class OPMRuntimeException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 7505711158268398826L;

  public OPMRuntimeException(Throwable cause) {
    super(cause);
  }
}

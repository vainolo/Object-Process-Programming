package com.vainolo.phd.opm.interpreter;

/**
 * Generic {@link RuntimeException} thrown when the execution of an {@link OPMProcessInstance} fails.
 */
public class OPMRuntimeException extends RuntimeException {

  public OPMRuntimeException(Throwable cause) {
    super(cause);
  }
}

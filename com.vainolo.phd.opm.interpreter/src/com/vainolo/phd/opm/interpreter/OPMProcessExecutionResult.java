package com.vainolo.phd.opm.interpreter;

public enum OPMProcessExecutionResult {
  FINISHED, UNABLE_TO_FINISH, ABORTED_BY_CALLER;
  public OPMProcessInstance instance;
}

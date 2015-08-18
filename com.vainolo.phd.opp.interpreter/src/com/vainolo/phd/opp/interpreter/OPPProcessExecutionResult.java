package com.vainolo.phd.opp.interpreter;

public class OPPProcessExecutionResult {
  private OPPProcessInstance instance;
  private OPMProcessExecutionResultType resultType;

  public OPPProcessExecutionResult(OPPProcessInstance instance, OPMProcessExecutionResultType resultType) {
    this.instance = instance;
    this.resultType = resultType;
  }

  public OPPProcessInstance getInstance() {
    return instance;
  }

  public OPMProcessExecutionResultType getResultType() {
    return resultType;
  }

  public enum OPMProcessExecutionResultType {
    FINISHED, UNABLE_TO_FINISH, ABORTED_BY_CALLER;
  }
}

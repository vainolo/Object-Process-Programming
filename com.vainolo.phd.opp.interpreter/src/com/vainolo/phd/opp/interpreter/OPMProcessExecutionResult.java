package com.vainolo.phd.opp.interpreter;

public class OPMProcessExecutionResult {
  private OPMProcessInstance instance;
  private OPMProcessExecutionResultType resultType;

  public OPMProcessExecutionResult(OPMProcessInstance instance, OPMProcessExecutionResultType resultType) {
    this.instance = instance;
    this.resultType = resultType;
  }

  public OPMProcessInstance getInstance() {
    return instance;
  }

  public OPMProcessExecutionResultType getResultType() {
    return resultType;
  }

  public enum OPMProcessExecutionResultType {
    FINISHED, UNABLE_TO_FINISH, ABORTED_BY_CALLER;
  }
}

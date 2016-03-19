/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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

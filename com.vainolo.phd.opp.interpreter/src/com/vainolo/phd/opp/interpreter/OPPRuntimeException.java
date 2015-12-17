/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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

  public OPPRuntimeException() {
    super();
  }

  public OPPRuntimeException(String message) {
    super(message);
  }
}

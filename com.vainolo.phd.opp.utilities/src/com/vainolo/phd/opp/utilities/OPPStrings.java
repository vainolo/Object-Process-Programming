/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities;

public class OPPStrings {
  public static final String PROCESS_NOT_READY = "Process {0} is not ready because Object {1} is not ready.";
  public static final String SKIP_PROCESS = "Process {0} must be skipped because conditional parameter {1} is not ready.";
  public static final String INSTANCE_NOT_READY_PARAMETER = "Instance of {0} is not ready because parameter {1} is empty.";
  public static final String INSTANCE_NOT_READY_PARAMETER_STATE = "Instance of {0} is not ready because conditional parameter {1}  is not in state {2}.";
  public static final String STARTING_EXECUTION = "Starting execution of process {0}.";
  public static final String SKIP_PARAMETER = "Skipping instance of {0} because conditional parameter {1} is empty.";
  public static final String SKIP_PARAMETER_STATE = "Skipping instance of {0} because conditional parameter {1} is not in state {2}.";

}

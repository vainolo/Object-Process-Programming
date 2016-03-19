/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;

public class OPPNewInstanceProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {
  private static final String INSTANCE_PARAM_NAME = "instance";
  private static final OPPParameter INSTANCE_PARAM = new OPPParameter(INSTANCE_PARAM_NAME);
  private static final List<OPPParameter> OUTPUT_PARAMS = Lists.newArrayList(INSTANCE_PARAM);

  @Override
  public void executing() {
    setArgument(INSTANCE_PARAM_NAME, OPPObjectInstance.createCompositeInstance());
  }

  @Override
  public String getName() {
    return "New Instance";
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return OUTPUT_PARAMS;
  }
}

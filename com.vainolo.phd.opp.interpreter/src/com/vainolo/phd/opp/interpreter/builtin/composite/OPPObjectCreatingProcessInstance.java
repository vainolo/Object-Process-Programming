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

public class OPPObjectCreatingProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  public void executing() {
    setArgument("object", OPPObjectInstance.createCompositeInstance());
  }

  @Override
  public String getName() {
    return "Object Creating";
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }
}

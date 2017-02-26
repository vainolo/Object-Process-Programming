/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.string;

import java.util.List;

import com.eclipsesource.json.JsonObject;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.json.OPPJsonWriter;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPStringObjectInstance;

public class OPPConcatenatingProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    String a, b;
    if (getArgument("a") instanceof OPPStringObjectInstance)
      a = ((OPPStringObjectInstance) getArgument("a")).getDisplayValue();
    else
      a = getArgument("a").getStringValue();

    if (getArgument("b") instanceof OPPStringObjectInstance)
      b = ((OPPStringObjectInstance) getArgument("b")).getDisplayValue();
    else
      b = getArgument("b").getStringValue();

    String c = a + b;
    setArgument("c", OPPObjectInstance.createFromValue(c));
  }

  @Override
  public String getName() {
    return "Concatenating";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("a", "b");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("c");
  }

}

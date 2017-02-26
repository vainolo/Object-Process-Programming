/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.string;

import java.math.BigDecimal;
import java.util.List;

import com.eclipsesource.json.JsonObject;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.json.OPPJsonWriter;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPStringObjectInstance;

public class OPPStringComparingProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  protected void executing() {
    String a = ((OPPStringObjectInstance) getArgument("a")).getDisplayValue();
    String b = ((OPPStringObjectInstance) getArgument("b")).getDisplayValue();

    BigDecimal c = new BigDecimal(a.compareTo(b));
    setArgument("c", OPPObjectInstance.createFromValue(c));
  }

  @Override
  public String getName() {
    return "String Comparing";
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

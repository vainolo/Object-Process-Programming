/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.general;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPRandomProcessInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  @Override
  public void executing() {
    Random r = new Random();
    setArgument("random", OPPObjectInstance.createFromValue(new BigDecimal(r.nextDouble())));
  }

  @Override
  public String getName() {
    return "Random";
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("random");
  }

}

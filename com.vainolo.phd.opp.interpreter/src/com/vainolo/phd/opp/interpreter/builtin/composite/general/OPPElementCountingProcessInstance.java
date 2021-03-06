/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.builtin.composite.general;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPCollectionObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPElementCountingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPCollectionObjectInstance collection = (OPPCollectionObjectInstance) getArgument("collection");

    BigDecimal count = new BigDecimal(collection.count());
    setArgument("count", OPPObjectInstance.createFromValue(count));
  }

  @Override
  public String getName() {
    return "Element Counting";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("collection"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("count"));
  }
}

package com.vainolo.phd.opp.interpreter.builtin.composite.complex;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPStringObjectInstance;

public class OPPPartFetchingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPComplexObjectInstance object = (OPPComplexObjectInstance) getArgument("object");
    OPPObjectInstance partName = getArgument("part name");

    if (object.containsPart(partName.getStringValue())) {
      setArgument("fetched?", OPPObjectInstance.createFromValue("yes"));
      setArgument("part", object.getPart(partName.getStringValue()));
    } else {
      setArgument("fetched?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public String getName() {
    return "Part Fetching";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("object", "part name");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("part", "fetched?");
  }
}

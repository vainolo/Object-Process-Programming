package com.vainolo.phd.opp.interpreter.builtin.composite.complex;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPStringObjectInstance;

public class OPPAllPartsFetchingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPComplexObjectInstance object = (OPPComplexObjectInstance) getArgument("object");

    OPPListObjectInstance parts = OPPObjectInstance.createListInstance();
    for (OPPObjectInstance part : object.getAllParts()) {
      parts.addLast(part);
    }

    setArgument("parts", parts);
  }

  @Override
  public String getName() {
    return "All Parts Fetching";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("object");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("parts");
  }
}

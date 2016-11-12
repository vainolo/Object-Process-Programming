package com.vainolo.phd.opp.interpreter.builtin.composite.complex;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPStringObjectInstance;
import com.vainolo.phd.opp.model.OPPObject;

public class OPPAllPartNamesFetchingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPComplexObjectInstance object = (OPPComplexObjectInstance) getArgument("object");

    OPPListObjectInstance partNames = OPPObjectInstance.createListInstance();
    for (String name : object.getPartNames()) {
      partNames.addLast(OPPObjectInstance.createFromValue(name));
    }

    setArgument("part names", partNames);
  }

  @Override
  public String getName() {
    return "Part Adding";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("object");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("part names");
  }
}

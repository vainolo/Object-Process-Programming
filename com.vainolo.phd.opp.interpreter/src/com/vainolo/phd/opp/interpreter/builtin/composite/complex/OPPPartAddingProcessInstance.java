package com.vainolo.phd.opp.interpreter.builtin.composite.complex;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPStringObjectInstance;

public class OPPPartAddingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPComplexObjectInstance object = (OPPComplexObjectInstance) getArgument("object");
    OPPObjectInstance part = getArgument("part");
    OPPObjectInstance partName = getArgument("part name");

    if (object.containsPart(partName.getStringValue())) {
      setArgument("replaced?", OPPObjectInstance.createFromValue("yes"));
      setArgument("replaced part", object.getPart(partName.getStringValue()));
    } else {
      setArgument("replaced?", OPPObjectInstance.createFromValue("no"));
    }
    OPPComplexObjectInstance newObject = (OPPComplexObjectInstance) OPPObjectInstance.createFromExistingInstance(object);
    newObject.setPart(partName.getStringValue(), part);
    setArgument("new object", newObject);
  }

  @Override
  public String getName() {
    return "Part Adding";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("object", "part", "part name");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("new object", "replaced?", "replaced part");
  }
}

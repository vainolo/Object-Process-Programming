package com.vainolo.phd.opp.interpreter.builtin.composite.complex;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPStringObjectInstance;

public class OPPPartRemovingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPComplexObjectInstance object = (OPPComplexObjectInstance) getArgument("object");
    OPPObjectInstance partName = getArgument("part name");

    if (object.containsPart(partName.getStringValue())) {
      setArgument("removed?", OPPObjectInstance.createFromValue("yes"));
      setArgument("part", object.getPart(partName.getStringValue()));
      OPPComplexObjectInstance newObject = (OPPComplexObjectInstance) OPPObjectInstance.createFromExistingInstance(object);
      newObject.removePart(partName.getStringValue());
      setArgument("new object", newObject);
    } else {
      setArgument("removed?", OPPObjectInstance.createFromValue("no"));
      setArgument("new object", object);
    }
  }

  @Override
  public String getName() {
    return "Part Removing";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return createParameterList("object", "part name");
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return createParameterList("new object", "part", "removed?");
  }
}

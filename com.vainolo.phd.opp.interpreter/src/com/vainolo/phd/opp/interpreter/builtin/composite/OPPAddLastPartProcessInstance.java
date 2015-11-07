package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPAddLastPartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance object = getArgument("object");
    OPPObjectInstance part = getArgument("part");
    if (object == null)
      object = OPPObjectInstance.createCompositeInstance();
    object.addLastPart(part);
    setArgument("new object", object);
  }

  @Override
  public String getName() {
    return "Add Last Part";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"), new OPPParameter("part"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("new object"));
  }
}

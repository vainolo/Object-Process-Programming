package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPHasPartValueProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance value = getArgument("value");
    OPPObjectInstance object = getArgument("object");

    if (object.getAllParts().contains(value)) {
      setArgument("exists?", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("exists?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"), new OPPParameter("value"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("exists?"));
  }

  @Override
  public String getName() {
    return "Has Part Value";
  }
}

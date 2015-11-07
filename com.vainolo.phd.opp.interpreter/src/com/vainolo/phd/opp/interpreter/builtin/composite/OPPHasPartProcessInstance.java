package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPHasPartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance key = getArgument("key");
    OPPObjectInstance object = getArgument("object");
    if (object.getAllPartIndexes().contains(key.getStringValue())) {
      setArgument("exists?", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("exists?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"), new OPPParameter("key"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("exists?"));
  }

  @Override
  public String getName() {
    return "Has Part";
  }
}

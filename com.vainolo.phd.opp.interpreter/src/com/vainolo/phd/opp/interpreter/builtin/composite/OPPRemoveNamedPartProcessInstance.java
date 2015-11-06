package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPRemoveNamedPartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance composite = getArgument("object");
    OPPObjectInstance name = getArgument("name");

    if (composite.containsPart(name.getStringValue())) {
      OPPObjectInstance part = composite.removePart(name);
      setArgument("part", part);
      setArgument("new object", composite);
      setArgument("exists?", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("exists?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public void setArgument(String name, OPPObjectInstance value) {
    // Modified since we need the original ID of the instance to be used as key, and this ID will be changed when a new
    // instance is created - so we transform the instance to a string that is used as the key.
    if ("name".equals(name)) {
      if (value.kind == InstanceKind.COMPOSITE) {
        value = OPPObjectInstance.createFromValue(value.getId());
      }
    }
    super.setArgument(name, value);
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"), new OPPParameter("name"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("part"), new OPPParameter("new object"), new OPPParameter("exists?"));
  }

  @Override
  public String getName() {
    return "Remove Part";
  }
}

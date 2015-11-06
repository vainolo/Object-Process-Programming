package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPAddNamedPartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance composite = getArgument("object");
    OPPObjectInstance name = getArgument("name");
    OPPObjectInstance part = getArgument("part");
    if (composite == null)
      composite = OPPObjectInstance.createCompositeInstance();
    composite.addPart(name.getStringValue(), part);
    setArgument("new object", composite);
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
    return Lists.newArrayList(new OPPParameter("object"), new OPPParameter("name"), new OPPParameter("part"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("new object"));
  }

  @Override
  public String getName() {
    return "Add Named Part";
  }
}

package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceKind;

public class OPPGetLastPartProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance composite = getArgument("object");
    if (composite.getAllPartIndexes().size() > 0) {
      OPPObjectInstance part = composite.getLastPart();
      setArgument("part", part);
      setArgument("exists?", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("exists?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("part"), new OPPParameter("exists?"));
  }

  @Override
  public String getName() {
    return "Get Last Part";
  }
}

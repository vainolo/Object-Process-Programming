package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPHasPartsProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance object = getArgument("object");
    if (object.getAllPartIndexes().size() > 0) {
      setArgument("answer", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("answer", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("answer"));
  }

  @Override
  public String getName() {
    return "Has Parts";
  }
}

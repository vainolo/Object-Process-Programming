package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPFirstElementAddingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance list = getArgument("list");
    OPPObjectInstance element = getArgument("element");
    OPPObjectInstance newList = OPPObjectInstance.createFromExistingInstance(list);
    newList.addFirstPart(element);
    setArgument("new list", newList);
  }

  @Override
  public String getName() {
    return "First Element Adding";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("list"), new OPPParameter("element"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("new list"));
  }
}

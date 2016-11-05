package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPFirstElementAddingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPListObjectInstance list = (OPPListObjectInstance) getArgument("list");
    OPPObjectInstance element = getArgument("element");
    OPPListObjectInstance newList = (OPPListObjectInstance) OPPObjectInstance.createFromExistingInstance(list);
    newList.addFirst(element);
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

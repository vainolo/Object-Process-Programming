package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPLastElementRemovingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPListObjectInstance list = (OPPListObjectInstance) getArgument("list");
    OPPListObjectInstance newList = (OPPListObjectInstance) OPPObjectInstance.createFromExistingInstance(list);
    OPPObjectInstance element = newList.removeLast();

    setArgument("new list", newList);
    if (element != null) {
      setArgument("element", element);
      setArgument("removed?", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("removed?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public String getName() {
    return "Last Element Removing";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("list"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("element"), new OPPParameter("removed?"), new OPPParameter("new list"));
  }
}

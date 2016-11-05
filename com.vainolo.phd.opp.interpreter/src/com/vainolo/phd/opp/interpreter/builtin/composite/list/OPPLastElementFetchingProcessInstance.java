package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPLastElementFetchingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPListObjectInstance list = (OPPListObjectInstance) getArgument("list");
    OPPObjectInstance element = list.getLast();
    if (element != null) {
      setArgument("element", element);
      setArgument("fetched?", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("fetched?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public String getName() {
    return "Last Element Fetching";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("list"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("element"), new OPPParameter("fetched?"));
  }
}

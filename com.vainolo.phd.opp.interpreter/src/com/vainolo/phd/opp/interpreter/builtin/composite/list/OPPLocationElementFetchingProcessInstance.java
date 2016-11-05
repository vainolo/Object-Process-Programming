package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPNumberObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPLocationElementFetchingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPListObjectInstance list = (OPPListObjectInstance) getArgument("list");
    int location = getArgument("location").getNumericalValue().intValue();

    if (location < 1 || location > list.count()) {
      setArgument("fetched?", OPPObjectInstance.createFromValue("no"));
    } else {
      setArgument("fetched?", OPPObjectInstance.createFromValue("yes"));
      setArgument("element", list.get(location));
    }
  }

  @Override
  public String getName() {
    return "Location Element Fetching";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("list"), new OPPParameter("location"), new OPPParameter("location"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("fetched?"), new OPPParameter("element"));
  }
}

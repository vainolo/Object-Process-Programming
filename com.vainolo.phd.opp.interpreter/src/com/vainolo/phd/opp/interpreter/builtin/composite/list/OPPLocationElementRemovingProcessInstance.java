package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPNumberObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPLocationElementRemovingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPListObjectInstance list = (OPPListObjectInstance) getArgument("list");
    int location = getArgument("location").getNumericalValue().intValue();
    OPPListObjectInstance newList = (OPPListObjectInstance) OPPObjectInstance.createFromExistingInstance(list);

    if (location < 1 || location > list.count()) {
      setArgument("removed?", OPPObjectInstance.createFromValue("no"));
      setArgument("new list", newList);
    } else {
      setArgument("removed?", OPPObjectInstance.createFromValue("yes"));
      setArgument("element", list.get(location));
      newList.remove(location);
      setArgument("new list", newList);
    }
  }

  @Override
  public String getName() {
    return "Location Element Removing";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("list"), new OPPParameter("location"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("removed?"), new OPPParameter("element"), new OPPParameter("new list"));
  }
}

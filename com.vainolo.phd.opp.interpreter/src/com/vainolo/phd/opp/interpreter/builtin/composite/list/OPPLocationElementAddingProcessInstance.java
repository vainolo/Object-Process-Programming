package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.types.OPPListObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;

public class OPPLocationElementAddingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPListObjectInstance list = (OPPListObjectInstance) getArgument("list");
    OPPObjectInstance element = getArgument("element");
    int location = getArgument("location").getNumericalValue().intValue();

    if (location < 1 || location > list.count()) {
      setArgument("added?", OPPObjectInstance.createFromValue("no"));
    } else {
      setArgument("added?", OPPObjectInstance.createFromValue("yes"));
      OPPListObjectInstance newList = OPPObjectInstance.createListInstance();
      boolean added = false;
      for (int i = 1; i <= list.count(); i++) {
        if (i == location) {
          added = true;
          newList.addLast(element);
        } else {
          newList.addLast(list.get(added ? i : i + 1));
        }
      }
      setArgument("new list", newList);
    }

  }

  @Override
  public String getName() {
    return "Location Element Adding";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("list"), new OPPParameter("element"), new OPPParameter("location"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("new list"), new OPPParameter("added?"));
  }
}

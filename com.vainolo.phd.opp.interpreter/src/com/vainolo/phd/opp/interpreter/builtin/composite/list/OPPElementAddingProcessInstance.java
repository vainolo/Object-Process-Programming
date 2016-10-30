package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPElementAddingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance collection = getArgument("collection");
    OPPObjectInstance element = getArgument("element");
    OPPObjectInstance newCollection = OPPObjectInstance.createFromExistingInstance(collection);
    newCollection.addLastPart(element);
    setArgument("new collection", newCollection);
    setArgument("added?", OPPObjectInstance.createFromValue("yes"));
  }

  @Override
  public String getName() {
    return "Element Adding";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("element"), new OPPParameter("collection"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("new collection"), new OPPParameter("added?"));
  }
}

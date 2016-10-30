package com.vainolo.phd.opp.interpreter.builtin.composite.list;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPElementRemovingProcessInstance extends OPPAbstractProcessInstance {

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance collection = getArgument("collection");
    OPPObjectInstance id = getArgument("id");

    Collection<OPPObjectInstance> parts = collection.getAllParts();
    OPPObjectInstance element = null;
    OPPObjectInstance newCollection = null;
    for (OPPObjectInstance part : parts) {
      if (part.getId().equals(id.getStringValue())) {
        element = part;
        newCollection = OPPObjectInstance.createFromExistingInstance(collection);
        newCollection.removePartById(part.getId());
      }
    }

    if (element != null) {
      setArgument("new collection", newCollection);
      setArgument("element", element);
      setArgument("removed?", OPPObjectInstance.createFromValue("yes"));
    } else {
      setArgument("removed?", OPPObjectInstance.createFromValue("no"));
    }
  }

  @Override
  public String getName() {
    return "Element Removing";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("id"), new OPPParameter("collection"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("element"), new OPPParameter("removed?"), new OPPParameter("new collection"));
  }
}

package com.vainolo.phd.opp.interpreter.builtin;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

/**
 * Process instance that handles basic binary math operations
 */
public class OPPCopyObjectProcessInstance extends OPPAbstractProcessInstance {
  @Override
  public void executing() {
    OPPObjectInstance object = getArgument("object");
    setArgument("copy", OPPObjectInstance.createFromExistingInstance(object));
  }

  @Override
  public String getName() {
    return "Copy Object";
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return Lists.newArrayList(new OPPParameter("object"));
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return Lists.newArrayList(new OPPParameter("copy"));
  }
}

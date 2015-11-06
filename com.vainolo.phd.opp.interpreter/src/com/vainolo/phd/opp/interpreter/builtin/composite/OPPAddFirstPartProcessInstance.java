package com.vainolo.phd.opp.interpreter.builtin.composite;

import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPAbstractProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;

public class OPPAddFirstPartProcessInstance extends OPPAbstractProcessInstance {
  private static final String PROCESS_NAME = "Add First Part";
  private static final String OBJECT_PARAM_NAME = "object";
  private static final OPPParameter OBJECT_PARAM = new OPPParameter(OBJECT_PARAM_NAME);
  private static final String PART_PARAM_NAME = "part";
  private static final OPPParameter PART_PARAM = new OPPParameter(PART_PARAM_NAME);
  private static final String NEW_OBJECT_PARAM_NAME = "new object";
  private static final OPPParameter NEW_INSTANCE_PARAM = new OPPParameter(NEW_OBJECT_PARAM_NAME);
  private static final List<OPPParameter> INCOMING_PARAMS = Lists.newArrayList(OBJECT_PARAM, PART_PARAM);
  private static final List<OPPParameter> OUTGOING_PARAMS = Lists.newArrayList(NEW_INSTANCE_PARAM);

  @Override
  protected void executing() throws Exception {
    OPPObjectInstance composite = getArgument(OBJECT_PARAM_NAME);
    OPPObjectInstance part = getArgument(PART_PARAM_NAME);
    if (composite == null)
      composite = OPPObjectInstance.createCompositeInstance();
    composite.addFirstPart(part);
    setArgument(NEW_OBJECT_PARAM_NAME, composite);
  }

  @Override
  public String getName() {
    return PROCESS_NAME;
  }

  @Override
  public List<OPPParameter> getIncomingParameters() {
    return INCOMING_PARAMS;
  }

  @Override
  public List<OPPParameter> getOutgoingParameters() {
    return OUTGOING_PARAMS;
  }
}

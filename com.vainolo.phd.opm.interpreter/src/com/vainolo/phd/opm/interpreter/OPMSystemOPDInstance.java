package com.vainolo.phd.opm.interpreter;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalysis;

public class OPMSystemOPDInstance implements OPMExecutableInstance {

  private final OPMObjectProcessDiagram opd;
  private final Map<String, Object> arguments = Maps.newHashMap();

  /**
   * Create a new instance.
   * 
   * @param opd
   *          the {@link OPMObjectProcessDiagram} for this instance.
   */
  public OPMSystemOPDInstance(OPMObjectProcessDiagram opd) {
    this.opd = opd;
    for(OPMObject parameter : OPDAnalysis.INSTANCE.findParameters(opd)) {
      arguments.put(parameter.getName(), null);
    }
  }

  public void setArgument(String parameterName, Object value) {
    Preconditions.checkArgument(arguments.containsKey(parameterName), "%s is not an valid parameter of %s",
        parameterName, opd.getName());
    arguments.put(parameterName, value);
  }

  public Object getArgument(String parameterName) {
    Preconditions.checkArgument(arguments.containsKey(parameterName), "%s is not an valid parameter of %s",
        parameterName, opd.getName());
    return arguments.get(parameterName);
  }

  @Override
  public void setArgumentValue(String name, Object value) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object getArgumentValue(String name) {
    // TODO Auto-generated method stub
    return null;
  }
}
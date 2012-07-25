/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.util.Set;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMOutgoingParameter;
import com.vainolo.phd.opm.interpreter.utils.OPDAnalyzer;
import com.vainolo.phd.opm.interpreter.utils.Parameter;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * An OPM process that upon execution simply creates all process outputs.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 10 Jul 2012
 * 
 */
public class OPMConceptualProcess extends OPMAbstractProcessInstance implements OPMProcessInstance {

  public OPMConceptualProcess(final OPMProcess process) {
    super(process);
  }

  @Override
  protected void executing() {
    Set<Parameter> outgoingParameters = OPDAnalyzer.calculateAllParameters(getProcess());
    outgoingParameters = Sets.filter(outgoingParameters, IsOPMOutgoingParameter.INSTANCE);
    for(Parameter parameter : outgoingParameters) {
      setArgumentValue(parameter.getName(), new Object());
    }
  }

}

/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import java.util.Collection;

import com.vainolo.phd.opm.interpreter.predicates.IsOPMInvocationLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProcessIncomingDataLink;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProcessOutgoingDataLink;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

import static com.google.common.collect.Collections2.filter;

public class OPMProcessAnalysis {

  static Collection<OPMProceduralLink> findIncomingDataLinks(OPMProcess node) {
    return filter(OPMAnalysis.findAllProceduralLinks(node), IsOPMProcessIncomingDataLink.INSTANCE);
  }

  static Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    return filter(OPMAnalysis.findAllProceduralLinks(process), IsOPMProcessOutgoingDataLink.INSTANCE);
  }

  static Collection<OPMProceduralLink> findOutgoingInvocationLinks(OPMProcess process) {
    return filter(OPMAnalysis.findOutgoingProceduralLinks(process), IsOPMInvocationLink.INSTANCE);
  }

}

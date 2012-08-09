/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import java.util.Collection;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMAnalysis {

  public static Collection<OPMProceduralLink> findAllProceduralLinks(OPMNode node) {
    return OPMNodeAnalysis.findAllProceduralLinks(node);
  }

  public static Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMProcess process) {
    return OPMNodeAnalysis.findOutgoingProceduralLinks(process);
  }

  public static Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMObject object) {
    return OPMObjectAnalysis.findIncomingDataLinks(object);
  }

  public static Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMObject object) {
    return OPMObjectAnalysis.findOutgoingDataLinks(object);
  }
}

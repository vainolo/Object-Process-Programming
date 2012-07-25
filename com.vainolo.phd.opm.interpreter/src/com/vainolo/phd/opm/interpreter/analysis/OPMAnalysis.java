/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import java.util.Collection;

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMAnalysis {
  public static Collection<OPMProceduralLink> findIncomingDataLinks(OPMProcess process) {
    return OPMProcessAnalysis.findIncomingDataLinks(process);
  }

  public static Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    return OPMProcessAnalysis.findOutgoingDataLinks(process);
  }

  public static Collection<OPMProceduralLink> findOutgoingInvocationLinks(OPMProcess process) {
    return OPMProcessAnalysis.findOutgoingInvocationLinks(process);
  }

  public static Collection<OPMProceduralLink> findAllProceduralLinks(OPMNode node) {
    return OPMNodeAnalysis.findAllProceduralLinks(node);
  }

  public static Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMProcess process) {
    return OPMNodeAnalysis.findOutgoingProceduralLinks(process);
  }

  public static Collection<OPMObject> findContainedObjects(OPMContainer container) {
    return OPMContainerAnalysis.findContainedObjects(container);
  }

  public static Collection<OPMProcess> findContainedProcesses(OPMContainer container) {
    return OPMContainerAnalysis.findContainedProcesses(container);
  }

  public static Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMObject object) {
    return OPMObjectAnalysis.findIncomingDataLinks(object);
  }

  public static Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMObject object) {
    return OPMObjectAnalysis.findOutgoingDataLinks(object);
  }

  public static OPMProcess findZoomedInProcess(OPMObjectProcessDiagram opd) {
    return OPMObjectProcessDiagramAnalysis.findZoomedInProcess(opd);
  }

  public static Collection<OPMProcess> findExecutableProcesses(OPMObjectProcessDiagram opd) {
    return OPMObjectProcessDiagramAnalysis.findExecutableProcesses(opd);
  }

  public static Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return OPMNodeAnalysis.findOutgoingStructuralLinks(node);
  }

  public static Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return OPMNodeAnalysis.findIncomingStructuralLinks(node);
  }

  public static OPMObjectProcessDiagram findOPD(OPMNode node) {
    return OPMNodeAnalysis.findOPD(node);
  }
}

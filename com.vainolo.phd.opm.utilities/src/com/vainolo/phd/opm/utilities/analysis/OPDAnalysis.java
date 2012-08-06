/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPDAnalysis {

  private OPMObjectProcessDiagram opd;

  public OPDAnalysis(OPMObjectProcessDiagram opd) {
    this.opd = opd;
  }

  public Collection<OPMProceduralLink> findIncomingDataLinks(OPMProcess process) {
    return null;
  }

  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    return null;
  }

  public Collection<OPMProceduralLink> findOutgoingInvocationLinks(OPMProcess process) {
    return null;
  }

  public Collection<OPMProceduralLink> findAllProceduralLinks(OPMNode node) {
    return null;
  }

  public Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMProcess process) {
    return null;
  }

  public Collection<OPMObject> findContainedObjects(OPMContainer container) {
    return null;
  }

  public Collection<OPMProcess> findContainedProcesses(OPMContainer container) {
    return null;
  }

  public Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMObject object) {
    return null;
  }

  public Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMObject object) {
    return null;
  }

  public OPMProcess findZoomedInProcess(OPMObjectProcessDiagram opd) {
    return null;
  }

  public Collection<OPMProcess> findExecutableProcesses(OPMObjectProcessDiagram opd) {
    return null;
  }

  public Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return null;
  }

  public Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return null;
  }

  public OPMObjectProcessDiagram findOPD(OPMNode node) {
    return null;
  }
}

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
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProceduralLink> findOutgoingInvocationLinks(OPMProcess process) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProceduralLink> findAllProceduralLinks(OPMNode node) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMProcess process) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMObject> findContainedObjects(OPMContainer container) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProcess> findContainedProcesses(OPMContainer container) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMObject object) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProceduralLink> findOutgoingProceduralLinks(OPMObject object) {
    throw new UnsupportedOperationException();
  }

  public OPMProcess findZoomedInProcess(OPMObjectProcessDiagram opd) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMProcess> findExecutableProcesses(OPMObjectProcessDiagram opd) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    throw new UnsupportedOperationException();
  }

  public Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    throw new UnsupportedOperationException();
  }

  public OPMObjectProcessDiagram findOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) { // $codepro.audit.disable useForLoop
      currentContainer = ((OPMNode) currentContainer).getContainer();
    }
    return (OPMObjectProcessDiagram) currentContainer;
  }
}

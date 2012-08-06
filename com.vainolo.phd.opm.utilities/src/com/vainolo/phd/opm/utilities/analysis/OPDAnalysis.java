/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;

import com.google.common.collect.Collections2;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.predicates.IsOPMProcessNode;
import com.vainolo.phd.opm.utilities.predicates.IsOPMStructuralLink;

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

  public Collection<OPMProcess> findExecutableProcesses(OPMObjectProcessDiagram opd) {
    throw new UnsupportedOperationException();
  }

  // Implementing
  // Finished implementing with tests

  public OPMProcess findZoomedInProcess(OPMObjectProcessDiagram opd) {
    Collection<OPMNode> processNodes = Collections2.filter(opd.getNodes(), IsOPMProcessNode.INSTANCE);
    if(processNodes.size() != 1) {
      throw new RuntimeException("A compound OPD can containt only one process directly.");
    }
    return (OPMProcess) processNodes.iterator().next();
  }

  public Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getOutgoingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  public Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getIncomingLinks(), IsOPMStructuralLink.INSTANCE);
  }
}

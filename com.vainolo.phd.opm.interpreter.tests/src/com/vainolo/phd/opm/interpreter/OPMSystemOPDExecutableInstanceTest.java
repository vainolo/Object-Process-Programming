/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMSystemOPDExecutableInstanceTest {

  private OPMSystemOPDExecutableInstance instance;
  private OPMObjectProcessDiagram opd;
  private OPDAnalyzer analyzer;
  private OPMProcess theProcess, process1, process2, process3, process4, process5;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDagMock;
  private Set<OPMProcess> waitingProcessesMock, waitingProcesses;   
  private Set<OPMProcess> readyProcessesMock, readyProcesses;
  private Set<DefaultEdge> outgoingEdgesOfMock, outgoingEdgesOf1, outgoingEdgesOf2,outgoingEdgesOf3;
  private Set<DefaultEdge> incomingEdgesOfMock, incomingEdgesOf1, incomingEdgesOf2, incomingEdgesOf3;
  private DefaultEdge edge1, edge2, edge3, edge4, edge5;
  
  @Before
  public void setUp() {
    opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    opd.setName("Hello");
    opd.setKind(OPMObjectProcessDiagramKind.COMPOUND);
    theProcess = OPMFactory.eINSTANCE.createOPMProcess();
    process1 = OPMFactory.eINSTANCE.createOPMProcess();
    process2 = OPMFactory.eINSTANCE.createOPMProcess();
    process3 = OPMFactory.eINSTANCE.createOPMProcess();    
    process4 = OPMFactory.eINSTANCE.createOPMProcess();    
    process5 = OPMFactory.eINSTANCE.createOPMProcess();    
    opdDagMock = mock(DirectedAcyclicGraph.class);
    waitingProcessesMock = mock(Set.class);
    waitingProcesses = Sets.newHashSet();
    readyProcessesMock = mock(Set.class);
    readyProcesses = Sets.newHashSet();
    outgoingEdgesOfMock = mock(Set.class);
    outgoingEdgesOf1 = Sets.newHashSet();
    outgoingEdgesOf2 = Sets.newHashSet();
    outgoingEdgesOf3 = Sets.newHashSet();
    incomingEdgesOfMock  = mock(Set.class);
    incomingEdgesOf1 = Sets.newHashSet();
    incomingEdgesOf2 = Sets.newHashSet();
    incomingEdgesOf3 = Sets.newHashSet();
    analyzer = mock(OPDAnalyzer.class);
    edge1 = new DefaultEdge();
    edge2 = new DefaultEdge();
    
  }
}
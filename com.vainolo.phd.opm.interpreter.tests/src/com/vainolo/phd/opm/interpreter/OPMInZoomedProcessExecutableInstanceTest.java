/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMProcessKind;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMInZoomedProcessExecutableInstanceTest {

  private OPMInZoomedProcessExecutableInstance instance;
//  private OPMObjectProcessDiagram opd;
//  private OPDAnalyzer analyzer;
//  private OPMProcess theProcess, process1, process2, process3, process4, process5;
//  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDagMock;
//  private Set<OPMProcess> waitingProcessesMock, waitingProcesses;   
//  private Set<OPMProcess> readyProcessesMock, readyProcesses;
//  private Set<DefaultEdge> outgoingEdgesOfMock, outgoingEdgesOf1, outgoingEdgesOf2,outgoingEdgesOf3;
//  private Set<DefaultEdge> incomingEdgesOfMock, incomingEdgesOf1, incomingEdgesOf2, incomingEdgesOf3;
//  private DefaultEdge edge1, edge2, edge3, edge4, edge5;
  
  private OPMObjectProcessDiagram createInZoomedOPD(String name) {
    OPMObjectProcessDiagram opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    opd.setKind(OPMObjectProcessDiagramKind.COMPOUND);
    opd.setName(name);
    return opd;
  }
  
  private OPMProcess createProcess(String name, OPMProcessKind kind) {
    OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
    process.setKind(kind);
    process.setName(name);
    return process;
  }
  
  private OPMObject createObject(String name) {
    OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
    object.setName(name);
    return object;
  }
  
  private OPMProceduralLink createProceduralLink(String centerDecoration, OPMProceduralLinkKind kind, OPMNode source, OPMNode target) {
    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setCenterDecoration(centerDecoration);
    link.setKind(kind);
    link.setSource(source);
    link.setTarget(target);
    return link;
  }
  
  @Test
  public void test_addTwoNumbers() {
    OPMObjectProcessDiagram opd = createInZoomedOPD("Adding Two Numbers");
    OPMProcess zoomedInProcess = createProcess("Adding two numbers", OPMProcessKind.COMPOUND);
    opd.getNodes().add(zoomedInProcess);
    OPMProcess innerProcess = createProcess("+", OPMProcessKind.BUILT_IN);
    zoomedInProcess.getNodes().add(innerProcess);
    OPMObject object = createObject("a");
    opd.getNodes().add(object);
    OPMProceduralLink link = createProceduralLink("a", OPMProceduralLinkKind.INSTRUMENT, object, innerProcess);
    opd.getLinks().add(link);
    object = createObject("b");
    opd.getNodes().add(object);
    link = createProceduralLink("b", OPMProceduralLinkKind.INSTRUMENT, object, innerProcess);
    opd.getLinks().add(link);
    object = createObject("c");
    opd.getNodes().add(object);
    link = createProceduralLink("c", OPMProceduralLinkKind.RESULT, innerProcess, object);
    opd.getLinks().add(link);
    
    OPMExecutableInstance instance = OPMExecutableInstanceFactory.createExecutableInstance(opd);
    
    instance.setArgument("a", OPMObjectInstance.createFromValue(new BigDecimal(1.0)));
    instance.setArgument("b", OPMObjectInstance.createFromValue(new BigDecimal(2.0)));
    instance.execute();
    assertEquals(3.0, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);
    
    instance.setArgument("a", OPMObjectInstance.createFromValue(new BigDecimal(5.0)));
    instance.setArgument("b", OPMObjectInstance.createFromValue(new BigDecimal(15.4)));
    instance.execute();
    assertEquals(20.4, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);
  }
  
  @Before
  public void setUp() {
//    opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
//    opd.setName("Hello");
//    opd.setKind(OPMObjectProcessDiagramKind.COMPOUND);
//    theProcess = OPMFactory.eINSTANCE.createOPMProcess();
//    process1 = OPMFactory.eINSTANCE.createOPMProcess();
//    process2 = OPMFactory.eINSTANCE.createOPMProcess();
//    process3 = OPMFactory.eINSTANCE.createOPMProcess();    
//    process4 = OPMFactory.eINSTANCE.createOPMProcess();    
//    process5 = OPMFactory.eINSTANCE.createOPMProcess();    
//    opdDagMock = mock(DirectedAcyclicGraph.class);
//    waitingProcessesMock = mock(Set.class);
//    waitingProcesses = Sets.newHashSet();
//    readyProcessesMock = mock(Set.class);
//    readyProcesses = Sets.newHashSet();
//    outgoingEdgesOfMock = mock(Set.class);
//    outgoingEdgesOf1 = Sets.newHashSet();
//    outgoingEdgesOf2 = Sets.newHashSet();
//    outgoingEdgesOf3 = Sets.newHashSet();
//    incomingEdgesOfMock  = mock(Set.class);
//    incomingEdgesOf1 = Sets.newHashSet();
//    incomingEdgesOf2 = Sets.newHashSet();
//    incomingEdgesOf3 = Sets.newHashSet();
//    analyzer = mock(OPDAnalyzer.class);
//    edge1 = new DefaultEdge();
//    edge2 = new DefaultEdge();
    
  }
}
/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind;

/**
 * The class <code>OPDAnalyzerTest</code> contains tests for the class
 * <code>{@link opdExecutionAnalyzer}</code>.
 * 
 * @generatedBy CodePro at 6/27/12 11:34 AM
 * @author vainolo
 * @version $Revision: 1.0 $
 */
public class OPDAnalyzerTest {
  private OPMObjectProcessDiagram opd;
  // private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private static final int SPACING = 50;

  private final Map<Integer, OPMProcess> processes = new HashMap<Integer, OPMProcess>();
  // private OPDExecutionAnalysis opdExecutionAnalyzer;
  private OPDAnalyzer analyzer;
  private OPMNode node;
  private OPMProcess process;

  // private void createProcess(final Integer name) {
  // final OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
  // process.setName(name.toString());
  // process.setConstraints(new Rectangle(10, 10, 10, 10));
  // processes.put(name, process);
  // opd.getNodes().add(process);
  // }
  //
  // private void createParalleProcess(final OPMProcess process, final Integer
  // name) {
  // final OPMProcess newProcess = OPMFactory.eINSTANCE.createOPMProcess();
  // newProcess.setName(name.toString());
  // final Rectangle constraints = new Rectangle();
  // constraints.setX(process.getConstraints().x() + SPACING);
  // constraints.setY(process.getConstraints().y());
  // constraints.setSize(process.getConstraints().getSize().getCopy());
  // newProcess.setConstraints(constraints);
  // processes.put(name, newProcess);
  // opd.getNodes().add(newProcess);
  // }
  //
  // private void createSerialProcess(final OPMProcess process, final Integer
  // name) {
  // final OPMProcess newProcess = OPMFactory.eINSTANCE.createOPMProcess();
  // newProcess.setName(name.toString());
  // final Rectangle constraints = new Rectangle();
  // constraints.setX(process.getConstraints().x());
  // constraints.setY(process.getConstraints().getBottom().y() + SPACING);
  // constraints.setSize(process.getConstraints().getSize().getCopy());
  // newProcess.setConstraints(constraints);
  // processes.put(name, newProcess);
  // opd.getNodes().add(newProcess);
  // }
  //
  // @Test
  // public void testCreateOPDDAG_DAGNeverNull() {
  // opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertNotNull(opdDag);
  // }
  //
  // @Test
  // public void testCreateOPDDAG_OneNode() {
  // createProcess(1);
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertEquals(1, opdDag.vertexSet().size());
  // assertTrue(opdDag.vertexSet().contains(processes.get(1)));
  // }
  //
  // @Test
  // public void testCreateOPDDAG_TwoNodes() {
  // final int numOfNodes = 2;
  // for(int i = 1; i <= numOfNodes; i++) {
  // createProcess(i);
  // }
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertEquals(numOfNodes, opdDag.vertexSet().size());
  // assertTrue(opdDag.vertexSet().contains(processes.get(1)));
  // assertTrue(opdDag.vertexSet().contains(processes.get(2)));
  // }
  //
  // @Test
  // public void testCreateOPDDAG_RandomNumberOfNodes() {
  // final int numOfNodes = (new Random()).nextInt(50);
  // for(int i = 1; i <= numOfNodes; i++) {
  // createProcess(i);
  // }
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertEquals(numOfNodes, opdDag.vertexSet().size());
  // for(int i = 1; i <= numOfNodes; i++) {
  // assertTrue(opdDag.vertexSet().contains(processes.get(i)));
  // }
  // }
  //
  // @Test
  // public void testCreateOPDDAG_TwoSerialNodes() {
  // createProcess(1);
  // createSerialProcess(processes.get(1), 2);
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // final Set<DefaultEdge> edges = opdDag.getAllEdges(processes.get(1),
  // processes.get(2));
  // assertEquals(1, edges.size());
  // final DefaultEdge edge = edges.iterator().next();
  // assertEquals(processes.get(1), opdDag.getEdgeSource(edge));
  // assertEquals(processes.get(2), opdDag.getEdgeTarget(edge));
  // }
  //
  // @Test
  // public void testCreateOPDDAG_TwoParallelNodes() {
  // createProcess(1);
  // createParalleProcess(processes.get(1), 2);
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // final Set<DefaultEdge> edges = opdDag.getAllEdges(processes.get(1),
  // processes.get(2));
  // assertEquals(0, edges.size());
  // }
  //
  // @Test
  // public void testCreateOPDDAG_OneAndThenTwoParallel() {
  // createProcess(1);
  // createSerialProcess(processes.get(1), 2);
  // createParalleProcess(processes.get(2), 3);
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertTrue(opdDag.containsEdge(processes.get(1), processes.get(2)));
  // assertTrue(opdDag.containsEdge(processes.get(1), processes.get(3)));
  // assertTrue(!opdDag.containsEdge(processes.get(2), processes.get(3)));
  // assertTrue(!opdDag.containsEdge(processes.get(3), processes.get(2)));
  // }
  //
  // @Test
  // public void testCreateOPDDAG_TwoParallelAndThenOne() {
  // createProcess(1);
  // createParalleProcess(processes.get(1), 2);
  // createSerialProcess(processes.get(1), 3);
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertEquals(2, opdDag.edgeSet().size());
  // assertTrue(opdDag.containsEdge(processes.get(1), processes.get(3)));
  // assertTrue(opdDag.containsEdge(processes.get(2), processes.get(3)));
  // assertTrue(!opdDag.containsEdge(processes.get(1), processes.get(2)));
  // assertTrue(!opdDag.containsEdge(processes.get(2), processes.get(1)));
  // }
  //
  // @Test
  // public void testCreateOPDDAG_SerialNoDuplicateEdges() {
  // createProcess(1);
  // createSerialProcess(processes.get(1), 2);
  // createSerialProcess(processes.get(2), 3);
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertEquals(2, opdDag.edgeSet().size());
  // assertTrue(opdDag.containsEdge(processes.get(1), processes.get(2)));
  // assertTrue(opdDag.containsEdge(processes.get(2), processes.get(3)));
  // }
  //
  // @Test
  // public void testCreateDAG_SerialAndParallelNoDuplicates() {
  // createProcess(1);
  // createSerialProcess(processes.get(1), 2);
  // createParalleProcess(processes.get(2), 3);
  // createSerialProcess(processes.get(3), 4);
  //
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // assertEquals(4, opdDag.edgeSet().size());
  // assertTrue(opdDag.containsEdge(processes.get(1), processes.get(2)));
  // assertTrue(opdDag.containsEdge(processes.get(1), processes.get(3)));
  // assertTrue(opdDag.containsEdge(processes.get(2), processes.get(4)));
  // assertTrue(opdDag.containsEdge(processes.get(3), processes.get(4)));
  //
  // }
  //
  // @Test(expected = IllegalArgumentException.class)
  // public void testGetNextProcessToExecute_NullDAG_IllegalArgumentException()
  // {
  // createProcess(1);
  // opdExecutionAnalyzer.findFollowingProcesses(null, processes.get(1));
  // }
  //
  // @Test(expected = IllegalArgumentException.class)
  // public void
  // testGetNextProcessToExecute_NullProcess_IllegalArgumentException() {
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  //
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, null);
  // }
  //
  // private void prepareSerialOPDTest() {
  // createProcess(1);
  // createSerialProcess(processes.get(1), 2);
  // createSerialProcess(processes.get(2), 3);
  // createSerialProcess(processes.get(3), 4);
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  // }
  //
  // @Test
  // public void testGetNextProcessToExecute_SerialOPD_1() {
  // prepareSerialOPDTest();
  //
  // final Set<OPMProcess> nextProcesses =
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, processes.get(1));
  //
  // assertEquals(1, nextProcesses.size());
  // assertTrue(nextProcesses.contains(processes.get(2)));
  // }
  //
  // @Test
  // public void testGetNextProcessToExecute_SerialOPD_2() {
  // prepareSerialOPDTest();
  //
  // Set<OPMProcess> nextProcesses =
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, processes.get(3));
  //
  // assertEquals(1, nextProcesses.size());
  // assertTrue(nextProcesses.contains(processes.get(4)));
  // }
  //
  // @Test
  // public void testGetNextProcessToExecute_SerialOPD_3() {
  // prepareSerialOPDTest();
  //
  // Set<OPMProcess> nextProcesses =
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, processes.get(4));
  //
  // assertEquals(0, nextProcesses.size());
  // }
  //
  // private void prepareParallelOPDTest() {
  // createProcess(1);
  // createSerialProcess(processes.get(1), 2);
  // createParalleProcess(processes.get(2), 3);
  // createParalleProcess(processes.get(3), 4);
  // createSerialProcess(processes.get(2), 5);
  // createSerialProcess(processes.get(3), 6);
  // createSerialProcess(processes.get(5), 7);
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  // }
  //
  // @Test
  // public void testGetNextProcessToExecute_ParallelOPD_1() {
  // prepareParallelOPDTest();
  //
  // Set<OPMProcess> nextProcesses =
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, processes.get(1));
  //
  // assertEquals(3, nextProcesses.size());
  // assertTrue(nextProcesses.contains(processes.get(2)));
  // assertTrue(nextProcesses.contains(processes.get(3)));
  // assertTrue(nextProcesses.contains(processes.get(4)));
  // }
  //
  // @Test
  // public void testGetNextProcessToExecute_ParallelOPD_2() {
  // prepareParallelOPDTest();
  //
  // Set<OPMProcess> nextProcesses =
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, processes.get(2));
  //
  // assertEquals(2, nextProcesses.size());
  // assertTrue(nextProcesses.contains(processes.get(5)));
  // assertTrue(nextProcesses.contains(processes.get(6)));
  // }
  //
  // @Test
  // public void textGetNextProcessToExecute_ParallelOPD_3() {
  // prepareParallelOPDTest();
  //
  // Set<OPMProcess> nextProcesses =
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, processes.get(5));
  //
  // final Set<OPMProcess> nextProcesses2 =
  // opdExecutionAnalyzer.findFollowingProcesses(opdDag, processes.get(6));
  // assertEquals(nextProcesses, nextProcesses2);
  // }
  //
  // @Test(expected = IllegalArgumentException.class)
  // public void testGetInitialProcesses_EmptyOPD() {
  // opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  // final Set<OPMProcess> initialProcesses =
  // opdExecutionAnalyzer.calculateInitialProcesses(opdDag);
  // assertEquals(0, initialProcesses.size());
  // }
  //
  // @Test
  // public void testGetInitialProcesses_OneProcess() {
  // createProcess(1);
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  // final Set<OPMProcess> initialProcesses =
  // opdExecutionAnalyzer.calculateInitialProcesses(opdDag);
  // assertEquals(1, initialProcesses.size());
  // }
  //
  // @Test
  // public void testGetInitialProcesses_TwoParallelProcesses() {
  // createProcess(1);
  // createParalleProcess(processes.get(1), 2);
  // createSerialProcess(processes.get(1), 3);
  // createSerialProcess(processes.get(2), 4);
  // createSerialProcess(processes.get(3), 5);
  // createSerialProcess(processes.get(5), 6);
  // createParalleProcess(processes.get(5), 7);
  // opdDag = opdExecutionAnalyzer.createContainerExecutionDAG(opd);
  // final Set<OPMProcess> initialProcesses =
  // opdExecutionAnalyzer.calculateInitialProcesses(opdDag);
  // assertEquals(2, initialProcesses.size());
  // assertTrue(initialProcesses.contains(processes.get(1)));
  // assertTrue(initialProcesses.contains(processes.get(2)));
  // }

  // findOPD()
  @Test
  public void test_findOPD_firstLevelNode() {
    when(node.getContainer()).thenReturn(opd);
    OPMObjectProcessDiagram result = analyzer.findOPD(node);
    assertEquals(opd, result);
  }

  @Test
  public void test_findOPD_secondLevelNode() {
    when(node.getContainer()).thenReturn(process);
    when(process.getContainer()).thenReturn(opd);
    OPMObjectProcessDiagram result = analyzer.findOPD(node);
    assertEquals(opd, result);
  }

  // findIncomingStructuralLinks()
  @Test
  public void test_findIncomingStructuralLinks_noLinks() {
    Collection<OPMLink> result = analyzer.findIncomingStructuralLinks(createProcess());
    assertEquals(0, result.size());
  }

  @Test
  public void test_findIncomingStructuralLinks_oneIncomingStructuralLink() {
    OPMObject object = createObject();
    addIncomingStructuralLink(object);
    Collection<OPMLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findIncomingStructuralLinks_twoIncomingStructuralLinks() {
    OPMObject object = createObject();
    addIncomingStructuralLink(object);
    addIncomingStructuralLink(object);
    Collection<OPMLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(2, result.size());
  }

  @Test
  public void test_findIncomingStructuralLinks_twoIncomingStructuralLinksOneProceduralLink() {
    OPMObject object = createObject();
    addIncomingStructuralLink(object);
    addIncomingStructuralLink(object);
    addIncomingProceduralLink(object);
    Collection<OPMLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(2, result.size());

  }

  @Test
  public void test_findIncomingStructuralLinks_twoIncomingOneOutgoingStructuralLink() {
    OPMObject object = createObject();
    addIncomingStructuralLink(object);
    addIncomingStructuralLink(object);
    addOutgoingStructuralLink(object);
    Collection<OPMLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(2, result.size());
  }

  // findOutgoingStructuralLinks()
  @Test
  public void test_findOutgoingStructuralLinks_noLinks() {
    Collection<OPMLink> result = analyzer.findOutgoingStructuralLinks(createProcess());
    assertEquals(0, result.size());
  }

  @Test
  public void test_findOutgoingStructuralLinks_oneOutgoingStructuralLink() {
    OPMObject object = createObject();
    addOutgoingStructuralLink(object);
    Collection<OPMLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findOutgoingStructuralLinks_twoOutgoingStructuralLinks() {
    OPMObject object = createObject();
    addOutgoingStructuralLink(object);
    addOutgoingStructuralLink(object);
    Collection<OPMLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(2, result.size());
  }

  @Test
  public void test_findOutgoingStructuralLinks_twoOutgoingStructuralLinksOneProceduralLink() {
    OPMObject object = createObject();
    addOutgoingStructuralLink(object);
    addOutgoingStructuralLink(object);
    addOutgoingProceduralLink(object);
    Collection<OPMLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(2, result.size());

  }

  @Test
  public void test_findIncomingStructuralLinks_twoOutgoingOneIncomingStructuralLink() {
    OPMObject object = createObject();
    addIncomingStructuralLink(object);
    addOutgoingStructuralLink(object);
    addOutgoingStructuralLink(object);
    Collection<OPMLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(2, result.size());
  }
  
  @Test
  public void test_findParent_hasParent_returnTrue() {
	  OPMObject whole = createObject();
	  OPMObject part = createObject();
	  addPart(whole, part);
	  
  }
  
  // Test helper methods
  private void addOutgoingProceduralLink(OPMNode node) {
    OPMLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setSource(node);
  }

  private void addIncomingProceduralLink(OPMNode node) {
    OPMLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setTarget(node);
  }

  private void addOutgoingStructuralLink(OPMNode node) {
    OPMNode aggregator = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
    OPMLink link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(node);
    link.setTarget(aggregator);
  }

  private void addIncomingStructuralLink(OPMNode node) {
    OPMNode aggregator = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
    OPMLink link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(aggregator);
    link.setTarget(node);
  }
  
  private void addPart(OPMObject whole, OPMObject part) {
	  OPMStructuralLinkAggregator aggregator = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
	  aggregator.setKind(OPMStructuralLinkAggregatorKind.AGGREGATION);
	  OPMLink link = OPMFactory.eINSTANCE.createOPMLink();
	  link.setSource(whole);
	  link.setTarget(aggregator);
	  link = OPMFactory.eINSTANCE.createOPMLink();
	  link.setSource(aggregator);
	  link.setTarget(part);
  }

  private OPMObject createObject() {
    return OPMFactory.eINSTANCE.createOPMObject();
  }

  private OPMObject createVariable() {
    OPMObject o = OPMFactory.eINSTANCE.createOPMObject();
    o.setParameter(false);
    return o;
  }

  private OPMObject createParameter() {
    OPMObject o = OPMFactory.eINSTANCE.createOPMObject();
    o.setParameter(true);
    return o;
  }

  private OPMProcess createProcess() {
    OPMProcess p = OPMFactory.eINSTANCE.createOPMProcess();
    return p;
  }

  @Before
  public void setUp() {
    node = mock(OPMNode.class);
    // using OPMProcess to simulate both a node and a container.
    process = mock(OPMProcess.class);
    opd = mock(OPMObjectProcessDiagram.class);

    opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    analyzer = new OPDAnalyzer();
  }

}
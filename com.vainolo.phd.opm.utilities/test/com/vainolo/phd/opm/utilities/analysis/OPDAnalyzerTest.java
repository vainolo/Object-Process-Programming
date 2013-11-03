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

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

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
  private OPDAnalyzer opdAnalyzer;
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

  @Test
  public void test_findOPD_firstLevelNode() {
    when(node.getContainer()).thenReturn(opd);
    OPMObjectProcessDiagram result = opdAnalyzer.findOPD(node);
    assertEquals(opd, result);
  }

  @Test
  public void test_findOPD_secondLevelNode() {
    when(node.getContainer()).thenReturn(process);
    when(process.getContainer()).thenReturn(opd);
    OPMObjectProcessDiagram result = opdAnalyzer.findOPD(node);
    assertEquals(opd, result);
  }

  @Test
  public void test_findVariables_noVariables() {
    Collection<OPMObject> result = opdAnalyzer.findVariables(opd);
    assertEquals(0, result.size());
  }

  @Test
  public void test_findVariables_oneVariable() {
    opd.getNodes().add(createVariable());
    Collection<OPMObject> result = opdAnalyzer.findVariables(opd);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findVariables_twoVariables() {
    opd.getNodes().add(createVariable());
    opd.getNodes().add(createVariable());
    Collection<OPMObject> result = opdAnalyzer.findVariables(opd);
    assertEquals(2, result.size());
  }

  @Test
  public void test_findVariables_twoVariablesAndOneParameter() {
    opd.getNodes().add(createVariable());
    opd.getNodes().add(createVariable());
    opd.getNodes().add(createParameter());
    Collection<OPMObject> result = opdAnalyzer.findVariables(opd);
    assertEquals(2, result.size());
  }

  @Test
  public void test_findVariables_twoVariablesAndInnerVariable() {
    opd.getNodes().add(createVariable());
    OPMObject node2 = createVariable();
    opd.getNodes().add(node2);
    node2.getNodes().add(createVariable());
    Collection<OPMObject> result = opdAnalyzer.findVariables(opd);
    assertEquals(2, result.size());
  }

  @Test
  public void test_findVariables_oneVariableOneParameterOneProcess() {
    opd.getNodes().add(createVariable());
    opd.getNodes().add(createProcess());
    Collection<OPMObject> result = opdAnalyzer.findVariables(opd);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findParameters_noParameters() {
    Collection<OPMObject> result = opdAnalyzer.findParameters(opd);
    assertEquals(0, result.size());
  }

  @Test
  public void test_findParameters_oneParameter() {
    opd.getNodes().add(createParameter());
    Collection<OPMObject> result = opdAnalyzer.findParameters(opd);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findParameters_oneParameterOneVariable() {
    opd.getNodes().add(createVariable());
    opd.getNodes().add(createParameter());
    Collection<OPMObject> result = opdAnalyzer.findParameters(opd);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findParameters_twoParametersOneVariableOneProcess() {
    opd.getNodes().add(createParameter());
    opd.getNodes().add(createParameter());
    opd.getNodes().add(createVariable());
    opd.getNodes().add(createProcess());
    Collection<OPMObject> result = opdAnalyzer.findParameters(opd);
    assertEquals(2, result.size());
  }

  // No tests for inner parameters since they should not be allowed by the
  // editor.

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
    opdAnalyzer = new OPDAnalyzer();
  }

}
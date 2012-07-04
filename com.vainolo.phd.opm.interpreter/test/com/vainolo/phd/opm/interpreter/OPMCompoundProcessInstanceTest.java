/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.jui.SystemProperties;
import com.vainolo.phd.opm.interpreter.model.Variable;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMProcessKind;

import static org.easymock.EasyMock.*;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 3 Jul 2012
 * 
 */
public class OPMCompoundProcessInstanceTest extends OPMAbstractProcessInstanceTest {

  private IMockBuilder<OPMCompoundProcessInstance> builder;
  private OPMCompoundProcessInstance fixture;
  private DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag;
  private OPDAnalyzer analyzer;

  @Test
  public void testExecuteStep_FirstStep() {
    builder.addMockedMethod("prepare");
    builder.addMockedMethod("isFirstStep");
    builder.addMockedMethod("getInitialProcesses");
    builder.addMockedMethod("executeProcesses");
    final List<OPMProcess> processList = new ArrayList<OPMProcess>();

    fixture = builder.createStrictMock();
    expect(fixture.isFirstStep()).andReturn(true);
    fixture.prepare();
    expect(fixture.getInitialProcesses()).andReturn(processList);
    fixture.executeProcesses(processList);
    fixture.setFirstStep(false);
    replay(fixture);

    fixture.executeStep();

    verify(fixture);
  }

  @Test
  public void testExecuteStep_NotFirstStep() {
    builder.addMockedMethod("prepare");
    builder.addMockedMethod("isFirstStep");
    builder.addMockedMethod("getNextProcesses");
    builder.addMockedMethod("executeProcesses");
    final List<OPMProcess> processList = new ArrayList<OPMProcess>();

    fixture = builder.createStrictMock();
    expect(fixture.isFirstStep()).andReturn(false);
    expect(fixture.getNextProcesses()).andReturn(processList);
    fixture.executeProcesses(processList);
    replay(fixture);

    fixture.executeStep();

    verify(fixture);
  }

  @Test
  public void testExecuteStep_TwoExecutions() {
    builder.addMockedMethod("prepare");
    builder.addMockedMethod("getInitialProcesses");
    builder.addMockedMethod("getNextProcesses");
    builder.addMockedMethod("executeProcesses");
    final List<OPMProcess> processList = new ArrayList<OPMProcess>();

    fixture = builder.createStrictMock();
    fixture.prepare();
    expect(fixture.getInitialProcesses()).andReturn(processList);
    fixture.executeProcesses(processList);
    expect(fixture.getNextProcesses()).andReturn(processList);
    fixture.executeProcesses(processList);
    replay(fixture);

    fixture.setFirstStep(true);
    fixture.executeStep();
    fixture.executeStep();

    verify(fixture);

  }

  @Test
  public void testPrepare() {
    builder.addMockedMethod("loadProcessDefinition");
    builder.addMockedMethod("createLocalVariables");
    fixture = builder.createStrictMock();
    fixture.loadProcessDefinition();
    fixture.createLocalVariables();
    replay(fixture);

    fixture.prepare();

    verify(fixture);

  }

  @Test
  public void testSetAndGetOPD() {
    fixture = builder.createMock();
    final OPMObjectProcessDiagram diagram = EasyMock.createMock(OPMObjectProcessDiagram.class);

    fixture.setOpd(diagram);
    assertEquals(diagram, fixture.getOpd());
  }

  @Test
  public void TestCreateLocalVariables() {
    final int numOfObjects = 10;
    final EList<OPMObject> objects = new BasicEList<OPMObject>();
    for(int i = 0; i < numOfObjects; i++) {
      final OPMObject o = OPMFactory.eINSTANCE.createOPMObject();
      o.setName("O" + i);
      objects.add(o);
    }
    builder.addMockedMethod("getVarManager");
    builder.addMockedMethod("getOpd");
    fixture = builder.createMock();
    final VariableManager varManager = createMock(VariableManager.class);
    final OPMObjectProcessDiagram opd = createMock(OPMObjectProcessDiagram.class);
    final Variable var = createMock(Variable.class);
    expect(fixture.getVarManager()).andReturn(varManager).anyTimes();
    expect(fixture.getOpd()).andReturn(opd);
    expect(opd.getObjects()).andReturn(objects);
    for(int i = 0; i < numOfObjects; i++)
      if(i % 3 == 0)
        expect(varManager.variableExists("O" + i)).andReturn(true);
      else {
        expect(varManager.variableExists("O" + i)).andReturn(false);
        expect(varManager.createVariable("O" + i)).andReturn(var);
      }
    replay(fixture, varManager, opd);

    fixture.createLocalVariables();

    verify(fixture, varManager, opd);
  }

  @Test
  public void testSetOpdDag() {
    fixture = builder.createMock();
    final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag = createMock(DirectedAcyclicGraph.class);

    fixture.setOpdDag(opdDag);
    assertEquals(opdDag, fixture.getOpdDag());
  }

  @Test
  public void testGetInitialProcesses() {
    builder.addMockedMethod("getOpdDag");
    fixture = builder.createMock();
    final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag = createMock(DirectedAcyclicGraph.class);
    expect(fixture.getOpdDag()).andReturn(opdDag);
    expect(opdDag.vertexSet()).andReturn(new HashSet());
    replay(fixture, opdDag);

    fixture.getInitialProcesses();

    verify(fixture);
  }

  @Test
  public void testLoadProcessDefinition() throws Exception {
    final String processName = "p1";
    final String tempfile = System.getProperty(SystemProperties.osTempDir) + processName + ".opm";
    final URI tempFileURI = URI.createFileURI(tempfile);
    final ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    final Resource resource = resourceSet.createResource(tempFileURI);
    final OPMObjectProcessDiagram diagram = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    diagram.setName(processName);
    resource.getContents().add(diagram);
    resource.save(null);

    builder.addMockedMethod("getProcessFilename");
    fixture = builder.createMock();
    expect(fixture.getProcessFilename()).andReturn(tempfile).atLeastOnce();
    replay(fixture);

    fixture.loadProcessDefinition();

    resource.delete(null);

    verify(fixture);
  }

  @Test
  public void testExecuteProcesses() {
    int numOfProcesses = 3;
    OPMProcessInstanceFactory factory = EasyMock.createMock(OPMProcessInstanceFactory.class);
    OPMProcessInstance processInstance = EasyMock.createMock(OPMProcessInstance.class);
    opdDag = EasyMock.createMock(DirectedAcyclicGraph.class);
    List<OPMProcess> processList = new ArrayList<OPMProcess>();

    for(int i = 0; i < numOfProcesses; i++)
      processList.add(EasyMock.createMock(OPMProcess.class));
    builder.addMockedMethod("getProcessInstanceFactory");
    builder.addMockedMethod("getOpdDag");
    fixture = builder.createMock();

    for(int i = 0; i < numOfProcesses; i++) {
      expect(processList.get(i).getName()).andReturn("P" + i).anyTimes();
      expect(processList.get(i).getKind()).andReturn(OPMProcessKind.COMPOUND);
      expect(processList.get(i).getIncomingProceduralLinks()).andReturn(new BasicEList<OPMProceduralLink>());
      expect(fixture.getProcessInstanceFactory()).andReturn(factory);
      expect(factory.createProcessInstance(anyObject(String.class), anyObject(OPMProcessKind.class))).andReturn(
          processInstance);
      processInstance.execute();
      expect(processList.get(i).getOutgoingProceduralLinks()).andReturn(new BasicEList<OPMProceduralLink>());
      expect(fixture.getOpdDag()).andReturn(opdDag);
      expect(opdDag.outgoingEdgesOf(anyObject(OPMProcess.class))).andReturn(new HashSet<DefaultEdge>());
      replay(processList.get(i));
    }
    replay(fixture, processInstance, factory, opdDag);

    fixture.executeProcesses(processList);

    verify(fixture, processInstance, factory, opdDag);
    for(int i = 0; i < numOfProcesses; i++)
      verify(processList.get(i));
  }

  /**
   * Perform pre-test initialization.
   * 
   * @throws Exception
   *           if the initialization fails for some reason
   */
  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    builder = createMockBuilder(OPMCompoundProcessInstance.class);
  }

  /**
   * Perform post-test clean-up.
   * 
   * @throws Exception
   *           if the clean-up fails for some reason
   */
  @Override
  @After
  public void tearDown() throws Exception {
    super.tearDown();
  }
}
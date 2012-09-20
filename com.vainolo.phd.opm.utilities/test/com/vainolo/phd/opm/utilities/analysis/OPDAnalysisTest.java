/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

public class OPDAnalysisTest {

  private static final int SYSTEM_OBJETCS = 6;
  private static final int SYSTEM_PROCESSES = 5;
  private static final int IN_ZOOMED_OBJECTS = 7;
  private static final int IN_ZOOMED_PROCESSES = 1;
  private static final int IN_ZOOMED_INSIDE_OBJECTS = 5;
  private static final int IN_ZOOMED_INSIDE_PROCESS = 8;
  private static final int IN_ZOOMED_OBJECTS_WITH_STATES = 2;
  private static final int IN_ZOOMED_OBJECTS_STATES = 6;

  private OPMObjectProcessDiagram systemOPD;
  private Map<Integer, OPMProcess> systemProcesses = Maps.newHashMap();
  private Map<Integer, OPMObject> systemObjects = Maps.newHashMap();
  private Map<Integer, OPMStructuralLinkAggregator> systemAggregators = Maps.newHashMap();
  private Map<Integer, OPMLink> systemStructuralLinks = Maps.newHashMap();
  private Map<Integer, OPMProceduralLink> systemProceduralLinks = Maps.newHashMap();

  private OPMObjectProcessDiagram inZoomedOPD;
  private Map<Integer, OPMProcess> inZoomedProcesses = Maps.newHashMap();
  private Map<Integer, OPMObject> inZoomedObjects = Maps.newHashMap();
  private Map<Integer, OPMStructuralLinkAggregator> inZoomedAggregators = Maps.newHashMap();
  private Map<Integer, OPMLink> inZoomedStructuralLinks = Maps.newHashMap();
  private Map<Integer, OPMProceduralLink> inZoomedProceduralLinks = Maps.newHashMap();
  private Map<Integer, OPMObject> inZoomedObjectsWithStates = Maps.newHashMap();
  private Map<Integer, OPMState> inZoomedStates = Maps.newHashMap();

  private OPDAnalysis fixture;

  @Test
  public void testFindIncomingStructuralLinks() {
    Collection<OPMLink> result = fixture.findIncomingStructuralLinks(systemObjects.get(2));
    assertEquals(2, result.size());
    assertTrue(result.contains(systemStructuralLinks.get(2)));
    assertTrue(result.contains(systemStructuralLinks.get(4)));
  }

  @Test
  public void testFindOutgoingStructuralLinks() {
    Collection<OPMLink> result = fixture.findOutgoingStructuralLinks(systemObjects.get(3));

    assertEquals(2, result.size());
    assertTrue(result.contains(systemStructuralLinks.get(3)));
    assertTrue(result.contains(systemStructuralLinks.get(5)));
  }

  @Test
  public void testFindInZoomedProcess() {
    OPMProcess result = fixture.findInZoomedProcess(inZoomedOPD);
    assertEquals(inZoomedProcesses.get(0), result);
  }

  @Test
  public void testFindInZoomedProcess_IllegalCall() {
    OPMProcess result = null;
    try {
      result = fixture.findInZoomedProcess(systemOPD);
      fail("Should not get here.");
    } catch(RuntimeException e) {}
  }

  @Test
  public void testFindContainedObjects_SystemOPD() {
    Collection<OPMObject> result = fixture.findContainedObjects(systemOPD);
    assertEquals(SYSTEM_OBJETCS, result.size());
    for(int i = 0; i < SYSTEM_OBJETCS; i++) {
      assertTrue(result.contains(systemObjects.get(i)));
    }
  }

  @Test
  public void testFindContainedObjects_InZoomedOPD() {
    Collection<OPMObject> result = fixture.findContainedObjects(inZoomedOPD);
    assertEquals(IN_ZOOMED_OBJECTS + IN_ZOOMED_OBJECTS_WITH_STATES, result.size());
    for(int i = 0; i < IN_ZOOMED_OBJECTS; i++) {
      assertTrue(result.contains(inZoomedObjects.get(i)));
    }
    for(int i = 0; i < IN_ZOOMED_OBJECTS_WITH_STATES; i++) {
      assertTrue(result.contains(inZoomedObjectsWithStates.get(i)));
    }
  }

  @Test
  public void testFindContainedObjects_InsideInZoomedProcess() {
    Collection<OPMObject> result = fixture.findContainedObjects(inZoomedProcesses.get(0));
    assertEquals(IN_ZOOMED_INSIDE_OBJECTS, result.size());
    for(int i = IN_ZOOMED_OBJECTS; i < IN_ZOOMED_OBJECTS + IN_ZOOMED_INSIDE_OBJECTS; i++) {
      assertTrue(result.contains(inZoomedObjects.get(i)));
    }
  }

  @Test
  public void testFindExecutableProcesses_SystemOPD() {
    Collection<OPMProcess> result = fixture.findExecutableProcesses(systemOPD);

    assertEquals(SYSTEM_PROCESSES, result.size());
    for(int i = 0; i < SYSTEM_PROCESSES; i++)
      assertTrue(result.contains(systemProcesses.get(i)));
  }

  @Test
  public void testFindExecutableProcesses_InZoomedOPD() {
    Collection<OPMProcess> result = fixture.findExecutableProcesses(inZoomedOPD);

    assertEquals(IN_ZOOMED_INSIDE_PROCESS, result.size());
    for(int i = IN_ZOOMED_PROCESSES; i < IN_ZOOMED_PROCESSES + IN_ZOOMED_INSIDE_PROCESS; i++)
      assertTrue(result.contains(inZoomedProcesses.get(i)));
  }

  @Test
  public void testFindOutgoingDataLinks_Process() {
    Iterable<OPMProceduralLink> result = fixture.findOutgoingDataLinks(inZoomedProcesses.get(2));

    assertEquals(4, Iterables.size(result));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(5)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(6)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(7)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(12)));

    result = fixture.findOutgoingDataLinks(inZoomedProcesses.get(6));
    assertEquals(1, Iterables.size(result));
  }

  @Test
  public void testFindIncomingDataLinks_Process() {
    Iterable<OPMProceduralLink> result = fixture.findIncomingDataLinks(inZoomedProcesses.get(2));

    assertEquals(10, Iterables.size(result));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(1)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(2)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(3)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(4)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(5)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(6)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(7)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(8)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(9)));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(10)));

    result = fixture.findIncomingDataLinks(inZoomedProcesses.get(5));
    assertEquals(2, Iterables.size(result));
    for(OPMProceduralLink link : result) {
      assertTrue(inZoomedStates.values().contains(link.getSource()));
    }
  }

  @Test
  public void testFindOutgoingInvocationLinks() {
    Iterable<OPMProceduralLink> result = fixture.findOutgoingInvocationLinks(inZoomedProcesses.get(2));

    assertEquals(1, Iterables.size(result));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(11)));
  }

  @Test
  public void testFindOPD() {
    OPMObjectProcessDiagram result = fixture.findOPD(systemObjects.get(2));
    assertEquals(systemOPD, result);

    result = fixture.findOPD(systemProcesses.get(1));
    assertEquals(systemOPD, result);

    result = fixture.findOPD(inZoomedObjects.get(10));
    assertEquals(inZoomedOPD, result);

    result = fixture.findOPD(inZoomedProcesses.get(4));
    assertEquals(inZoomedOPD, result);

  }

  @Test
  public void testfindConnectedEventProcesses() {
    Collection<OPMProcess> result = fixture.findConnectedEventProcesses(inZoomedObjects.get(6));
    assertEquals(2, result.size());
    assertTrue(result.contains(inZoomedProcesses.get(2)));
    assertTrue(result.contains(inZoomedProcesses.get(4)));
  }

  @Test
  public void testFindInvocationProcesses() {
    Set<OPMProcess> result = fixture.findInvocationProcesses(inZoomedProcesses.get(2));
    assertEquals(1, result.size());
    assertTrue(result.contains(inZoomedProcesses.get(3)));

  }

  @Before
  public void setUp() {
    initSystemOPD();
    initInZoomedOPD();
    fixture = new OPDAnalysis();
  }

  public void initSystemOPD() {
    systemOPD = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    systemOPD.setKind(OPMObjectProcessDiagramKind.SYSTEM);

    createProcesses(systemOPD, systemProcesses, SYSTEM_PROCESSES, 0);
    createObjects(systemOPD, systemObjects, SYSTEM_OBJETCS, 0);
    createAggregators(systemOPD, systemAggregators, 3, 0);

    createSystemOPDStructuralLinks();
    createSystemOPDProceduralLinks();
  }

  private void createSystemOPDProceduralLinks() {
    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.AGENT);
    link.setSource(systemObjects.get(0));
    link.setTarget(systemProcesses.get(0));
    systemProceduralLinks.put(0, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INSTRUMENT);
    link.setSource(systemObjects.get(1));
    link.setTarget(systemProcesses.get(0));
    systemProceduralLinks.put(1, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.CONSUMPTION);
    link.setSource(systemObjects.get(2));
    link.setTarget(systemProcesses.get(0));
    systemProceduralLinks.put(2, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.RESULT);
    link.setSource(systemProcesses.get(0));
    link.setTarget(systemObjects.get(3));
    systemProceduralLinks.put(3, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.EFFECT);
    link.setSource(systemObjects.get(4));
    link.setTarget(systemProcesses.get(0));

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.EFFECT);
    link.setSource(systemProcesses.get(0));
    link.setTarget(systemObjects.get(5));

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INVOCATION);
    link.setSource(systemProcesses.get(0));
    link.setTarget(systemProcesses.get(1));
  }

  private void createSystemOPDStructuralLinks() {
    OPMLink link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(systemObjects.get(0));
    link.setTarget(systemAggregators.get(0));
    systemStructuralLinks.put(0, link);

    link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(systemAggregators.get(0));
    link.setTarget(systemObjects.get(1));
    systemStructuralLinks.put(1, link);

    link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(systemAggregators.get(0));
    link.setTarget(systemObjects.get(2));
    systemStructuralLinks.put(2, link);

    link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(systemObjects.get(3));
    link.setTarget(systemAggregators.get(1));
    systemStructuralLinks.put(3, link);

    link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(systemAggregators.get(1));
    link.setTarget(systemObjects.get(2));
    systemStructuralLinks.put(4, link);

    link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(systemObjects.get(3));
    link.setTarget(systemAggregators.get(2));
    systemStructuralLinks.put(5, link);

    link = OPMFactory.eINSTANCE.createOPMLink();
    link.setSource(systemAggregators.get(2));
    link.setTarget(systemObjects.get(4));
    systemStructuralLinks.put(6, link);
  }

  private void initInZoomedOPD() {
    inZoomedOPD = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    inZoomedOPD.setKind(OPMObjectProcessDiagramKind.COMPOUND);

    createObjects(inZoomedOPD, inZoomedObjects, IN_ZOOMED_OBJECTS, 0);
    createProcesses(inZoomedOPD, inZoomedProcesses, IN_ZOOMED_PROCESSES, 0);
    createAggregators(inZoomedOPD, inZoomedAggregators, 3, 0);

    OPMProcess inZoomedProcess = inZoomedProcesses.get(0);
    createObjects(inZoomedProcess, inZoomedObjects, IN_ZOOMED_INSIDE_OBJECTS, IN_ZOOMED_OBJECTS);
    createProcesses(inZoomedProcess, inZoomedProcesses, IN_ZOOMED_INSIDE_PROCESS, IN_ZOOMED_PROCESSES);
    createInZoomedOPDProceduralLinks();
    createInZoomedStatesAndProceduralLinks();
  }

  private void createInZoomedStatesAndProceduralLinks() {
    for(int i = 0; i < IN_ZOOMED_OBJECTS_WITH_STATES; i++) {
      OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
      inZoomedOPD.getNodes().add(object);
      inZoomedObjectsWithStates.put(i, object);
    }

    int j = 0;
    for(OPMObject object : inZoomedObjectsWithStates.values()) {
      for(int i = 0; i < IN_ZOOMED_OBJECTS_WITH_STATES; i++) {
        OPMState state = OPMFactory.eINSTANCE.createOPMState();
        object.getNodes().add(state);
        inZoomedStates.put(i + j, state);
      }
      j++;
    }

    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.CONSUMPTION);
    link.setSource(inZoomedStates.get(0));
    link.setTarget(inZoomedProcesses.get(5));

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INSTRUMENT_EVENT);
    link.setSource(inZoomedStates.get(1));
    link.setTarget(inZoomedProcesses.get(5));

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.RESULT);
    link.setSource(inZoomedProcesses.get(6));
    link.setTarget(inZoomedStates.get(2));
  }

  private void createInZoomedOPDProceduralLinks() {
    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.AGENT);
    link.setSource(inZoomedObjects.get(0));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(1, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.CONSUMPTION);
    link.setSource(inZoomedObjects.get(1));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(2, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.CONSUMPTION_CONDITION);
    link.setSource(inZoomedObjects.get(2));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(3, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.CONSUMPTION_EVENT);
    link.setSource(inZoomedObjects.get(3));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(4, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.EFFECT);
    link.setSource(inZoomedObjects.get(4));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(5, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.EFFECT_CONDITION);
    link.setSource(inZoomedObjects.get(5));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(6, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.EFFECT_EVENT);
    link.setSource(inZoomedObjects.get(6));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(7, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INSTRUMENT);
    link.setSource(inZoomedObjects.get(7));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(8, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INSTRUMENT_CONDITION);
    link.setSource(inZoomedObjects.get(8));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(9, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INSTRUMENT_EVENT);
    link.setSource(inZoomedObjects.get(9));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(10, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INVOCATION);
    link.setSource(inZoomedProcesses.get(2));
    link.setTarget(inZoomedProcesses.get(3));
    inZoomedProceduralLinks.put(11, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.RESULT);
    link.setTarget(inZoomedProcesses.get(2));
    link.setSource(inZoomedObjects.get(10));
    inZoomedProceduralLinks.put(12, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.CONSUMPTION_EVENT);
    link.setSource(inZoomedObjects.get(6));
    link.setTarget(inZoomedProcesses.get(4));
  }

  private void createObjects(OPMContainer container, Map<Integer, OPMObject> objects, int number, int startIndex) {
    for(int i = startIndex; i < startIndex + number; i++) {
      OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
      object.setName(Integer.toString(i));
      objects.put(i, object);
      container.getNodes().add(object);
    }
  }

  private void createProcesses(OPMContainer container, Map<Integer, OPMProcess> processes, int number, int startIndex) {
    for(int i = startIndex; i < startIndex + number; i++) {
      OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
      process.setName(Integer.toString(i));
      processes.put(i, process);
      container.getNodes().add(process);
    }
  }

  private void createAggregators(OPMContainer container, Map<Integer, OPMStructuralLinkAggregator> aggregators,
      int number, int startIndex) {
    for(int i = startIndex; i < startIndex + number; i++) {
      OPMStructuralLinkAggregator aggregator = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
      aggregators.put(i, aggregator);
      container.getNodes().add(aggregator);
    }
  }

}
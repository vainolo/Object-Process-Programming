/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities.analysis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
    } catch(RuntimeException e) {
    }
  }

  @Test
  public void testFindExecutableProcesses_SystemOPD() {
    Collection<OPMProcess> result = fixture.findFirstLevelContainedProcesses(systemOPD);

    assertEquals(SYSTEM_PROCESSES, result.size());
    for(int i = 0; i < SYSTEM_PROCESSES; i++)
      assertTrue(result.contains(systemProcesses.get(i)));
  }

  @Test
  public void testFindOutgoingInvocationLinks() {
    Iterable<OPMProceduralLink> result = fixture.findOutgoingInvocationLinks(inZoomedProcesses.get(2));

    assertEquals(1, Iterables.size(result));
    assertTrue(Iterables.contains(result, inZoomedProceduralLinks.get(11)));
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
    fixture = OPDAnalysis.INSTANCE;
  }

  public void initSystemOPD() {
    systemOPD = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    systemOPD.setKind(OPMObjectProcessDiagramKind.COMPOUND);

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
    link.setKind(OPMProceduralLinkKind.EFFECT);
    link.setSource(inZoomedObjects.get(4));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(5, link);

    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(OPMProceduralLinkKind.INSTRUMENT);
    link.setSource(inZoomedObjects.get(7));
    link.setTarget(inZoomedProcesses.get(2));
    inZoomedProceduralLinks.put(8, link);

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
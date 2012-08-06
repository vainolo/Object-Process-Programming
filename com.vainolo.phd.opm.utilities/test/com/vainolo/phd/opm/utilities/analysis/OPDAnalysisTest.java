package com.vainolo.phd.opm.utilities.analysis;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

public class OPDAnalysisTest {

  private OPMObjectProcessDiagram systemOPD;
  private Map<Integer, OPMProcess> systemProcesses = Maps.newHashMap();
  private Map<Integer, OPMObject> systemObjects = Maps.newHashMap();
  private Map<Integer, OPMStructuralLinkAggregator> systemAggregators = Maps.newHashMap();
  private Map<Integer, OPMLink> systemStructuralLinks = Maps.newHashMap();

  private OPMObjectProcessDiagram inZoomedOPD;
  private Map<Integer, OPMProcess> inZoomedProcesses = Maps.newHashMap();
  private Map<Integer, OPMObject> inZoomedObjects = Maps.newHashMap();
  private Map<Integer, OPMStructuralLinkAggregator> inZoomedAggregators = Maps.newHashMap();
  private Map<Integer, OPMLink> inZoomedStructuralLinks = Maps.newHashMap();

  private OPDAnalysis systemOPDFixture;
  private OPDAnalysis inZoomedOPDFixture;

  @Test
  public void testFindIncomingStructuralLinks() {
    Collection<OPMLink> result = systemOPDFixture.findIncomingStructuralLinks(systemObjects.get(2));
    assertEquals(2, result.size());
    assertTrue(result.contains(systemStructuralLinks.get(2)));
    assertTrue(result.contains(systemStructuralLinks.get(4)));
  }

  @Test
  public void testFindOutgoingStructuralLinks() {
    Collection<OPMLink> result = systemOPDFixture.findOutgoingStructuralLinks(systemObjects.get(3));

    assertEquals(2, result.size());
    assertTrue(result.contains(systemStructuralLinks.get(3)));
    assertTrue(result.contains(systemStructuralLinks.get(5)));
  }

  @Test
  public void testFindInZoomedProcess() {
    OPMProcess result = inZoomedOPDFixture.findZoomedInProcess(inZoomedOPD);
    assertEquals(inZoomedProcesses.get(0), result);
  }

  @Test(expected = RuntimeException.class)
  public void testFindInZoomedProcess_IllegalCall() {
    systemOPDFixture.findZoomedInProcess(systemOPD);
  }

  @Test
  public void testFindContainedObjects_SystemOPD() {
    Collection<OPMObject> result = systemOPDFixture.findContainedObjects(systemOPD);
    assertEquals(5, result.size());
    for(int i = 0; i < 5; i++) {
      assertTrue(result.contains(systemObjects.get(i)));
    }
  }

  @Test
  public void testFindContainedObjects_InZoomedOPD() {
    Collection<OPMObject> result = inZoomedOPDFixture.findContainedObjects(inZoomedOPD);
    assertEquals(5, result.size());
    for(int i = 0; i < 5; i++) {
      assertTrue(result.contains(inZoomedObjects.get(i)));
    }
  }

  public void testFindContainedObjects_InsideInZoomedProcess() {
    Collection<OPMObject> result = inZoomedOPDFixture.findContainedObjects(inZoomedProcesses.get(0));
    assertEquals(5, result.size());
    for(int i = 5; i < 10; i++) {
      assertTrue(result.contains(inZoomedObjects.get(i)));
    }
  }

  @Before
  public void setUp() {
    initSystemOPD();
    initInZoomedOPD();
    systemOPDFixture = new OPDAnalysis(systemOPD);
    inZoomedOPDFixture = new OPDAnalysis(inZoomedOPD);
  }

  public void initSystemOPD() {
    systemOPD = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();

    createProcesses(systemOPD, systemProcesses, 5);
    createObjects(systemOPD, systemObjects, 5);
    createAggregators(systemOPD, systemAggregators, 3);

    // create some structural links.
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
    createProcesses(inZoomedOPD, inZoomedProcesses, 1);
    createObjects(inZoomedOPD, inZoomedObjects, 5);
    createAggregators(inZoomedOPD, inZoomedAggregators, 3);

    OPMProcess inZoomedProcess = inZoomedProcesses.get(0);
    createObjects(inZoomedProcess, inZoomedObjects, 5);
  }

  private void createObjects(OPMContainer container, Map<Integer, OPMObject> objects, int number) {
    for(int i = 0; i < number; i++) {
      OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
      object.setName(Integer.toString(i + 5));
      objects.put(objects.size(), object);
      container.getNodes().add(object);
    }
  }

  private void createProcesses(OPMContainer container, Map<Integer, OPMProcess> processes, int number) {
    for(int i = 0; i < number; i++) {
      OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
      process.setName(Integer.toString(i + 5));
      processes.put(processes.size(), process);
      container.getNodes().add(process);
    }
  }

  private void createAggregators(OPMContainer container, Map<Integer, OPMStructuralLinkAggregator> aggregators,
      int number) {
    for(int i = 0; i < number; i++) {
      OPMStructuralLinkAggregator aggregator = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
      aggregators.put(aggregators.size(), aggregator);
      container.getNodes().add(aggregator);
    }
  }

}
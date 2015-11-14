/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.utilities.analysis;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind;
import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer;

public class OPPOPDAnalyzerTest {
  private OPPObjectProcessDiagram opd;
  private OPPAnalyzer analyzer;
  private OPPNode node;
  private OPPProcess process;

  // findOPD()
  @Test
  public void test_findOPD_firstLevelNode() {
    when(node.getContainer()).thenReturn(opd);
    OPPObjectProcessDiagram result = analyzer.findOPD(node);
    assertEquals(opd, result);
  }

  @Test
  public void test_findOPD_secondLevelNode() {
    when(node.getContainer()).thenReturn(process);
    when(process.getContainer()).thenReturn(opd);
    OPPObjectProcessDiagram result = analyzer.findOPD(node);
    assertEquals(opd, result);
  }

  // findIncomingStructuralLinks()
  @Test
  public void test_findIncomingStructuralLinks_noLinks() {
    Collection<OPPLink> result = analyzer.findIncomingStructuralLinks(createProcess());
    assertEquals(0, result.size());
  }

  @Test
  public void test_findIncomingStructuralLinks_oneIncomingStructuralLink() {
    OPPObject object = createObject();
    addIncomingStructuralLink(object);
    Collection<OPPLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findIncomingStructuralLinks_twoIncomingStructuralLinks() {
    OPPObject object = createObject();
    addIncomingStructuralLink(object);
    addIncomingStructuralLink(object);
    Collection<OPPLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(2, result.size());
  }

  @Test
  public void test_findIncomingStructuralLinks_twoIncomingStructuralLinksOneProceduralLink() {
    OPPObject object = createObject();
    addIncomingStructuralLink(object);
    addIncomingStructuralLink(object);
    addIncomingProceduralLink(object);
    Collection<OPPLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(2, result.size());

  }

  @Test
  public void test_findIncomingStructuralLinks_twoIncomingOneOutgoingStructuralLink() {
    OPPObject object = createObject();
    addIncomingStructuralLink(object);
    addIncomingStructuralLink(object);
    addOutgoingStructuralLink(object);
    Collection<OPPLink> result = analyzer.findIncomingStructuralLinks(object);
    assertEquals(2, result.size());
  }

  // findOutgoingStructuralLinks()
  @Test
  public void test_findOutgoingStructuralLinks_noLinks() {
    Collection<OPPLink> result = analyzer.findOutgoingStructuralLinks(createProcess());
    assertEquals(0, result.size());
  }

  @Test
  public void test_findOutgoingStructuralLinks_oneOutgoingStructuralLink() {
    OPPObject object = createObject();
    addOutgoingStructuralLink(object);
    Collection<OPPLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(1, result.size());
  }

  @Test
  public void test_findOutgoingStructuralLinks_twoOutgoingStructuralLinks() {
    OPPObject object = createObject();
    addOutgoingStructuralLink(object);
    addOutgoingStructuralLink(object);
    Collection<OPPLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(2, result.size());
  }

  @Test
  public void test_findOutgoingStructuralLinks_twoOutgoingStructuralLinksOneProceduralLink() {
    OPPObject object = createObject();
    addOutgoingStructuralLink(object);
    addOutgoingStructuralLink(object);
    addOutgoingProceduralLink(object);
    Collection<OPPLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(2, result.size());

  }

  @Test
  public void test_findIncomingStructuralLinks_twoOutgoingOneIncomingStructuralLink() {
    OPPObject object = createObject();
    addIncomingStructuralLink(object);
    addOutgoingStructuralLink(object);
    addOutgoingStructuralLink(object);
    Collection<OPPLink> result = analyzer.findOutgoingStructuralLinks(object);
    assertEquals(2, result.size());
  }
  
  @Test
  public void test_findParent_hasParent_returnTrue() {
	  OPPObject whole = createObject();
	  OPPObject part = createObject();
	  addPart(whole, part);
	  
  }
  
  // Test helper methods
  private void addOutgoingProceduralLink(OPPNode node) {
    OPPLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setSource(node);
  }

  private void addIncomingProceduralLink(OPPNode node) {
    OPPLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setTarget(node);
  }

  private void addOutgoingStructuralLink(OPPNode node) {
    OPPNode aggregator = OPPFactory.eINSTANCE.createOPPStructuralLinkAggregator();
    OPPLink link = OPPFactory.eINSTANCE.createOPPStructuralLinkPart();
    link.setSource(node);
    link.setTarget(aggregator);
  }

  private void addIncomingStructuralLink(OPPNode node) {
    OPPNode aggregator = OPPFactory.eINSTANCE.createOPPStructuralLinkAggregator();
    OPPLink link = OPPFactory.eINSTANCE.createOPPStructuralLinkPart();
    link.setSource(aggregator);
    link.setTarget(node);
  }
  
  private void addPart(OPPObject whole, OPPObject part) {
	  OPPStructuralLinkAggregator aggregator = OPPFactory.eINSTANCE.createOPPStructuralLinkAggregator();
	  aggregator.setKind(OPPStructuralLinkAggregatorKind.AGGREGATION);
	  OPPLink link = OPPFactory.eINSTANCE.createOPPStructuralLinkPart();
	  link.setSource(whole);
	  link.setTarget(aggregator);
	  link = OPPFactory.eINSTANCE.createOPPLink();
	  link.setSource(aggregator);
	  link.setTarget(part);
  }

  private OPPObject createObject() {
    return OPPFactory.eINSTANCE.createOPPObject();
  }

//  private OPMObject createVariable() {
//    OPMObject o = OPMFactory.eINSTANCE.createOPMObject();
//    o.setParameter(false);
//    return o;
//  }
//
//  private OPMObject createParameter() {
//    OPMObject o = OPMFactory.eINSTANCE.createOPMObject();
//    o.setParameter(true);
//    return o;
//  }

  private OPPProcess createProcess() {
    OPPProcess p = OPPFactory.eINSTANCE.createOPPProcess();
    return p;
  }

  @Before
  public void setUp() {
    node = mock(OPPNode.class);
    // using OPMProcess to simulate both a node and a container.
    process = mock(OPPProcess.class);
    opd = mock(OPPObjectProcessDiagram.class);

    opd = OPPFactory.eINSTANCE.createOPPObjectProcessDiagram();
    analyzer = new OPPAnalyzer();
  }

}
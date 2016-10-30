/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstanceFactory;
import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPProcessKind;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPInZoomedProcessExecutableInstanceTest {

  private OPPObjectProcessDiagram createInZoomedOPD(String name) {
    OPPObjectProcessDiagram opd = OPPFactory.eINSTANCE.createOPPObjectProcessDiagram();
    opd.setKind(OPPObjectProcessDiagramKind.COMPOUND);
    opd.setName(name);
    return opd;
  }

  private OPPProcess createProcess(String name, OPPProcessKind kind) {
    OPPProcess process = OPPFactory.eINSTANCE.createOPPProcess();
    process.setKind(kind);
    process.setName(name);
    process.setY(10);
    return process;
  }

  private OPPObject createObject(String name) {
    OPPObject object = OPPFactory.eINSTANCE.createOPPObject();
    object.setName(name);
    return object;
  }

  private OPPProceduralLink createProceduralLink(String centerDecoration, OPPProceduralLinkKind kind, OPPNode source, OPPNode target) {
    OPPProceduralLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setCenterDecoration(centerDecoration);
    link.setKind(kind);
    link.setSource(source);
    link.setTarget(target);
    return link;
  }

  @Test
  public void test_execute_addTwoNumbers() throws Exception {
    OPPObjectProcessDiagram opd = createInZoomedOPD("Adding Two Numbers");
    OPPProcess inZoomedProcess = createProcess("Adding Two Numbers", OPPProcessKind.COMPOUND);
    opd.getNodes().add(inZoomedProcess);

    OPPProcess innerProcess = createProcess("+", OPPProcessKind.BUILT_IN);
    inZoomedProcess.getNodes().add(innerProcess);
    OPPObject object = createObject("a");
    opd.getNodes().add(object);
    opd.getLinks().add(createProceduralLink("a", OPPProceduralLinkKind.INSTRUMENT, object, innerProcess));
    object = createObject("b");
    opd.getNodes().add(object);
    opd.getLinks().add(createProceduralLink("b", OPPProceduralLinkKind.INSTRUMENT, object, innerProcess));
    object = createObject("c");
    opd.getNodes().add(object);
    opd.getLinks().add(createProceduralLink("c", OPPProceduralLinkKind.CONS_RES, innerProcess, object));

    OPPProcessInstance instance = OPPProcessInstanceFactory.createExecutableInstance(opd);

    instance.setArgument("a", OPPObjectInstance.createFromValue(new BigDecimal(1.0)));
    instance.setArgument("b", OPPObjectInstance.createFromValue(new BigDecimal(2.0)));
    instance.call();
    assertEquals(3.0, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);

    instance.setArgument("a", OPPObjectInstance.createFromValue(new BigDecimal(5.0)));
    instance.setArgument("b", OPPObjectInstance.createFromValue(new BigDecimal(15.4)));
    instance.call();
    assertEquals(20.4, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);
  }

  @Before
  public void setUp() {

  }
}
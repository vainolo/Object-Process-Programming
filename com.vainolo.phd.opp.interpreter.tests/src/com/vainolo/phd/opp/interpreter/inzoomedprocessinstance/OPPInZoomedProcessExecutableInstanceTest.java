/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
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

  @Test
  public void test_execute_AddTwoNumber_ArgumentInference() throws Exception {
    OPPObjectProcessDiagram opd = createInZoomedOPD("Adding Two Numbers with Argument Inference");
    OPPProcess inZoomedProcess = createProcess("Adding Two Numbers with Argument Inference", OPPProcessKind.COMPOUND);
    opd.getNodes().add(inZoomedProcess);

    OPPProcess addProcess = createProcess("+", OPPProcessKind.BUILT_IN);
    inZoomedProcess.getNodes().add(addProcess);

    OPPObject one = createObject("1");
    inZoomedProcess.getNodes().add(one);
    OPPObject two = createObject("2");
    inZoomedProcess.getNodes().add(two);

    OPPObject a = createObject("a");
    inZoomedProcess.getNodes().add(a);
    OPPObject b = createObject("b");
    inZoomedProcess.getNodes().add(b);
    OPPObject c = createObject("c");
    opd.getNodes().add(c);

    opd.getLinks().add(createProceduralLink(null, OPPProceduralLinkKind.CONS_RES, one, a));
    opd.getLinks().add(createProceduralLink(null, OPPProceduralLinkKind.CONS_RES, two, b));
    opd.getLinks().add(createProceduralLink(null, OPPProceduralLinkKind.CONS_RES, a, addProcess));
    opd.getLinks().add(createProceduralLink(null, OPPProceduralLinkKind.CONS_RES, b, addProcess));
    opd.getLinks().add(createProceduralLink(null, OPPProceduralLinkKind.CONS_RES, addProcess, c));

    OPPProcessInstance instance = OPPProcessInstanceFactory.createExecutableInstance(opd);
    instance.call();
    assertEquals(3.0, ((BigDecimal) instance.getArgument("c").getValue()).doubleValue(), 0.01);

    instance = OPPProcessInstanceFactory.createExecutableInstance(opd);
    c.setName("C");
    instance.call();
    assertEquals(3.0, ((BigDecimal) instance.getArgument("C").getValue()).doubleValue(), 0.01);

    instance = OPPProcessInstanceFactory.createExecutableInstance(opd);
    a.setName("A");
    instance.call();
    assertEquals(3.0, ((BigDecimal) instance.getArgument("C").getValue()).doubleValue(), 0.01);

  }

  @Before
  public void setUp() {

  }
}
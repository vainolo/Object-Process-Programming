/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstanceFactory;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMProcessKind;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMInZoomedProcessExecutableInstanceTest {

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

  private OPMProceduralLink createProceduralLink(String centerDecoration, OPMProceduralLinkKind kind, OPMNode source,
      OPMNode target) {
    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setCenterDecoration(centerDecoration);
    link.setKind(kind);
    link.setSource(source);
    link.setTarget(target);
    return link;
  }

  @Test
  public void test_execute_addTwoNumbers() {
    OPMObjectProcessDiagram opd = createInZoomedOPD("Adding Two Numbers");
    OPMProcess inZoomedProcess = createProcess("Adding Two Numbers", OPMProcessKind.COMPOUND);
    opd.getNodes().add(inZoomedProcess);
    OPMProcess innerProcess = createProcess("+", OPMProcessKind.BUILT_IN);
    inZoomedProcess.getNodes().add(innerProcess);
    OPMObject object = createObject("a");
    opd.getNodes().add(object);
    opd.getLinks().add(createProceduralLink("a", OPMProceduralLinkKind.INSTRUMENT, object, innerProcess));
    object = createObject("b");
    opd.getNodes().add(object);
    opd.getLinks().add(createProceduralLink("b", OPMProceduralLinkKind.INSTRUMENT, object, innerProcess));
    object = createObject("c");
    opd.getNodes().add(object);
    opd.getLinks().add(createProceduralLink("c", OPMProceduralLinkKind.RESULT, innerProcess, object));

    OPMProcessInstance instance = OPMProcessInstanceFactory.createExecutableInstance(opd);

    instance.setArgument("a", OPMObjectInstance.createFromValue(new BigDecimal(1.0)));
    instance.setArgument("b", OPMObjectInstance.createFromValue(new BigDecimal(2.0)));
    instance.execute();
    assertEquals(3.0, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);

    instance.setArgument("a", OPMObjectInstance.createFromValue(new BigDecimal(5.0)));
    instance.setArgument("b", OPMObjectInstance.createFromValue(new BigDecimal(15.4)));
    instance.execute();
    assertEquals(20.4, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);
  }

  @Test
  public void test_execute_AddTwoNumber_ArgumentInference() {
    OPMObjectProcessDiagram opd = createInZoomedOPD("Adding Two Numbers with Arugment Inference");
    OPMProcess inZoomedProcess = createProcess("Adding Two Numbers with Argument Inference", OPMProcessKind.COMPOUND);
    opd.getNodes().add(inZoomedProcess);

    OPMProcess addProcess = createProcess("+", OPMProcessKind.BUILT_IN);
    inZoomedProcess.getNodes().add(addProcess);
    OPMObject one = createObject("1");
    opd.getNodes().add(one);
    OPMObject two = createObject("2");
    opd.getNodes().add(two);
    OPMObject a = createObject("a");
    inZoomedProcess.getNodes().add(a);
    OPMObject b = createObject("b");
    inZoomedProcess.getNodes().add(b);
    OPMObject c = createObject("c");
    opd.getNodes().add(c);

    opd.getLinks().add(createProceduralLink(null, OPMProceduralLinkKind.CONSUMPTION, one, a));
    opd.getLinks().add(createProceduralLink(null, OPMProceduralLinkKind.CONSUMPTION, two, b));
    opd.getLinks().add(createProceduralLink(null, OPMProceduralLinkKind.INSTRUMENT, a, addProcess));
    opd.getLinks().add(createProceduralLink(null, OPMProceduralLinkKind.INSTRUMENT, b, addProcess));
    opd.getLinks().add(createProceduralLink(null, OPMProceduralLinkKind.RESULT, addProcess, c));

    OPMProcessInstance instance = OPMProcessInstanceFactory.createExecutableInstance(opd);
    instance.execute();
    assertEquals(3.0, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);

    c.setName("C");
    instance.execute();
    assertEquals(3.0, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);

    a.setName("A");
    instance.execute();
    assertEquals(3.0, BigDecimal.class.cast(instance.getArgument("c").getValue()).doubleValue(), 0.01);

  }

  @Before
  public void setUp() {

  }
}
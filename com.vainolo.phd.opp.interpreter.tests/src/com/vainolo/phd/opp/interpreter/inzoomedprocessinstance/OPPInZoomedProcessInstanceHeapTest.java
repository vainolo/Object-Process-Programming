/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap.OPMHeapChange;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap.OPMHeapChangeType;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance.InstanceKind;
import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind;
import com.vainolo.phd.opp.model.OPPStructuralLinkPart;

public class OPPInZoomedProcessInstanceHeapTest {

  private OPPInZoomedProcessInstanceHeap heap;
  private OPPObject obj1, obj2, obj3, part1, part2, part11, objPart12;
  private OPPObjectInstance inst1, inst2, inst3;
  private MyObserver observer;
  private OPPObjectInstance compInst1;
  private OPPObjectInstance compInst2;

  @Test
  public void createVariable() {
    heap.setVariable(obj1, inst1);
    OPPObjectInstance objectInstance = heap.getVariable(obj1);
    assertEquals(inst1.getNumericalValue(), objectInstance.getNumericalValue());
  }

  @Test
  public void createVariable_ReceiveNotification() {
    heap.addObserver(observer);
    heap.setVariable(obj1, inst1);
    assertEquals(inst1.getNumericalValue(), observer.changes.get(0).objectInstance.getNumericalValue());
    heap.setVariable(obj1, inst2);
    assertEquals(inst2.getNumericalValue(), observer.changes.get(0).objectInstance.getNumericalValue());
    heap.setVariable(obj2, inst2);
    assertEquals(inst2.getNumericalValue(), observer.changes.get(0).objectInstance.getNumericalValue());
    heap.setVariable(obj1, inst3);
    assertEquals(inst3.getNumericalValue(), observer.changes.get(0).objectInstance.getNumericalValue());
  }

  @Test
  public void createVariablePart_ValidateParentCreation() {
    createAggregationRelation(obj1, part1);

    heap.setVariable(part1, inst1);

    OPPObjectInstance instance1 = heap.getVariable(obj1);
    assertNotNull(instance1);
    OPPObjectInstance instance2 = instance1.getPart(part1.getName());
    assertNotNull(instance2);
    assertEquals(inst1.getNumericalValue(), instance2.getNumericalValue());
  }

  @Test
  public void createVariablePart_ValidateNotificationOfParentAndPart() {
    createAggregationRelation(obj1, part1);
    MyObserver observer = new MyObserver();
    heap.addObserver(observer);

    heap.setVariable(part1, inst1);

    assertEquals(2, observer.changes.size());
    assertEquals(OPMHeapChangeType.PART_ADDED, observer.changes.get(0).changeType);
    assertEquals(obj1, observer.changes.get(0).object);
    assertEquals(part1, observer.changes.get(0).child);
    assertEquals(inst1.getNumericalValue(), observer.changes.get(0).childInstance.getNumericalValue());
    assertEquals(OPMHeapChangeType.VARIABLE_SET, observer.changes.get(1).changeType);
    assertTrue(observer.changes.get(1).objectInstance.type == "Complex Object");
    assertEquals(inst1.getNumericalValue(), observer.changes.get(0).objectInstance.getPart(part1.getName()).getNumericalValue());
  }

  @Test
  public void createAndChangeCompositePart() {
    createAggregationRelation(obj1, part1);
    createAggregationRelation(obj1, part2);
    createAggregationRelation(part2, part11);

    heap.setVariable(obj1, compInst1);

    assertNotNull(heap.getVariable(obj1));
    assertEquals(heap.getVariable(obj1).getAllParts().size(), 0);

    heap.setVariable(part1, inst1);

    assertNotNull(heap.getVariable(part1));
    assertNotNull(heap.getVariable(obj1).getPart(part1.getName()));
    assertEquals(1, heap.getVariable(obj1).getAllParts().size());

    heap.setVariable(part2, compInst2);

    assertNotNull(heap.getVariable(part2));
    assertNotNull(heap.getVariable(obj1).getPart(part2.getName()));
    assertNotNull(heap.getVariable(obj1).getPart(part1.getName()));
    assertEquals(2, heap.getVariable(obj1).getAllParts().size());

    heap.setVariable(part11, inst3);

    assertNotNull(heap.getVariable(part11));
    assertNotNull(heap.getVariable(obj1).getPart(part2.getName()).getPart(part11.getName()));
    assertEquals(2, heap.getVariable(obj1).getAllParts().size());
    assertEquals(1, heap.getVariable(part2).getAllParts().size());
  }

  @Before
  public void setup() {
    heap = new OPPInZoomedProcessInstanceHeap();
    observer = new MyObserver();

    obj1 = OPPFactory.eINSTANCE.createOPPObject();
    obj1.setName("Obj1");
    obj2 = OPPFactory.eINSTANCE.createOPPObject();
    obj2.setName("Obj2");
    obj3 = OPPFactory.eINSTANCE.createOPPObject();
    obj3.setName("Obj3");
    part1 = OPPFactory.eINSTANCE.createOPPObject();
    part1.setName("Part1");
    part2 = OPPFactory.eINSTANCE.createOPPObject();
    part2.setName("Part2");
    part11 = OPPFactory.eINSTANCE.createOPPObject();
    part11.setName("Part11");
    objPart12 = OPPFactory.eINSTANCE.createOPPObject();
    objPart12.setName("Part12");

    inst1 = OPPObjectInstance.createFromValue(new BigDecimal(1));
    inst2 = OPPObjectInstance.createFromValue(new BigDecimal(2));
    inst3 = OPPObjectInstance.createFromValue(new BigDecimal(3));
    compInst1 = OPPObjectInstance.createCompositeInstance();
    compInst2 = OPPObjectInstance.createCompositeInstance();

  }

  private void createAggregationRelation(OPPObject parent, OPPObject child) {
    OPPStructuralLinkPart link = OPPFactory.eINSTANCE.createOPPStructuralLinkPart();
    OPPStructuralLinkAggregator agg = OPPFactory.eINSTANCE.createOPPStructuralLinkAggregator();
    agg.setKind(OPPStructuralLinkAggregatorKind.AGGREGATION);
    link.setSource(parent);
    link.setTarget(agg);
    link = OPPFactory.eINSTANCE.createOPPStructuralLinkPart();
    link.setSource(agg);
    link.setTarget(child);
  }

  class MyObserver implements Observer {
    public List<OPMHeapChange> changes = Lists.newArrayList();

    @Override
    public void update(Observable o, Object arg) {
      changes.add(0, OPMHeapChange.class.cast(arg));
    }
  }
}

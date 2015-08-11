package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.math.BigDecimal;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance.InstanceType;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzer;
import com.vainolo.phd.opm.interpreter.inzoomedprocessinstance.OPMInZoomedProcessInstanceHeap.OPMHeapChange;
import com.vainolo.phd.opm.interpreter.inzoomedprocessinstance.OPMInZoomedProcessInstanceHeap.OPMHeapChangeType;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMStructuralLink;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessInstanceHeapTest {

  private OPMInZoomedProcessInstanceHeap heap;
  private OPMObject obj1, obj2, obj3, part1, part2, part11, objPart12;
  private OPMObjectInstance inst1, inst2, inst3;
  private MyObserver observer;
  private OPMObjectInstance compInst1;
  private OPMObjectInstance compInst2;

  @Test
  public void createVariable() {
    heap.setVariable(obj1, inst1);
    OPMObjectInstance objectInstance = heap.getVariable(obj1);
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

    OPMObjectInstance instance1 = heap.getVariable(obj1);
    assertNotNull(instance1);
    OPMObjectInstance instance2 = instance1.getCompositePart(part1.getName());
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
    assertTrue(observer.changes.get(1).objectInstance.type == InstanceType.COMPOSITE);
    assertEquals(inst1.getNumericalValue(), observer.changes.get(0).objectInstance.getCompositePart(part1.getName())
        .getNumericalValue());
  }

  @Test
  public void createAndChangeCompositePart() {
    createAggregationRelation(obj1, part1);
    createAggregationRelation(obj1, part2);
    createAggregationRelation(part2, part11);

    heap.setVariable(obj1, compInst1);

    assertNotNull(heap.getVariable(obj1));
    assertEquals(heap.getVariable(obj1).getCompositeParts().size(), 0);

    heap.setVariable(part1, inst1);

    assertNotNull(heap.getVariable(part1));
    assertNotNull(heap.getVariable(obj1).getCompositePart(part1.getName()));
    assertEquals(1, heap.getVariable(obj1).getCompositeParts().size());

    heap.setVariable(part2, compInst2);

    assertNotNull(heap.getVariable(part2));
    assertNotNull(heap.getVariable(obj1).getCompositePart(part2.getName()));
    assertNotNull(heap.getVariable(obj1).getCompositePart(part1.getName()));
    assertEquals(2, heap.getVariable(obj1).getCompositeParts().size());

    heap.setVariable(part11, inst3);

    assertNotNull(heap.getVariable(part11));
    assertNotNull(heap.getVariable(obj1).getCompositePart(part2.getName()).getCompositePart(part11.getName()));
    assertEquals(2, heap.getVariable(obj1).getCompositeParts().size());
    assertEquals(1, heap.getVariable(part2).getCompositeParts().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void assignSimpleInstanceToCompositeObject() {
    createAggregationRelation(obj1, part1);

    heap.setVariable(obj1, inst1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void assignCompositeInstanceToSimpleObject() {
    heap.setVariable(obj1, compInst1);
  }

  @Before
  public void setup() {
    heap = new OPMInZoomedProcessInstanceHeap(new OPMObjectInstanceValueAnalyzer(), new OPDAnalyzer());
    observer = new MyObserver();

    obj1 = OPMFactory.eINSTANCE.createOPMObject();
    obj1.setName("Obj1");
    obj2 = OPMFactory.eINSTANCE.createOPMObject();
    obj2.setName("Obj2");
    obj3 = OPMFactory.eINSTANCE.createOPMObject();
    obj3.setName("Obj3");
    part1 = OPMFactory.eINSTANCE.createOPMObject();
    part1.setName("Part1");
    part2 = OPMFactory.eINSTANCE.createOPMObject();
    part2.setName("Part2");
    part11 = OPMFactory.eINSTANCE.createOPMObject();
    part11.setName("Part11");
    objPart12 = OPMFactory.eINSTANCE.createOPMObject();
    objPart12.setName("Part12");

    inst1 = OPMObjectInstance.createFromValue(new BigDecimal(1));
    inst2 = OPMObjectInstance.createFromValue(new BigDecimal(2));
    inst3 = OPMObjectInstance.createFromValue(new BigDecimal(3));
    compInst1 = OPMObjectInstance.createCompositeInstance();
    compInst2 = OPMObjectInstance.createCompositeInstance();

  }

  private void createAggregationRelation(OPMObject parent, OPMObject child) {
    OPMStructuralLink link = OPMFactory.eINSTANCE.createOPMStructuralLink();
    OPMStructuralLinkAggregator agg = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
    agg.setKind(OPMStructuralLinkAggregatorKind.AGGREGATION);
    link.setSource(parent);
    link.setTarget(agg);
    link = OPMFactory.eINSTANCE.createOPMStructuralLink();
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

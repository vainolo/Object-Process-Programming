package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.interpreter.OPMInterpreterInjector;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.inzoomedprocessinstance.OPMInZoomedProcessInstanceHeap.HeapChange;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMStructuralLink;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind;

public class OPMInZoomedProcessInstanceHeapTest {

  private OPMInZoomedProcessInstanceHeap heap;
  private OPMObject obj1, obj2, obj3, objPart1, objPart2, objPart11, objPart12;
  private OPMObjectInstance inst1, inst2, inst3;
  private MyObserver observer;

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
    assertEquals(inst1.getNumericalValue(), observer.lastUpdate.instance.getNumericalValue());
    heap.setVariable(obj1, inst2);
    assertEquals(inst2.getNumericalValue(), observer.lastUpdate.instance.getNumericalValue());
    heap.setVariable(obj2, inst2);
    assertEquals(inst2.getNumericalValue(), observer.lastUpdate.instance.getNumericalValue());
    heap.setVariable(obj1, inst3);
    assertEquals(inst3.getNumericalValue(), observer.lastUpdate.instance.getNumericalValue());
  }

  @Test
  public void createVariablePart_ValidateParentCreation() {
    OPMStructuralLink link = OPMFactory.eINSTANCE.createOPMStructuralLink();
    OPMStructuralLinkAggregator agg = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
    agg.setKind(OPMStructuralLinkAggregatorKind.AGGREGATION);
    link.setSource(obj1);
    link.setTarget(agg);
    link = OPMFactory.eINSTANCE.createOPMStructuralLink();
    link.setSource(agg);
    link.setTarget(objPart1);

    heap.setVariable(objPart1, inst1);

    OPMObjectInstance instance1 = heap.getVariable(obj1);
    assertNotNull(instance1);
    OPMObjectInstance instance2 = instance1.getPart(objPart1.getName());
    assertNotNull(instance2);

  }

  @Before
  public void setup() {
    heap = OPMInterpreterInjector.INSTANCE.getInstance(OPMInZoomedProcessInstanceHeap.class);
    observer = new MyObserver();

    obj1 = OPMFactory.eINSTANCE.createOPMObject();
    obj2 = OPMFactory.eINSTANCE.createOPMObject();
    obj3 = OPMFactory.eINSTANCE.createOPMObject();
    objPart1 = OPMFactory.eINSTANCE.createOPMObject();
    objPart1.setName("Part1");
    objPart2 = OPMFactory.eINSTANCE.createOPMObject();
    objPart2.setName("Part2");
    objPart11 = OPMFactory.eINSTANCE.createOPMObject();
    objPart11.setName("Part11");
    objPart12 = OPMFactory.eINSTANCE.createOPMObject();
    objPart12.setName("Part12");

    inst1 = OPMObjectInstance.createFromValue(new BigDecimal(1));
    inst2 = OPMObjectInstance.createFromValue(new BigDecimal(2));
    inst3 = OPMObjectInstance.createFromValue(new BigDecimal(3));

  }

  class MyObserver implements Observer {
    public HeapChange lastUpdate = null;

    @Override
    public void update(Observable o, Object arg) {
      lastUpdate = HeapChange.class.cast(arg);
    }
  }
}

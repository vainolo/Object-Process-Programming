package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstanceHeap;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessExecutionHeapManager {

  private OPMProcessInstanceHeap heap;
  private OPDAnalyzer analyzer = new OPDAnalyzer();

  public OPMInZoomedProcessExecutionHeapManager(OPMProcessInstanceHeap heap) {
    this.heap = heap;
  }

  /**
   * Set the value in an {@link OPMObject}. If the {@link OPMObject} is a part
   * of another {@link OPMObject}, the parent {@link OPMObject}.
   * 
   * @param object
   *          where a value can be stored
   * @param value
   *          the value to store
   */
  public void setVariable(OPMObject object, OPMObjectInstance value) {
    if(analyzer.isObjectPartOfAnotherObject(object)) {
      OPMObject parentObject = analyzer.findParent(object);
      OPMObjectInstance parentInstance = heap.getVariable(parentObject);
      if(parentInstance == null) {
        parentInstance = OPMObjectInstance.createCompositeInstance();
        setVariable(parentObject, parentInstance);
      }
      parentInstance.addPart(object.getName(), value);
    } else {
      heap.setVariable(object, value);
    }
  }

  /**
   * Return the value stored in the {@link OPMObject}. If the {@link OPMObject}
   * is part of another {@link OPMObject}, the value if fetched from the parent
   * {@link OPMObject}.
   * 
   * @param object
   *          where a value can be stored
   * @return the value of the {@link OPMObject}, or <code>null</code> if no
   *         value has been assigned.
   */
  protected OPMObjectInstance getVariable(OPMObject object) {
    if(analyzer.isObjectPartOfAnotherObject(object)) {
      OPMObjectInstance parent = getVariable(analyzer.findParent(object));
      if(parent == null) {
        return null;
      } else {
        return parent.getPart(object.getName());
      }
    } else {
      return heap.getVariable(object);
    }
  }

}

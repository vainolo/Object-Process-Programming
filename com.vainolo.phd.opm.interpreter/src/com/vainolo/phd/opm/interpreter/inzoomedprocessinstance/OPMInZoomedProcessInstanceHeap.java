package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.util.Collection;

import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzer;
import com.vainolo.phd.opm.interpreter.OPMProcessInstanceHeap;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessInstanceHeap extends OPMProcessInstanceHeap {

  private OPDAnalyzer analyzer = new OPDAnalyzer();
  private OPMObjectInstanceValueAnalyzer valueAnalyzer = new OPMObjectInstanceValueAnalyzer();

  /**
   * <p>
   * Set the value in an {@link OPMObject}.
   * </p>
   * 
   * <p>
   * If the {@link OPMObject} is a part of another {@link OPMObject}, the parent
   * {@link OPMObject} is updated. If the {@link OPMObject} is part of another
   * {@link OPMObject}, but the parent doesn't exist yet, it is created.
   * </p>
   * 
   * <p>
   * If the {@link OPMObject} has outgoing data links to other {@link OPMObject}
   * s, these {@link OPMObject}s are updated (recursively if necessary).
   * 
   * 
   * @param object
   *          where a value can be stored
   * @param value
   *          the value to store
   */
  @Override
  public void setVariable(OPMObject object, OPMObjectInstance value) {
    if(analyzer.isObjectPartOfAnotherObject(object)) {
      OPMObject parentObject = analyzer.findParent(object);
      OPMObjectInstance parentInstance = super.getVariable(parentObject);
      if(parentInstance == null) {
        parentInstance = OPMObjectInstance.createCompositeInstance();
        setVariable(parentObject, parentInstance);
      }
      parentInstance.addPart(object.getName(), value);
    } else {
      super.setVariable(object, value);
    }
    transferDataFromObject(object);
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
  @Override
  public OPMObjectInstance getVariable(OPMObject object) {
    if(analyzer.isObjectPartOfAnotherObject(object)) {
      OPMObjectInstance parent = getVariable(analyzer.findParent(object));
      if(parent == null) {
        return null;
      } else {
        return parent.getPart(object.getName());
      }
    } else {
      return super.getVariable(object);
    }
  }

  /**
   * Transfer the data in an {@link OPMObject} through outgoing data links to
   * other {@link OPMObject}'s, also doing this recursively if needed.
   * 
   * @param object
   */
  private void transferDataFromObject(OPMObject object) {
    Collection<OPMProceduralLink> dataLinks = analyzer.findOutgoingDataLinks(object);
    for(OPMProceduralLink link : dataLinks) {
      if(OPMObject.class.isInstance(link.getTarget())) {
        OPMObject target = OPMObject.class.cast(link.getTarget());
        setVariable(target, getVariable(object));
        transferDataFromObject(target);
      }
    }
  }

  /**
   * Calculate the value of an {@link OPMObject} literal, and set the value of
   * the {@link OPMObject} variable with the literal value.
   * 
   * @param object
   *          that is being analyzed.
   */
  public void calculateOPMObjectValueAndSetVariableIfValueIfExists(OPMObject object) {
    OPMObjectInstance objectValue = valueAnalyzer.calculateOPMObjectValue(object, analyzer);
    if(objectValue != null)
      setVariable(object, objectValue);
  }

  /**
   * Initialize local variables from literals
   */
  public void initializeVariablesWithLiterals(OPMProcess mainProcess) {
    Collection<OPMObject> objectVariables = analyzer.findObjects(mainProcess);
    for(OPMObject object : objectVariables) {
      calculateOPMObjectValueAndSetVariableIfValueIfExists(object);
      if(getVariable(object) != null)
        transferDataFromObject(object);
    }
  }

  /**
   * Create a variable for all of the arguments that were passed to the process,
   * or for arguments that contain literal values.
   */
  public void initializeVariablesWithArgumentValues(OPMObjectProcessDiagram opd) {
    Collection<OPMObject> objectArguments = analyzer.findParameters(opd);
    for(OPMObject object : objectArguments) {
      if(getArgument(object.getName()) != null) {
        setVariable(object, getArgument(object.getName()));
      } else {
        calculateOPMObjectValueAndSetVariableIfValueIfExists(object);
      }
      transferDataFromObject(object);
    }
  }

  /**
   * Initialize variables of the process instance. Variables are initialized
   * from two sources: arguments and literals.
   * 
   * @param opd
   *          that is being executed.
   */
  public void initializeVariables(OPMObjectProcessDiagram opd) {
    initializeVariablesWithArgumentValues(opd);
    initializeVariablesWithLiterals(analyzer.getInZoomedProcess(opd));
  }

  public void exportVariableValuesToArguments(OPMObjectProcessDiagram opd) {
    Collection<OPMObject> objectArguments = analyzer.findParameters(opd);
    for(OPMObject object : objectArguments) {
      if(getVariable(object) != null) {
        addArgument(object.getName(), getVariable(object));
      }
    }
  }
}

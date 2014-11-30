package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.internal.win32.COMPOSITIONFORM;

import static com.google.common.base.Preconditions.*;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstanceValueAnalyzer;
import com.vainolo.phd.opm.interpreter.OPMProcessInstanceHeap;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance.InstanceType;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessInstanceHeap extends OPMProcessInstanceHeap {

  private OPDAnalyzer analyzer;
  private final Map<OPMObject, OPMObjectInstance> variables;
  private OPMObjectInstanceValueAnalyzer valueAnalyzer;
  private Observable observable;

  @Inject
  OPMInZoomedProcessInstanceHeap(OPMObjectInstanceValueAnalyzer valueAnalyzer, OPDAnalyzer analyzer) {
    this.valueAnalyzer = valueAnalyzer;
    this.analyzer = analyzer;
    this.variables = Maps.newHashMap();
    this.observable = new OPMProcessInstanceHeapObservable();
  }

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
  public void setVariable(OPMObject object, OPMObjectInstance value) {
    checkArgument(value != null, "Value cannot be null");
    if(analyzer.isObjectComposite(object))
      checkArgument(value.type == InstanceType.COMPOSITE,
          "The value of a composite object must be a composite instance.");
    else
      checkArgument(value.type != InstanceType.COMPOSITE,
          "The value of a simple object cannot be a composite instance.");
    if(analyzer.isObjectPartOfAnotherObject(object)) {
      OPMObject parentObject = analyzer.findParent(object);
      OPMObjectInstance parentValue = getVariable(parentObject);
      if(parentValue == null) {
        parentValue = OPMObjectInstance.createCompositeInstance();
      }
      setVariable(parentObject, parentValue);
      parentValue = getVariable(parentObject);
      parentValue.addCompositePart(object.getName(), OPMObjectInstance.createFromExistingInstance(value));
      observable.notifyObservers(new HeapChange(parentObject, parentValue, object, getVariable(object)));
    } else {
      OPMObjectInstance objectValue = OPMObjectInstance.createFromExistingInstance(value);
      variables.put(object, objectValue);
      observable.notifyObservers(new HeapChange(object, objectValue));
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
  public OPMObjectInstance getVariable(OPMObject object) {
    if(analyzer.isObjectPartOfAnotherObject(object)) {
      OPMObjectInstance parent = getVariable(analyzer.findParent(object));
      if(parent == null) {
        return null;
      } else {
        return parent.getCompositePart(object.getName());
      }
    } else {
      return variables.get(object);
    }
  }

  /**
   * Transfer the data in an {@link OPMObject} through outgoing data links to
   * other {@link OPMObject}'s, also doing this recursively if needed.
   * 
   * @param object
   */
  private void transferDataFromObject(OPMObject object) {
    Collection<OPMProceduralLink> dataTransferLinks = analyzer.findOutgoingDataTrasferLinks(object);
    for(OPMProceduralLink link : dataTransferLinks) {
      if(analyzer.isLinkTargetAnObject(link)) {
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

  /**
   * Copy the value stored in variables matching process arguments to the
   * external arguments.
   * 
   * @param opd
   *          The Object Process Diagram that contains the variables and the
   *          arguments.
   */
  public void exportVariableValuesToArguments(OPMObjectProcessDiagram opd) {
    Collection<OPMObject> objectArguments = analyzer.findParameters(opd);
    for(OPMObject object : objectArguments) {
      if(getVariable(object) != null) {
        addArgument(object.getName(), getVariable(object));
      }
    }
  }

  public void addObserver(Observer observer) {
    observable.addObserver(observer);
  }

  class OPMProcessInstanceHeapObservable extends Observable {
    @Override
    public void notifyObservers(Object arg) {
      setChanged();
      super.notifyObservers(arg);
    }
  }

  enum HeapChangeType {
    VARIABLE_SET, PART_ADDED
  }

  class HeapChange {
    public HeapChangeType changeType;
    public OPMObject object;
    public OPMObjectInstance objectInstance;
    public OPMObject child;
    public OPMObjectInstance childInstance;

    public HeapChange(OPMObject object, OPMObjectInstance instance) {
      this.changeType = HeapChangeType.VARIABLE_SET;
      this.object = object;
      this.objectInstance = instance;
    }

    public HeapChange(OPMObject parent, OPMObjectInstance parentInstance, OPMObject child,
        OPMObjectInstance childInstance) {
      this.changeType = HeapChangeType.PART_ADDED;
      this.object = parent;
      this.objectInstance = parentInstance;
      this.child = child;
      this.childInstance = childInstance;
    }
  }
}

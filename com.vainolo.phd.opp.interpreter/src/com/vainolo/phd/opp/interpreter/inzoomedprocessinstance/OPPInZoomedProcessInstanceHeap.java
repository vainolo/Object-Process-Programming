/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import static com.google.common.base.Preconditions.*;
import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opp.interpreter.OPPInterpreter;
import com.vainolo.phd.opp.interpreter.OPPObjectInstanceValueAnalyzer;
import com.vainolo.phd.opp.interpreter.OPPProcessInstanceHeap;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;
import com.vainolo.phd.opp.interpreter.types.OPPComplexObjectInstance;
import com.vainolo.phd.opp.interpreter.types.OPPObjectInstance;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPContainerExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPLinkExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPObjectExtensions;

public class OPPInZoomedProcessInstanceHeap extends OPPProcessInstanceHeap {

  private Map<OPPObject, OPPObjectInstance> variables;
  private OPPObjectInstanceValueAnalyzer valueAnalyzer;
  private Observable observable;
  private boolean globalHeap = false;

  public OPPInZoomedProcessInstanceHeap() {
    this.valueAnalyzer = new OPPObjectInstanceValueAnalyzer();
    this.variables = Maps.newHashMap();
    this.observable = new OPMHeapObservable();
  }

  public void setGlobalHeap(boolean global) {
    globalHeap = true;
  }

  private boolean isGlobalHeap() {
    return globalHeap;
  }

  /**
   * <p>
   * Set the value in an {@link OPPObject}.
   * </p>
   * 
   * <p>
   * If the {@link OPPObject} is a part of another {@link Object}, the parent {@link OPPObject} is updated. If the
   * {@link OPPObject} is part of another {@link OPPObject}, but the parent doesn't exist yet, it is created.
   * </p>
   * 
   * <p>
   * If the {@link OPPObject} has outgoing data links to other {@link OPPObject} s, these {@link OPPObject}s are updated
   * (recursively if necessary).
   * 
   * 
   * @param object
   *          where a value can be stored
   * @param value
   *          the value to store
   */
  public void setVariable(OPPObject object, OPPObjectInstance value) {
    checkArgument(value != null, "Value cannot be null");
    if (OPPObjectExtensions.findParent(object) != null) {
      setPartVariable(object, value);
    } else {
      setMainVariable(object, value);
    }
    transferDataFromObject(object);
  }

  private void setPartVariable(OPPObject object, OPPObjectInstance value) {
    OPPObject parentObject = OPPObjectExtensions.findParent(object);
    OPPComplexObjectInstance parentValue = (OPPComplexObjectInstance) getVariable(parentObject);
    if (parentValue == null) {
      parentValue = OPPObjectInstance.createCompositeInstance();
    }
    setVariable(parentObject, parentValue);
    parentValue = (OPPComplexObjectInstance) getVariable(parentObject);
    parentValue.setPart(object.getName(), OPPObjectInstance.createFromExistingInstance(value));
    logFinest("Setting part variable {0} with value {1}.", object.getName(), value.toString());
    observable.notifyObservers(new OPMHeapChange(parentObject, parentValue, object, getVariable(object)));
  }

  private void setMainVariable(OPPObject object, OPPObjectInstance value) {
    logFinest("Setting main variable {0} with value {1}.", object.getName(), value.toString());
    OPPObjectInstance objectValue = OPPObjectInstance.createFromExistingInstance(value);
    if (object.isGlobal() && !isGlobalHeap()) {
      OPPInterpreter.INSTANCE.getGlobalHeap().setVariable(object.getName(), objectValue);
    } else {
      variables.put(object, objectValue);
    }
    observable.notifyObservers(new OPMHeapChange(object, objectValue));
  }

  /**
   * Return the value stored in the {@link OPPObject}. If the {@link OPPObject} is part of another {@link OPPObject},
   * the value if fetched from the parent {@link OPPObject}.
   * 
   * @param object
   *          where a value can be stored
   * @return the value of the {@link OPPObject}, or <code>null</code> if no value has been assigned.
   */
  public OPPObjectInstance getVariable(OPPObject object) {
    if (OPPObjectExtensions.findParent(object) != null) {
      return getPartVariable(object);
    } else {
      return getMainVariable(object);
    }
  }

  private OPPObjectInstance getPartVariable(OPPObject object) {
    OPPComplexObjectInstance parent = (OPPComplexObjectInstance) getVariable(OPPObjectExtensions.findParent(object));
    OPPObjectInstance value;
    if (parent == null) {
      logFinest("Parent of {0} doesn't exist, so part doesn't exist either.", object.getName());
      value = null;
    } else {
      value = parent.getPart(object.getName());
      logFinest("Getting part variable {0} which is {1}.", object.getName(), parent.getPart(object.getName()));
    }
    return value;
  }

  private OPPObjectInstance getMainVariable(OPPObject object) {
    OPPObjectInstance value;
    if (object.isGlobal() && !isGlobalHeap()) {
      value = OPPInterpreter.INSTANCE.getGlobalHeap().getVariable(object.getName());
      logFinest("Getting global variable {0} which is {1}.", object.getName(), value);
    } else {
      value = variables.get(object);
      logFinest("Getting main variable {0} which is {1}.", object.getName(), value);
    }
    return value;
  }

  /** Clear the value of a variable when used with a consumption link. */
  public void clearVariable(OPPObject object) {
    if (OPPObjectExtensions.findParent(object) != null) {
      clearPartVariable(object);
    } else {
      clearMainVariable(object);
    }
  }

  private void clearPartVariable(OPPObject object) {
    OPPComplexObjectInstance parent = (OPPComplexObjectInstance) getVariable(OPPObjectExtensions.findParent(object));
    if (parent == null) {
      logSevere("Tried clearing a variable which is part of another object, but parent object doesn't exist.", object.getName());
      throw new OPPRuntimeException("Tried clearing a variable which is part of another object, but parent object doesn't exist.");
    } else {
      logFinest("Clearing part variable {0}.", object.getName());
      parent.removePart(object.getName());
    }
  }

  private void clearMainVariable(OPPObject object) {
    if (object.isGlobal() && !isGlobalHeap()) {
      OPPInterpreter.INSTANCE.getGlobalHeap().clearVariable(object.getName());
    } else {
      variables.remove(object);
      logFinest("Clearing main variable {0}.", object.getName());
    }
  }

  /**
   * Transfer the data in an {@link OPPObject} through outgoing data links to other {@link OPPObject}'s, also doing this
   * recursively if needed.
   * 
   * @param source
   */
  private void transferDataFromObject(OPPObject source) {
    Collection<OPPProceduralLink> dataTransferLinks = OPPObjectExtensions.findOutgoingDataLinks(source);
    for (OPPProceduralLink link : dataTransferLinks) {
      if (link.getTarget() instanceof OPPProcess)
        continue;

      OPPObject target = OPPLinkExtensions.getTargetObject(link);
      if ((link.getCenterDecoration() == null) || (link.getCenterDecoration().equals(""))) {
        setVariable(target, getVariable(source));
      } else {
        throw new OPPRuntimeException("Data transfer link modifiers are not supported.");
      }

      if (link.getKind() == OPPProceduralLinkKind.CONS_RES) {
        clearVariable(source);
      }

    }
  }

  /**
   * Calculate the value of an {@link OPPObject} literal, and set the value of the {@link OPPObject} variable with the
   * literal value.
   * 
   * @param object
   *          that is being analyzed.
   */
  public boolean calculateOPMObjectValueAndSetVariableIfValueIfExists(OPPObject object) {
    OPPObjectInstance objectValue;
    if (object.getInitialValue() != null && !object.getInitialValue().equals("")) {
      objectValue = valueAnalyzer.calculateOPMObjectValue(object.getInitialValue());
    } else {
      objectValue = valueAnalyzer.calculateOPMObjectValue(object.getName());
    }
    if (objectValue != null) {
      setVariable(object, objectValue);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Initialize local variables from literals
   */
  public void initializeVariablesWithLiterals(OPPProcess mainProcess) {
    Collection<OPPObject> objectVariables = OPPContainerExtensions.getObjects(mainProcess);
    for (OPPObject object : objectVariables) {
      calculateOPMObjectValueAndSetVariableIfValueIfExists(object);
    }
  }

  /**
   * Create a variable for all of the arguments that were passed to the process, or for arguments that contain literal
   * values.
   */
  public void initializeVariablesWithArgumentValues(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> objectArguments = OPPOPDExtensions.getParameters(opd);
    for (OPPObject object : objectArguments) {
      if (getArgument(object.getName()) != null) {
        setVariable(object, getArgument(object.getName()));
      } else {
        calculateOPMObjectValueAndSetVariableIfValueIfExists(object);
      }
    }
  }

  /**
   * Initialize variables of the process instance. Variables are initialized from two sources: arguments and literals.
   * 
   * @param opd
   *          that is being executed.
   */
  public void initializeVariables(OPPObjectProcessDiagram opd) {
    initializeVariablesWithArgumentValues(opd);
    initializeVariablesWithLiterals(OPPOPDExtensions.getInZoomedProcess(opd));
  }

  /**
   * Copy the value stored in variables matching process arguments to the external arguments.
   * 
   * @param opd
   *          The Object Process Diagram that contains the variables and the arguments.
   */
  public void exportVariableValuesToArguments(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> objectArguments = OPPOPDExtensions.getParameters(opd);
    for (OPPObject object : objectArguments) {
      OPPObjectInstance variable = getVariable(object);
      if (variable != null) {
        setArgument(object.getName(), variable);
      }
    }
  }

  /**
   * Add an observer to changes in the {@link OPPInZoomedProcessInstanceHeap}
   * 
   * @param observer
   *          a new observer for this {@link OPPInZoomedProcessInstanceHeap}
   */
  public void addObserver(Observer observer) {
    observable.addObserver(observer);
  }

  class OPMHeapObservable extends Observable {
    @Override
    public void notifyObservers(Object arg) {
      setChanged();
      super.notifyObservers(arg);
    }
  }

  static class OPMHeapObserver implements Observer {
    private List<OPMHeapChange> changes = Lists.newArrayList();

    @Override
    public void update(Observable o, Object arg) {
      changes.add(0, OPMHeapChange.class.cast(arg));
    }

    public void clear() {
      changes.clear();
    }

    public List<OPMHeapChange> getChanges() {
      return Collections.unmodifiableList(changes);
    }

    public Set<OPPObject> getObjectsWithNewValue() {
      Set<OPPObject> objects = Sets.newHashSet();
      for (OPMHeapChange change : changes) {
        if (change.changeType.equals(OPMHeapChangeType.VARIABLE_SET)) {
          objects.add(change.object);
        }
      }
      return objects;
    }
  }

  enum OPMHeapChangeType {
    VARIABLE_SET, PART_ADDED
  }

  class OPMHeapChange {
    public OPMHeapChangeType changeType;
    public OPPObject object;
    public OPPObjectInstance objectInstance;
    public OPPObject child;
    public OPPObjectInstance childInstance;

    public OPMHeapChange(OPPObject object, OPPObjectInstance instance) {
      this.changeType = OPMHeapChangeType.VARIABLE_SET;
      this.object = object;
      this.objectInstance = instance;
    }

    public OPMHeapChange(OPPObject parent, OPPObjectInstance parentInstance, OPPObject child, OPPObjectInstance childInstance) {
      this.changeType = OPMHeapChangeType.PART_ADDED;
      this.object = parent;
      this.objectInstance = parentInstance;
      this.child = child;
      this.childInstance = childInstance;
    }
  }

}

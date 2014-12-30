package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

import static com.google.common.base.Preconditions.*;

import java.util.Collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.model.OPMProcess;

/**
 * State of a {@link OPMInZoomedProcessExecutableInstance}
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class OPMInZoomedProcessExecutionState {
  private Map<OPMProcessInstance, OPMProcess> instanceToProcessMapping = Maps.newHashMap();
  private List<OPMProcessInstance> readyInstances = Lists.newArrayList();
  private List<OPMProcessInstance> waitingInstances = Lists.newArrayList();

  private void addProcessToInstanceMapping(OPMProcess process, OPMProcessInstance instance) {
    instanceToProcessMapping.put(instance, process);
  }

  public void addWaitingInstance(OPMProcess process, OPMProcessInstance instance) {
    waitingInstances.add(instance);
    addProcessToInstanceMapping(process, instance);
  }

  public void addReadyInstance(OPMProcess process, OPMProcessInstance instance) {
    readyInstances.add(instance);
    addProcessToInstanceMapping(process, instance);
  }

  public List<OPMProcessInstance> getWaitingInstances() {
    return Collections.unmodifiableList(waitingInstances);
  }

  public List<OPMProcessInstance> getReadyInstances() {
    return Collections.unmodifiableList(readyInstances);
  }

  public void makeWaitingInstanceReady(OPMProcessInstance instance) {
    waitingInstances.remove(instance);
    readyInstances.add(instance);
  }

  public void makeWaitingInstancesReady(Set<OPMProcessInstance> instances) {
    for(OPMProcessInstance instance : instances) {
      makeWaitingInstanceReady(instance);
    }
  }

  public void makeReadyInstanceWaiting(OPMProcessInstance instance) {
    readyInstances.remove(instance);
    waitingInstances.add(instance);
  }

  public OPMProcess getProcess(OPMProcessInstance instance) {
    return instanceToProcessMapping.get(instance);
  }

  public void removeReadyInstance(OPMProcessInstance instance) {
    checkState(readyInstances.contains(instance), "Instance " + instance.getName() + " is not ready.");
    instanceToProcessMapping.remove(instance);
    readyInstances.remove(instance);
  }

  public void removeWaitingInstance(OPMProcessInstance instance) {
    checkState(waitingInstances.contains(instance), "Instance " + instance.getName() + " is not waiting.");
    instanceToProcessMapping.remove(instance);
    waitingInstances.remove(instance);
  }

  public boolean areThereWaitingOrReadyInstances() {
    return areThereWaitingInstances() || areThereReadyInstances();
  }

  public boolean areThereReadyInstances() {
    return readyInstances.size() > 0;
  }

  public boolean areThereWaitingInstances() {
    return waitingInstances.size() > 0;
  }

  public List<OPMProcess> getWaitingProcesses() {
    List<OPMProcess> ret = Lists.transform(getWaitingInstances(), new TransformInstanceToProcess());
    return ret;
  }

  public List<OPMProcess> getReadyProcesses() {
    List<OPMProcess> ret = Lists.transform(getReadyInstances(), new TransformInstanceToProcess());
    return ret;
  }

  private class TransformInstanceToProcess implements Function<OPMProcessInstance, OPMProcess> {
    @Override
    public OPMProcess apply(OPMProcessInstance input) {
      return getProcess(input);
    }
  }

}
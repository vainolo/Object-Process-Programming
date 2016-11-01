/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPLinkExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPProcessExtensions;

public class OPPInZoomedProcessArgumentHandler {
  private OPPInZoomedProcessInstanceHeap heap;

  public OPPInZoomedProcessArgumentHandler(OPPInZoomedProcessInstanceHeap heap) {
    this.heap = heap;
  }

  public void loadInstanceArguments(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPPArgument> namedArguments = Maps.newHashMap();
    List<OPPArgument> anonymousArguments = Lists.newArrayList();

    catalogueArguments(OPPProcessExtensions.findIncomingDataLinks(process), namedArguments, anonymousArguments);
    logFiner("Found {0} anonymous arguments and {1} named arguments.", anonymousArguments.size(), namedArguments.size());

    List<String> availableParametersNames = instance.getIncomingParameters().stream().map(param -> param.getName()).collect(Collectors.toList());
    loadNamedArguments(instance, namedArguments);

    availableParametersNames.removeAll(namedArguments.keySet());
    loadAnonymousArguments(instance, anonymousArguments, availableParametersNames);
  }

  private void loadNamedArguments(OPPProcessInstance instance, Map<String, OPPArgument> namedArguments) {
    for (String parameterName : namedArguments.keySet()) {
      OPPObjectInstance value = getArgumentValueFromHeapAndClearIfNecessary(namedArguments.get(parameterName));
      instance.setArgument(parameterName, value);
    }
  }

  private void loadAnonymousArguments(OPPProcessInstance instance, List<OPPArgument> arguments, List<String> availableParameterNames) {
    // First arguments who's variable names matches an available parameter name
    List<OPPArgument> argumentsMatchingParameterNames = arguments.stream().filter(a -> availableParameterNames.contains(a.getObject().getName()))
        .collect(Collectors.toList());
    List<String> remainingParameterNames = Lists.newArrayList(availableParameterNames);

    // Arguments that match parameter names
    for (OPPArgument argument : argumentsMatchingParameterNames) {
      OPPObjectInstance value = getArgumentValueFromHeapAndClearIfNecessary(argument);
      instance.setArgument(argument.getObject().getName(), value);
      remainingParameterNames.remove(argument.getObject().getName());
      arguments.remove(argument);
    }

    // Fill up remaining parameters using the remaining arguments
    Iterator<String> remainingParameterNamesIterator = remainingParameterNames.iterator();
    while (arguments.size() > 0 && remainingParameterNamesIterator.hasNext()) {
      String parameterName = remainingParameterNamesIterator.next();
      OPPObjectInstance value = getArgumentValueFromHeapAndClearIfNecessary(arguments.remove(0));
      instance.setArgument(parameterName, value);
      remainingParameterNamesIterator.remove();
    }

    // In case there are left arguments, pass them as parameters with default names
    if (arguments.size() > 0) {
      int argNumber = 0;
      for (OPPArgument argument : arguments) {
        OPPObjectInstance value = getArgumentValueFromHeapAndClearIfNecessary(argument);
        instance.setArgument("arg" + argNumber, value);
        argNumber++;
      }
    }
  }

  public void extractResultsToVariables(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPPArgument> namedResults = Maps.newHashMap();
    List<OPPArgument> anonymousResults = Lists.newArrayList();

    catalogueArguments(OPPProcessExtensions.findOutgoingDataLinks(process), namedResults, anonymousResults);

    logFiner("Found {0} anonymous results and {1} named results.", anonymousResults.size(), namedResults.size());

    // First extract named results
    List<String> outgoingParametersNames = instance.getOutgoingParameters().stream().map(p -> p.getName()).collect(Collectors.toList());
    for (String namedResult : namedResults.keySet()) {
      copyArgumentValueToHeap(namedResults.get(namedResult), instance.getArgument(namedResult));
      outgoingParametersNames.remove(namedResult);
    }

    // Then extract results where the variable in the instance matches the
    // result object
    Iterator<OPPArgument> anonymousResultsIterator = anonymousResults.iterator();
    while (anonymousResultsIterator.hasNext()) {
      OPPArgument argument = anonymousResultsIterator.next();
      if (instance.getOutgoingParameters().stream().map(p -> p.getName()).collect(Collectors.toList()).contains(argument.getObject().getName())) {
        if (instance.getArgument(argument.getObject().getName()) != null) {
          copyArgumentValueToHeap(argument, instance.getArgument(argument.getObject().getName()));
          anonymousResultsIterator.remove();
          outgoingParametersNames.remove(argument.getObject().getName());
        }
      }
    }

    // Finally, extract all remaining outgoing parameters to the remaining
    // anonymous result objects.
    for (int i = 0; i < anonymousResults.size(); i++) {
      copyArgumentValueToHeap(anonymousResults.get(i), instance.getArgument(outgoingParametersNames.get(i)));
    }
  }

  private void catalogueArguments(Collection<OPPProceduralLink> links, Map<String, OPPArgument> namedArguments, List<OPPArgument> anonymousArguments) {
    for (OPPProceduralLink link : links) {
      OPPArgument argument = new OPPArgument(OPPLinkExtensions.getObject(link), link.getKind() == OPPProceduralLinkKind.CONS_RES);
      if (link.getCenterDecoration() == null || "".equals(link.getCenterDecoration())) {
        anonymousArguments.add(argument);
      } else if (link.getCenterDecoration().contains(",")) {
        throw new OPPRuntimeException("Argument modifiers are not supported.");
      } else {
        namedArguments.put(link.getCenterDecoration(), argument);
      }
    }
  }

  private void copyArgumentValueToHeap(OPPArgument argument, OPPObjectInstance objectInstance) {
    if (objectInstance == null) {
      logFinest("Clearing value of {0} because given argument value is null.", argument.getObject().getName());
      heap.clearVariable(argument.getObject());
    } else {
      logFinest("Setting value of {0} with {1}.", argument.getObject().getName(), objectInstance);
      if (argument.hasModifier) {
        throw new OPPRuntimeException("Argument modifiers are not supported.");
      } else {
        heap.setVariable(argument.getObject(), objectInstance);
      }
    }
  }

  private OPPObjectInstance getArgumentValueFromHeapAndClearIfNecessary(OPPArgument argument) {
    if (!argument.hasModifier) {
      OPPObjectInstance value = heap.getVariable(argument.getObject());
      if (argument.isConsumption())
        heap.clearVariable(argument.getObject());
      return value;
    } else {
      throw new OPPRuntimeException("Argument modifiers are not supported.");
    }
  }

  class OPPArgument {
    private OPPObject object;
    private boolean consumption;
    public boolean hasModifier = false;
    public String modifier;

    public OPPArgument(OPPObject object, boolean consumption) {
      this.object = object;
      this.consumption = consumption;
    }

    public OPPObject getObject() {
      return object;
    }

    public boolean isConsumption() {
      return consumption;
    }
  }
}

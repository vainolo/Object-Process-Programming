package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPProcessInstance;
import com.vainolo.phd.opp.interpreter.OPPRuntimeException;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

public class OPPInZoomedProcessArgumentHandler {
  private OPPOPDAnalyzer analyzer = new OPPOPDAnalyzer();
  private OPPInZoomedProcessInstanceHeap heap;

  public OPPInZoomedProcessArgumentHandler(OPPOPDAnalyzer analyzer, OPPInZoomedProcessInstanceHeap heap) {
    this.analyzer = analyzer;
    this.heap = heap;
  }

  public void loadInstanceArguments(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPPArgument> namedArguments = Maps.newHashMap();
    List<OPPArgument> anonymousArguments = Lists.newArrayList();

    catalogueArguments(analyzer.findIncomingDataLinks(process), namedArguments, anonymousArguments);

    logFine("Found {0} anonymous arguments and {1} named arguments.", anonymousArguments.size(), namedArguments.size());

    List<String> availableParametersNames = instance.getIncomingParameters().stream().map(param -> param.getName()).collect(Collectors.toList());
    loadNamedArguments(instance, namedArguments);

    availableParametersNames.removeAll(namedArguments.keySet());
    loadAnonymousArguments(instance, anonymousArguments, availableParametersNames);
  }

  private void loadNamedArguments(OPPProcessInstance instance, Map<String, OPPArgument> namedArguments) {
    for (String parameterName : namedArguments.keySet()) {
      instance.setArgument(parameterName, getValue(namedArguments.get(parameterName)));
    }
  }

  private void loadAnonymousArguments(OPPProcessInstance instance, List<OPPArgument> arguments, List<String> availableParameterNames) {
    // First arguments who's variable names matches an available parameter name
    List<OPPArgument> argumentsMatchingParameterNames = arguments.stream().filter(a -> availableParameterNames.contains(a.object.getName()))
        .collect(Collectors.toList());
    List<String> remainingParameterNames = Lists.newArrayList(availableParameterNames);

    // Arguments that match parameter names
    for (OPPArgument argument : argumentsMatchingParameterNames) {
      instance.setArgument(argument.object.getName(), getValue(argument));
      remainingParameterNames.remove(argument.object.getName());
      arguments.remove(argument);
    }

    // Fill up remaining parameters using the remaining arguments
    Iterator<String> remainingParameterNamesIterator = remainingParameterNames.iterator();
    while (arguments.size() > 0 && remainingParameterNamesIterator.hasNext()) {
      String parameterName = remainingParameterNamesIterator.next();
      instance.setArgument(parameterName, getValue(arguments.remove(0)));
      remainingParameterNamesIterator.remove();
    }

    // In case there are left arguments, pass them as parameters with default names
    if (arguments.size() > 0) {
      int argNumber = 0;
      for (OPPArgument argument : arguments) {
        instance.setArgument("arg" + argNumber, getValue(argument));
        argNumber++;
      }
    }
  }

  public void extractResultsToVariables(OPPProcess process, OPPProcessInstance instance) {
    Map<String, OPPArgument> namedResults = Maps.newHashMap();
    List<OPPArgument> anonymousResults = Lists.newArrayList();

    catalogueArguments(analyzer.findOutgoingDataLinks(process), namedResults, anonymousResults);

    logFine("Found {0} anonymous results and {1} named results.", anonymousResults.size(), namedResults.size());

    // First extract named results
    List<String> outgoingParametersNames = instance.getOutgoingParameters().stream().map(p -> p.getName()).collect(Collectors.toList());
    for (String namedResult : namedResults.keySet()) {
      setValue(namedResults.get(namedResult), instance.getArgument(namedResult));
      outgoingParametersNames.remove(namedResult);
    }

    // Then extract results where the variable in the instance matches the
    // result object
    Iterator<OPPArgument> anonymousResultsIterator = anonymousResults.iterator();
    while (anonymousResultsIterator.hasNext()) {
      OPPArgument argument = anonymousResultsIterator.next();
      if (instance.getOutgoingParameters().contains(argument.object.getName())) {
        if (instance.getArgument(argument.object.getName()) != null) {
          setValue(argument, instance.getArgument(argument.object.getName()));
          anonymousResultsIterator.remove();
        }
      }
    }

    // Finally, extract all remaining outgoing parameters to the remaining
    // anonymous result objects.
    for (int i = 0; i < anonymousResults.size(); i++) {
      setValue(anonymousResults.get(i), instance.getArgument(outgoingParametersNames.get(i)));
    }
  }

  private void catalogueArguments(Collection<OPPProceduralLink> links, Map<String, OPPArgument> namedArguments, List<OPPArgument> anonymousArguments) {
    for (OPPLink link : links) {
      OPPArgument argument = new OPPArgument(analyzer.getObject(link));
      if (link.getCenterDecoration() == null || "".equals(link.getCenterDecoration())) {
        anonymousArguments.add(argument);
      } else if (link.getCenterDecoration().contains(",")) {
        throw new OPPRuntimeException("Argument modifiers are not supported.");
      } else {
        namedArguments.put(link.getCenterDecoration(), argument);
      }
    }
  }

  private void setValue(OPPArgument argument, OPPObjectInstance objectInstance) {
    logFinest("Setting value of {0} with {1}.", argument.object.getName(), objectInstance);
    if (argument.hasModifier) {
      throw new OPPRuntimeException("Argument modifiers are not supported.");
    } else {
      heap.setVariable(argument.object, objectInstance);
    }
  }

  private OPPObjectInstance getValue(OPPArgument argument) {
    if (!argument.hasModifier) {
      return heap.getVariable(argument.object);
    } else {
      throw new OPPRuntimeException("Argument modifiers are not supported.");
    }
  }

  /**
   * Representation of an argument that is passed to a {@link OPPProcessInstance}. If the argument is passed to the
   * instance using a modifier, this modifier is stored here and is applied only when the value of the argument is
   * retrieved.
   */
  class OPPArgument {
    private OPPObject object;
    public BigDecimal collectionElementIndex;
    public boolean hasModifier = false;
    public String modifier;

    public OPPArgument(OPPObject object) {
      this.object = object;
    }
  }
}

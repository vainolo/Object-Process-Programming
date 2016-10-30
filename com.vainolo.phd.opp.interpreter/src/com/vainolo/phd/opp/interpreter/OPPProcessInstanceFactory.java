/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import org.eclipse.core.runtime.Path;

import com.vainolo.phd.opp.interpreter.builtin.OPPCompareProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPConceptualProcess;
import com.vainolo.phd.opp.interpreter.builtin.OPPCopyObjectProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPGetDateProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPSleepProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCompareProcessInstance.ComparisonType;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPAddFirstPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPAddLastPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPGetFirstPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPGetLastPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPGetPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPHasPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPHasPartValueProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPHasPartsProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPObjectCreatingProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemoveFirstPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemoveLastPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPAddPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemovePartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.general.OPPCountProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.list.OPPElementAddingProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.list.OPPElementFetchingProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.list.OPPElementRemovingProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.io.OPPConsoleInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.io.OPPConsoleOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.io.OPPDialogInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.io.OPPDialogOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.io.OPPReadTextFileProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.io.OPPTransformJSONStringToObjectProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPBinaryMathOpProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPBinaryMathOpProcessInstance.OPPBinaryMathOpType;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPUnaryMathOpProcessInstance.OPPUnaryMathOpType;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPUnaryMathOpProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.twitter.OPPInitializeTwitterClientProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.twitter.OPPSearchTwitter;
import com.vainolo.phd.opp.interpreter.builtin.web.OPPCallWebAPIProcessInstance;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessExecutableInstance;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.OPPFileUtils;

public class OPPProcessInstanceFactory {

  public static OPPProcessInstance createExecutableInstance(OPPObjectProcessDiagram opd) {
    switch (opd.getKind()) {
    case COMPOUND:
      return new OPPInZoomedProcessExecutableInstance(opd);
    case UNFOLDED:
      logInfo("Unfolded OPDs can't be executed.");
      throw new IllegalArgumentException("Unfolded OPDs cannot be executed");
    case SYSTEM:
      logInfo("System OPDs can't be executed yet.");
      throw new IllegalArgumentException("System OPDs can't be executed yet.");
    }
    return null;
  }

  public static OPPProcessInstance createExecutableInstance(String opdName) {
    OPPObjectProcessDiagram opd = OPPFileUtils.loadOPPFile(OPPInterpreter.container.getFile(new Path(opdName + ".opp")).getFullPath().toString());
    return createExecutableInstance(opd);

  }

  public static OPPProcessInstance createExecutableInstance(OPPProcess process) {
    OPPProcessInstance executableInstance = null;
    switch (process.getKind()) {
    case BUILT_IN:
    case COMPOUND:
      logFinest("Searching for built-in process named {0}.", process.getName());
      executableInstance = createBuiltInProcess(process.getName());
      if (executableInstance == null) {
        logFinest("Built-in process {0} not found, searching compound processes.", process.getName());
        executableInstance = createExecutableInstance(process.getName());
      }
      break;
    case CONCEPTUAL:
      executableInstance = new OPPConceptualProcess(process);
      break;
    case JAVA:
      executableInstance = new OPPJavaProcessExecutableInstance(process);
      break;
    }

    return executableInstance;
  }

  private static OPPProcessInstance createBuiltInProcess(String name) {

    switch (name.toLowerCase()) {
    // runtime
    case "object creating":
    case "create object":
      return new OPPObjectCreatingProcessInstance();

    // math
    case "+":
    case "adding":
      return new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.ADD);
    case "-":
    case "subtracting":
      return new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.SUBS);
    case "*":
    case "multiplying":
      return new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.MULT);
    case "/":
    case "dividing":
      return new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.DIV);
    case "^":
    case "power":
      return new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.POW);

    // Collections
    case "element counting":
    case "count":
      return new OPPCountProcessInstance();
    case "element adding":
    case "add element":
      return new OPPElementAddingProcessInstance();
    case "element fetching":
    case "fetch element":
      return new OPPElementFetchingProcessInstance();
    case "element removing":
    case "remove element":
      return new OPPElementRemovingProcessInstance();
    }

    // Composite
    if (name.equalsIgnoreCase("New Instance")) {

    } else if (name.equalsIgnoreCase("Add First Part")) {
      return new OPPAddFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Add Last Part")) {
      return new OPPAddLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Add Part")) {
      return new OPPAddPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get First Part")) {
      return new OPPGetFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get Last Part")) {
      return new OPPGetLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get Part")) {
      return new OPPGetPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove First Part")) {
      return new OPPRemoveFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove Last Part")) {
      return new OPPRemoveLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove Part")) {
      return new OPPRemovePartProcessInstance();
    } else if (name.equalsIgnoreCase("Has Part")) {
      return new OPPHasPartProcessInstance();
    } else if (name.equalsIgnoreCase("Has Part Value")) {
      return new OPPHasPartValueProcessInstance();
    } else if (name.equalsIgnoreCase("Has Parts")) {
      return new OPPHasPartsProcessInstance();

      // Input and Output
    } else if (name.equalsIgnoreCase("Console Input")) {
      return new OPPConsoleInputProcessInstance();
    } else if (name.equalsIgnoreCase("Console Output")) {
      return new OPPConsoleOutputProcessInstance();
    } else if (name.equalsIgnoreCase("Dialog Input")) {
      return new OPPDialogInputProcessInstance();
    } else if (name.equalsIgnoreCase("Dialog Output")) {
      return new OPPDialogOutputProcessInstance();

      // Math and Data
      // } else if (name.equals("a+b") || name.equals("+")) {
      // } else if (name.equals("a-b") || name.equals("-")) {
      // } else if (name.equals("a*b") || name.equals("*")) {
      // } else if (name.equals("a/b") || name.equals("/")) {
      // } else if (name.equals("a^b") || name.equals("^")) {
    } else if (name.equals("a<=b") || name.equals("<=")) {
      return new OPPCompareProcessInstance(ComparisonType.LESS_THAN_OR_EQUAL);
    } else if (name.equals("a>=b") || name.equals(">=")) {
      return new OPPCompareProcessInstance(ComparisonType.GREATER_THAN_OR_EQUAL);
    } else if (name.equals("a>b") || name.equals(">")) {
      return new OPPCompareProcessInstance(ComparisonType.GREATER_THAN);
    } else if (name.equals("a<b") || name.equals("<")) {
      return new OPPCompareProcessInstance(ComparisonType.LESS_THAN);
    } else if (name.equals("a==b") || name.equals("==")) {
      return new OPPCompareProcessInstance(ComparisonType.EQUAL);
    } else if (name.equals("log(a)") || name.equals("log")) {
      return new OPPUnaryMathOpProcessInstance(OPPUnaryMathOpType.LOG);
    } else if (name.equals("-a") || name.equals("-")) {
      return new OPPUnaryMathOpProcessInstance(OPPUnaryMathOpType.NEG);
    } else if (name.equals("sqrt(a)") || name.equals("sqrt")) {
      return new OPPUnaryMathOpProcessInstance(OPPUnaryMathOpType.SQRT);

      // Misc
    } else if (name.equalsIgnoreCase("Sleep")) {
      return new OPPSleepProcessInstance();
    } else if (name.equalsIgnoreCase("Call Web API")) {
      return new OPPCallWebAPIProcessInstance();
    } else if (name.equalsIgnoreCase("Initialize Twitter Client")) {
      return new OPPInitializeTwitterClientProcessInstance();
    } else if (name.equalsIgnoreCase("Search Twitter")) {
      return new OPPSearchTwitter();
    } else if (name.equalsIgnoreCase("Get Date")) {
      return new OPPGetDateProcessInstance();
    } else if (name.equalsIgnoreCase("Copy Object")) {
      return new OPPCopyObjectProcessInstance();
    } else if (name.equalsIgnoreCase("Read Text File")) {
      return new OPPReadTextFileProcessInstance();
    } else if (name.equalsIgnoreCase("Transform JSON String To Object")) {
      return new OPPTransformJSONStringToObjectProcessInstance();
    }
    return null;
  }
}

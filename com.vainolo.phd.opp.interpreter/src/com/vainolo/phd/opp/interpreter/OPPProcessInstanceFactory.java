/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import org.eclipse.core.runtime.Path;

import com.vainolo.phd.opp.interpreter.builtin.OPPCallWebAPIProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCompareProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPConceptualProcess;
import com.vainolo.phd.opp.interpreter.builtin.OPPConsoleInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPConsoleOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCopyObjectProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPDialogInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPDialogOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPGetDateProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPTransformJSONStringToObjectProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPReadTextFileProcessInstance;
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
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPNewInstanceProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemoveFirstPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemoveLastPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPAddPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemovePartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPBinaryMathOpProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPBinaryMathOpProcessInstance.OPPBinaryMathOpType;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPUnaryMathOpProcessInstance.OPPUnaryMathOpType;
import com.vainolo.phd.opp.interpreter.builtin.math.OPPUnaryMathOpProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.twitter.OPPInitializeTwitterClientProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.twitter.OPPSearchTwitter;
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
    OPPProcessInstance processInstance = null;

    // Input and Output
    if (name.equalsIgnoreCase("Console Input")) {
      processInstance = new OPPConsoleInputProcessInstance();
    } else if (name.equalsIgnoreCase("Console Output")) {
      processInstance = new OPPConsoleOutputProcessInstance();
    } else if (name.equalsIgnoreCase("Dialog Input")) {
      processInstance = new OPPDialogInputProcessInstance();
    } else if (name.equalsIgnoreCase("Dialog Output")) {
      processInstance = new OPPDialogOutputProcessInstance();

      // Math and Data
    } else if (name.equals("a+b") || name.equals("+")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.ADD);
    } else if (name.equals("a-b") || name.equals("-")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.SUBS);
    } else if (name.equals("a*b") || name.equals("*")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.MULT);
    } else if (name.equals("a/b") || name.equals("/")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.DIV);
    } else if (name.equals("a^b") || name.equals("^")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.POW);
    } else if (name.equals("a<=b") || name.equals("<=")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.LESS_THAN_OR_EQUAL);
    } else if (name.equals("a>=b") || name.equals(">=")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.GREATER_THAN_OR_EQUAL);
    } else if (name.equals("a>b") || name.equals(">")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.GREATER_THAN);
    } else if (name.equals("a<b") || name.equals("<")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.LESS_THAN);
    } else if (name.equals("a==b") || name.equals("==")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.EQUAL);
    } else if (name.equals("log(a)") || name.equals("log")) {
      processInstance = new OPPUnaryMathOpProcessInstance(OPPUnaryMathOpType.LOG);
    } else if (name.equals("-a") || name.equals("-")) {
      processInstance = new OPPUnaryMathOpProcessInstance(OPPUnaryMathOpType.NEG);
    } else if (name.equals("sqrt(a)") || name.equals("sqrt")) {
      processInstance = new OPPUnaryMathOpProcessInstance(OPPUnaryMathOpType.SQRT);

      // Composite
    } else if (name.equalsIgnoreCase("New Instance")) {
      processInstance = new OPPNewInstanceProcessInstance();
    } else if (name.equalsIgnoreCase("Add First Part")) {
      processInstance = new OPPAddFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Add Last Part")) {
      processInstance = new OPPAddLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Add Part")) {
      processInstance = new OPPAddPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get First Part")) {
      processInstance = new OPPGetFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get Last Part")) {
      processInstance = new OPPGetLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get Part")) {
      processInstance = new OPPGetPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove First Part")) {
      processInstance = new OPPRemoveFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove Last Part")) {
      processInstance = new OPPRemoveLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove Part")) {
      processInstance = new OPPRemovePartProcessInstance();
    } else if (name.equalsIgnoreCase("Has Part")) {
      processInstance = new OPPHasPartProcessInstance();
    } else if (name.equalsIgnoreCase("Has Part Value")) {
      processInstance = new OPPHasPartValueProcessInstance();
    } else if (name.equalsIgnoreCase("Has Parts")) {
      processInstance = new OPPHasPartsProcessInstance();

      // Misc
    } else if (name.equalsIgnoreCase("Sleep")) {
      processInstance = new OPPSleepProcessInstance();
    } else if (name.equalsIgnoreCase("Call Web API")) {
      processInstance = new OPPCallWebAPIProcessInstance();
    } else if (name.equalsIgnoreCase("Initialize Twitter Client")) {
      processInstance = new OPPInitializeTwitterClientProcessInstance();
    } else if (name.equalsIgnoreCase("Search Twitter")) {
      processInstance = new OPPSearchTwitter();
    } else if (name.equalsIgnoreCase("Get Date")) {
      processInstance = new OPPGetDateProcessInstance();
    } else if (name.equalsIgnoreCase("Copy Object")) {
      processInstance = new OPPCopyObjectProcessInstance();
    } else if (name.equalsIgnoreCase("Read Text File")) {
      processInstance = new OPPReadTextFileProcessInstance();
    } else if (name.equalsIgnoreCase("Transform JSON String To Object")) {
      processInstance = new OPPTransformJSONStringToObjectProcessInstance();
    }
    return processInstance;
  }
}

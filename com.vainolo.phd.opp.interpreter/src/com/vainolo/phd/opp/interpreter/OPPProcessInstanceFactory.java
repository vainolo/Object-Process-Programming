/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import org.eclipse.core.runtime.Path;

import com.vainolo.phd.opp.interpreter.builtin.OPPBinaryMathOpProcessInstance.OPPBinaryMathOpType;
import com.vainolo.phd.opp.interpreter.builtin.OPPBinaryMathOpProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCallWebAPIProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCompareProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPConceptualProcess;
import com.vainolo.phd.opp.interpreter.builtin.OPPConsoleInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPConsoleOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPDialogInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPDialogOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPSleepProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCompareProcessInstance.ComparisonType;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPAddFirstPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPAddLastPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPGetFirstPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPGetLastPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPGetNamedPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPNewInstanceProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemoveFirstPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemoveLastPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPAddNamedPartProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.composite.OPPRemoveNamedPartProcessInstance;
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
    } else if (name.equals("a<=b")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.LESS_THAN_OR_EQUAL);
    } else if (name.equals("a>=b")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.GREATER_THAN_OR_EQUAL);
    } else if (name.equals("a>b")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.GREATER_THAN);
    } else if (name.equals("a<b")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.LESS_THAN);
    } else if (name.equals("a==b")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.EQUAL);

      // Composite
    } else if (name.equalsIgnoreCase("New Instance")) {
      processInstance = new OPPNewInstanceProcessInstance();
    } else if (name.equalsIgnoreCase("Add First Part")) {
      processInstance = new OPPAddFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Add Last Part")) {
      processInstance = new OPPAddLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Add Named Part")) {
      processInstance = new OPPAddNamedPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get First Part")) {
      processInstance = new OPPGetFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get Last Part")) {
      processInstance = new OPPGetLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Get Named Part")) {
      processInstance = new OPPGetNamedPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove First Part")) {
      processInstance = new OPPRemoveFirstPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove Last Part")) {
      processInstance = new OPPRemoveLastPartProcessInstance();
    } else if (name.equalsIgnoreCase("Remove Named Part")) {
      processInstance = new OPPRemoveNamedPartProcessInstance();

      // Misc
    } else if (name.equalsIgnoreCase("Sleep")) {
      processInstance = new OPPSleepProcessInstance();
    } else if (name.equalsIgnoreCase("Call Web API")) {
      processInstance = new OPPCallWebAPIProcessInstance();
    } else if (name.equalsIgnoreCase("Initialize Twitter Client")) {
      processInstance = new OPPInitializeTwitterClientProcessInstance();
    } else if (name.equalsIgnoreCase("Search Twitter")) {
      processInstance = new OPPSearchTwitter();
    }
    return processInstance;
  }
}

/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import org.eclipse.core.runtime.Path;

import com.vainolo.phd.opp.interpreter.builtin.OPPBinaryMathOpType;
import com.vainolo.phd.opp.interpreter.builtin.OPPBinaryMathOpProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCompareProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPConceptualProcess;
import com.vainolo.phd.opp.interpreter.builtin.OPPCreateObjectProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPPrintHelloWorldProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPSleepProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPPCompareProcessInstance.ComparisonType;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessExecutableInstance;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.OPPFileUtils;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

public class OPPProcessInstanceFactory {

  public static OPPProcessInstance createExecutableInstance(OPPObjectProcessDiagram opd) {
    switch(opd.getKind()) {
    case COMPOUND:
      return new OPPInZoomedProcessExecutableInstance(opd, new OPPOPDAnalyzer());
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
    OPPObjectProcessDiagram opd = OPPFileUtils.loadOPPFile(OPPInterpreter.container.getFile(new Path(opdName + ".opm"))
        .getFullPath().toString());
    return createExecutableInstance(opd);

  }

  public static OPPProcessInstance createExecutableInstance(OPPProcess process) {
    OPPProcessInstance executableInstance = null;
    switch(process.getKind()) {
    case BUILT_IN:
      executableInstance = createBuiltInProcess(process);
      break;
    case COMPOUND:
      executableInstance = createExecutableInstance(process.getName());
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

  private static OPPProcessInstance createBuiltInProcess(final OPPProcess process) {
    OPPProcessInstance processInstance;

    if(process.getName().equals("Input")) {
      processInstance = OPPInterpreterInjector.INSTANCE.getInstance(OPPInputProcessInstance.class);
    } else if(process.getName().equals("Output") || process.getName().equals("Dialog")
        || process.getName().equals("Print")) {
      processInstance = new OPPOutputProcessInstance();
      processInstance.setName(process.getName());
    } else if(process.getName().equals("+")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.ADD);// OPMAddProcessInstance();
    } else if(process.getName().equals("-")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.SUBS);// OPMSubstractProcessInstance();
    } else if(process.getName().equals("*")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.MULT);
    } else if(process.getName().equals("/")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.DIV);
    } else if(process.getName().equals("^")) {
      processInstance = new OPPBinaryMathOpProcessInstance(OPPBinaryMathOpType.POW);
    } else if(process.getName().equals("Sleep")) {
      processInstance = new OPPSleepProcessInstance();
      processInstance.setName(process.getName());
    } else if(process.getName().equals("Hello World")) {
      processInstance = new OPPPrintHelloWorldProcessInstance();
    } else if(process.getName().equals("Create") || process.getName().equals("New")) {
      processInstance = new OPPCreateObjectProcessInstance();
    } else if(process.getName().equals("<=")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.LESS_THAN_OR_EQUAL);
    } else if(process.getName().equals(">=")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.GREATER_THAN_OR_EQUAL);
    } else if(process.getName().equals(">")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.GREATER_THAN);
    } else if(process.getName().equals("<")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.LESS_THAN);
    } else if(process.getName().equals("==")) {
      processInstance = new OPPCompareProcessInstance(ComparisonType.EQUAL);
    } else {
      throw new IllegalStateException("Tried to create unexistent build-in process " + process.getName());
    }

    return processInstance;

  }
}

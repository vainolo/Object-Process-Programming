/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPMLogger.*;

import org.eclipse.core.runtime.Path;

import com.vainolo.phd.opp.interpreter.builtin.BinaryMathOpType;
import com.vainolo.phd.opp.interpreter.builtin.OPMBinaryMathOpProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPMCompareProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPMConceptualProcess;
import com.vainolo.phd.opp.interpreter.builtin.OPMCreateObjectProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPMInputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPMOutputProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPMPrintHelloWorldProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPMSleepProcessInstance;
import com.vainolo.phd.opp.interpreter.builtin.OPMCompareProcessInstance.ComparisonType;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPMInZoomedProcessExecutableInstance;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.OPPFileUtils;
import com.vainolo.phd.opp.utilities.analysis.OPDAnalyzer;

public class OPMProcessInstanceFactory {

  public static OPMProcessInstance createExecutableInstance(OPPObjectProcessDiagram opd) {
    switch(opd.getKind()) {
    case COMPOUND:
      return new OPMInZoomedProcessExecutableInstance(opd, new OPDAnalyzer());
    case UNFOLDED:
      logInfo("Unfolded OPDs can't be executed.");
      throw new IllegalArgumentException("Unfolded OPDs cannot be executed");
    case SYSTEM:
      logInfo("System OPDs can't be executed yet.");
      throw new IllegalArgumentException("System OPDs can't be executed yet.");
    }
    return null;
  }

  public static OPMProcessInstance createExecutableInstance(String opdName) {
    OPPObjectProcessDiagram opd = OPPFileUtils.loadOPPFile(OPMInterpreter.container.getFile(new Path(opdName + ".opm"))
        .getFullPath().toString());
    return createExecutableInstance(opd);

  }

  public static OPMProcessInstance createExecutableInstance(OPPProcess process) {
    OPMProcessInstance executableInstance = null;
    switch(process.getKind()) {
    case BUILT_IN:
      executableInstance = createBuiltInProcess(process);
      break;
    case COMPOUND:
      executableInstance = createExecutableInstance(process.getName());
      break;
    case CONCEPTUAL:
      executableInstance = new OPMConceptualProcess(process);
      break;
    case JAVA:
      executableInstance = new OPMJavaProcessExecutableInstance(process);
      break;
    }

    return executableInstance;
  }

  private static OPMProcessInstance createBuiltInProcess(final OPPProcess process) {
    OPMProcessInstance processInstance;

    if(process.getName().equals("Input")) {
      processInstance = OPMInterpreterInjector.INSTANCE.getInstance(OPMInputProcessInstance.class);
    } else if(process.getName().equals("Output") || process.getName().equals("Dialog")
        || process.getName().equals("Print")) {
      processInstance = new OPMOutputProcessInstance();
      processInstance.setName(process.getName());
    } else if(process.getName().equals("+")) {
      processInstance = new OPMBinaryMathOpProcessInstance(BinaryMathOpType.ADD);// OPMAddProcessInstance();
    } else if(process.getName().equals("-")) {
      processInstance = new OPMBinaryMathOpProcessInstance(BinaryMathOpType.SUBS);// OPMSubstractProcessInstance();
    } else if(process.getName().equals("*")) {
      processInstance = new OPMBinaryMathOpProcessInstance(BinaryMathOpType.MULT);
    } else if(process.getName().equals("/")) {
      processInstance = new OPMBinaryMathOpProcessInstance(BinaryMathOpType.DIV);
    } else if(process.getName().equals("^")) {
      processInstance = new OPMBinaryMathOpProcessInstance(BinaryMathOpType.POW);
    } else if(process.getName().equals("Sleep")) {
      processInstance = new OPMSleepProcessInstance();
      processInstance.setName(process.getName());
    } else if(process.getName().equals("Hello World")) {
      processInstance = new OPMPrintHelloWorldProcessInstance();
    } else if(process.getName().equals("Create") || process.getName().equals("New")) {
      processInstance = new OPMCreateObjectProcessInstance();
    } else if(process.getName().equals("<=")) {
      processInstance = new OPMCompareProcessInstance(ComparisonType.LESS_THAN_OR_EQUAL);
    } else if(process.getName().equals(">=")) {
      processInstance = new OPMCompareProcessInstance(ComparisonType.GREATER_THAN_OR_EQUAL);
    } else if(process.getName().equals(">")) {
      processInstance = new OPMCompareProcessInstance(ComparisonType.GREATER_THAN);
    } else if(process.getName().equals("<")) {
      processInstance = new OPMCompareProcessInstance(ComparisonType.LESS_THAN);
    } else if(process.getName().equals("==")) {
      processInstance = new OPMCompareProcessInstance(ComparisonType.EQUAL);
    } else {
      throw new IllegalStateException("Tried to create unexistent build-in process " + process.getName());
    }

    return processInstance;

  }
}

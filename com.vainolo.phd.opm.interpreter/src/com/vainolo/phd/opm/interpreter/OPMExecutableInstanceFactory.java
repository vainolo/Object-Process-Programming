/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.logging.Logger;

import org.eclipse.core.runtime.Path;

import com.vainolo.phd.opm.interpreter.builtin.OPMAddProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMAssignProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMConceptualProcess;
import com.vainolo.phd.opm.interpreter.builtin.OPMInputProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMOutputProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMPrintHelloWorldProcessInstance;
import com.vainolo.phd.opm.interpreter.builtin.OPMSleepProcessInstance;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.OPMFileUtils;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;
import com.vainolo.utils.SimpleLoggerFactory;

public class OPMExecutableInstanceFactory {

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMExecutableInstanceFactory.class.getName());

  static OPMExecutableInstance createExecutableInstance(final OPMObjectProcessDiagram opd) {
    switch(opd.getKind()) {
    case COMPOUND:
      return new OPMInZoomedProcessExecutableInstance(opd, new OPDAnalyzer());
    case UNFOLDED:
      logger.info("Unfolded OPDs cannot be executed.");
      throw new IllegalArgumentException("Unfolded OPDs cannot be executed");
    }
    return null;
  }

  public static OPMExecutableInstance createExecutableInstance(String opdName) {
    OPMObjectProcessDiagram opd = OPMFileUtils.INSTANCE.loadOPDFile(OPMInterpreter.container
        .getFile(new Path(opdName + ".opm")).getFullPath().toString());
    return createExecutableInstance(opd);

  }

  public static OPMExecutableInstance createExecutableInstance(OPMProcess process) {
    OPMExecutableInstance executableInstance = null;
    switch(process.getKind()) {
    case BUILT_IN:
      executableInstance = createBuildInProcess(process);
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

  private static OPMExecutableInstance createBuildInProcess(final OPMProcess process) {
    OPMExecutableInstance processInstance;

    if(process.getName().equals("Input")) {
      processInstance = new OPMInputProcessInstance();
    } else if(process.getName().equals("Output") || process.getName().equals("Dialog")
        || process.getName().equals("Show Message Dialog")) {
      processInstance = new OPMOutputProcessInstance();
    } else if(process.getName().equals("Add") || process.getName().equals("+")) {
      processInstance = new OPMAddProcessInstance();
    } else if(process.getName().equals("Sleep")) {
      processInstance = new OPMSleepProcessInstance();
    } else if(process.getName().equals("Assign") || process.getName().equals("=")) {
      processInstance = new OPMAssignProcessInstance();
    } else if(process.getName().equals("Hello World")) {
      processInstance = new OPMPrintHelloWorldProcessInstance();
    } else {
      throw new IllegalStateException("Tried to create unexistent build-in process " + process.getName());
    }

    return processInstance;

  }
}

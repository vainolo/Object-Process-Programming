/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.vainolo.phd.opm.utilities.OPMLogger.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.core.resources.IContainer;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 5 Jul 2012
 * 
 */
public enum OPMInterpreter {
  INSTANCE;

  public static IContainer container = null;

  public final ExecutorService executorService;

  private OPMInterpreter() {
    executorService = Executors.newCachedThreadPool();
  }

  /**
   * Execute an Object Process Diagram (OPD). An OPD can be of two kinds,
   * {@link OPMObjectProcessDiagramKind#SYSTEM} and
   * {@link OPMObjectProcessDiagramKind#COMPOUND}, but they can both be executed
   * in the same way.
   * 
   * @param opdName
   * @param container
   */
  public void interpret(String opdName, final IContainer _container) {
    container = _container;
    logInfo("Interpreting OPD {0}.", opdName);
    OPMProcessInstance instance = OPMProcessInstanceFactory.createExecutableInstance(opdName);

    try {
      instance.call();
    } catch(Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    logInfo("Finished interpreting {0}.", opdName);
  }

  public void stopExecution() {
    // instance.stop();
    executorService.shutdownNow();
  }
}

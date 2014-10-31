/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

import org.eclipse.core.resources.IContainer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.utils.SimpleLoggerFactory;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 5 Jul 2012
 * 
 */
public enum OPMInterpreter {
  INSTANCE;

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMInterpreter.class.getName());
  public static IContainer container = null;

  public final ExecutorService executorService;
  public final Injector injector;

  private OPMInterpreter() {
    executorService = Executors.newCachedThreadPool();
    injector = Guice.createInjector(new InterpreterModule());
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
    logger.info("Interpreting OPD" + opdName);
    OPMProcessInstance instance = OPMProcessInstanceFactory.createExecutableInstance(opdName);

    try {
      instance.call();
    } catch(Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    logger.info("Finished interpreting " + opdName);
  }

  public void stopExecution() {
    // instance.stop();
    executorService.shutdownNow();
  }
}

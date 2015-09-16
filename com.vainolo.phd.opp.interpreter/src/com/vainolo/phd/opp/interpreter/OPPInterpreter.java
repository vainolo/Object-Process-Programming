/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.eclipse.core.resources.IContainer;

import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.utilities.OPPLogger;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 5 Jul 2012
 * 
 */
public enum OPPInterpreter {
  INSTANCE;

  public static IContainer container = null;

  private OPPProcessInstance instance;
  private ExecutorService executor;
  private ExecutorCompletionService<OPPProcessExecutionResult> completionService;
  private OPPGlobalHeap globalHeap;

  private OPPInterpreter() {
  }

  /**
   * Execute an Object Process Diagram (OPD). An OPD can be of two kinds, {@link OPPObjectProcessDiagramKind#SYSTEM} and
   * {@link OPPObjectProcessDiagramKind#COMPOUND}, but they can both be executed in the same way.
   * 
   * @param opdName
   * @param container
   */
  public void interpret(String opdName, final IContainer _container) {
    executor = Executors.newCachedThreadPool();
    completionService = new ExecutorCompletionService<>(executor);
    globalHeap = new OPPGlobalHeap();

    OPPLogger.setLevel(Level.INFO);

    container = _container;
    logInfo("Interpreting OPD {0}.", opdName);
    instance = OPPProcessInstanceFactory.createExecutableInstance(opdName);

    try {
      completionService.submit(instance);
      completionService.take();
    } catch (Exception e) {
      logSevere("Unexpected exception: " + e.getMessage());
    }
    logInfo("Finished interpreting {0}.", opdName);
  }

  public Executor getExecutor() {
    return executor;
  }

  public void stopExecution() {
    logInfo("Stopping execution");
    executor.shutdownNow();
    try {
      executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      logWarning("Interrupted while waiting for all processes to finish.");
      e.printStackTrace();
    }
  }

  public OPPGlobalHeap getGlobalHeap() {
    return globalHeap;
  }
}

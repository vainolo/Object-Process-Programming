/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.utilities.OPPLogTarget;
import com.vainolo.phd.opp.utilities.OPPLogger;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 5 Jul 2012
 * 
 */
public enum OPPInterpreter {
  INSTANCE;
  
  public static String workingDirectory;
  
  private OPPProcessInstance instance;
  private ExecutorService executor;
  private ExecutorCompletionService<OPPProcessExecutionResult> completionService;
  private OPPGlobalHeap globalHeap;
  private OPPLogTarget logViewPart;
  private boolean stopped;

  private OPPInterpreter() {
  }

  /**
   * Execute an Object Process Diagram (OPD). An OPD can be of two kinds, {@link OPPObjectProcessDiagramKind#SYSTEM} and
   * {@link OPPObjectProcessDiagramKind#COMPOUND}, but they can both be executed in the same way.
   * 
   * @param opdName
   * @param container
   */
  public void interpret(OPPObjectProcessDiagram opd) {
    stopped = false;
    executor = Executors.newCachedThreadPool();
    completionService = new ExecutorCompletionService<>(executor);
    globalHeap = new OPPGlobalHeap();

    OPPLogger.setLevel(Level.FINE);
    try {
      logViewPart.clear();
    } catch (NullPointerException e) {
      OPPLogger.logWarning("logViewPart is null. probably not initialized. Ignoring.");
    }

    logInfo("Interpreting OPD {0}.", opd.getName());
    instance = OPPProcessInstanceFactory.createExecutableInstance(opd);

    try {
      completionService.submit(instance);
      completionService.take();
    } catch (Exception e) {
      logSevere("Unexpected exception: " + e.getMessage());
    }
    logInfo("Finished interpreting {0}.", opd.getName());
  }

  public Executor getExecutor() {
    return executor;
  }

  public void stopExecution() {
    logInfo("Stopping execution");
    stopped = true;
    executor.shutdownNow();
    while (!executor.isTerminated()) {
      try {
        executor.awaitTermination(5, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        logWarning("Interrupted while waiting for all processes to finish.");
        e.printStackTrace();
      }
    }
    logInfo("Stopped execution");
  }

  public boolean isStopped() {
    return stopped;
  }

  public OPPGlobalHeap getGlobalHeap() {
    return globalHeap;
  }

  public void setLogView(OPPLogTarget oppExecutionLogViewPart) {
    logViewPart = oppExecutionLogViewPart;
  }
}

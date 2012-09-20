/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import static com.vainolo.phd.opm.interpreter.OPMProcessInstanceFactory.createProcessInstance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.resources.IContainer;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMProcessKind;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 5 Jul 2012
 * 
 */
public enum Interpreter {
  INSTANCE;

  private IContainer containter;
  private ExecutorService executorService;
  private OPMProcessInstance instance;

  private Interpreter() {
  }

  public IContainer getContainer() {
    return containter;
  }

  public void interpret(final String processName, final IContainer container) {
    executorService = Executors.newCachedThreadPool();
    final OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
    this.containter = container;
    process.setName(processName);
    instance = createProcessInstance(process, OPMProcessKind.COMPOUND);
    instance.execute();
  }

  public ExecutorService getExecutorService() {
    return executorService;
  }

  public void stopExecution() {
    instance.stop();
    executorService.shutdownNow();
  }
}

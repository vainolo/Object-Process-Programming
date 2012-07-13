/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import java.util.concurrent.BlockingQueue;

class OPMProcessInstanceRunnable implements Runnable {
  private OPMProcessInstance instance;
  private BlockingQueue<OPMProcessInstanceRunnable> runningProcessInstanceQueue;

  public OPMProcessInstanceRunnable(final OPMProcessInstance instance,
      BlockingQueue<OPMProcessInstanceRunnable> runningProcessInstanceQueue) {
    this.instance = instance;
    this.runningProcessInstanceQueue = runningProcessInstanceQueue;
  }

  @Override
  public void run() {
    instance.execute();
    try {
      runningProcessInstanceQueue.put(this);
    } catch(InterruptedException e) {
      // The blocking queue should not throw this exception since it is "unbounded" (size of Integer.MAX_INT). So this
      // is very problematic.
      throw new IllegalStateException("Process execution communication queue threw an unexpected exception.", e);
    }
  }

  public OPMProcessInstance getInstance() {
    return instance;
  }
}
/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import org.eclipse.core.resources.IContainer;

import com.google.common.annotations.VisibleForTesting;
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
  private OPMProcessInstanceFactory factory;

  public IContainer getContainer() {
    return containter;
  }

  public void interpret(final String processName, final IContainer container) {
    this.containter = container;
    final OPMProcessInstance instance = getFactory().createProcessInstance(processName, OPMProcessKind.COMPOUND);
    instance.execute();
  }

  @VisibleForTesting
  OPMProcessInstanceFactory getFactory() {
    if(factory == null)
      factory = OPMProcessInstanceFactory.INSTANCE;
    return factory;
  }

  @VisibleForTesting
  void setFactory(final OPMProcessInstanceFactory factory) {
    this.factory = factory;
  }

}

/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter;

import com.vainolo.phd.opm.model.OPMProcessKind;

public interface OPMProcessInstanceFactory {

  OPMProcessInstanceFactory INSTANCE = OPMProcessInstanceFactoryImpl.INSTANCE;

  OPMProcessInstance createProcessInstance(String name, OPMProcessKind kind);

}
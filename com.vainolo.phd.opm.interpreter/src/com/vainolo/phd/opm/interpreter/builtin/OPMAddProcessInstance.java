/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import java.math.BigDecimal;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMExecutableInstance;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;

/**
 * Process that adds two integer values.
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @created 9 Jul 2012
 * 
 */
public class OPMAddProcessInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {
  public OPMAddProcessInstance() {
    OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
    object.setName("a");
    createArgument(object);
    object = OPMFactory.eINSTANCE.createOPMObject();
    object.setName("b");
    createArgument(object);
    object = OPMFactory.eINSTANCE.createOPMObject();
    object.setName("c");
    createArgument(object);
  }

  @Override
  public void executing() {
    final BigDecimal a = new BigDecimal(getArgument("a").toString());
    final BigDecimal b = new BigDecimal(getArgument("b").toString());
    final BigDecimal c = a.add(b);
    setArgument("c", c);
  }

  @Override
  public String getName() {
    return "Add";
  }

}

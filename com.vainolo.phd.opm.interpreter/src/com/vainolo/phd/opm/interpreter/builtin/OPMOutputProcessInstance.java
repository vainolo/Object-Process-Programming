/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMExecutableInstance;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;

/**
 * Arguments:
 * <ul>
 * <li>text:String, instrument.</li>
 * </ul>
 * 
 * @author vainolo
 * 
 */
public class OPMOutputProcessInstance extends OPMAbstractProcessInstance implements OPMExecutableInstance {

  public OPMOutputProcessInstance() {
    OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
    object.setName("text");
    createArgument(object);
  }

  @Override
  protected void executing() {
    final String text = getArgument("text").toString();
    System.out.println(text);
  }

  public void showMessageDialog(final String text) {
    JOptionPane.showMessageDialog(null, text);
  }

  @Override
  public String getName() {
    return "Console";
  }

}

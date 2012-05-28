package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;

/**
 * Arguments:
 * <ul>
 * <li>text:String, result</li>
 * </ul>
 * 
 * @author vainolo
 * 
 */
public class OPMInputProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {
	@Override
	public void execute() {
		super.execute();
		String retVal = JOptionPane.showInputDialog("Please enter your text here");
		setArgumentValue("text", retVal);
	}

	@Override
	public String getName() {
		return "Input";
	}
}

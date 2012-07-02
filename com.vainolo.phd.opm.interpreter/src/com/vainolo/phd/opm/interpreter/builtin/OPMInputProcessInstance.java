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
		final String retVal = showInputDialog();
		getVarManager().createVariable("text").setValue(retVal);
	}

	/**
	 * Method is public for testing purposes. Do not call directly.
	 */
	public String showInputDialog() {
		return JOptionPane.showInputDialog("Please enter your text here");
	}

	@Override
	public String getName() {
		return "Input";
	}
}

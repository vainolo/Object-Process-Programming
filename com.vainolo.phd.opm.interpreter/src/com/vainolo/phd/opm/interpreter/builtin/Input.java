package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

import com.vainolo.phd.opm.interpreter.AbstractProcess;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;
import com.vainolo.phd.opm.interpreter.model.InterpreterFactory;
import com.vainolo.phd.opm.interpreter.model.Variable;

/**
 * Arguments:
 * <ul>
 * <li>text:String, result</li>
 * </ul>
 * 
 * @author vainolo
 * 
 */
public class Input extends AbstractProcess implements OPMProcessInstance {
	@Override
	public void execute() {
		String retVal = JOptionPane.showInputDialog("Please enter your text here");
		Variable v = InterpreterFactory.eINSTANCE.createVariable();
		v.setValue(retVal);
		setArgument("text", v);
	}
}

package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

import com.vainolo.phd.opm.interpreter.AbstractProcess;
import com.vainolo.phd.opm.interpreter.OPMProcessInstance;

/**
 * Arguments:
 * <ul>
 * <li>text:String, instrument.</li>
 * </ul>
 * 
 * @author vainolo
 * 
 */
public class Output extends AbstractProcess implements OPMProcessInstance {

	@Override
	public void execute() {
		String text = (String) getArgument("text").getValue();
		JOptionPane.showMessageDialog(null, text);
	}

}

package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

import com.vainolo.phd.opm.interpreter.OPMAbstractProcessInstance;
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
public class OPMOutputProcessInstance extends OPMAbstractProcessInstance implements OPMProcessInstance {

	@Override
	public void execute() {
		super.execute();
		final String text = getArgumentValue("text").toString();
		showMessageDialog(text);
	}

	@Override
	public String getName() {
		return "Output";
	}

	public void showMessageDialog(final String text) {
		JOptionPane.showMessageDialog(null, text);
	}
}

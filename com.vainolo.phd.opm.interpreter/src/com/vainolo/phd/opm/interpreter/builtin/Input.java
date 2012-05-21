package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

/**
 * Process which receives input from the user.
 * 
 * @author vainolo
 * 
 */
public class Input {
	public String execute() {
		String retVal = JOptionPane.showInputDialog("Hello");
		return retVal;
	}
}

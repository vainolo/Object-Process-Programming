package com.vainolo.phd.opm.interpreter.builtin;

import javax.swing.JOptionPane;

public class DialogOutput {
	public void execute(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

}

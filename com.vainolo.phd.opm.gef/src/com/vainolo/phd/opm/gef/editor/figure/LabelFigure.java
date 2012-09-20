/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Label;

public class LabelFigure extends Label implements OPMNamedElementFigure {

	@Override
	public Label getNameLabel() {
		return this;
	}

}

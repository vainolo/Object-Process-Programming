package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Label;

public class LabelFigure extends Label implements OPMNamedElementFigure {

	@Override
	public Label getNameLabel() {
		return this;
	}

}

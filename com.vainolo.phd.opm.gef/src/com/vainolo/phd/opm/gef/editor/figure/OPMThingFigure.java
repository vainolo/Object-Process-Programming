package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

public interface OPMThingFigure extends OPMNodeFigure {
	public Label getNameLabel();
	/**
	 * The figure on which this figure's childs should be added
	 * instead of adding them directory.
	 * @return a figure on which child figures can be added.
	 */
	public IFigure getContentPane();
}

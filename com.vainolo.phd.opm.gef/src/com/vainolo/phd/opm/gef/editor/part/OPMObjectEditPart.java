/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;

import com.vainolo.phd.opm.gef.editor.figure.OPMObjectFigure;

public class OPMObjectEditPart extends OPMThingEditPart {

	@Override
	protected IFigure createFigure() {
		return new OPMObjectFigure();
	}
}

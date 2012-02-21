/*******************************************************************************
 * This is me!!!
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

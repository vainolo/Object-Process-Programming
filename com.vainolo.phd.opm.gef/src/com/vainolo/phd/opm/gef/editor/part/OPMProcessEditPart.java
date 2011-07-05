package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;

import com.vainolo.phd.opm.gef.editor.figure.OPMProcessFigure;

public class OPMProcessEditPart extends OPMThingEditPart {

	@Override protected IFigure createFigure() {
		return new OPMProcessFigure();
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		
	}
}

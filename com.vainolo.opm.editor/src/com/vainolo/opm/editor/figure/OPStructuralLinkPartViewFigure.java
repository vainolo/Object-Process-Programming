package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.ManhattanConnectionRouter;

public class OPStructuralLinkPartViewFigure extends OPLinkFigure {

	public OPStructuralLinkPartViewFigure() {
		setConnectionRouter(new ManhattanConnectionRouter());
	}
}

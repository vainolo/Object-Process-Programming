package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

public class OPMStructuralLinkEditPart extends AbstractConnectionEditPart {

	@Override public Connection getConnectionFigure() {
		Connection connection = super.getConnectionFigure();
		connection.setConnectionRouter(new ManhattanConnectionRouter());
		return connection;
	}

	@Override protected void createEditPolicies() {
		// TODO Auto-generated method stub
	}
}

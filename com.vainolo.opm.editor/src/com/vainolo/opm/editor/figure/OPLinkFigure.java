package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.SWT;

public abstract class OPLinkFigure extends PolylineConnection {
	public OPLinkFigure() {
		setAntialias(SWT.ON);
		setLineWidth(OPFigureConstants.CONNECTION_LINE_WIDTH);
	}
}

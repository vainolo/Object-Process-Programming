package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.swt.SWT;

import com.vainolo.opm.editor.OPEditor;
import com.vainolo.opm.editor.OPEditorPlugin;

public class OPObjectFigure extends Figure {

	private RectangleFigure borderRectangle;
	private Label nameLabel;
	
	public OPObjectFigure() {
		setLayoutManager(new XYLayout());
		borderRectangle = new RectangleFigure();
		borderRectangle.setAntialias(SWT.ON);
		borderRectangle.setForegroundColor(OPMFigureConstants.OBJECT_COLOR);
		borderRectangle.setLineWidth(OPMFigureConstants.ENTITY_BORDER_WIDTH);
		
		nameLabel = new Label("hello");
		nameLabel.setForegroundColor(OPMFigureConstants.LABEL_COLOR);
		add(borderRectangle);
		add(nameLabel);
	}
	
	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		bounds = getBounds().getCopy();
		setConstraint(borderRectangle, new Rectangle(0, 0, bounds.width, bounds.height));
		setConstraint(nameLabel, new Rectangle(0, 0, bounds.width, bounds.height));
	}
	
	public void setName(String name) {
		nameLabel.setText(name);
	}
}

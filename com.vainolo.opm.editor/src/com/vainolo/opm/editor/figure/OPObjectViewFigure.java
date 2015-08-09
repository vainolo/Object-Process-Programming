package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class OPObjectViewFigure extends OPMNodeFigure {

	private RectangleFigure borderRectangle;
	private Label nameLabel;
	
	public OPObjectViewFigure() {
		setLayoutManager(new XYLayout());
		
		borderRectangle = new RectangleFigure();
		borderRectangle.setAntialias(SWT.ON);
		borderRectangle.setForegroundColor(OPFigureConstants.OBJECT_COLOR);
		borderRectangle.setLineWidth(OPFigureConstants.ENTITY_BORDER_WIDTH);
		
		nameLabel = new Label();
		nameLabel.setForegroundColor(OPFigureConstants.LABEL_COLOR);
		
		add(borderRectangle);
		add(nameLabel);
	}
	
	public void setName(String name) {
		nameLabel.setText(name);
	}
	
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		bounds = getBounds().getCopy();
		setConstraint(borderRectangle, new Rectangle(0, 0, bounds.width, bounds.height));
		setConstraint(nameLabel, new Rectangle(0, 0, bounds.width, bounds.height));
	}
	
	
}

package com.vainolo.opm.editor.figure;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class OPProcessFigure extends OPMNodeFigure {

	private Ellipse borderEllipse;
	private Label nameLabel;
	
	public OPProcessFigure() {
		setLayoutManager(new XYLayout());
		
		borderEllipse = new Ellipse();
		borderEllipse.setAntialias(SWT.ON);
		borderEllipse.setForegroundColor(OPFigureConstants.PROCESS_COLOR);
		borderEllipse.setLineWidth(OPFigureConstants.ENTITY_BORDER_WIDTH);
		
		nameLabel = new Label();
		nameLabel.setForegroundColor(OPFigureConstants.LABEL_COLOR);
		
		add(borderEllipse);
		add(nameLabel);
		
		setConnectionAnchor(new EllipseAnchor(this));
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		Rectangle bounds = getBounds().getCopy();
		setConstraint(borderEllipse, new Rectangle(0,0,bounds.width,bounds.height));
		setConstraint(nameLabel, new Rectangle(0, 0, bounds.width, bounds.height));
	}
	
	public void setName(String name) {
		nameLabel.setText(name);
	}	
}

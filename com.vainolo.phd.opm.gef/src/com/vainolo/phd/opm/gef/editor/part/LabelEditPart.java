package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;

import com.vainolo.phd.opm.model.LinkLabel;

public class LabelEditPart extends AbstractGraphicalEditPart {

	private Label label;

	@Override
	protected IFigure createFigure() {
		label = new Label();
		return label;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy("chukumuku", new ResizableEditPolicy() {

		});
	}

	@Override
	protected void refreshVisuals() {
		GraphicalEditPart parent = (GraphicalEditPart) getParent();
		LinkLabel model = (LinkLabel) getModel();
		label.setText(model.getText());
		Dimension size = label.getPreferredSize();
		parent.setLayoutConstraint(this, label, new Rectangle(model.getLocation(), size));
		// StringBuffer model = (StringBuffer) getModel();
		// label.setText(model.toString());
		// GraphicalEditPart parent = (GraphicalEditPart) getParent();
		// ConnectionLocator locator = new ConnectionLocator((Connection)
		// parent.getFigure()) {
		// @Override
		// public void relocate(IFigure target) {
		// Dimension prefSize = target.getPreferredSize();
		// Point center = getReferencePoint();
		// center = new Point(200, 200);
		// System.out.println(center);
		// target.translateToRelative(center);
		// target.setBounds(getNewBounds(prefSize, center));
		// }
		// };
		// locator.setGap(100);
		// locator.setRelativePosition(PositionConstants.NORTH);
		// parent.setLayoutConstraint(this, label, locator);
	}
}

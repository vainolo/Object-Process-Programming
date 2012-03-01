package com.vainolo.gef.template.part;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.gef.template.model.Node;

public class NodeEditPart extends AbstractGraphicalEditPart implements Observer {

	Ellipse figure;

	public NodeEditPart(Node model) {
		setModel(model);
	}

	@Override
	protected IFigure createFigure() {
		figure = new Ellipse();
		return figure;
	}

	@Override
	public void activate() {
		((Node) getModel()).addObserver(this);
		super.activate();
	}

	@Override
	public void deactivate() {
		super.deactivate();
		((Node) getModel()).deleteObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		refresh();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		Node model = (Node) getModel();
		figure.setBounds(new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));
	}

	@Override
	protected void createEditPolicies() {
		// nothing to do here.
	}
}

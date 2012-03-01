/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.part;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.gef.template.model.Node;

/**
 * An edit part representation for the {@link Node} model entity.
 * 
 * @author vainolo
 * 
 */
public class NodeEditPart extends AbstractGraphicalEditPart implements Observer {

	private Ellipse figure;

	/**
	 * Create a new edit part using the provided {@link Node} model.
	 * 
	 * @param model
	 *            of this edit part.
	 */
	public NodeEditPart(Node model) {
		setModel(model);
	}

	/**
	 * Create an {@link Ellipse} as the representation of the model {@link Node}
	 * .
	 */
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

	/**
	 * When the model has changed, this method refreshed the visual
	 * representation.
	 */
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

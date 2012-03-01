/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.part;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.model.Node;
import com.vainolo.gef.template.policy.CanvasXYLayoutEditPolicy;

/**
 * The top-most (or bottom-most?) edit part of the editor. This is the edit part
 * representation of the {@link Canvas} class, which contains {@link Node}
 * instances, which are the model children of this edit part.
 * 
 * @author vainolo
 * 
 */
public class CanvasEditPart extends AbstractGraphicalEditPart implements Observer {

	/**
	 * Create a new edit part using the provided {@link Canvas} model
	 * 
	 * @param model
	 *            of this edit part.
	 */
	public CanvasEditPart(Canvas model) {
		setModel(model);
	}

	/**
	 * The canvas is a {@link FreeformLayer} figure that acts as the editor's
	 * canvas.
	 */
	@Override
	protected IFigure createFigure() {
		FreeformLayer layer = new FreeformLayer();
		layer.setLayoutManager(new FreeformLayout());
		return layer;
	}

	/**
	 * Returns the nodes of the canvas.
	 */
	@Override
	protected List<Node> getModelChildren() {
		Canvas c = (Canvas) getModel();
		return c.getNodes();
	}

	@Override
	public void activate() {
		((Canvas) getModel()).addObserver(this);
		super.activate();
	}

	@Override
	public void deactivate() {
		super.deactivate();
		((Canvas) getModel()).deleteObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		refresh();
	}

	/**
	 * Install the {@link CanvasXYLayoutEditPolicy} as an
	 * {@link EditPolicy#LAYOUT_ROLE} (not that it matters since role is never
	 * checked by the framework).
	 */
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CanvasXYLayoutEditPolicy());
	}
}

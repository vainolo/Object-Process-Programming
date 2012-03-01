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

public class CanvasEditPart extends AbstractGraphicalEditPart implements Observer {

	public CanvasEditPart(Canvas model) {
		setModel(model);
	}

	@Override
	protected IFigure createFigure() {
		FreeformLayer layer = new FreeformLayer();
		layer.setLayoutManager(new FreeformLayout());
		return layer;
	}

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

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CanvasXYLayoutEditPolicy());
	}
}

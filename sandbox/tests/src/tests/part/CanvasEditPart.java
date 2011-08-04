package tests.part;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import tests.command.CreateNodeCommand;
import tests.model.Canvas;
import tests.model.Node;

public class CanvasEditPart extends AbstractGraphicalEditPart {

	@Override 
	protected IFigure createFigure() {
		FreeformLayer layer = new FreeformLayer();
		layer.setLayoutManager(new FreeformLayout());
		layer.setBorder(new LineBorder(1));
		return layer;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			@Override protected Command getCreateCommand(CreateRequest request) {
				CreateNodeCommand command = new CreateNodeCommand();
				command.setParams((Canvas)(getHost().getModel()),(Node)(request.getNewObject()), request.getLocation());
				return command;
			}
		});
	}
	
	@Override
	protected List getModelChildren() {
		return ((Canvas)getModel()).getNodes();
	}
	
	@Override
	public void activate() {
		if(!isActive()) {
			((Canvas)getModel()).addObserver(new CanvasObserver());
		}
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive()) {
			((Canvas)getModel()).deleteObservers();
		}
		super.deactivate();
	}
	
	private class CanvasObserver implements Observer {

		@Override
		public void update(Observable arg0, Object arg1) {
			refreshChildren();
		}
		
		
		
	}

}

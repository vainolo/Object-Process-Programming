package tests.part;


import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import tests.command.CreateLinkCommand;
import tests.model.Link;
import tests.model.Node;

public class MyNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart {
	
	private Figure figure;
	private ConnectionAnchor anchor;
	
	public MyNodeEditPart() {
	}

	@Override
	protected IFigure createFigure() {
		if(figure == null) {
			figure = new RectangleFigure();
		}
		return figure;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
			
			@Override
			protected Command getReconnectTargetCommand(ReconnectRequest request) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			protected Command getReconnectSourceCommand(ReconnectRequest request) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
				return UnexecutableCommand.INSTANCE;
			}
			
			@Override
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				CreateLinkCommand command = new CreateLinkCommand(); 
				Node source = (Node) request.getSourceEditPart().getModel();
				Node target = (Node) request.getTargetEditPart().getModel();
				Link link = (Link) request.getNewObject();
				command.setParams(source, target, link);
				return command;
			}
		});
	}
	
	private ConnectionAnchor getConnectionAnchor() {
		if(anchor == null) {
			anchor = new ChopboxAnchor(figure);
		}
		return anchor;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getConnectionAnchor();
	}
	
	@Override
	protected void refreshVisuals() {
		Node node = (Node) getModel();
		CanvasEditPart parent = (CanvasEditPart) getParent();
		parent.setLayoutConstraint(this, figure, new Rectangle(node.getLocation().x, node.getLocation().y, 25, 25));
	}
	
	@Override
	protected List getModelSourceConnections() {
		return ((Node)getModel()).getSourceLinks(); 
	}
	
	@Override
	protected List getModelTargetConnections() {
		System.out.println("I have "+((Node)getModel()).getTargetLinks()+" target links");
		return ((Node)getModel()).getTargetLinks();
	}
	@Override
	public void activate() {
		if(!isActive()) {
			((Node)getModel()).addObserver(new NodeObserver());
		}
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive()) {
			((Node)getModel()).deleteObservers();
		}
		super.deactivate();
	}
	
	public class NodeObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			refreshVisuals();
			refreshSourceConnections();
			refreshTargetConnections();
		}
		
	}
	

}

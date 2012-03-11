package tests.part;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
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
		if (figure == null) {
			figure = new RectangleFigure();
			figure.setLayoutManager(new FreeformLayout());
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
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {

			@Override
			protected Command getCreateCommand(final CreateRequest request) {
				System.out.println("Create in container node");
				final Node newNode = (Node) request.getNewObject();
				newNode.setParent((Node) getHost().getModel());
				newNode.setLocation(request.getLocation().getCopy());
				final Node host = (Node) ((NodeEditPart) getHost()).getModel();
				Command c = new Command() {
					@Override
					public void execute() {
						host.addChild(newNode);
					}
				};
				return c;
			}
		});

		installEditPolicy("moco", new ResizableEditPolicy() {
			@Override
			protected void showSelection() {
				super.showSelection();
				MyNodeEditPart me = (MyNodeEditPart) getHost();
				if (getHost().getParent().getClass().equals(CanvasEditPart.class)) {
					return;
				}
				MyNodeEditPart parent = (MyNodeEditPart) getHost().getParent();
				parent.reorderChild(me, parent.getChildren().size() - 1);
			}

		});

		// installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
		//
		// @Override
		// protected Command getCreateCommand(CreateRequest request) {
		// System.out.println("Create in layout node");
		// return null;
		// }
		// });

	}

	@Override
	protected List getModelChildren() {
		List retVal = ((Node) getModel()).getChildren();
		System.out.println(this.toString() + retVal.size());
		return retVal;
	}

	@Override
	public void performRequest(Request req) {
		System.out.println(req.getType());
		if (req.getType() == RequestConstants.REQ_OPEN) {
			System.out.println("requested double-click.");
		}
	}

	private ConnectionAnchor getConnectionAnchor() {
		if (anchor == null) {
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
		if (getParent() instanceof CanvasEditPart) {
			CanvasEditPart parent = (CanvasEditPart) getParent();
			parent.setLayoutConstraint(this, figure,
					new Rectangle(node.getLocation().x, node.getLocation().y, node.getSize(), node.getSize()));
		} else {
			NodeEditPart parent = (NodeEditPart) getParent();
			parent.setLayoutConstraint(this, figure,
					new Rectangle(node.getLocation().x, node.getLocation().y, node.getSize(), node.getSize()));
		}
	}

	@Override
	protected List getModelSourceConnections() {
		return ((Node) getModel()).getSourceLinks();
	}

	@Override
	protected List getModelTargetConnections() {
		return ((Node) getModel()).getTargetLinks();
	}

	@Override
	public void activate() {
		if (!isActive()) {
			((Node) getModel()).addObserver(new NodeObserver());
		}
		super.activate();
	}

	@Override
	public void deactivate() {
		if (isActive()) {
			((Node) getModel()).deleteObservers();
		}
		super.deactivate();
	}

	public class NodeObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			refreshVisuals();
			refreshChildren();
			refreshSourceConnections();
			refreshTargetConnections();
		}

	}

}

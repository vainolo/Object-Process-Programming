package tests.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import tests.model.Canvas;
import tests.model.Node;

public class CreateNodeCommand extends Command {
	private Canvas canvas;
	private Node node;
	private Point location;
	
	@Override
	public void execute() {
		node.setLocation(location);
		canvas.addNode(node);
	}
	
	@Override
	public void undo() {
		canvas.removeNode(node);
	}
	
	public void setParams(final Canvas canvas, final Node node, final Point location) {
		this.canvas = canvas;
		this.node = node;
		this.location = location;
	}
	

}

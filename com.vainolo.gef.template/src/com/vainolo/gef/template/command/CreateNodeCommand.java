package com.vainolo.gef.template.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.model.Node;

public class CreateNodeCommand extends Command {

	private final Canvas canvas;
	private final Node node;

	public CreateNodeCommand(Canvas canvas, Node node) {
		this.canvas = canvas;
		this.node = node;
	}

	@Override
	public void execute() {
		canvas.addNode(node);
	}

	@Override
	public void undo() {
		super.undo();
		canvas.removeNode(node);
	}
}

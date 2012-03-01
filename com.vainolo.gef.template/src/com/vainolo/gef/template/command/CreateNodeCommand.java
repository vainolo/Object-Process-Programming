/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.model.Node;

/**
 * Command used to create a new node in the diagram.
 * 
 * @author vainolo
 * 
 */
public class CreateNodeCommand extends Command {

	private final Canvas canvas;
	private final Node node;

	/**
	 * Create a new command where the node is added to the canvas.
	 * 
	 * @param canvas
	 *            in which the node is added.
	 * @param node
	 *            to add to the canvas.
	 */
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

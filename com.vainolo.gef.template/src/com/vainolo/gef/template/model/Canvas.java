/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

/**
 * A simple class to store nodes.
 * 
 * @author vainolo
 * 
 */
public class Canvas extends Observable {
	List<Node> nodes;

	/**
	 * Create a new canvas.
	 */
	public Canvas() {
		nodes = new ArrayList<>();
	}

	/**
	 * Add a node to the canvas. Nothing happens if the node was already in the
	 * canvas.
	 * 
	 * @param node
	 *            the node to add to the canvas.
	 */
	public void addNode(Node node) {
		nodes.add(node);
		markChangedAndNotify();
	}

	/**
	 * Remove the node from the canvas. Nothing happens if the node was not in
	 * the canvas.
	 * 
	 * @param node
	 *            the node to remove from the canvas.
	 */
	public void removeNode(Node node) {
		nodes.remove(node);
		markChangedAndNotify();
	}

	/**
	 * Get a list of all the nodes in the canvas.
	 * 
	 * @return an unmodifiable list of nodes.
	 */
	public List<Node> getNodes() {
		return Collections.unmodifiableList(nodes);
	}

	/**
	 * Mark the instance as changed and notify all observers.
	 */
	public void markChangedAndNotify() {
		setChanged();
		notifyObservers();
	}
}

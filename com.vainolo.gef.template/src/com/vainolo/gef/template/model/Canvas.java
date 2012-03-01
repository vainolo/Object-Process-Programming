package com.vainolo.gef.template.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Canvas extends Observable {
	List<Node> nodes;

	public Canvas() {
		nodes = new ArrayList<>();
	}

	public void addNode(Node node) {
		nodes.add(node);
		markChangedAndNotify();
	}

	public void removeNode(Node node) {
		nodes.remove(node);
		markChangedAndNotify();
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void markChangedAndNotify() {
		setChanged();
		notifyObservers();
	}
}

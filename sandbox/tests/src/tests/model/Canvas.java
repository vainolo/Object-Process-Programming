package tests.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Canvas extends Observable {
	private List<Node> nodes;

	public void addNode(Node node) {
		getNodes().add(node);
		setChanged();
		notifyObservers();
	}
	
	public void removeNode(Node node) {
		getNodes().remove(node);
		setChanged();
		notifyObservers();
	}
	
	public List<Node> getNodes() {
		if(nodes == null) {
			nodes = new ArrayList<Node>();
		}
		return nodes; 
	}
}

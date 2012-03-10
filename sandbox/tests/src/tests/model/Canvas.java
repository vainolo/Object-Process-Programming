package tests.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Canvas extends Observable {
	private List<Node> nodes;

	public void addNode(Node node) {
		getNodes().add(node);
		setChangedAndNotify();
	}
	
	public void removeNode(Node node) {
		getNodes().remove(node);
		setChangedAndNotify();
	}
	
	public List<Node> getNodes() {
		if(nodes == null) {
			nodes = new ArrayList<Node>();
		}
		return nodes; 
	}
	
	private void setChangedAndNotify() {
		setChanged();
		notifyObservers();
	}
	
}

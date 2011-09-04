package tests.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.eclipse.draw2d.geometry.Point;

public class Node extends Observable {
	private Point location;
	private int size;
	private List<Link> sourceLinks;
	private List<Link> targetLinks;
	private List<Node> children;
	
	public Node(int x, int y) {
	    size = 20;
		setLocation(new Point(x, y));
		sourceLinks = new ArrayList<Link>();
		targetLinks = new ArrayList<Link>();
		children = new ArrayList<Node>();
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
		setChanged();
		notifyObservers();
	}
	
	public void addSourceLink(Link link) {
		sourceLinks.add(link);
		setChanged();
		notifyObservers();
	}
	
	public void removeSourceLink(Link link) {
		sourceLinks.remove(link);
		setChanged();
		notifyObservers();
	}
	
	public void addTargetLink(Link link) {
		targetLinks.add(link);
		setChanged();
		notifyObservers();
	}
	
	public void removeTargetLink(Link link) {
		targetLinks.remove(link);
		setChanged();
		notifyObservers();
	}
	
	public List<Link> getSourceLinks() {
		return sourceLinks;
	}
	
	public List<Link> getTargetLinks() {
		return targetLinks;
	}

	public List<Node> getChildren() {
	    return children;
	}
	
	public void addChild(Node child) {
	    children.add(child);
	    setChanged();
	    notifyObservers();
	}
	
	public void removeChild(Node child) {
	    children.remove(child);
	    setChanged();
	    notifyObservers();
	}

	public int getSize() {
	    return size;
	}
	
	public void setSize(final int size) {
	    this.size = size;
	    setChanged();
	    notifyObservers();
	}
}

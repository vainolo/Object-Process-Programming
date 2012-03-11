package tests.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.eclipse.draw2d.geometry.Point;

public class Node extends Observable {
	private Point location;
	private int size;
	private Node parent;
	private final List<Link> sourceLinks;
	private final List<Link> targetLinks;
	private final List<Node> children;

	public Node(int x, int y, Node parent) {
		size = 50;
		setLocation(new Point(x, y));
		sourceLinks = new ArrayList<Link>();
		targetLinks = new ArrayList<Link>();
		children = new ArrayList<Node>();
		this.parent = parent;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
		setChangedAndNotify();
	}

	public void addSourceLink(Link link) {
		sourceLinks.add(link);
		setChangedAndNotify();
	}

	public void removeSourceLink(Link link) {
		sourceLinks.remove(link);
		setChangedAndNotify();
	}

	public void addTargetLink(Link link) {
		targetLinks.add(link);
		setChangedAndNotify();
	}

	public void removeTargetLink(Link link) {
		targetLinks.remove(link);
		setChangedAndNotify();
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
		setChangedAndNotify();
	}

	public void removeChild(Node child) {
		children.remove(child);
		setChangedAndNotify();
	}

	public int getSize() {
		return size;
	}

	public void setSize(final int size) {
		this.size = size;
		setChangedAndNotify();
	}

	public Node getParent() {
		return this.parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
		setChangedAndNotify();
	}

	private void setChangedAndNotify() {
		setChanged();
		notifyObservers();
	}
}

package com.vainolo.diagram.view;

public class NodeImpl extends AbstractViewElementWithModel implements Node {
	private Point location;
	private Size size;
	
	@Override
	public Point getLocation() { return location; }

	@Override
	public void setLocation(Point location) { this.location = location; }

	@Override
	public Size getSize() { return size; }

	@Override
	public void setSize(Size size) { this.size = size; }

}

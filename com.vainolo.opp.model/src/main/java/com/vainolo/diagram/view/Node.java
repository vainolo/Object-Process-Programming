package com.vainolo.diagram.view;

public interface Node extends ViewElementWithModel {

	public abstract Point getLocation();

	public abstract void setLocation(Point location);

	public abstract Size getSize();

	public abstract void setSize(Size size);

}
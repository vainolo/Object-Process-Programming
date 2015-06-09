package com.vainolo.diagram.model;

public interface Link extends ModelElement, NamedModelElement {

	public abstract void setSource(Node source);

	public abstract void setTarget(Node target);

	public abstract Node getSource();

	public abstract Node getTarget();

}
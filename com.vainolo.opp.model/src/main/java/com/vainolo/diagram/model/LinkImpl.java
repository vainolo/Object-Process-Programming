package com.vainolo.diagram.model;

public class LinkImpl extends AbstractNamedModelElement implements Link {
	private Node source;
	private Node target;
	
	@Override
	public void setSource(Node source) {
		this.source = source;
		getNotifier().notifyObservers();
	}
	
	@Override
	public void setTarget(Node target) {
		this.target = target;
		getNotifier().notifyObservers();
	}
	

	@Override
	public Node getSource() {
		return source;
	}
	

	@Override
	public Node getTarget() {
		return target;
	}
}

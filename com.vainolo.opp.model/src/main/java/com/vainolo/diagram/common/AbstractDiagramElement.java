package com.vainolo.diagram.common;


public abstract class AbstractDiagramElement implements DiagramElement {
	
	private DiagramNotifier notifier = new DiagramNotifier(this);

	@Override
	public DiagramNotifier getNotifier() {
		return notifier;
	}

}

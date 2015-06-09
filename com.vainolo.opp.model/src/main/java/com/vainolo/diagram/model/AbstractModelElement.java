package com.vainolo.diagram.model;

import com.vainolo.diagram.common.AbstractDiagramElement;

public abstract class AbstractModelElement extends AbstractDiagramElement implements ModelElement {
	
	private int id;
	
	@Override
	public int getId() {
		return id; 
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
}

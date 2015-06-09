package com.vainolo.diagram.view;

import com.vainolo.diagram.common.AbstractDiagramElement;

public abstract class AbstractViewElement extends AbstractDiagramElement implements ViewElement {
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

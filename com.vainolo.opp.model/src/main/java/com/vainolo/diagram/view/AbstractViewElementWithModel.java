package com.vainolo.diagram.view;

import com.vainolo.diagram.model.ModelElement;

public class AbstractViewElementWithModel extends AbstractViewElement {
	
	private ModelElement model;
	
	public void setModel(ModelElement model) {
		this.model = model;
	}
	
	public ModelElement getModel() {
		return model;
	}
}

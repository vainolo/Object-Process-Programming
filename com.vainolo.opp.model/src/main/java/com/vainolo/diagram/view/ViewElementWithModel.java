package com.vainolo.diagram.view;

import com.vainolo.diagram.model.ModelElement;

public interface ViewElementWithModel extends ViewElement {
	ModelElement getModel();
	void setModel(ModelElement mode); 
}

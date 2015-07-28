package com.vainolo.opm.model.view;

import com.vainolo.opm.model.OPElement;

public interface OPElementView extends OPElement {
	OPElementViewContainer getElementViewContainer();
	void setViewElementContainer(OPElementViewContainer container);
}

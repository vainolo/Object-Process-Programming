package com.vainolo.opm.model.view;

import java.util.List;

import com.vainolo.opm.model.OPElement;

public interface OPElementViewContainer extends OPElement {
	void addElementView(OPElementView element);
	void removeElementView(OPElementView element);
	List<OPElementView> getViewElements();
}

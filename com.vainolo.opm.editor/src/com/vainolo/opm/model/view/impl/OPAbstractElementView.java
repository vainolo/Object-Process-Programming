package com.vainolo.opm.model.view.impl;

import com.vainolo.opm.model.impl.OPAbstractElement;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPElementViewContainer;

public abstract class OPAbstractElementView extends OPAbstractElement implements OPElementView {

	private OPElementViewContainer container;

	public OPAbstractElementView(int id) {
		super(id);
	}
	
	@Override
	public OPElementViewContainer getElementViewContainer() {
		return container;
	}
	
	@Override
	public void setViewElementContainer(OPElementViewContainer container) {
		this.container = container;
		notifyObservers();
	}
	

}

package com.vainolo.opm.model.view.impl;

import com.vainolo.opm.model.impl.OPAbstractElementImpl;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPElementViewContainer;

public abstract class OPAbstractElementViewImpl extends OPAbstractElementImpl implements OPElementView {

	private OPElementViewContainer container;

	public OPAbstractElementViewImpl(int id) {
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

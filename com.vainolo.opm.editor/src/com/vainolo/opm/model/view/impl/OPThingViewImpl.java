package com.vainolo.opm.model.view.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.opm.model.view.OPNodeView;
import com.vainolo.opm.model.view.OPThingView;
import com.vainolo.opm.model.view.OPElementView;

public class OPThingViewImpl extends OPNodeViewImpl implements OPThingView {
	List<OPNodeView> nodes = Lists.newArrayList();
	List<OPElementView> elements = Lists.newArrayList();

	public OPThingViewImpl(int id) {
		super(id);
	}
	
	@Override
	public void addElementView(OPElementView element) {
		elements.add(element);
		notifyObservers();
	}

	@Override
	public void removeElementView(OPElementView element) {
		elements.remove(element);
		notifyObservers();
	}

	@Override
	public List<OPElementView> getViewElements() {
		return Collections.unmodifiableList(elements);
	}

}

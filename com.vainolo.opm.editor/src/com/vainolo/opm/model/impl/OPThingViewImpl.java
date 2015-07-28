package com.vainolo.opm.model.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPThingView;

public class OPThingViewImpl extends OPNodeViewImpl implements OPThingView {
	List<OPNodeView> nodes = Lists.newArrayList();

	public OPThingViewImpl(int id) {
		super(id);
	}

	@Override
	public void addNode(OPNodeView node) {
		nodes.add(node);
		notifyObservers();
	}

	@Override
	public void removeNode(OPNodeView node) {
		nodes.remove(node);
		notifyObservers();
	}

	@Override
	public List<OPNodeView> getNodes() {
		return Collections.unmodifiableList(nodes);
	}

}

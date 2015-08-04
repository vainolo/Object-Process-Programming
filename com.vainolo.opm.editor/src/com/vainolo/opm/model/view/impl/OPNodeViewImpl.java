package com.vainolo.opm.model.view.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;

public abstract class OPNodeViewImpl extends OPAbstractElementViewImpl implements OPNodeView {
	private int[] constraints = new int[4];
	
	private OPNode model;
	private List<OPLinkView> links = new ArrayList<OPLinkView>();

	public OPNodeViewImpl(int id) {
		super(id);
	}

	@Override
	public OPNode getModel() {
		return model;
	}

	@Override
	public void setModel(OPNode model) {
		this.model = model;
		if(!this.equals(model.getView()))
			model.setView(this);
		notifyObservers();
	}

	@Override
	public Collection<OPLinkView> getLinks() {
		return Collections.unmodifiableList(links);
	}

	@Override
	public void addLink(OPLinkView link) {
		links.add(link);
		notifyObservers();
	}

	@Override
	public void removeLink(OPLinkView link) {
		links.remove(link);
		notifyObservers();
	}

	@Override
	public int[] getConstraints() {
		return Arrays.copyOf(constraints, 4);
	}

	@Override
	public void setConstraints(int x, int y, int width, int height) {
		constraints[0] = x;
		constraints[1] = y;
		constraints[2] = width;
		constraints[3] = height;
		notifyObservers();
	}

	@Override
	public void setConstraints(int[] constraints) {
		setConstraints(constraints[0], constraints[1], constraints[2], constraints[3]);
	}
}

package com.vainolo.opm.model.impl;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPRectangle;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPNodeViewContainer;

public class OPNodeViewImpl extends OPAbstractModelBase implements OPNodeView {

	private OPRectangle constraints;
	private OPNode model;
	private List<OPLinkView> links = new ArrayList<OPLinkView>();
	private OPNodeViewContainer container;

	public OPNodeViewImpl(int id) {
		super(id);
		constraints = OPModelFactory.createOPRectangle();
	}

	@Override
	public OPRectangle getConstraints() {
		return constraints;
	}

	@Override
	public void setConstraints(OPRectangle constraints) {
		this.constraints = constraints;
		notifyObservers();
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
	public OPNodeViewContainer getContainer() {
		return container;
	}

	@Override
	public void setContainer(OPNodeViewContainer container) {
		this.container = container;
		notifyObservers();
	}
}

package com.vainolo.opm.model.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPThingView;

public class OPObjectProcessDiagramImpl extends OPAbstractModelBase implements
		OPObjectProcessDiagram {
	private List<OPNodeView> nodes = Lists.newArrayList();
	private List<OPLinkView> links = Lists.newArrayList();
	private boolean inzoomed = false;
	private OPThingView inzoomedThing;
	private boolean unfolded = false;
	private OPThingView unfoldedThing;

	public OPObjectProcessDiagramImpl(int id) {
		super(id);
	}

	@Override
	public boolean isInzoomed() {
		return inzoomed;
	}

	@Override
	public void setInzoomed(boolean inzoomed) {
		this.inzoomed = inzoomed;
	}

	@Override
	public OPThingView getInzoomedThing() {
		return inzoomedThing;
	}

	@Override
	public void setInzoomedThing(OPThingView inzoomedThing) {
		this.inzoomedThing = inzoomedThing;
	}
	
	@Override
	public boolean isUnfolded() {
		return unfolded;
	}

	@Override
	public void setUnfolded(boolean unfolded) {
		this.unfolded = unfolded;
	}

	@Override
	public OPThingView getUnfoldedThing() {
		return unfoldedThing;
	}

	@Override
	public void setUnfoldedThing(OPThingView unfoldedThing) {
		this.unfoldedThing = unfoldedThing;
	}
	
	@Override
	public void removeNode(OPNodeView node) {
		nodes.remove(node);
		notifyObservers();
	}

	@Override
	public void addNode(OPNodeView node) {
		nodes.add(node);
		notifyObservers();
	}

	@Override
	public List<OPNodeView> getNodes() {
		return Collections.unmodifiableList(nodes);
	}

	@Override
	public void addLinkView(OPLinkView link) {
		links.add(link);
		notifyObservers();
	}

	@Override
	public void removeLinkView(OPLinkView link) {
		links.remove(link);
		notifyObservers();
	}

	@Override
	public List<OPLinkView> getLinks() {
		return Collections.unmodifiableList(links);
	}

}

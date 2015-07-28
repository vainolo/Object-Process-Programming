package com.vainolo.opm.model.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;
import com.vainolo.opm.model.view.OPThingView;

public class OPObjectProcessDiagramImpl extends OPAbstractElement implements
		OPObjectProcessDiagram {
	private List<OPNodeView> nodes = Lists.newArrayList();
	private List<OPElementView> elements = Lists.newArrayList();
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

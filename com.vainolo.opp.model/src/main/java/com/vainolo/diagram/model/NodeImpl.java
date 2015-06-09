package com.vainolo.diagram.model;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class NodeImpl extends AbstractNamedModelElement implements Node {

	List<Link> incomingLinks = Lists.newArrayList();
	List<Link> outgoingLinks = Lists.newArrayList();
	
	@Override
	public List<Link> getIncomingLinks() {
		return Collections.unmodifiableList(incomingLinks);
	}

	@Override
	public List<Link> getOutgoingLinks() {
		return Collections.unmodifiableList(outgoingLinks);
	}

	@Override
	public void addIncomingLink(Link link) {
		incomingLinks.add(link);
		getNotifier().notifyObservers();
	}

	@Override
	public void removeIncomingLink(Link link) {
		incomingLinks.remove(link);
		getNotifier().notifyObservers();
	}

	@Override
	public void addOutgoingLink(Link link) {
		outgoingLinks.add(link);
		getNotifier().notifyObservers();
	}

	@Override
	public void removeOutgoingLink(Link link) {
		outgoingLinks.remove(link);
		getNotifier().notifyObservers();
	}
	
}

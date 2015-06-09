package com.vainolo.diagram.model;

import java.util.List;

public interface Node extends ModelElement, NamedModelElement {
	List<Link> getIncomingLinks();
	List<Link> getOutgoingLinks();
	void addIncomingLink(Link link);
	void removeIncomingLink(Link link);
	void addOutgoingLink(Link link);
	void removeOutgoingLink(Link link);
}

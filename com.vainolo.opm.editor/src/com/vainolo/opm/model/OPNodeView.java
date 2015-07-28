package com.vainolo.opm.model;

import java.util.Collection;

public interface OPNodeView extends OPModelBase {
	OPRectangle getConstraints();
	void setConstraints(OPRectangle constraints);
	
	OPNode getModel();
	void setModel(OPNode node);
	
	Collection<OPLinkView> getLinks();
	void addLink(OPLinkView link);
	void removeLink(OPLinkView link);
	
	OPNodeViewContainer getContainer();
	void setContainer(OPNodeViewContainer container);
}

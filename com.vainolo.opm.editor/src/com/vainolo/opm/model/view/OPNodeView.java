package com.vainolo.opm.model.view;

import java.util.Collection;
import com.vainolo.opm.model.OPNode;

public interface OPNodeView extends OPElementView {
	int[] getConstraints();
	void setConstraints(int[] constraints);
	void setConstraints(int x, int y, int width, int height);
	
	OPNode getModel();
	void setModel(OPNode node);
	
	Collection<OPLinkView> getLinks();
	void addLink(OPLinkView link);
	void removeLink(OPLinkView link);
}

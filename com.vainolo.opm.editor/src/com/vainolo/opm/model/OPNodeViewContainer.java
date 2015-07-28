package com.vainolo.opm.model;

import java.util.List;

public interface OPNodeViewContainer extends OPModelBase {
	void removeNode(OPNodeView node);
	void addNode(OPNodeView node);
	List<OPNodeView> getNodes();
}

package com.vainolo.opm.model;

import java.util.List;

public interface OPContainer {
	List<OPNode> getNodes();
	void removeNode(OPNode node);
	void addNode(OPNode node);
}

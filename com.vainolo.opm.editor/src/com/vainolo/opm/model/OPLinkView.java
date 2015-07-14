package com.vainolo.opm.model;

public interface OPLinkView extends OPModelBase {
	OPLink getModel();
	void setModel(OPLink link);
	
	OPNodeView getSource();
	void setSource(OPNodeView nodeView);
	
	OPNodeView getTarget();
	void setTarget(OPNodeView nodeView);
}

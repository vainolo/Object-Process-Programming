package com.vainolo.opm.model.view;

import com.vainolo.opm.model.OPLink;

public interface OPLinkView extends OPElementView {
	OPLink getModel();
	void setModel(OPLink link);
	
	OPNodeView getSource();
	void setSource(OPNodeView nodeView);
	
	OPNodeView getTarget();
	void setTarget(OPNodeView nodeView);
}

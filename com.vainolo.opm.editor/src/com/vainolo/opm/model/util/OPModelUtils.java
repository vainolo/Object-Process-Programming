package com.vainolo.opm.model.util;

import com.vainolo.opm.model.OPNodeView;
import com.vainolo.opm.model.OPNodeViewContainer;
import com.vainolo.opm.model.OPObjectProcessDiagram;

public class OPModelUtils {
	public static OPObjectProcessDiagram getObjectProcessDiagram(OPNodeView node) {
		OPNodeViewContainer container = node.getContainer();
		while(!OPObjectProcessDiagram.class.isInstance(container))
			container = ((OPNodeView)container).getContainer();
		return (OPObjectProcessDiagram) container;
	}
	
}

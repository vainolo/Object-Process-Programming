package com.vainolo.opm.model.util;

import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.view.OPElementView;
import com.vainolo.opm.model.view.OPElementViewContainer;

public class OPModelUtils {
	public static OPObjectProcessDiagram getObjectProcessDiagram(OPElementView element) {
		OPElementViewContainer container = element.getElementViewContainer();
		while(!OPObjectProcessDiagram.class.isInstance(container))
			container = ((OPElementView)container).getElementViewContainer();
		return (OPObjectProcessDiagram) container;
	}
	
}

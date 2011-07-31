package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

import com.vainolo.phd.opm.gef.editor.figure.OPMObjectFigure;
import com.vainolo.phd.opm.model.NodeContainer;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMState;

public class OPMObjectEditPart extends OPMThingEditPart {

    private boolean set = false;
    
	@Override protected IFigure createFigure() {
		return new OPMObjectFigure();
	}
	
	@Override protected List getModelChildren() {
	    return ((NodeContainer)getModel()).getNodes();
	}
}

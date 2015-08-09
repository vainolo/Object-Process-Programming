package com.vainolo.opm.editor.part;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.opm.editor.figure.OPMNodeFigure;
import com.vainolo.opm.editor.policy.OPProceduralLinkConnectionEditPolicy;
import com.vainolo.opm.editor.policy.OPNodeDeleteEditPolicy;
import com.vainolo.opm.editor.policy.OPStructuralLinkConnectionEditPolicy;
import com.vainolo.opm.model.opm.OPElement;
import com.vainolo.opm.model.opm.OPLinkView;
import com.vainolo.opm.model.opm.OPNodeView;


public abstract class OPNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart{

	OPElementAdapterForEditPart adapter = new OPElementAdapterForEditPart(this);
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(UUID.randomUUID().toString(), new OPProceduralLinkConnectionEditPolicy());
		installEditPolicy(UUID.randomUUID().toString(), new OPNodeDeleteEditPolicy());
		installEditPolicy(UUID.randomUUID().toString(), new OPStructuralLinkConnectionEditPolicy());
	}

	@Override
	protected List<OPLinkView> getModelSourceConnections() {
		OPNodeView model = (OPNodeView) getModel();
		return Collections.unmodifiableList(model.getOutgoingLinks());
	}
	
	@Override
	protected List<OPLinkView> getModelTargetConnections() {
		OPNodeView model = (OPNodeView) getModel();
		return Collections.unmodifiableList(model.getIncomingLinks());
	}
	
	
	@Override
	public void activate() {
		if(!isActive())
			((OPElement) getModel()).eAdapters().add(adapter);
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive())
			((OPElement) getModel()).eAdapters().remove(adapter);
		super.deactivate();
	}
	
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((OPMNodeFigure)getFigure()).getSourceConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((OPMNodeFigure)getFigure()).getTargetConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((OPMNodeFigure)getFigure()).getSourceConnectionAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((OPMNodeFigure)getFigure()).getTargetConnectionAnchor();
	}	
}

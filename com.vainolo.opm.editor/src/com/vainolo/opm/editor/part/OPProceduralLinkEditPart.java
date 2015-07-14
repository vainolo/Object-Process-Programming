package com.vainolo.opm.editor.part;

import java.util.UUID;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import com.vainolo.opm.editor.figure.OPProceduralLinkFigure;
import com.vainolo.opm.editor.policy.OPProceduralLinkDeleteEditPolicy;
import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPModelBase;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPProceduralLink;
import com.vainolo.opm.model.OPProceduralLinkKind;
;

public class OPProceduralLinkEditPart extends AbstractConnectionEditPart implements OPModelObserver {

	@Override
	protected IFigure createFigure() {
		OPLinkView viewModel = (OPLinkView) getModel();
		OPProceduralLink model = (OPProceduralLink) viewModel.getModel();
		return new OPProceduralLinkFigure(model.getKind());
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(UUID.randomUUID().toString(), new OPProceduralLinkDeleteEditPolicy());
		installEditPolicy(UUID.randomUUID().toString(), new ConnectionEndpointEditPolicy());
		
	}
	
	@Override
	public void activate() {
		if(!isActive())
			((OPModelBase) getModel()).addObserver(this);
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive())
			((OPModelBase) getModel()).removeObserver(this);
		super.deactivate();
	}
	
	@Override
	public void acceptNotification(OPModelBase notifier) {
		refresh();
	}
	
}

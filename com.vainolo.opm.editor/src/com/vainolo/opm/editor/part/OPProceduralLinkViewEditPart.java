package com.vainolo.opm.editor.part;

import java.util.UUID;





import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import com.vainolo.opm.editor.figure.OPProceduralLinkFigure;
import com.vainolo.opm.editor.policy.OPProceduralLinkDeleteEditPolicy;
import com.vainolo.opm.model.opm.OPElement;
import com.vainolo.opm.model.opm.OPLinkView;
import com.vainolo.opm.model.opm.OPProceduralLink;
;

public class OPProceduralLinkViewEditPart extends AbstractConnectionEditPart {

	private OPElementAdapterForEditPart adapter = new OPElementAdapterForEditPart(this);
	
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
			((OPElement) getModel()).eAdapters().add(adapter);
		super.activate();
	}
	
	@Override
	public void deactivate() {
		if(isActive())
			((OPElement) getModel()).eAdapters().remove(adapter);
		super.deactivate();
	}
}

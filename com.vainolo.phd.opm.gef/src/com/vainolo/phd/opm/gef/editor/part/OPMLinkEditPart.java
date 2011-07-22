package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import com.vainolo.phd.opm.gef.editor.policy.OPMLinkConnectionEditPolicy;

/**
 * {@link EditPart} for the {@link OPMLink} model element.
 * @author vainolo
 */
public class OPMLinkEditPart extends AbstractConnectionEditPart {

	/**
	 * Create and initialize a new {@link OPMLinkEditPart}.
	 */
	public OPMLinkEditPart() {
		super();
	}
	
	/**
	 * Installs two edit policies:
	 * <ol>
	 *   <li>For the {@link EditPolicy#CONNECTION_ENDPOINTS_ROLE} a {@link ConnectionEndpoinEditPolicy}.</li>
	 *   <li>For the {@link EditPolicy#CONNECTION_ROLE} a {@link OPMLinkConnectionEditPolicy}</li>
	 */
	@Override protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new OPMLinkConnectionEditPolicy());		
	}

	@Override protected IFigure createFigure() {
		PolylineConnection conn = new PolylineConnection();
		return conn; 
	}
}

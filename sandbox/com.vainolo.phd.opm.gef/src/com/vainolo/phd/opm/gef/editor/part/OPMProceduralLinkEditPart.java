package com.vainolo.phd.opm.gef.editor.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import com.vainolo.phd.opm.gef.editor.policy.OPMProceduralLinkBendpointEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMProceduralLinkConnectionEditPolicy;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMPackage;

public abstract class OPMProceduralLinkEditPart extends AbstractConnectionEditPart {

	/**
	 * Used when the link is a loop. Defines the distance from the figure to
	 * the bendpoints of the loop link.
	 */
	private static final int LOOP_SPACE = 10;
	
	private OPMProceduralLinkAdapter adapter;
	
	public OPMProceduralLinkEditPart() {
		super();
		adapter = new OPMProceduralLinkAdapter();
	}
	
	@Override protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new OPMProceduralLinkBendpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new OPMProceduralLinkConnectionEditPolicy());
		//TODO check that the CONNECTION_ROLE can be converted to a COMPONENT_ROLE
	}

	/**
	 * Creates a bendable polyline connection.
	 */
	@Override protected PolylineConnection createFigure() {
		PolylineConnection conn = new PolylineConnection();
        conn.setConnectionRouter(new BendpointConnectionRouter());

//		PolygonDecoration decoration = new PolygonDecoration();
//		PointList decorationPointList = new PointList();
//		decorationPointList.addPoint(0,0);
//		decorationPointList.addPoint(-2,2);
//		decorationPointList.addPoint(-4,0);
//		decorationPointList.addPoint(-2,-2);
//		decoration.setTemplate(decorationPointList);
//		CircleDecoration decoration = new CircleDecoration();
//		decoration.setBackgroundColor(ColorConstants.black);
//		conn.setSourceDecoration(decoration);		
//		
//		conn.setTargetDecoration(new PolylineDecoration());
//		
//		ConnectionEndpointLocator targetEndpointLocator = new ConnectionEndpointLocator(conn, false);
//		targetEndpointLocator.setVDistance(15);
//		Label targetMultiplicityLabel = new Label("1..*");
//		conn.add(targetMultiplicityLabel, targetEndpointLocator);	
//		
//		ConnectionLocator midpointLocator = new MidpointLocator(conn, 0);
//		Triangle triangle = new Triangle();
//		triangle.setSize(10, 10);
//		conn.add(triangle, midpointLocator);

		
		return conn;
		
	}

	@Override public void activate() {
		if(!isActive()) {
			((OPMProceduralLink)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
			((OPMProceduralLink)getModel()).eAdapters().remove(adapter);
		}
		super.deactivate();
	}
	
	@Override protected void refreshVisuals() {
		Connection connection = getConnectionFigure();
		List<Point> modelConstraint = ((OPMProceduralLink)getModel()).getBendpoints();
		List<AbsoluteBendpoint> figureConstraint = new ArrayList<AbsoluteBendpoint>();
		for (Point p : modelConstraint) {
			figureConstraint.add(new AbsoluteBendpoint(p));
		}
		connection.setRoutingConstraint(figureConstraint);
	}
	
	public class OPMProceduralLinkAdapter implements Adapter {

		@Override public void notifyChanged(Notification notification) {
			if(OPMPackage.eINSTANCE.getLink_Source().equals(notification.getFeature()) ||
		       OPMPackage.eINSTANCE.getLink_Target().equals(notification.getFeature())) {
				OPMProceduralLink link = (OPMProceduralLink) getModel();
				if(link.getSource() == null || link.getTarget() == null) {
					// do nothing.
				} else if(link.getSource().equals(link.getTarget()) && (link.getBendpoints().size() == 0)) {
					OPMThingEditPart thingPart = (OPMThingEditPart) getSource();
					Rectangle bounds = thingPart.getFigure().getBounds();
					Point p;
					// we add three bendpoints for the loop. After this the used can change/add/remove as he wishes.
					// the link will exit from the right of the figure and enter from the top.
					p = new Point(bounds.x+bounds.width+LOOP_SPACE, bounds.y+LOOP_SPACE);
					link.getBendpoints().add(p);
					p = new Point(bounds.x+bounds.width+LOOP_SPACE, bounds.y-LOOP_SPACE);
					link.getBendpoints().add(p);
					p = new Point(bounds.x+bounds.width-LOOP_SPACE, bounds.y-LOOP_SPACE);
					link.getBendpoints().add(p);
				}
			} else if(OPMPackage.eINSTANCE.getOPMProceduralLink_Bendpoints().equals(notification.getFeature())) {
				OPMProceduralLink link = (OPMProceduralLink)getModel();
				if(link.getSource().equals(link.getTarget()) && link.getBendpoints().size() == 1 && notification.getEventType() == Notification.REMOVE) {
					// Don't let the user destroy the loop by leaving only one bendpoint
					Point p = (Point) notification.getOldValue();
					link.getBendpoints().add(p);
				}
			}
			refreshVisuals();
		}

		@Override public Notifier getTarget() {			
			return (OPMProceduralLink)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(OPMProceduralLink.class);
		}
	}
}

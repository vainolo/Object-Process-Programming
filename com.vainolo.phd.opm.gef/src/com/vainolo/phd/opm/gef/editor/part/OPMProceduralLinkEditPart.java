/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;

import com.vainolo.phd.opm.gef.editor.figure.CircleDecoration;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

/**
 * An extension of a {@link OPMLinkEditPart} used for {@link OPMProceduralLink}
 * instances. It add endpoint decorations to the regular link figure.
 * 
 * @author vainolo
 * 
 */
public class OPMProceduralLinkEditPart extends OPMLinkEditPart {

	private Label targetDecorationLabel;
	private Label sourceDecorationLabel;
	private Label centerDecorationLabel;

	// private final StringBuffer label = new StringBuffer("Hello World");

	/**
	 * Extend the connection created by {@link OPMLinkEditPart#createFigure()}
	 * by adding decorations depending on the link kind. An agent link is
	 * decorated at the target with black filled {@link CircleDecoration}. An
	 * instrument link is decorated at the target with a white filled
	 * {@link CircleDecoration}. A consumption or result link is decorated at
	 * the target with a {@link PolylineDecoration} (which is an arrow). An
	 * effect link link is decorated at the source and target with a
	 * {@link PolylineDecoration}.
	 * 
	 * @return a decorated {@link PolylineConnection} figure.
	 */
	@Override
	protected PolylineConnection createFigure() {
		PolylineConnection connection = super.createFigure();
		OPMProceduralLink model = (OPMProceduralLink) getModel();
		decorateConnection(connection, model.getKind());
		sourceDecorationLabel = new Label();
		centerDecorationLabel = new Label();
		targetDecorationLabel = new Label();
		ConnectionLocator locator = new ConnectionLocator(connection, ConnectionLocator.SOURCE);
		connection.add(sourceDecorationLabel, locator);
		locator = new ConnectionLocator(connection, ConnectionLocator.MIDDLE);
		connection.add(centerDecorationLabel, locator);
		locator = new ConnectionLocator(connection, ConnectionLocator.TARGET);
		connection.add(targetDecorationLabel, locator);

		return connection;
	}

	// @Override
	// protected List getModelChildren() {
	// List retVal = new ArrayList();
	// retVal.add(label);
	// return retVal;
	// }

	@Override
	protected void refreshVisuals() {
		OPMProceduralLink model = (OPMProceduralLink) getModel();
		targetDecorationLabel.setText(model.getTargetDecoration());
		centerDecorationLabel.setText(model.getCenterDecoration());
		sourceDecorationLabel.setText(model.getSourceDecoration());
		// label.delete(0, label.length());
		// label.append(model.getCenterDecoration());
		// for (EditPart child : (List<EditPart>) getChildren()) {
		// child.refresh();
		// }
		super.refreshVisuals();
	}

	/**
	 * Decorate a connection depending on its kind.
	 * 
	 * @param connection
	 *            the {@link PolylineConnection} to decorate.
	 * @param kind
	 *            the {@link OPMProceduralLinkKind} of the model entity.
	 */
	private void decorateConnection(PolylineConnection connection, OPMProceduralLinkKind kind) {
		switch (kind) {
		case AGENT:
			CircleDecoration agentDecoration = new CircleDecoration();
			agentDecoration.setBackgroundColor(ColorConstants.black);
			agentDecoration.setFill(true);
			connection.setTargetDecoration(agentDecoration);
			break;
		case INSTRUMENT:
			CircleDecoration instrumentDecoration = new CircleDecoration();
			instrumentDecoration.setBackgroundColor(ColorConstants.white);
			instrumentDecoration.setFill(true);
			connection.setTargetDecoration(instrumentDecoration);
			break;
		case CONSUMPTION:
		case RESULT:
		case INVOCATION:
			connection.setTargetDecoration(new PolylineDecoration());
			break;

		case EFFECT:
			connection.setSourceDecoration(new PolylineDecoration());
			connection.setTargetDecoration(new PolylineDecoration());
			break;

		default:
			throw new IllegalArgumentException("No case for kind " + kind);
		}
	}
}

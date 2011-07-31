package com.vainolo.phd.opm.gef.editor.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.figure.NodeFigure;
import com.vainolo.phd.opm.gef.editor.policy.NodeComponentEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.NodeNodeEditPolicy;
import com.vainolo.phd.opm.model.Node;

public abstract class NodeEditPart extends AbstractGraphicalEditPart implements org.eclipse.gef.NodeEditPart {
    
    @SuppressWarnings("rawtypes") @Override protected List getModelSourceConnections() {
        Node node = (Node) getModel();
        return Collections.unmodifiableList(node.getOutgoingLinks());
    }
    
    @SuppressWarnings("rawtypes") @Override protected List getModelTargetConnections() {
        Node node = (Node) getModel();
        return Collections.unmodifiableList(node.getIncomingLinks());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
        return ((NodeFigure)getFigure()).getSourceConnectionAnchor();
    }

    /**
     * {@inheritDoc}
     */
    @Override public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
        return ((NodeFigure)getFigure()).getTargetConnectionAnchor();
    }

    /**
     * {@inheritDoc}
     */
    @Override public ConnectionAnchor getSourceConnectionAnchor(Request request) {
        return ((NodeFigure)getFigure()).getSourceConnectionAnchor();
    }

    /**
     * {@inheritDoc}
     */
    @Override public ConnectionAnchor getTargetConnectionAnchor(Request request) {
        return ((NodeFigure)getFigure()).getTargetConnectionAnchor();
    }   
    
    @Override protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new NodeComponentEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new NodeNodeEditPolicy());
    }
}

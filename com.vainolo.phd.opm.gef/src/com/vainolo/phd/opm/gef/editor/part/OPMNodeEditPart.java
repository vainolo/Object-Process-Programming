package com.vainolo.phd.opm.gef.editor.part;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.vainolo.phd.opm.gef.editor.policy.OPMNodeComponentEditPolicy;
import com.vainolo.phd.opm.gef.editor.policy.OPMNodeGraphicalNodeEditPolicy;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMThing;

public abstract class OPMNodeEditPart extends AbstractGraphicalEditPart {

    public class OPMNodeAdapter implements Adapter {
    
    	// Adapter interface
    	@Override public void notifyChanged(Notification notification) {
    		refreshVisuals();
    		refreshSourceConnections();
    		refreshTargetConnections();
    	}
    
    	@Override public Notifier getTarget() {
    		return (OPMNode)getModel();
    	}
    
    	@Override public void setTarget(Notifier newTarget) {
    		// Do nothing.
    	}
    
    	@Override public boolean isAdapterForType(Object type) {
    		return type.equals(OPMNode.class);
    	}
    }

    protected OPMNodeAdapter adapter;

    public OPMNodeEditPart() {
        super();
        adapter = new OPMNodeAdapter();
    }

    @Override
    protected List<OPMLink> getModelSourceConnections() {
    	OPMNode model = (OPMNode)getModel();
    	return model.getOutgoingLinks();
    }

    @Override
    protected List<OPMLink> getModelTargetConnections() {
    	OPMNode model = (OPMNode)getModel();
    	return model.getIncomingLinks();
    }

    @Override
    public void activate() {
        if(!isActive()) {
            ((OPMNode)getModel()).eAdapters().add(adapter);
        }
        super.activate();
    }

    @Override
    public void deactivate() {
        if(isActive()) {
            ((OPMNode)getModel()).eAdapters().remove(adapter);
        }
    
        super.deactivate();
    }

    /**
     * Install edit policies that can be applied to {@link OPMNodeEditPart} instances.
     */
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new OPMNodeComponentEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new OPMNodeGraphicalNodeEditPolicy());
    }

}
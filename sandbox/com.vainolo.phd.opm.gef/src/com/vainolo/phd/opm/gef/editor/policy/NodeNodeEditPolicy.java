package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import com.vainolo.phd.opm.gef.editor.command.LinkCreateCommand;
import com.vainolo.phd.opm.gef.editor.command.NodeCreateCommand;
import com.vainolo.phd.opm.gef.editor.part.NodeEditPart;
import com.vainolo.phd.opm.model.Link;
import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMStructuralLink;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMThing;

public class NodeNodeEditPolicy extends GraphicalNodeEditPolicy {

	@Override protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
	    if(request.getSourceEditPart() instanceof OPMStructuralLinkAggregator) {
	        return UnexecutableCommand.INSTANCE;
	    }
	    
		if(request.getNewObject() instanceof OPMProceduralLink) {
			LinkCreateCommand command = new LinkCreateCommand();
			command.setSource((OPMThing)getHost().getModel());
			command.setLink((OPMProceduralLink) request.getNewObject());
			command.setOPD((OPMObjectProcessDiagram)((OPMThing)getHost().getModel()).getParent());
			request.setStartCommand(command);
			return command;
		} else if(request.getNewObject() instanceof OPMStructuralLinkAggregator) {
			return UnexecutableCommand.INSTANCE;
		}
		
		return UnexecutableCommand.INSTANCE;
	}
	
	@Override protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
	    if(request.getTargetEditPart() instanceof OPMStructuralLinkAggregator)
	        return UnexecutableCommand.INSTANCE;
	    
		if(request.getNewObject() instanceof OPMProceduralLink) {
			LinkCreateCommand command = (LinkCreateCommand) request.getStartCommand();
			command.setTarget((OPMThing)getHost().getModel());
			return command;
		} else if(request.getNewObject() instanceof OPMStructuralLinkAggregator) {
		    Node source = (Node) ((NodeEditPart) request.getSourceEditPart()).getModel();
		    Node target = (Node) ((NodeEditPart) request.getTargetEditPart()).getModel();
		    
		    // If there is already an aggregator connected to the source node, we only add
		    // a new link from the aggregator to the target node.
		    for(Link link: source.getOutgoingLinks()) {
		        if(link.getTarget() instanceof OPMStructuralLinkAggregator) {
		            // must only add new link between agregator and new target.
		            Node aggregator = link.getTarget();
		            LinkCreateCommand targetLinkCreateCommand = new LinkCreateCommand();
		            targetLinkCreateCommand.setSource(aggregator);
		            targetLinkCreateCommand.setTarget(target);
		            targetLinkCreateCommand.setLink(OPMFactory.eINSTANCE.createOPMStructuralLink());
		            targetLinkCreateCommand.setOPD((OPMObjectProcessDiagram)aggregator.getParent());
		            return targetLinkCreateCommand;
		        }
		    }

		    // There is currently no aggregator connected to the source node, add a new
		    // one and also links from source to aggregator and from aggregator to target.
		    return buildCreateStructuralLinkAggregatorAndLinksCommand(request);
		}
		
		return UnexecutableCommand.INSTANCE;
	}

    /**
     * Build a {@link CompoundCommand} that is composed of a {@link NodeCreateCommand} used
     * to create a {@link OPMStructuralLinkAggregator}, and two {@link LinkCreateCommand} to create source and
     * target {@link OPMStructuralLink}.
     * @param request the request to connect two nodes in a structural relation.
     * @return a {@link CompoundCommand} consisting of a {@link NodeCreateCommand} and two {@link LinkCreateCommand}.
     */
    private Command buildCreateStructuralLinkAggregatorAndLinksCommand(CreateConnectionRequest request) {
        Rectangle sourceBounds = ((NodeEditPart)request.getSourceEditPart()).getFigure().getBounds().getCopy();
        Rectangle targetBounds = ((NodeEditPart)request.getTargetEditPart()).getFigure().getBounds().getCopy();
        request.getTargetEditPart();
        NodeCreateCommand createNodeCommand = new NodeCreateCommand();
        createNodeCommand.setNode((Node) request.getNewObject());
        createNodeCommand.setLocation(new Point(sourceBounds.x+(targetBounds.x-sourceBounds.x)/2, sourceBounds.y+(targetBounds.y-sourceBounds.y)/2));
        createNodeCommand.setParent((OPMObjectProcessDiagram)((Node)request.getSourceEditPart().getModel()).getParent());
        
        LinkCreateCommand sourceLinkCreateCommand = new LinkCreateCommand();
        sourceLinkCreateCommand.setOPD((OPMObjectProcessDiagram)((Node)request.getSourceEditPart().getModel()).getParent());
        sourceLinkCreateCommand.setLink(OPMFactory.eINSTANCE.createOPMStructuralLink());
        sourceLinkCreateCommand.setSource((Node) request.getSourceEditPart().getModel());
        sourceLinkCreateCommand.setTarget((Node) request.getNewObject());
        
        LinkCreateCommand targetLinkCreateCommand = new LinkCreateCommand();
        targetLinkCreateCommand.setOPD((OPMObjectProcessDiagram)((Node)request.getSourceEditPart().getModel()).getParent());
        targetLinkCreateCommand.setLink(OPMFactory.eINSTANCE.createOPMStructuralLink());
        targetLinkCreateCommand.setSource((Node) request.getNewObject());
        targetLinkCreateCommand.setTarget((Node) request.getTargetEditPart().getModel());

        CompoundCommand compoundCommand = new CompoundCommand();
        compoundCommand.add(createNodeCommand);
        compoundCommand.add(sourceLinkCreateCommand);
        compoundCommand.add(targetLinkCreateCommand);
        
        return compoundCommand;
    }

	@Override protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}
	
}

package com.vainolo.phd.opm.gef.editor.policy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opm.gef.editor.command.NodeDeleteCommand;
import com.vainolo.phd.opm.model.Link;
import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;

/**
 * Policy that is used when a request to delete a node is received.
 * @author vainolo
 *
 */
public class NodeComponentEditPolicy extends ComponentEditPolicy {

    /**
     * Create a node delete command.
     * @param deleteRequest received delete request.
     * @return the command used to delete the thing.
     */
	@Override protected Command createDeleteCommand(final GroupRequest deleteRequest) {
        CompoundCommand compoundCommand = new CompoundCommand();

        NodeDeleteCommand nodeDeleteCommand = new NodeDeleteCommand();
		nodeDeleteCommand.setNode((Node) getHost().getModel());
		compoundCommand.add(nodeDeleteCommand);
		
		for(OPMStructuralLinkAggregator aggregator:getOutgoingDeletableStructuralLinkAggregators()) {
		    nodeDeleteCommand = new NodeDeleteCommand();
		    nodeDeleteCommand.setNode(aggregator);
		    compoundCommand.add(nodeDeleteCommand);
		}
		
        for(OPMStructuralLinkAggregator aggregator:getIncomingDeletableStructuralLinkAggregators()) {
            nodeDeleteCommand = new NodeDeleteCommand();
            nodeDeleteCommand.setNode(aggregator);
            compoundCommand.add(nodeDeleteCommand);
        }

        return compoundCommand;
	}
	
	/**
	 * Fetch all the {@link OPMStructuralLinkAggregator} instances who's source
	 * is the current node. They must be deleted when the node is deleted.
	 * @return all the {@link OPMStructuralLinkAggregator} instances who's
	 * source is the current node.
	 */
	private List<OPMStructuralLinkAggregator> getOutgoingDeletableStructuralLinkAggregators() {
	    List<OPMStructuralLinkAggregator> outgoingAggregators = new ArrayList<OPMStructuralLinkAggregator>();
	    Node node = (Node) getHost().getModel();
	    for(Link link : node.getOutgoingLinks()) {
	        if(link.getTarget() instanceof OPMStructuralLinkAggregator) {
	            outgoingAggregators.add((OPMStructuralLinkAggregator) link.getTarget());
	        }
	    }
	    
	    return outgoingAggregators;
	}
	
	/**
	 * Fetch all the {@link OPMStructuralLinkAggregator} instances who's target
	 * is the current node and which have no other connecting nodes. They
	 * must be deleted when the node is deleted.
	 * @return all the {@link OPMStructuralLinkAggregator} instances who's
	 * target is the current node and have no other target.
	 */
	private List<OPMStructuralLinkAggregator> getIncomingDeletableStructuralLinkAggregators() {
	    List<OPMStructuralLinkAggregator> incomingAggregators = new ArrayList<OPMStructuralLinkAggregator>();
	    Node node = (Node) getHost().getModel();
	    for(Link link : node.getIncomingLinks()) {
	        if(link.getSource() instanceof OPMStructuralLinkAggregator) {
	            if(link.getSource().getOutgoingLinks().size() == 1) {
	                incomingAggregators.add((OPMStructuralLinkAggregator) link.getSource());
	            }
	        }
	    }
	    return incomingAggregators;
	}
	
}

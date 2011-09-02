package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.vainolo.phd.opm.gef.editor.command.OPMNodeDeleteCommand;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMThing;

/**
 * {@link EditPolicy} used for delete requests.
 * 
 * @author vainolo
 */
public class OPMNodeComponentEditPolicy extends ComponentEditPolicy {

    /**
     * Create a command to delete a node. When a node is deleted all incoming
     * and outgoing links are also deleted (functionality provided by the
     * command). When a {@link OPMThing} node is deleted, there is special
     * treatment for structural links that start and end at this node. If this
     * node is source for a structural link, the
     * {@link OPMStructuralLinkAggregator} of this link must be deleted. Also if
     * this node is the target of the only outgoing link of a
     * {@link OPMStructuralLinkAggregator}, the aggregator must be deleted.
     * 
     * @return a command that deletes a node and all other required diagram
     *         entities.
     */
    @Override
    protected Command createDeleteCommand(GroupRequest deleteRequest) {
        OPMNode nodeToDelete = (OPMNode) getHost().getModel();
        CompoundCommand compoundCommand;
        compoundCommand = createRecursiveDeleteNodeCommand(nodeToDelete);

        return compoundCommand;
    }
    
    /**
     * This function creates a command that consists of all the commands
     * required to delete the given node and all of the nodes contained inside it.
     * This function is called recursively when a node is a container and has internal nodes.
     * @param nodeToDelete the node that will be deleted.
     * @return a {@link CompoundCommand} command that deletes the node, the contained nodes
     * and all links that must be deleted. 
     */
    private CompoundCommand createRecursiveDeleteNodeCommand(OPMNode nodeToDelete) {
        CompoundCommand compoundCommand = new CompoundCommand();
        
        // For every outgoing structural link, create a command to delete the aggregator
        // node at the end of the link.
        for(OPMLink outgoingStructuralLink : nodeToDelete.getOutgoingStructuralLinks()) {
            OPMNode aggregatorNode = outgoingStructuralLink.getTarget();
            OPMNodeDeleteCommand aggregatorNodeDeleteCommand = new OPMNodeDeleteCommand();
            aggregatorNodeDeleteCommand.setNode(aggregatorNode);
            compoundCommand.add(aggregatorNodeDeleteCommand);
        }
        // For every incoming structural link whose aggregator has only one outgoing
        // link, create a command to delete the aggregator.
        for(OPMLink incomingStructuralLink : nodeToDelete.getIncomingStructuralLinks()) {
            OPMNode aggregatorNode = incomingStructuralLink.getSource();
            if(aggregatorNode.getOutgoingLinks().size() == 1) {
                OPMNodeDeleteCommand aggregatorNodeDeleteCommand = new OPMNodeDeleteCommand();
                aggregatorNodeDeleteCommand.setNode(aggregatorNode);
                compoundCommand.add(aggregatorNodeDeleteCommand);
            }
        }
        
        for(OPMNode node : nodeToDelete.getNodes()) {
            Command containedNodeDelete = createRecursiveDeleteNodeCommand(node);
            compoundCommand.add(containedNodeDelete);
        }

        // Create a command to delete the node.
        OPMNodeDeleteCommand nodeDeleteCommand = new OPMNodeDeleteCommand();
        nodeDeleteCommand.setNode(nodeToDelete);
        compoundCommand.add(nodeDeleteCommand);

        return compoundCommand;
    }
}

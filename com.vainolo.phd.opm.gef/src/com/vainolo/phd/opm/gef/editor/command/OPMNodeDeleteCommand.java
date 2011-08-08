package com.vainolo.phd.opm.gef.editor.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

/**
 * Command used to delete a node.
 * The functionality of this class fairly closed so it is declared final. 
 * @author vainolo
 *
 */
public final class OPMNodeDeleteCommand extends Command {
	
    /** Node to be deleted. */
	private OPMNode node;
	/** OPD that owns the node. */
	private OPMObjectProcessDiagram opd;
	/** Incoming and outgoing links. */
	private List<OPMLink> links;
	/** Sources for the links that start or end at this node. */
	private Map<OPMLink, OPMNode> linkSources;
	/** Targets for the links that start or end at this node. */ 
	private Map<OPMLink, OPMNode> linkTargets;

	@Override
	public void execute() {
		detachLinks();
		node.setOpd(null);
	}

	@Override
	public void undo() {
		reattachLinks();
		node.setOpd(opd);
	}

	/**
	 * Detach all links from the node and from the other
	 * connecting node, storing the connection information in local
	 * data structures.
	 */
	private void detachLinks() {
		links = new ArrayList<OPMLink>();
		linkSources = new HashMap<OPMLink, OPMNode>();
		linkTargets = new HashMap<OPMLink, OPMNode>();
		links.addAll(node.getIncomingLinks());
		links.addAll(node.getOutgoingLinks());
		for (OPMLink link : links) {
			linkSources.put(link, link.getSource());
			linkTargets.put(link, link.getTarget());
			link.setSource(null);
			link.setTarget(null);
			link.setOpd(null);
		}
	}

	/**
	 * Reattach all links to their source and target node.
	 */
	private void reattachLinks() {
		for (OPMLink link : links) {
			link.setSource(linkSources.get(link));
			link.setTarget(linkTargets.get(link));
			link.setOpd(opd);
		}
	}
	
	/**
	 * Set the node to delete from the diagram.
	 * @param node the Node to delete from the diagram.
	 */
	public void setNode(final OPMNode node) {
		this.node = node;
		this.opd = node.getOpd();
	}
}

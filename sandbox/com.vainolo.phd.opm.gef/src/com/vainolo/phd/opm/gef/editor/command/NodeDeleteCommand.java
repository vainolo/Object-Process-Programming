package com.vainolo.phd.opm.gef.editor.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.Link;
import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

/**
 * Command used to delete a node.
 * The functionality of this class fairly closed so it is declared final. 
 * @author vainolo
 *
 */
public final class NodeDeleteCommand extends Command {
	
    /** Node to be deleted. */
	private Node node;
	/** OPD that owns the node. */
	private OPMObjectProcessDiagram opd;
	/** Incoming and outgoing links. */
	private List<Link> links;
	/** Sources for the links that start or end at this node. */
	private Map<Link, Node> linkSources;
	/** Targets for the links that start or end at this node. */ 
	private Map<Link, Node> linkTargets;
	
	/**
	 * Detach links and remove node from container.
	 */
	@Override public void execute() {
		detachLinks();
		node.setParent(null);
	}

	/**
	 * Reattach links and add node to container.
	 */
	@Override public void undo() {
		reattachlinks();
		node.setParent(opd);
	}

	/**
	 * Detach all links from the thing and from the other
	 * connecting thing, storing the connection information in local
	 * data structures.
	 */
	private void detachLinks() {
		links = new ArrayList<Link>();
		linkSources = new HashMap<Link, Node>();
		linkTargets = new HashMap<Link, Node>();
		links.addAll(node.getIncomingLinks());
		links.addAll(node.getOutgoingLinks());
		for (Link link : links) {
			linkSources.put(link, (Node) link.getSource());
			linkTargets.put(link, (Node) link.getTarget());
			link.setSource(null);
			link.setTarget(null);
		}
	}
	
	private void reattachlinks() {
		for (Link link : links) {
			link.setSource(linkSources.get(link));
			link.setTarget(linkTargets.get(link));
		}
	}
	
	public void setNode(final Node node) {
		this.node = node;
		this.opd = (OPMObjectProcessDiagram)node.getParent();
	}
}

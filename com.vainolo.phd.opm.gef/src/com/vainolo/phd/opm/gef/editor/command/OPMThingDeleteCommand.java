package com.vainolo.phd.opm.gef.editor.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMThing;

/**
 * Command used to delete a thing.
 * The functionality of this class fairly closed so it is declared final. 
 * @author vainolo
 *
 */
public final class OPMThingDeleteCommand extends Command {
	
    /** Thing to be deleted. */
	private OPMThing thing;
	/** OPD that owns the thing. */
	private OPMObjectProcessDiagram opd;
	/** Incoming and outgoing links. */
	private List<OPMLink> links;
	/** Sources for the links that start or end at this thing. */
	private Map<OPMLink, OPMNode> linkSources;
	/** Targets for the links that start or end at this thing. */ 
	private Map<OPMLink, OPMNode> linkTargets;

	@Override
	public void execute() {
		detachLinks();
		thing.setOpd(null);
	}

	@Override
	public void undo() {
		reattachLinks();
		thing.setOpd(opd);
	}

	/**
	 * Detach all links from the thing and from the other
	 * connecting thing, storing the connection information in local
	 * data structures.
	 */
	private void detachLinks() {
		links = new ArrayList<OPMLink>();
		linkSources = new HashMap<OPMLink, OPMNode>();
		linkTargets = new HashMap<OPMLink, OPMNode>();
		links.addAll(thing.getIncomingLinks());
		links.addAll(thing.getOutgoingLinks());
		for (OPMLink link : links) {
			linkSources.put(link, link.getSource());
			linkTargets.put(link, link.getTarget());
			link.setSource(null);
			link.setTarget(null);
			link.setOpd(null);
		}
	}

	/**
	 * Reattach all links to their source and target things.
	 */
	private void reattachLinks() {
		for (OPMLink link : links) {
			link.setSource(linkSources.get(link));
			link.setTarget(linkTargets.get(link));
			link.setOpd(opd);
		}
	}
	
	/**
	 * Set the thing to delete from the diagram.
	 * @param thing the Thing to delete from the diagram.
	 */
	public void setThing(OPMThing thing) {
		this.thing = thing;
		this.opd = thing.getOpd();
	}
}

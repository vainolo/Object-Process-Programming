/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

/**
 * Command used to delete a link.
 * 
 * @author vainolo
 */
public class OPMLinkDeleteCommand extends Command {
	/** Link to be deleted. */
	private OPMLink link;
	/** OPD that owns the link. */
	private OPMObjectProcessDiagram opd;
	/** Source of the link. */
	private OPMNode source;
	/** Target of the link. */
	private OPMNode target;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return link != null;
	}

	/**
	 * Disconnect link from source and target things and remove from owner OPD.
	 */
	@Override
	public void execute() {
		opd = link.getOpd();
		source = link.getSource();
		target = link.getTarget();

		link.setSource(null);
		link.setTarget(null);
		link.setOpd(null);
	}

	/**
	 * Reconnect the link to the source and target and add it to the owner OPD.
	 */
	@Override
	public void undo() {
		link.setSource(source);
		link.setTarget(target);
		link.setOpd(opd);
	}

	/**
	 * Set the link that will be delete from the diagram.
	 * 
	 * @param linkParam
	 *            the link to delete from the diagram.
	 */
	public void setLink(final OPMLink linkParam) {
		link = linkParam;
	}
}
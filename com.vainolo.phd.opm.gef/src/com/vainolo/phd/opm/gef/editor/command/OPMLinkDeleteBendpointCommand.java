/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMLink;

/**
 * Command used to delete a bendpoint from a {@link OPMLink} This class is
 * declared final since it has a very specific functionality.
 * 
 * @author vainolo
 */
public final class OPMLinkDeleteBendpointCommand extends Command {

	/** Link that contains the bendpoint. */
	private OPMLink link;
	/** Index where the bendpoint is located in the link's bendpoin list. */
	private int index;
	/** Point in the diagram where the bendpoint is located. */
	private Point location;

	/**
	 * Only execute is link is not null and index is valid.
	 */
	@Override
	public boolean canExecute() {
		return (link != null) && (link.getBendpoints().size() > index);
	}

	/**
	 * Remove the bendpoint from the link.
	 */
	@Override
	public void execute() {
		location = link.getBendpoints().get(index);
		link.getBendpoints().remove(index);
	}

	/**
	 * Reinsert the bendpoint in the link.
	 */
	@Override
	public void undo() {
		link.getBendpoints().add(index, location);
	}

	/**
	 * Set the index of the bendpoint that should be removed.
	 * 
	 * @param index
	 *            the index of the bendpoint to remove.
	 */
	public void setIndex(final int index) {
		this.index = index;
	}

	/**
	 * Set the link from which the bendpoint is removed.
	 * 
	 * @param link
	 *            the link from which the bendpoint is removed.
	 */
	public void setOPMLink(final OPMLink link) {
		this.link = link;
	}
}

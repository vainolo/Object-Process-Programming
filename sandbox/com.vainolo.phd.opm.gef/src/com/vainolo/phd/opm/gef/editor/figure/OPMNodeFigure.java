/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;

import com.vainolo.phd.opm.model.OPMNode;

/**
 * A figure for a {@link OPMNode} in the diagram.
 * 
 * @author vainolo
 * 
 */
public interface OPMNodeFigure extends IFigure {
	/**
	 * Get the anchor used for links who use this figure as their source.
	 * 
	 * @return the anchor for source links.
	 */
	public ConnectionAnchor getSourceConnectionAnchor();

	/**
	 * Get the anchor used for links who use this figure as their target.
	 * 
	 * @return the anchor for target links.
	 */
	public ConnectionAnchor getTargetConnectionAnchor();
}
/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;

/**
 * A figure for a {@link OPMNode} in the diagram.
 * 
 * @author vainolo
 * 
 */
public interface OPPNodeFigure extends IFigure {

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
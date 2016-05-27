/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.*;
import com.vainolo.phd.opp.utilities.analysis.OPPNodeExtensions;

public final class OPPDeleteNodeCommand extends Command {

  private OPPNode node;
  private OPPContainer container;
  private List<OPPLink> links;
  private Map<OPPLink, OPPNode> linkSources;
  private Map<OPPLink, OPPNode> linkTargets;

  @Override
  public void execute() {
    detachLinks();
    node.setContainer(null);
  }

  @Override
  public void undo() {
    reattachLinks();
    node.setContainer(container);
  }

  /**
   * Detach all links from the node and from the other connecting node, storing the connection information in local data
   * structures.
   */
  private void detachLinks() {
    links = new ArrayList<>();
    linkSources = new HashMap<>();
    linkTargets = new HashMap<>();
    links.addAll(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    for (OPPLink link : links) {
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
    for (OPPLink link : links) {
      link.setSource(linkSources.get(link));
      link.setTarget(linkTargets.get(link));
      if (container instanceof OPPObjectProcessDiagram) {
        link.setOpd((OPPObjectProcessDiagram) container);
      } else {
        OPPNode containerNode = (OPPNode) container;
        link.setOpd(OPPNodeExtensions.findOPD(containerNode));
      }

    }
  }

  /**
   * Set the node to delete from the diagram.
   * 
   * @param node
   *          the Node to delete from the diagram.
   */
  public void setNode(final OPPNode node) {
    this.node = node;
    this.container = node.getContainer();
  }

  @Override
  public boolean canExecute() {
    if (node == null)
      return false;
    if (node instanceof OPPThing) {
      OPPThing thing = (OPPThing) node;
      if (thing.isMain())
        return false;
    }
    return true;
  }
}

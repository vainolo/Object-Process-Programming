/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opp.model.*;
import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer;

public final class OPPDeleteNodeCommand extends Command {

  private OPPNode node;
  private OPPContainer container;
  private List<OPPLink> links;
  private Map<OPPLink, OPPNode> linkSources;
  private Map<OPPLink, OPPNode> linkTargets;

  private OPPAnalyzer analyzer = new OPPAnalyzer();

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
   * Detach all links from the node and from the other connecting node, storing
   * the connection information in local data structures.
   */
  private void detachLinks() {
    links = new ArrayList<OPPLink>();
    linkSources = new HashMap<OPPLink, OPPNode>();
    linkTargets = new HashMap<OPPLink, OPPNode>();
    links.addAll(node.getIncomingLinks());
    links.addAll(node.getOutgoingLinks());
    for(OPPLink link : links) {
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
    for(OPPLink link : links) {
      link.setSource(linkSources.get(link));
      link.setTarget(linkTargets.get(link));
      if(container instanceof OPPObjectProcessDiagram) {
        link.setOpd((OPPObjectProcessDiagram) container);
      } else {
        OPPNode containerNode = (OPPNode) container;
        link.setOpd(analyzer.findOPD(containerNode));
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
    if(node == null)
      return false;
    if(node instanceof OPPThing) {
      OPPThing thing = (OPPThing) node;
      if(thing.isMain())
        return false;
    }
    return true;
  }
}

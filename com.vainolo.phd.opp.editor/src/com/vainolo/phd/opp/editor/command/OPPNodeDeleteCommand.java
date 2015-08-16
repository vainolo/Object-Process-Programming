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

import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.utilities.analysis.OPDAnalyzer;

/**
 * Command used to delete a node. The functionality of this class fairly closed
 * so it is declared final.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public final class OPPNodeDeleteCommand extends Command {

  /** Node to be deleted. */
  private OPPNode node;
  /** Container of the node. */
  private OPPContainer container;
  /** Incoming and outgoing links. */
  private List<OPPLink> links;
  /** Sources for the links that start or end at this node. */
  private Map<OPPLink, OPPNode> linkSources;
  /** Targets for the links that start or end at this node. */
  private Map<OPPLink, OPPNode> linkTargets;

  private OPDAnalyzer analyzer = new OPDAnalyzer();

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
}

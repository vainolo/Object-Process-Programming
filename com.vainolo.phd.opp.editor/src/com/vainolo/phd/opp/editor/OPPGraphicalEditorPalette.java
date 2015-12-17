/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;
import org.eclipse.jface.resource.ImageDescriptor;

import com.vainolo.phd.opp.editor.factory.*;
import com.vainolo.phd.opp.editor.tool.OPPCreationAndDirectEditTool;

/**
 * Tool pallete for the {@link OPPGraphicalEditor}.
 */
public class OPPGraphicalEditorPalette extends PaletteRoot {

  PaletteGroup group;

  public OPPGraphicalEditorPalette(OPPIdManager idManager) {
    add(createGeneralPaletteTools());
    add(createNodeTools(idManager));
    add(createProceduralLinkTools(idManager));
    add(createStructuralLinkTools(idManager));

  }

  private PaletteDrawer createGeneralPaletteTools() {
    PaletteDrawer drawer = new PaletteDrawer("General");
    ToolEntry tool = new PanningSelectionToolEntry();
    drawer.add(tool);
    setDefaultEntry(tool);

    PaletteStack marqueeStack = new PaletteStack("Marquee Tools", "", null);

    // NODES CONTAINED (default)
    marqueeStack.add(new MarqueeToolEntry());

    // NODES TOUCHED
    MarqueeToolEntry marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(MarqueeSelectionTool.BEHAVIOR_NODES_TOUCHED));
    marqueeStack.add(marquee);

    // NODES CONTAINED AND RELATED CONNECTIONS
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(MarqueeSelectionTool.BEHAVIOR_NODES_CONTAINED_AND_RELATED_CONNECTIONS));
    marqueeStack.add(marquee);

    // NODES TOUCHED AND RELATED CONNECTIONS
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(MarqueeSelectionTool.BEHAVIOR_NODES_TOUCHED_AND_RELATED_CONNECTIONS));
    marqueeStack.add(marquee);

    // CONNECTIONS CONTAINED
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(MarqueeSelectionTool.BEHAVIOR_CONNECTIONS_CONTAINED));
    marqueeStack.add(marquee);

    // CONNECTIONS TOUCHED
    marquee = new MarqueeToolEntry();
    marquee.setToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR, new Integer(MarqueeSelectionTool.BEHAVIOR_CONNECTIONS_TOUCHED));
    marqueeStack.add(marquee);

    marqueeStack.setUserModificationPermission(PaletteEntry.PERMISSION_NO_MODIFICATION);
    drawer.add(marqueeStack);

    // drawer.add(new CreationToolEntry("Label", "Create new Label", new
    // LabelFactory(), ImageDescriptor.createFromFile(
    // this.getClass(), "icons/label.ico"),
    // ImageDescriptor.createFromFile(this.getClass(), "icons/label.ico")));

    return drawer;
  }

  private PaletteDrawer createNodeTools(OPPIdManager idManager) {
    PaletteDrawer drawer = new PaletteDrawer("Nodes");

    ToolEntry entry = new CombinedTemplateCreationEntry("OPMObject", "Create a new Object", new OPPObjectFactory(idManager), ImageDescriptor.createFromFile(
        this.getClass(), "icons/object.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/object.ico"));
    entry.setToolClass(OPPCreationAndDirectEditTool.class);
    drawer.add(entry);

    entry = new CreationToolEntry("OPMProcess", "Create a new Process", new OPPProcessFactory(idManager), ImageDescriptor.createFromFile(this.getClass(),
        "icons/process.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/process.ico"));
    entry.setToolClass(OPPCreationAndDirectEditTool.class);
    drawer.add(entry);

    entry = new CreationToolEntry("OPMState", "Create a new State", new OPPStateFactory(idManager), ImageDescriptor.createFromFile(this.getClass(),
        "icons/state.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/state.ico"));
    entry.setToolClass(OPPCreationAndDirectEditTool.class);
    drawer.add(entry);

    return drawer;
  }

  private PaletteEntry createProceduralLinkTools(OPPIdManager idManager) {
    PaletteDrawer drawer = new PaletteDrawer("Procedural Links");

    drawer.add(new ConnectionCreationToolEntry("Agent", "Create a new Agent link", new OPPAgentLinkFactory(idManager), ImageDescriptor.createFromFile(
        this.getClass(), "icons/agent.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/agent.ico")));

    drawer.add(new ConnectionCreationToolEntry("Instrument", "Create a new Instrument link", new OPPInstrumentLinkFactory(idManager), ImageDescriptor
        .createFromFile(this.getClass(), "icons/instrument.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/instrument.ico")));

    drawer.add(new ConnectionCreationToolEntry("Data", "Create a new Data link", new OPPConsResLinkFactory(idManager), ImageDescriptor.createFromFile(
        this.getClass(), "icons/consumption.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/consumption.ico")));

    return drawer;
  }

  private PaletteEntry createStructuralLinkTools(OPPIdManager idManager) {
    PaletteDrawer drawer = new PaletteDrawer("Structural Links");
    drawer.add(new ConnectionCreationToolEntry("Aggregation", "Create a new Aggregation link", new OPPAggregationStructuralLinkAggregatorFactory(idManager),
        ImageDescriptor.createFromFile(this.getClass(), "icons/aggregation.ico"), ImageDescriptor.createFromFile(this.getClass(), "icons/aggregation.ico")));

    drawer.add(new ConnectionCreationToolEntry("Generalization", "Create a new Generalization link", new OPPGeneralizationStructuralLinkAggregatorFactory(
        idManager), ImageDescriptor.createFromFile(this.getClass(), "icons/generalization.ico"), ImageDescriptor.createFromFile(this.getClass(),
        "icons/generalization.ico")));

    return drawer;
  }
}

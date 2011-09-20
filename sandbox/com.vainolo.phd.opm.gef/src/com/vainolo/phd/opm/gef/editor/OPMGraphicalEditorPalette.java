package com.vainolo.phd.opm.gef.editor;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;

import com.vainolo.phd.opm.gef.editor.factory.OPMAgentLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMAggregationStructuralLinkAggregatorFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMConsumptionLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMEffectLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMExhibitionStructuralLinkAggregatorFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMGeneralizationStructuralLinkAggregatorFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMInstrumentLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMInvocationLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMObjectFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMProcessFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMResultLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMStateFactory;
import com.vainolo.phd.opm.gef.editor.tool.CreationAndDirectEditTool;

/**
 * Tool pallete for the {@link OPMGraphicalEditor}.
 */
public class OPMGraphicalEditorPalette extends PaletteRoot {

    PaletteGroup group;

    public OPMGraphicalEditorPalette() {
        addGroup();
        addSelectionTool();
        addNodeTools();
        addOPMLinkTool();
        addOPMProceduralLinkTools();
        addOPMStructuralLinkTools();
    }

    private void addSelectionTool() {
        SelectionToolEntry entry = new SelectionToolEntry();
        group.add(entry);
        setDefaultEntry(entry);
    }

    private void addGroup() {
        group = new PaletteGroup("OPM Controls");
        add(group);
    }

    private void addNodeTools() {
        CreationToolEntry entry = new CreationToolEntry("OPMObject", "Create a new Object", new OPMObjectFactory(), null, null);
        entry.setToolClass(CreationAndDirectEditTool.class);        
        group.add(entry);
        entry = new CreationToolEntry("OPMProcess", "Create a new Process", new OPMProcessFactory(), null, null);
        entry.setToolClass(CreationAndDirectEditTool.class);		
        group.add(entry);
        entry = new CreationToolEntry("OPMState", "Create a new State", new OPMStateFactory(), null, null);
        entry.setToolClass(CreationAndDirectEditTool.class);        
        group.add(entry);
    }

    private void addOPMLinkTool() {
        ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Link", "Creates a new link", new OPMLinkFactory(), null, null);
        group.add(entry);
    }

    /**
     * Add tools to create procedural links in the diagram.
     */
    private void addOPMProceduralLinkTools() {
        ConnectionCreationToolEntry entry;		
        entry = new ConnectionCreationToolEntry("Agent", "Create a new Agent link", new OPMAgentLinkFactory(), null, null);
        group.add(entry);
        entry = new ConnectionCreationToolEntry("Instrument", "Create a new Instrument link", new OPMInstrumentLinkFactory(), null, null);
        group.add(entry);
        entry = new ConnectionCreationToolEntry("Consumption", "Create a new Consumption link", new OPMConsumptionLinkFactory(), null, null);
        group.add(entry);
        entry = new ConnectionCreationToolEntry("Result", "Create a new Result link", new OPMResultLinkFactory(), null, null);
        group.add(entry);
        entry = new ConnectionCreationToolEntry("Effect", "Create a new Effect link", new OPMEffectLinkFactory(), null, null);
        group.add(entry);
        entry = new ConnectionCreationToolEntry("Invocation", "Create a new Invocation link", new OPMInvocationLinkFactory(), null, null);
        group.add(entry);
    }

    /**
     * Add tools to create structural links in the diagram.
     */
    private void addOPMStructuralLinkTools() {
        ConnectionCreationToolEntry entry;
        entry = new ConnectionCreationToolEntry("Aggregation", "Create a new Aggregation link", new OPMAggregationStructuralLinkAggregatorFactory(), null, null);
        group.add(entry);
        entry = new ConnectionCreationToolEntry("Exhibition", "Create a new Exhibition link", new OPMExhibitionStructuralLinkAggregatorFactory(), null, null);
        group.add(entry);
        entry = new ConnectionCreationToolEntry("Generalization", "Create a new Generalization link", new OPMGeneralizationStructuralLinkAggregatorFactory(), null, null);
        group.add(entry);
    }

}

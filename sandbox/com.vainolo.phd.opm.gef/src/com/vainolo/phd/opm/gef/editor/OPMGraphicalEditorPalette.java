package com.vainolo.phd.opm.gef.editor;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;

import com.vainolo.phd.opm.gef.editor.factory.OPMAgentLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMConsumptionLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMEffectLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMInstrumentLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMObjectFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMProcessFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMResultLinkFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMStructuralLinkAggregatorFactory;
import com.vainolo.phd.opm.gef.editor.tool.CreationAndDirectEditTool;

public class OPMGraphicalEditorPalette extends PaletteRoot {

	PaletteGroup group;
	
	public OPMGraphicalEditorPalette() {
		addGroup();
		addSelectionTool();
		addOPMObjectTool();
		addOPMProcessTool();
		addOPMAgentLinkTool();
		addOPMInstrumentLinkTool();
        addOPMConsumptionLinkTool();
        addOPMResultLinkTool();
        addOPMEffectLinkTool();
		addOPMStructuralLinkTool();
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
	
	private void addOPMObjectTool() {
		CreationToolEntry entry = new CreationToolEntry("OPMObject", "Create a new Object", new OPMObjectFactory(), null, null);
		entry.setToolClass(CreationAndDirectEditTool.class);
		group.add(entry);
	}
	
	private void addOPMProcessTool() {
		CreationToolEntry entry = new CreationToolEntry("OPMProcess", "Create a new Process", new OPMProcessFactory(), null, null);
		entry.setToolClass(CreationAndDirectEditTool.class);
		group.add(entry);
	}
	
	
	private void addOPMAgentLinkTool() {
		ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Agent Link", "Creates a new Agent Link", new OPMAgentLinkFactory(), null, null);
		group.add(entry);
	}
	
    private void addOPMInstrumentLinkTool() {
        ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Instrument Link", "Creates a new Instrument Link", new OPMInstrumentLinkFactory(), null, null);
        group.add(entry);
    }

    private void addOPMConsumptionLinkTool() {
        ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Consumption Link", "Creates a new Consumption Link", new OPMConsumptionLinkFactory(), null, null);
        group.add(entry);
    }

    private void addOPMResultLinkTool() {
        ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Result Link", "Creates a new Result Link", new OPMResultLinkFactory(), null, null);
        group.add(entry);
    }

    private void addOPMEffectLinkTool() {
        ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Effect Link", "Creates a new Effect Link", new OPMEffectLinkFactory(), null, null);
        group.add(entry);
    }
    
    private void addOPMStructuralLinkTool() {
		ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Structural Link", "Creates a new Structural Link", new OPMStructuralLinkAggregatorFactory(), null, null);
		group.add(entry);
	}

	
}

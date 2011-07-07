package com.vainolo.phd.opm.gef.editor;

import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;

import com.vainolo.phd.opm.gef.editor.factory.OPMObjectFactory;
import com.vainolo.phd.opm.gef.editor.factory.OPMProcessFactory;
import com.vainolo.phd.opm.gef.editor.tool.CreationAndDirectEditTool;

public class OPMGraphicalEditorPalette extends PaletteRoot {

	PaletteGroup group;
	
	public OPMGraphicalEditorPalette() {
		addGroup();
		addSelectionTool();
		addOPMObjectTool();
		addOPMProcessTool();
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
}

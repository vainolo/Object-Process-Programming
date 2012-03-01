package com.vainolo.gef.template;

import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;

import com.vainolo.gef.template.factory.NodeFactory;

public class GEFEditorTemplatePalette extends PaletteRoot {
	PaletteGroup group;

	public GEFEditorTemplatePalette() {
		addGroup();
		addSelectionTool();
		addNodeTool();
	}

	private void addGroup() {
		group = new PaletteGroup("OPM Controls");
		add(group);
	}

	private void addSelectionTool() {
		SelectionToolEntry entry = new SelectionToolEntry();
		group.add(entry);
		setDefaultEntry(entry);
	}

	private void addNodeTool() {
		CreationToolEntry entry = new CreationToolEntry("Node", "Create a new node", new NodeFactory(), null, null);
		group.add(entry);
	}
}

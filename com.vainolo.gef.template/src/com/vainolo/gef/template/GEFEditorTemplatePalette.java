package com.vainolo.gef.template;

import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;

public class GEFEditorTemplatePalette extends PaletteRoot {
	PaletteGroup group;

	public GEFEditorTemplatePalette() {
		addGroup();
		addSelectionTool();
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
}

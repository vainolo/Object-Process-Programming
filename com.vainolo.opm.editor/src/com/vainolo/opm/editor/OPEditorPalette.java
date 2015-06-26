package com.vainolo.opm.editor;

import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;

import com.vainolo.opm.editor.factory.OPObjectFactory;

public class OPEditorPalette extends PaletteRoot {

	public OPEditorPalette() {
		PaletteDrawer drawer = new PaletteDrawer("All");
		add(drawer);
		ToolEntry entry = new CreationToolEntry("Object", "Create new Object", new OPObjectFactory(), null, null);
		drawer.add(entry);
	}
	
}

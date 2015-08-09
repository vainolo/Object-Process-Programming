package com.vainolo.opm.editor;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

import com.google.common.base.Preconditions;
import com.vainolo.opm.editor.factory.OPObjectViewFactory;
import com.vainolo.opm.editor.factory.OPProceduralLinkViewFactory;
import com.vainolo.opm.editor.factory.OPProcessViewFactory;
import com.vainolo.opm.editor.factory.OPStructuralLinkViewFactory;
import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPProceduralLinkKind;
import com.vainolo.opm.model.opm.OPStructuralLinkKind;

public class OPEditorPalette extends PaletteRoot {

	public OPEditorPalette(OPFactory factory) {
		Preconditions.checkArgument(factory != null, "Model factory cannot be null.");
		
		PaletteDrawer drawer = new PaletteDrawer("All");
		add(drawer);
		
		ToolEntry entry = new CreationToolEntry("Object", 
				"Create new Object", 
				new OPObjectViewFactory(), 
				ImageDescriptor.createFromFile(this.getClass(), "icons/object.ico"),
				null);
		drawer.add(entry);

		entry = new CreationToolEntry("Process", 
				"Create new Process", 
				new OPProcessViewFactory(), 
				ImageDescriptor.createFromFile(this.getClass(), "icons/process.ico"), 
				null);
		drawer.add(entry);

		entry = new ConnectionCreationToolEntry("Agent Link", 
				"Create a new agent link", 
				new OPProceduralLinkViewFactory(OPProceduralLinkKind.AGENT), 
				ImageDescriptor.createFromFile(this.getClass(), "icons/agent.ico"), 
				null);
		drawer.add(entry);
		
		entry = new ConnectionCreationToolEntry("Instrument Link", 
				"Create a new instrument link", 
				new OPProceduralLinkViewFactory(OPProceduralLinkKind.INSTRUMENT), 
				ImageDescriptor.createFromFile(this.getClass(), "icons/instrument.ico"), 
				null);
		drawer.add(entry);
		
		entry = new ConnectionCreationToolEntry("Consumption Link", 
				"Create a new consumption link", 
				new OPProceduralLinkViewFactory(OPProceduralLinkKind.CONSUMPTION), 
				ImageDescriptor.createFromFile(this.getClass(), "icons/consumption.ico"), 
				null);
		drawer.add(entry);
		
		entry = new ConnectionCreationToolEntry("Result Link",  
				"Create a new result link", 
				new OPProceduralLinkViewFactory(OPProceduralLinkKind.RESULT), 
				ImageDescriptor.createFromFile(this.getClass(), "icons/result.ico"), 
				null);
		drawer.add(entry);
		
		entry = new ConnectionCreationToolEntry("Aggregation link", 
				"Create a new Aggregation link", 
				new OPStructuralLinkViewFactory(OPStructuralLinkKind.AGGREGATION), 
				ImageDescriptor.createFromFile(this.getClass(), "icons/aggregation.ico"),
				null);
		drawer.add(entry);		
		
	}
	
}

package tests;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;

import tests.factory.LinkFactory;
import tests.factory.NodeFactory;

public class TestEditorPalette extends PaletteRoot {

	private PaletteGroup group;
	
	public TestEditorPalette() {
		group = new PaletteGroup("Controls");
		add(group);
		CreationToolEntry entry = new CreationToolEntry("Node", "Create a new Node", new NodeFactory(), null, null);
		group.add(entry);
		ConnectionCreationToolEntry entry2 = new ConnectionCreationToolEntry("Link", "Creates a new Link", new LinkFactory(), null, null);
		group.add(entry2);
		
		
	}
}

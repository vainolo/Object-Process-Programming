package com.vainolo.opm.editor;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.vainolo.opm.editor.part.OPEditPartFactory;
import com.vainolo.opm.editor.property.OPPropertySourceFactory;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.OPProcess;
import com.vainolo.opm.model.view.OPNodeView;

public class OPEditor extends GraphicalEditorWithFlyoutPalette {
	
	private OPObjectProcessDiagram opd;
	private PropertySheetPage propertyPage;
	

	public OPEditor() {
		setEditDomain(new DefaultEditDomain(this));
		opd = OPModelFactory.createObjectProcessDiagram();
		OPNodeView view = OPModelFactory.createThingView();
		OPObject object = OPModelFactory.createObject();
		view.setModel(object);
		object.setName("Hello");
		view.setViewElementContainer(opd);
		opd.addElementView(view);
		view.setViewElementContainer(opd);
		object.getView().setConstraints(100, 100, 200, 200);
		view = OPModelFactory.createThingView();
		OPProcess process = OPModelFactory.createProcess();
		view.setModel(process);
		process.setName("world");
		view.setViewElementContainer(opd);
		opd.addElementView(view);
		view.setViewElementContainer(opd);
		process.getView().setConstraints(400, 100, 200, 200);
	}
	
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(opd);
	}
	
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new OPEditPartFactory());
	}
	
	@Override
	protected PaletteRoot getPaletteRoot() {
		return new OPEditorPalette();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class type) {
		if(type.equals(IPropertySheetPage.class)) {
			if(propertyPage == null) {
				propertyPage = (UndoablePropertySheetPage)super.getAdapter(type);
				IPropertySourceProvider provider = new IPropertySourceProvider() {
					@Override
					public IPropertySource getPropertySource(Object object) {
						return null;//OPPropertySourceFactory.getPropertySource(object);
					}
				};
				UndoablePropertySheetEntry root = new UndoablePropertySheetEntry(getCommandStack());
				root.setPropertySourceProvider(provider);
				propertyPage.setRootEntry(root);
			}
			return propertyPage;
		}
		return super.getAdapter(type);
	}

}

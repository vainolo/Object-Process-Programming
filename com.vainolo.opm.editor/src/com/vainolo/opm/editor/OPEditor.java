package com.vainolo.opm.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.EventObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.vainolo.opm.editor.part.OPEditPartFactory;
import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPObject;
import com.vainolo.opm.model.opm.OPObjectProcessDiagram;
import com.vainolo.opm.model.opm.OPObjectView;
import com.vainolo.opm.model.opm.OPProcess;
import com.vainolo.opm.model.opm.OPProcessView;
import com.vainolo.opm.model.opm.OPSystem;

public class OPEditor extends GraphicalEditorWithFlyoutPalette {
	
	private OPSystem system;
	private OPObjectProcessDiagram opd;
	private PropertySheetPage propertyPage;
	
	private OPFactory modelFactory = OPFactory.eINSTANCE;
	
	public OPEditor() {
		setEditDomain(new DefaultEditDomain(this));
		
		system = getModelFactory().createOPSystem();
		opd = getModelFactory().createOPObjectProcessDiagram();
		system.setSystemDiagram(opd);
		OPObjectView objectView = getModelFactory().createOPObjectView();
		OPObject object = getModelFactory().createOPObject();
		objectView.setModel(object);
		objectView.setOpd(opd);
		object.setName("Hello");
		objectView.setX(100);
		objectView.setY(100);
		objectView.setWidth(50);
		objectView.setHeight(50);
		OPProcessView processView = getModelFactory().createOPProcessView();
		OPProcess process = getModelFactory().createOPProcess();
		processView.setModel(process);
		process.setName("world");
		processView.setX(400);
		processView.setY(100);
		processView.setWidth(50);
		processView.setHeight(50);
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
		return new OPEditorPalette(getModelFactory());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			system.eResource().save(null);
			getCommandStack().markSaveLocation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void setInput(IEditorInput input) {
		if(!OPEditorInput.class.isInstance(input)) {
			if(FileEditorInput.class.isInstance(input)) {
				FileEditorInput fInput = FileEditorInput.class.cast(input);
				
//				OPEditorInput opInput = new OPEditorInput(fInput.getFile(), system)
			}
		}
		super.setInput(input);
	}
	
	  @Override
	  public void commandStackChanged(EventObject event) {
	    firePropertyChange(PROP_DIRTY);
	    super.commandStackChanged(event);
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

	public OPFactory getModelFactory() {
		return modelFactory;
	}
}

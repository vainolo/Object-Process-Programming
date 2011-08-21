package com.vainolo.phd.opm.gef.editor;

import java.io.IOException;
import java.util.EventObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.vainolo.phd.opm.gef.editor.part.OPMEditPartFactory;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.provider.OPMItemProviderAdapterFactory;

public class OPMGraphicalEditor extends GraphicalEditorWithFlyoutPalette {

	private Resource opdResource;
	private OPMObjectProcessDiagram opd;
	
    PropertySheetPage propertyPage;
    
	/**
	 * Initialize the {@link EditDomain} of the editor.
	 */
	public OPMGraphicalEditor() {
		setEditDomain(new DefaultEditDomain(this));
	}
	
	@Override protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(opd);
	}	
	
	@Override protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		getGraphicalViewer().setEditPartFactory(new OPMEditPartFactory());
	}	
	
	@Override protected PaletteRoot getPaletteRoot() {
		return new OPMGraphicalEditorPalette();
	}

	/**
	 * Save the model using the resource from which it was
	 * opened, and mark the current location in the 
	 * {@link CommandStack}.
	 */
	@Override public void doSave(IProgressMonitor monitor) {
		if(opdResource == null) {
			return;
		}
		
		try {
			opdResource.save(null);
            getCommandStack().markSaveLocation();			
		} catch(IOException e) {
			// TODO do something smarter.
			e.printStackTrace();
			opdResource = null;
		}
	}

	@Override public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		
		loadInput(input);
	}
	
	private void loadInput(IEditorInput input) {
		OPMPackage.eINSTANCE.eClass(); // This initializes the OPMPackage singleton implementation.
		ResourceSet resourceSet = new ResourceSetImpl();
		if(input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			IFile file = fileInput.getFile();
			opdResource = resourceSet.createResource(URI.createURI(file.getLocationURI().toString()));
			try {
				opdResource.load(null);
				opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
			} catch(IOException e) {
				// TODO do something smarter.
				e.printStackTrace();
				opdResource = null;
			}
		}
	}
	
	/**
	 * Fire a {@link IEditorPart#PROP_DIRTY} property change and
	 * call super implementation.
	 */
	@Override public void commandStackChanged(EventObject event) {
        firePropertyChange(PROP_DIRTY);
        super.commandStackChanged(event);
    }
	
	@Override
	public Object getAdapter(Class type) {
	    if(type.equals(IPropertySheetPage.class)) {
	        if(propertyPage == null) {
	            propertyPage = (UndoablePropertySheetPage) super.getAdapter(type);
	            IPropertySourceProvider sourceProvider = new IPropertySourceProvider() {
	                OPMItemProviderAdapterFactory factory = new OPMItemProviderAdapterFactory();
                    IPropertySourceProvider modelPropertySourceProvider = new AdapterFactoryContentProvider(new OPMItemProviderAdapterFactory());
	                
                    @Override
                    public IPropertySource getPropertySource(Object object) {
                        IPropertySource source = null;                        
                        if(object instanceof EditPart) {
                            source = modelPropertySourceProvider.getPropertySource(((EditPart)object).getModel());
                        } else {
                            source = modelPropertySourceProvider.getPropertySource(object);
                        }
                        
                        if(source != null) {
                            return new MyPropertySource(source);
                        } else {
                            return null;
                        }
                    }
	                
	            };
	            UndoablePropertySheetEntry root = new UndoablePropertySheetEntry(getCommandStack());
	            root.setPropertySourceProvider(sourceProvider);
	            propertyPage.setRootEntry(root);
	        }
            return propertyPage;
	    }
	    return super.getAdapter(type);
	}
	
	public class MyPropertySource implements IPropertySource {
	    private IPropertySource source;

	    public MyPropertySource(final IPropertySource source) {
	        this.source = source;
	    }
	    
        @Override
        public Object getEditableValue() {
            Object value = source.getEditableValue();
            if(value instanceof PropertyValueWrapper) {
                PropertyValueWrapper wrapper = (PropertyValueWrapper) value;
                return wrapper.getEditableValue(null);
            } else {
                return source.getEditableValue();
            }
        }

        @Override
        public IPropertyDescriptor[] getPropertyDescriptors() {
            return source.getPropertyDescriptors();
        }

        @Override
        public Object getPropertyValue(Object id) {
            Object value = source.getPropertyValue(id);
            if(value instanceof PropertyValueWrapper) {
                PropertyValueWrapper wrapper = (PropertyValueWrapper) value;
                return wrapper.getEditableValue(null);
            }
            return source.getPropertyValue(id);
        }

        @Override
        public boolean isPropertySet(Object id) {
            return source.isPropertySet(id);
        }

        @Override
        public void resetPropertyValue(Object id) {
            source.resetPropertyValue(id);
        }

        @Override
        public void setPropertyValue(Object id, Object value) {
            source.setPropertyValue(id, value);
        }
	    
	}
}

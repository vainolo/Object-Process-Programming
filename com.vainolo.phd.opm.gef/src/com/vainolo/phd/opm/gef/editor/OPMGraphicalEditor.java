/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor;

import java.util.EventObject;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.gef.ui.properties.UndoablePropertySheetPage;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.vainolo.phd.opm.gef.action.ResizeToContentsAction;
import com.vainolo.phd.opm.gef.editor.factory.OPMIdManager;
import com.vainolo.phd.opm.gef.editor.part.OPMEditPartFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.provider.OPMItemProviderAdapterFactory;
import com.vainolo.phd.opm.utilities.OPDLoader;

public class OPMGraphicalEditor extends GraphicalEditorWithFlyoutPalette {

  Logger logger = Logger.getLogger(OPMGraphicalEditor.class.getName());

  private IFile opdFile;
  private OPMObjectProcessDiagram opd;

  PropertySheetPage propertyPage;

  /**
   * Initialize the {@link EditDomain} of the editor.
   */
  public OPMGraphicalEditor() {
    setEditDomain(new DefaultEditDomain(this));
  }

  @Override
  protected void initializeGraphicalViewer() {
    super.initializeGraphicalViewer();
    getGraphicalViewer().setContents(opd);
    getGraphicalControl().setFont(new Font(null, "Consolas", 10, SWT.NORMAL));
  }

  @Override
  protected void configureGraphicalViewer() {
    super.configureGraphicalViewer();
    getGraphicalViewer().setEditPartFactory(new OPMEditPartFactory());
    getActionRegistry().registerAction(new ToggleGridAction(getGraphicalViewer()));
    getActionRegistry().registerAction(new ToggleSnapToGeometryAction(getGraphicalViewer()));
    getGraphicalViewer().setContextMenu(
        new OPMGraphicalEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry()));
    configureKeyboardShortcuts();
  }

  private void configureKeyboardShortcuts() {
    GraphicalViewerKeyHandler keyHandler = new GraphicalViewerKeyHandler(getGraphicalViewer());
    keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));
    keyHandler.put(KeyStroke.getPressed(SWT.F3, 0),
        getActionRegistry().getAction(ResizeToContentsAction.RESIZE_TO_CONTENTS_ID));
    getGraphicalViewer().setKeyHandler(keyHandler);

  }

  @Override
  protected PaletteRoot getPaletteRoot() {
    return new OPMGraphicalEditorPalette();
  }

  /**
   * Save the model using the resource from which it was opened, and mark the current location in the
   * {@link CommandStack}.
   */
  @Override
  public void doSave(IProgressMonitor monitor) {
    try {
      opd.setNextId(OPMIdManager.getNextId());
      opd.eResource().save(null);
      opdFile.touch(null);
      getCommandStack().markSaveLocation();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void setInput(IEditorInput input) {
    super.setInput(input);
    loadInput(input);
    setPartName(input.getName());
  }

  private void loadInput(IEditorInput input) {
    OPMPackage.eINSTANCE.eClass(); // This initializes the OPMPackage singleton implementation. Must be called before
                                   // reading the file.
    if(input instanceof IFileEditorInput) {

      IFileEditorInput fileInput = (IFileEditorInput) input;
      opdFile = fileInput.getFile();
      opd = OPDLoader.loadOPDFile(opdFile.getLocationURI().toString());
      if(opd == null) {
        throw new RuntimeException("Could not load OPD file " + opdFile.getLocationURI().toString());
      }
      if(opd.getId() == 0) {
        opd.setId(1);
        opd.setNextId(2);
      }
      OPMIdManager.setId(opd.getNextId());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void createActions() {
    super.createActions();

    IAction action = new ResizeToContentsAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new DirectEditAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());
  }

  /**
   * Fire a {@link IEditorPart#PROP_DIRTY} property change and call super implementation.
   */
  @Override
  public void commandStackChanged(EventObject event) {
    firePropertyChange(PROP_DIRTY);
    super.commandStackChanged(event);
  }

  /**
   * This methos implements adapting to {@link IPropertySheetPage}. All other requests are forwarded to the
   * {@link GraphicalEditorWithFlyoutPalette#getAdapter(Class) parent} implementation.
   */
  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
    if(type.equals(IPropertySheetPage.class)) {
      if(propertyPage == null) {
        propertyPage = (UndoablePropertySheetPage) super.getAdapter(type);
        // A new PropertySourceProvider was implemented to fetch the model
        // from the edit part when required. The property source is provided
        // by the generated EMF classes and wrapped by the AdapterFactoryContentProvider
        // to yield standard eclipse interfaces.
        IPropertySourceProvider sourceProvider = new IPropertySourceProvider() {
          IPropertySourceProvider modelPropertySourceProvider = new AdapterFactoryContentProvider(
              new OPMItemProviderAdapterFactory());

          @Override
          public IPropertySource getPropertySource(Object object) {
            IPropertySource source = null;
            if(object instanceof EditPart) {
              source = modelPropertySourceProvider.getPropertySource(((EditPart) object).getModel());
            } else {
              source = modelPropertySourceProvider.getPropertySource(object);
            }

            if(source != null) {
              return new UnwrappingPropertySource(source);
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

  /**
   * A property source which unwraps values that are wrapped in an EMF {@link PropertyValueWrapper}
   * 
   * @author vainolo
   * 
   */
  public class UnwrappingPropertySource implements IPropertySource {
    private final IPropertySource source;

    public UnwrappingPropertySource(final IPropertySource source) {
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
      } else {
        return source.getPropertyValue(id);
      }
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

  public OPMObjectProcessDiagram getOPD() {
    return opd;
  }
}

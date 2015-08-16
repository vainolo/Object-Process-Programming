/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

import java.util.EventObject;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor.PropertyValueWrapper;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.gef.*;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.*;
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

import com.vainolo.phd.opp.model.OPPPackage;
import com.vainolo.phd.opp.model.provider.OPPItemProviderAdapterFactory;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.utilities.OPPFileUtils;
import com.vainolo.phd.opp.editor.action.*;
import com.vainolo.phd.opp.editor.factory.OPMIdManager;
import com.vainolo.phd.opp.editor.part.OPMEditPartFactory;

public class OPMGraphicalEditor extends GraphicalEditorWithFlyoutPalette {

  Logger logger = Logger.getLogger(OPMGraphicalEditor.class.getName());

  private IFile opdFile;
  private OPPObjectProcessDiagram opd;
  private OPMIdManager idManager;

  private PropertySheetPage propertyPage;
  private PaletteRoot palette;

  /**
   * Initialize the {@link EditDomain} of the editor.
   */
  public OPMGraphicalEditor() {
    idManager = new OPMIdManager();
    setEditDomain(new DefaultEditDomain(this));
  }

  public OPMIdManager getIdManager() {
    return idManager;
  }

  @Override
  protected void initializeGraphicalViewer() {
    super.initializeGraphicalViewer();
    getGraphicalViewer().setContents(opd);
    getGraphicalControl().setFont(new Font(null, "Consolas", 10, SWT.NORMAL));
  }

  @Override
  public GraphicalViewer getGraphicalViewer() {
    return super.getGraphicalViewer();
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

    // D&D
    getGraphicalViewer().addDropTargetListener(new TemplateTransferDropTargetListener(getGraphicalViewer()));
    getEditDomain().getPaletteViewer().addDragSourceListener(
        new TemplateTransferDragSourceListener(getEditDomain().getPaletteViewer()));
    // end D&D

    // start zoom
    ScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();
    root.getZoomManager().setZoomLevels(new double[] { 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0 });
    root.getZoomManager().setZoomAnimationStyle(ZoomManager.ANIMATE_ZOOM_IN_OUT);
    IAction zoomIn = new ZoomInAction(root.getZoomManager());
    IAction zoomOut = new ZoomOutAction(root.getZoomManager());
    getActionRegistry().registerAction(zoomIn);
    getActionRegistry().registerAction(zoomOut);
    // ((IKeyBindingService)
    // getSite().getService(IKeyBindingService.class)).registerAction(zoomIn);
    // ((IKeyBindingService)
    // getSite().getService(IKeyBindingService.class)).registerAction(zoomOut);
    // end zoom.

    getGraphicalViewer().setRootEditPart(root);
  }

  private void configureKeyboardShortcuts() {
    GraphicalViewerKeyHandler keyHandler = new GraphicalViewerKeyHandler(getGraphicalViewer());
    keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.OPEN_EXT));
    keyHandler.put(KeyStroke.getPressed(SWT.F3, 0),
        getActionRegistry().getAction(OPMResizeToContentsAction.RESIZE_TO_CONTENTS_ID));
    getGraphicalViewer().setKeyHandler(keyHandler);

  }

  @Override
  protected PaletteRoot getPaletteRoot() {
    if(palette == null)
      palette = new OPMGraphicalEditorPalette(idManager);
    return palette;
  }

  @Override
  public DefaultEditDomain getEditDomain() {
    return super.getEditDomain();
  }

  /**
   * Save the model using the resource from which it was opened, and mark the
   * current location in the {@link CommandStack}.
   */
  @Override
  public void doSave(IProgressMonitor monitor) {
    try {
      opd.setLastKnownUsedId(idManager.getNextId());
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
    OPPPackage.eINSTANCE.eClass(); // This initializes the OPMPackage
                                   // singleton implementation. Must be called
                                   // before reading the file.
    if(input instanceof IFileEditorInput) {

      IFileEditorInput fileInput = (IFileEditorInput) input;
      opdFile = fileInput.getFile();
      opd = OPPFileUtils.loadOPPFile(opdFile.getLocationURI().toString());
      if(opd == null) {
        throw new RuntimeException("Could not load OPD file " + opdFile.getLocationURI().toString());
      }
      idManager.setInitialId(opd.getLastKnownUsedId());
      // if(opd.getId() == 0) {
      // opd.setId(1);
      // opd.setLastKnownUsedId(2);
      // }
      // OPMIdManager.setInitialId(opd.getNextId());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void createActions() {
    super.createActions();

    IAction action = new OPMResizeToContentsAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new DirectEditAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPMToggledProceduralLinkSubkindAction(this,
        OPMToggledProceduralLinkSubkindAction.CONDITIONAL_SUBKIND_ID);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPMToggledProceduralLinkSubkindAction(this, OPMToggledProceduralLinkSubkindAction.EVENT_SUBKIND_ID);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPMToggledProceduralLinkSubkindAction(this, OPMToggledProceduralLinkSubkindAction.OPTIONAL_SUBKIND_ID);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPMToggleThingMultiplicityAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPMToggleStateValueAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPMThingInZoomAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPMCreateObjectAction(this);
    getActionRegistry().registerAction(action);

    action = new OPMCreateProcessAction(this);
    getActionRegistry().registerAction(action);

    action = new OPMCreateStateAction(this);
    getActionRegistry().registerAction(action);

    action = new OPMCreateConsumptionLinkAction(this);
    getActionRegistry().registerAction(action);

    action = new OPMCreateResultLinkAction(this);
    getActionRegistry().registerAction(action);

    action = new CopyTemplateAction(this);
    getActionRegistry().registerAction(action);

    action = new PasteTemplateAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

  }

  /**
   * Fire a {@link IEditorPart#PROP_DIRTY} property change and call super
   * implementation.
   */
  @Override
  public void commandStackChanged(EventObject event) {
    firePropertyChange(PROP_DIRTY);
    super.commandStackChanged(event);
  }

  /**
   * This method implements adapting to {@link IPropertySheetPage}. All other
   * requests are forwarded to the
   * {@link GraphicalEditorWithFlyoutPalette#getAdapter(Class) parent}
   * implementation.
   */
  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
    if(type.equals(IPropertySheetPage.class)) {
      if(propertyPage == null) {
        propertyPage = (UndoablePropertySheetPage) super.getAdapter(type);
        // A new PropertySourceProvider was implemented to fetch the model
        // from the edit part when required. The property source is provided
        // by the generated EMF classes and wrapped by the
        // AdapterFactoryContentProvider
        // to yield standard eclipse interfaces.

        IPropertySourceProvider sourceProvider = new IPropertySourceProvider() {
          IPropertySourceProvider modelPropertySourceProvider = new AdapterFactoryContentProvider(
              new OPPItemProviderAdapterFactory());

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
    } else if(type == ZoomManager.class) {
      return ((ScalableFreeformRootEditPart) getGraphicalViewer().getRootEditPart()).getZoomManager();
    }

    return super.getAdapter(type);
  }

  /**
   * A property source which unwraps values that are wrapped in an EMF
   * {@link PropertyValueWrapper}
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

  public OPPObjectProcessDiagram getOPD() {
    return opd;
  }
}

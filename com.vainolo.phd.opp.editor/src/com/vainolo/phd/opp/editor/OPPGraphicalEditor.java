/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

import java.util.EventObject;
import java.util.logging.Logger;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
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
import com.vainolo.phd.opp.editor.factory.OPPIdManager;
import com.vainolo.phd.opp.editor.part.OPPEditPartFactory;

public class OPPGraphicalEditor extends GraphicalEditorWithFlyoutPalette {

  Logger logger = Logger.getLogger(OPPGraphicalEditor.class.getName());

  private IFile opdFile;
  private OPPObjectProcessDiagram opd;
  private OPPIdManager idManager;

  private PropertySheetPage propertyPage;
  private PaletteRoot palette;

  /**
   * Initialize the {@link EditDomain} of the editor.
   */
  public OPPGraphicalEditor() {
    idManager = new OPPIdManager();
    setEditDomain(new DefaultEditDomain(this));
  }

  public OPPIdManager getIdManager() {
    return idManager;
  }

  OPPEditorResourceChangeListener changeListener = new OPPEditorResourceChangeListener();

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
    getGraphicalViewer().setEditPartFactory(new OPPEditPartFactory());
    getActionRegistry().registerAction(new ToggleGridAction(getGraphicalViewer()));
    getActionRegistry().registerAction(new ToggleSnapToGeometryAction(getGraphicalViewer()));
    getGraphicalViewer().setContextMenu(new OPPGraphicalEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry()));
    configureKeyboardShortcuts();

    // D&D
    getGraphicalViewer().addDropTargetListener(new TemplateTransferDropTargetListener(getGraphicalViewer()));
    getEditDomain().getPaletteViewer().addDragSourceListener(new TemplateTransferDragSourceListener(getEditDomain().getPaletteViewer()));
    // end D&D

    // start zoom
    ScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();
    root.getZoomManager().setZoomLevels(new double[] { 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0 });
    root.getZoomManager().setZoomAnimationStyle(ZoomManager.ANIMATE_ZOOM_IN_OUT);
    IAction zoomIn = new ZoomInAction(root.getZoomManager());
    IAction zoomOut = new ZoomOutAction(root.getZoomManager());
    getActionRegistry().registerAction(zoomIn);
    getActionRegistry().registerAction(zoomOut);
    // ((IKeyBindingService) getSite().getService(IKeyBindingService.class)).registerAction(zoomIn);
    // ((IKeyBindingService) getSite().getService(IKeyBindingService.class)).registerAction(zoomOut);
    // end zoom.

    getGraphicalViewer().setRootEditPart(root);
  }

  private void configureKeyboardShortcuts() {
    GraphicalViewerKeyHandler keyHandler = new GraphicalViewerKeyHandler(getGraphicalViewer());
    keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.OPEN_EXT));
    keyHandler.put(KeyStroke.getPressed(SWT.F3, 0), getActionRegistry().getAction(OPPResizeToContentsAction.RESIZE_TO_CONTENTS_ID));
    getGraphicalViewer().setKeyHandler(keyHandler);

  }

  @Override
  protected PaletteRoot getPaletteRoot() {
    if (palette == null)
      palette = new OPPGraphicalEditorPalette(idManager);
    return palette;
  }

  @Override
  public DefaultEditDomain getEditDomain() {
    return super.getEditDomain();
  }

  /**
   * Save the model using the resource from which it was opened, and mark the current location in the
   * {@link CommandStack}.
   */
  @Override
  public void doSave(IProgressMonitor monitor) {
    try {
      opd.setLastKnownUsedId(idManager.getNextId());
      opd.eResource().save(null);
      opdFile.touch(null);
      getCommandStack().markSaveLocation();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void setInput(IEditorInput input) {
    super.setInput(input);
    loadInput(input);
    setPartName(input.getName());
    ResourcesPlugin.getWorkspace().addResourceChangeListener(changeListener, IResourceChangeEvent.POST_CHANGE);
  }

  private void loadInput(IEditorInput input) {
    OPPPackage.eINSTANCE.eClass(); // This initializes the OPMPackage singleton implementation. Must be called before
                                   // reading the file.
    if (input instanceof IFileEditorInput) {
      IFileEditorInput fileInput = (IFileEditorInput) input;
      opdFile = fileInput.getFile();
      opd = OPPFileUtils.loadOPPFile(opdFile.getLocationURI().toString());
      if (opd == null) {
        throw new RuntimeException("Could not load OPD file " + opdFile.getLocationURI().toString());
      }
      // If filename has changed, change the name of the OPD to match the file.
      opd.setName(opdFile.getName().substring(0, opdFile.getName().length() - 4));
      idManager.setInitialId(opd.getLastKnownUsedId());
      doSave(null);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void createActions() {
    super.createActions();

    IAction action = new OPPResizeToContentsAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new DirectEditAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPToggledProceduralLinkSubkindAction(this, OPPToggledProceduralLinkSubkindAction.CONDITIONAL_SUBKIND_ID);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPToggledProceduralLinkSubkindAction(this, OPPToggledProceduralLinkSubkindAction.EVENT_SUBKIND_ID);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPToggledProceduralLinkSubkindAction(this, OPPToggledProceduralLinkSubkindAction.OPTIONAL_SUBKIND_ID);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPToggleThingMultiplicityAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPToggleGlobalObjectAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPToggleStateValueAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPThingInZoomAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPThingUnfoldAction(this);
    getActionRegistry().registerAction(action);
    getSelectionActions().add(action.getId());

    action = new OPPCreateObjectAction(this);
    getActionRegistry().registerAction(action);

    action = new OPPCreateProcessAction(this);
    getActionRegistry().registerAction(action);

    action = new OPPCreateStateAction(this);
    getActionRegistry().registerAction(action);

    action = new OPPCreateAgentLinkAction(this);
    getActionRegistry().registerAction(action);

    action = new OPPCreateInstrumentLinkAction(this);
    getActionRegistry().registerAction(action);

    action = new OPPCreateConsResLinkAction(this);
    getActionRegistry().registerAction(action);

    action = new CopyTemplateAction(this);
    getActionRegistry().registerAction(action);

    action = new PasteTemplateAction(this);
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
   * This method implements adapting to {@link IPropertySheetPage}. All other requests are forwarded to the
   * {@link GraphicalEditorWithFlyoutPalette#getAdapter(Class) parent} implementation.
   */
  @Override
  public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
    if (type.equals(IPropertySheetPage.class)) {
      if (propertyPage == null) {
        propertyPage = (UndoablePropertySheetPage) super.getAdapter(type);
        // A new PropertySourceProvider was implemented to fetch the model
        // from the edit part when required. The property source is provided
        // by the generated EMF classes and wrapped by the
        // AdapterFactoryContentProvider
        // to yield standard eclipse interfaces.

        IPropertySourceProvider sourceProvider = new IPropertySourceProvider() {
          IPropertySourceProvider modelPropertySourceProvider = new AdapterFactoryContentProvider(new OPPItemProviderAdapterFactory());

          @Override
          public IPropertySource getPropertySource(Object object) {
            IPropertySource source;
            if (object instanceof EditPart) {
              source = modelPropertySourceProvider.getPropertySource(((EditPart) object).getModel());
            } else {
              source = modelPropertySourceProvider.getPropertySource(object);
            }

            if (source != null) {
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
    } else if (type == ZoomManager.class) {
      return ((ScalableFreeformRootEditPart) getGraphicalViewer().getRootEditPart()).getZoomManager();
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
      if (value instanceof PropertyValueWrapper) {
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
      if (value instanceof PropertyValueWrapper) {
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

  @Override
  public void dispose() {
    ResourcesPlugin.getWorkspace().removeResourceChangeListener(changeListener);
    super.dispose();
  }

  private class DeltaVisitor implements IResourceDeltaVisitor {
    @Override
    public boolean visit(IResourceDelta delta) throws CoreException {
      if (delta.getKind() == IResourceDelta.REMOVED) {
        if (delta.getResource().getType() == IResource.FILE) {
          if (delta.getResource().getFullPath().equals(opdFile.getFullPath())) {
            getSite().getShell().getDisplay().asyncExec(new Runnable() {
              @Override
              public void run() {
                if (!isDirty()) {
                  getSite().getPage().closeEditor(OPPGraphicalEditor.this, false);
                }
              }
            });
          }
        }
      }
      for (IResourceDelta child : delta.getAffectedChildren()) {
        child.accept(this);
      }
      return false;
    }
  }

  private class OPPEditorResourceChangeListener implements IResourceChangeListener {
    @Override
    public void resourceChanged(IResourceChangeEvent event) {
      IResourceDelta delta = event.getDelta();
      try {
        delta.accept(new DeltaVisitor());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
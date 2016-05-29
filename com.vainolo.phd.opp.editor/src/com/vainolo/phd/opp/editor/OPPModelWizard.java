/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.vainolo.phd.opp.utilities.OPPFileUtils;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;

public class OPPModelWizard extends Wizard implements INewWizard {

  public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList("opp"));
  public static final String FORMATTED_FILE_EXTENSIONS = "opp";
  protected OPMModelWizardNewFileCreationPage newFileCreationPage;
  protected IStructuredSelection selection;
  protected IWorkbench workbench;
  protected List<String> initialObjectNames;
  private OPMModelWizardInitialObjectCreationPage initialObjectCreationPage;

  @Override
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    this.workbench = workbench;
    this.selection = selection;
    setWindowTitle("New");
  }

  @Override
  public boolean performFinish() {
    try {
      final IFile modelFile = getModelFile();

      WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
        @Override
        protected void execute(final IProgressMonitor progressMonitor) {
          try {
            OPPFileUtils.createOPPFile(modelFile, modelFile.getName().substring(0, modelFile.getName().length() - 4), initialObjectCreationPage.getOPDKind(),
                false, true);
          } catch (Exception exception) {
            OPPEditorPlugin.INSTANCE.log(exception);
          } finally {
            progressMonitor.done();
          }
        }
      };

      getContainer().run(false, false, operation);

      IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
      IWorkbenchPage page = workbenchWindow.getActivePage();
      final IWorkbenchPart activePart = page.getActivePart();
      if (activePart instanceof ISetSelectionTarget) {
        final ISelection targetSelection = new StructuredSelection(modelFile);
        getShell().getDisplay().asyncExec(() -> ((ISetSelectionTarget) activePart).selectReveal(targetSelection));
      }

      try {
        modelFile.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
        page.openEditor(new FileEditorInput(modelFile), workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
      } catch (PartInitException exception) {
        MessageDialog.openError(workbenchWindow.getShell(), "Open Editor", exception.getMessage());
        return false;
      }

      return true;
    } catch (Exception exception) {
      OPPEditorPlugin.INSTANCE.log(exception);
      return false;
    }
  }

  /**
   * New File wizard page
   * 
   * @author t-arib
   */
  public class OPMModelWizardNewFileCreationPage extends WizardNewFileCreationPage {

    public OPMModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
      super(pageId, selection);
    }

    @Override
    protected boolean validatePage() {
      if (super.validatePage()) {
        String extension = new Path(getFileName()).getFileExtension();
        if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
          String key = FILE_EXTENSIONS.size() > 1 ? "The file name must end in " : "The file name must have one of the following extensions: ";
          setErrorMessage(key + FORMATTED_FILE_EXTENSIONS);
          return false;
        }
        return true;
      }
      return false;
    }

    public IFile getModelFile() {
      return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
    }
  }

  /**
   */
  public class OPMModelWizardInitialObjectCreationPage extends WizardPage {
    protected Combo opdKind;
    protected List<String> encodings;
    protected Combo encodingField;

    public OPMModelWizardInitialObjectCreationPage(String pageId) {
      super(pageId);
    }

    @Override
    public void createControl(Composite parent) {
      Composite composite = new Composite(parent, SWT.NONE);
      GridLayout layout = new GridLayout();
      layout.numColumns = 1;
      layout.verticalSpacing = 12;
      composite.setLayout(layout);

      GridData data = new GridData();
      data.verticalAlignment = GridData.FILL;
      data.grabExcessVerticalSpace = true;
      data.horizontalAlignment = GridData.FILL;
      composite.setLayoutData(data);

      Label containerLabel = new Label(composite, SWT.LEFT);
      containerLabel.setText("OPD Kind");

      data = new GridData();
      data.horizontalAlignment = GridData.FILL;
      containerLabel.setLayoutData(data);

      opdKind = new Combo(composite, SWT.BORDER);

      data = new GridData();
      data.horizontalAlignment = GridData.FILL;
      data.grabExcessHorizontalSpace = true;
      opdKind.setLayoutData(data);

      for (OPPObjectProcessDiagramKind value : OPPObjectProcessDiagramKind.VALUES)
        opdKind.add(value.getLiteral());

      // for (String objectName : new String[] { OPPObjectProcessDiagramKind.COMPOUND.getLiteral(),
      // OPPObjectProcessDiagramKind.UNFOLDED.getLiteral(),
      // OPPObjectProcessDiagramKind.SYSTEM.getLiteral() }) {
      // opdKind.add(objectName);
      // }

      opdKind.select(0);
      setControl(composite);
    }

    public OPPObjectProcessDiagramKind getOPDKind() {
      return OPPObjectProcessDiagramKind.get(opdKind.getText());
    }

    @Override
    public void setVisible(boolean visible) {
      super.setVisible(visible);
      if (visible) {
        if (opdKind.getItemCount() == 1) {
          opdKind.clearSelection();
        } else {
          opdKind.setFocus();
        }
      }
    }
  }

  /**
   * Create the wizard pages and initialize the filename to the first available default value.
   */
  @Override
  public void addPages() {
    newFileCreationPage = new OPMModelWizardNewFileCreationPage("Whatever", selection);
    newFileCreationPage.setTitle("OPP Model");
    newFileCreationPage.setDescription("Create a new OPP model");
    newFileCreationPage.setFileName("Model" + "." + FILE_EXTENSIONS.get(0));
    addPage(newFileCreationPage);

    if (selection != null && !selection.isEmpty()) {
      Object selectedElement = selection.iterator().next();
      if (selectedElement instanceof IResource) {
        IResource selectedResource = (IResource) selectedElement;
        if (selectedResource.getType() == IResource.FILE) {
          selectedResource = selectedResource.getParent();
        }

        if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
          newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

          String defaultModelBaseFilename = "Model";
          String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
          String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
          for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
            modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
          }
          newFileCreationPage.setFileName(modelFilename);
        }
      }
    }

    initialObjectCreationPage = new OPMModelWizardInitialObjectCreationPage("Whatever2");
    initialObjectCreationPage.setTitle("OPD Kind");
    initialObjectCreationPage.setDescription("Select the kind of OPD you are creating");
    addPage(initialObjectCreationPage);

  }

  public IFile getModelFile() {
    return newFileCreationPage.getModelFile();
  }

}

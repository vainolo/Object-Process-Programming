/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.vainolo.phd.opm.gef;

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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
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

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMModelWizard extends Wizard implements INewWizard {

  public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList("opm"));
  public static final String FORMATTED_FILE_EXTENSIONS = "opm";
  protected OPMModelWizardNewFileCreationPage newFileCreationPage;
  protected IStructuredSelection selection;
  protected IWorkbench workbench;
  protected List<String> initialObjectNames;

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
            ResourceSet resourceSet = new ResourceSetImpl();
            URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
            Resource resource = resourceSet.createResource(fileURI);

            OPMObjectProcessDiagram opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
            if(opd != null) {
              resource.getContents().add(opd);
              opd.setName(modelFile.getName().substring(0, modelFile.getName().length() - 4));
              OPMProcess p = OPMFactory.eINSTANCE.createOPMProcess();
              p.setId(1);
              p.setName(opd.getName());
              p.setConstraints(new Rectangle(200, 100, 300, 400));
              opd.getNodes().add(p);
              opd.setNextId(2);
            }
            resource.save(null);
          } catch(Exception exception) {
            OPMGEFEditorPlugin.INSTANCE.log(exception);
          } finally {
            progressMonitor.done();
          }
        }
      };

      getContainer().run(false, false, operation);

      IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
      IWorkbenchPage page = workbenchWindow.getActivePage();
      final IWorkbenchPart activePart = page.getActivePart();
      if(activePart instanceof ISetSelectionTarget) {
        final ISelection targetSelection = new StructuredSelection(modelFile);
        getShell().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            ((ISetSelectionTarget) activePart).selectReveal(targetSelection);
          }
        });
      }

      try {
        page.openEditor(new FileEditorInput(modelFile),
            workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
      } catch(PartInitException exception) {
        MessageDialog.openError(workbenchWindow.getShell(), "Open Editor", exception.getMessage());
        return false;
      }

      return true;
    } catch(Exception exception) {
      OPMGEFEditorPlugin.INSTANCE.log(exception);
      return false;
    }
  }

  /**
   * 
   * @author t-arib
   * 
   */
  public class OPMModelWizardNewFileCreationPage extends WizardNewFileCreationPage {

    public OPMModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
      super(pageId, selection);
    }

    @Override
    protected boolean validatePage() {
      if(super.validatePage()) {
        String extension = new Path(getFileName()).getFileExtension();
        if(extension == null || !FILE_EXTENSIONS.contains(extension)) {
          String key = FILE_EXTENSIONS.size() > 1 ? "The file name must end in "
              : "The file name must have one of the following extensions: ";
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
   * Create the wizard pages and initialize the filename to the first available
   * default value.
   */
  @Override
  public void addPages() {
    newFileCreationPage = new OPMModelWizardNewFileCreationPage("Whatever", selection);
    newFileCreationPage.setTitle("OPM Model");
    newFileCreationPage.setDescription("Create a new OPM mode");
    newFileCreationPage.setFileName("My" + "." + FILE_EXTENSIONS.get(0));
    addPage(newFileCreationPage);

    if(selection != null && !selection.isEmpty()) {
      Object selectedElement = selection.iterator().next();
      if(selectedElement instanceof IResource) {
        IResource selectedResource = (IResource) selectedElement;
        if(selectedResource.getType() == IResource.FILE) {
          selectedResource = selectedResource.getParent();
        }

        if(selectedResource instanceof IFolder || selectedResource instanceof IProject) {
          newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

          String defaultModelBaseFilename = "My";
          String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
          String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
          for(int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
            modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
          }
          newFileCreationPage.setFileName(modelFilename);
        }
      }
    }
  }

  public IFile getModelFile() {
    return newFileCreationPage.getModelFile();
  }

}

/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities;

import static com.vainolo.phd.opm.utilities.OPMLogger.logInfo;
import static com.vainolo.phd.opm.utilities.OPMLogger.logWarning;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPMFileUtils {

  public static OPMObjectProcessDiagram loadOPDFile(String uri) {
    OPMObjectProcessDiagram opd;
    final ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    final Resource opdResource = resourceSet.createResource(URI.createURI(uri));
    try {
      opdResource.load(null);
      opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
    } catch(final IOException e) {
      logWarning("OPD File " + uri + " could not be loaded. Please check the path.");
      logWarning("Exception thrown: " + e);
      opd = null;
    }

    return opd;
  }

  public static void createOPDFile2(IFile opdFile, String name, OPMObjectProcessDiagramKind kind, boolean isObject,
      boolean isProcess) throws IOException {
    if(opdFile.exists()) {
      logInfo("Tried to create file that already exists.");
      logInfo("Filename: " + opdFile.getFullPath());
      throw new IllegalArgumentException("Tried to create a file that already exists: " + opdFile.getName());
    }

    final ResourceSet resourceSet = new ResourceSetImpl();
    final Resource resource = resourceSet.createResource(URI.createURI(opdFile.getLocationURI().toString()));
    OPMObjectProcessDiagram opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    opd.setId(0);
    opd.setName(name);
    opd.setKind(kind);
    resource.getContents().add(opd);
    switch(kind) {
    case COMPOUND:
      createInitialProcessNode(opd);
      break;
    case UNFOLDED:
      createInitialObjectNode(opd, name);
      break;
    case SYSTEM:
      break;
    }
    resource.save(null);
  }

  private static void createInitialProcessNode(OPMObjectProcessDiagram opd) {
    OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
    process.setId(1);
    process.setName("");
    process.setConstraints(new Rectangle(200, 100, 100, 100));
    opd.getNodes().add(process);
    opd.setLastKnownUsedId(1);
  }

  private static void createInitialObjectNode(OPMObjectProcessDiagram opd, String name) {
    OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
    object.setId(1);
    object.setName(name);
    object.setConstraints(new Rectangle(200, 100, 100, 100));
    opd.getNodes().add(object);
    opd.setLastKnownUsedId(1);
  }
}

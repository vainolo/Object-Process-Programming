/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.utilities;

import static com.vainolo.phd.opp.utilities.OPPLogger.logInfo;
import static com.vainolo.phd.opp.utilities.OPPLogger.logWarning;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPProcess;

public class OPPFileUtils {

  public static OPPObjectProcessDiagram loadOPPFile(String uri) {
    OPPObjectProcessDiagram opd;
    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    Resource oppResource = resourceSet.createResource(URI.createURI(uri));
    try {
      oppResource.load(null);
      opd = (OPPObjectProcessDiagram) oppResource.getContents().get(0);
    } catch(final IOException e) {
      logWarning("OPD File " + uri + " could not be loaded. Please check the path.");
      logWarning("Exception thrown: " + e);
      opd = null;
    }

    return opd;
  }

  public static void createOPPFile(IFile opdFile, String name, OPPObjectProcessDiagramKind kind, boolean isObject,
      boolean isProcess) throws IOException {
    if(opdFile.exists()) {
      logInfo("Tried to create file that already exists.");
      logInfo("Filename: " + opdFile.getFullPath());
      throw new IllegalArgumentException("Tried to create a file that already exists: " + opdFile.getName());
    }

    final ResourceSet resourceSet = new ResourceSetImpl();
    final Resource resource = resourceSet.createResource(URI.createURI(opdFile.getLocationURI().toString()));
    OPPObjectProcessDiagram opd = OPPFactory.eINSTANCE.createOPPObjectProcessDiagram();
    opd.setId(0);
    opd.setName(name);
    opd.setKind(kind);
    resource.getContents().add(opd);
    switch(kind) {
    case COMPOUND:
      createInitialOPPProcessNode(opd, name);
      break;
    case UNFOLDED:
      createInitialOPPObjectNode(opd, name);
      break;
    case SYSTEM:
      break;
    }
    resource.save(null);
  }

  private static void createInitialOPPProcessNode(OPPObjectProcessDiagram opd, String name) {
    OPPProcess process = OPPFactory.eINSTANCE.createOPPProcess();
    process.setId(1);
    process.setName(name);
    process.setConstraints(200, 100, 300, 400);
    process.setMain(true);
    opd.getNodes().add(process);
    opd.setLastKnownUsedId(1);
  }

  private static void createInitialOPPObjectNode(OPPObjectProcessDiagram opd, String name) {
    OPPObject object = OPPFactory.eINSTANCE.createOPPObject();
    object.setId(1);
    object.setName(name);
    object.setConstraints(200, 100, 100, 100);
    object.setMain(true);
    opd.getNodes().add(object);
    opd.setLastKnownUsedId(1);
  }

  // public static OPMObjectProcessDiagram loadOPDFile(String uri) {
  // OPMObjectProcessDiagram opd;
  // final ResourceSet resourceSet = new ResourceSetImpl();
  // resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
  // .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new
  // XMIResourceFactoryImpl());
  // final Resource opdResource =
  // resourceSet.createResource(URI.createURI(uri));
  // try {
  // opdResource.load(null);
  // opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
  // } catch(final IOException e) {
  // logWarning("OPD File " + uri +
  // " could not be loaded. Please check the path.");
  // logWarning("Exception thrown: " + e);
  // opd = null;
  // }
  //
  // return opd;
  // }
  //
  // public static void createOPDFile2(IFile opdFile, String name,
  // OPMObjectProcessDiagramKind kind, boolean isObject,
  // boolean isProcess) throws IOException {
  // if(opdFile.exists()) {
  // logInfo("Tried to create file that already exists.");
  // logInfo("Filename: " + opdFile.getFullPath());
  // throw new
  // IllegalArgumentException("Tried to create a file that already exists: " +
  // opdFile.getName());
  // }
  //
  // final ResourceSet resourceSet = new ResourceSetImpl();
  // final Resource resource =
  // resourceSet.createResource(URI.createURI(opdFile.getLocationURI().toString()));
  // OPMObjectProcessDiagram opd =
  // OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
  // opd.setId(0);
  // opd.setName(name);
  // opd.setKind(kind);
  // resource.getContents().add(opd);
  // switch(kind) {
  // case COMPOUND:
  // createInitialProcessNode(opd);
  // break;
  // case UNFOLDED:
  // createInitialObjectNode(opd, name);
  // break;
  // case SYSTEM:
  // break;
  // }
  // resource.save(null);
  // }
  //
  // private static void createInitialProcessNode(OPMObjectProcessDiagram opd) {
  // OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
  // process.setId(1);
  // process.setName("");
  // process.setConstraints(new Rectangle(200, 100, 100, 100));
  // opd.getNodes().add(process);
  // opd.setLastKnownUsedId(1);
  // }
  //
  // private static void createInitialObjectNode(OPMObjectProcessDiagram opd,
  // String name) {
  // OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
  // object.setId(1);
  // object.setName(name);
  // object.setConstraints(new Rectangle(200, 100, 100, 100));
  // opd.getNodes().add(object);
  // opd.setLastKnownUsedId(1);
  // }
}

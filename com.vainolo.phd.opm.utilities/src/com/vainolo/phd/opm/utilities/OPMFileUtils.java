/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMNamedElement;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagramKind;
import com.vainolo.utils.SimpleLoggerFactory;

public enum OPMFileUtils {
  INSTANCE;

  private static final Logger logger = SimpleLoggerFactory.createLogger(OPMFileUtils.class.getName());

  public OPMObjectProcessDiagram loadOPDFile(String uri) {
    OPMObjectProcessDiagram opd;
    final ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    final Resource opdResource = resourceSet.createResource(URI.createURI(uri));
    try {
      opdResource.load(null);
      opd = (OPMObjectProcessDiagram) opdResource.getContents().get(0);
    } catch(final IOException e) {
      logger.warning("OPD File " + uri + " could not be loaded. Please check the path.");
      logger.warning("Exception thrown: " + e);
      opd = null;
    }

    return opd;
  }

  public void createOPDFile2(IFile opdFile, String name, OPMObjectProcessDiagramKind kind, boolean isObject,
      boolean isProcess) throws IOException {
    if(opdFile.exists()) {
      logger.info("Tried to create file that already exists.");
      logger.info("Filename: " + opdFile.getFullPath());
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
      createInitialNode(opd, name, isObject, isProcess, new Rectangle(200, 100, 300, 400));
      break;
    case UNFOLDED:
      createInitialNode(opd, name, isObject, isProcess, new Rectangle(200, 100, 100, 100));
      break;
    }
    resource.save(null);
  }

  /**
   * Create the first node of the diagram. Note that either
   * <code>isObject</code> or <code>isProcess</code> must be true, but not both
   * of them.
   * 
   * @param opd
   *          parent OPD where the node will be created.
   * @param name
   *          the name of the new node.
   * @param isObject
   *          <code>true</code> if the new node is an object, <code>false</code>
   *          otherwise.
   * @param isProcess
   *          <code>true</code> if the new node is an process,
   *          <code>false</code> otherwise.
   * @param constraints
   *          the desired constraints for the new node.
   */
  private void createInitialNode(OPMObjectProcessDiagram opd, String name, boolean isObject, boolean isProcess,
      Rectangle constraints) {
    Preconditions.checkArgument((isObject ^ isProcess),
        "Initial node must be either an Object or a Process. Found isProcess=" + isProcess + ", isObject=" + isObject);
    OPMNode node = null;
    if(isObject) {
      node = OPMFactory.eINSTANCE.createOPMObject();
    } else if(isProcess) {
      node = OPMFactory.eINSTANCE.createOPMProcess();
    }
    node.setId(1);
    ((OPMNamedElement) node).setName(name);
    node.setConstraints(constraints);
    opd.getNodes().add(node);
    opd.setLastKnownUsedId(2);
  }
}

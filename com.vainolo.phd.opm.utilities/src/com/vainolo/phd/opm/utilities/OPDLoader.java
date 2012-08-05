/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.utils.SimpleLoggerFactory;

public class OPDLoader {
  private static final Logger logger = SimpleLoggerFactory.createLogger(OPDLoader.class.getName());

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
      logger.warning("OPD File " + uri + " could not be loaded. Please check the path.");
      logger.fine("Exception thrown: " + e);
      opd = null;
    }

    return opd;
  }

  public static OPMObjectProcessDiagram createOPDFile(String uri, String opdName) {
    final ResourceSet resourceSet = new ResourceSetImpl();
    final Resource resource = resourceSet.createResource(URI.createURI(uri));
    OPMObjectProcessDiagram diagram = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    diagram.setName(opdName);
    resource.getContents().add(diagram);
    try {
      resource.save(null);
    } catch(IOException e) {
      logger.warning("Could not create OPD at location " + uri);
      logger.fine("Exception thrown: " + e);
      File f = new File(uri);
      if(f.exists()) {
        f.delete();
      }
      diagram = null;
    }

    return diagram;
  }
}

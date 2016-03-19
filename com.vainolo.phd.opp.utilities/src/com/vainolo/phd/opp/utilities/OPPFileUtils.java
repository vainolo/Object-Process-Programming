/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities;

import static com.vainolo.phd.opp.utilities.OPPLogger.logInfo;
import static com.vainolo.phd.opp.utilities.OPPLogger.logSevere;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagramKind;
import com.vainolo.phd.opp.model.OPPThing;

public class OPPFileUtils {

  public static OPPObjectProcessDiagram loadOPPFile(String oppFile) {
    OPPObjectProcessDiagram opd;
    ResourceSet resourceSet = new ResourceSetImpl();
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    Resource oppResource = resourceSet.createResource(URI.createURI(oppFile));
    try {
      oppResource.load(null);
      opd = (OPPObjectProcessDiagram) oppResource.getContents().get(0);
    } catch (final IOException e) {
      logSevere("OPD File " + oppFile + " could not be loaded. Please check the path.");
      logSevere("Exception thrown: " + e);
      opd = null;
    }

    return opd;
  }

  public static void createOPPFile(IFile opdFile, String name, OPPObjectProcessDiagramKind kind, boolean isObject, boolean isProcess) throws IOException {
    if (opdFile.exists()) {
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

    OPPThing initialThing;
    if (isObject) {
      initialThing = initializeThing(opd, OPPFactory.eINSTANCE.createOPPObject(), name);
    } else {
      initialThing = initializeThing(opd, OPPFactory.eINSTANCE.createOPPProcess(), name);
    }

    switch (kind) {
    case COMPOUND:
      // createInitialOPPProcessNode(opd, name);
      setConstraintsForInZoomedThing(initialThing);
      break;
    case UNFOLDED:
      // createInitialOPPObjectNode(opd, name);
      setConstraintsForUnfoldedThing(initialThing);
      break;
    case SYSTEM:
      break;
    }
    resource.save(null);
  }

  private static void setConstraintsForInZoomedThing(OPPThing thing) {
    thing.setConstraints(300, 100, 300, 400);
  }

  private static void setConstraintsForUnfoldedThing(OPPThing thing) {
    thing.setConstraints(300, 100, 100, 100);
  }

  private static OPPThing initializeThing(OPPObjectProcessDiagram opd, OPPThing thing, String name) {
    thing.setId(1);
    thing.setName(name);
    thing.setMain(true);
    opd.getNodes().add(thing);
    opd.setLastKnownUsedId(1);
    return thing;
  }
}

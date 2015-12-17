/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.utilities;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class OPPUtilitiesActivator implements BundleActivator {

  private static BundleContext context;

  static BundleContext getContext() {
    return context;
  }

  @Override
  public void start(BundleContext bundleContext) throws Exception {
    OPPUtilitiesActivator.context = bundleContext;
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception {
    OPPUtilitiesActivator.context = null;
  }

}

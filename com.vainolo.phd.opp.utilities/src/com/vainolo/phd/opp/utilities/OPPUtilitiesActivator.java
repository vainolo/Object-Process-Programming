/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
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

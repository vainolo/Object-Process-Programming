/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class OPLViewPart extends ViewPart {
  private Browser browser;

  public OPLViewPart() {
  }

  @Override
  public void createPartControl(Composite parent) {
    browser = new Browser(parent, SWT.NONE);
    browser.setText("hello world!");
  }

  @Override
  public void setFocus() {
    browser.setFocus();
  }
}

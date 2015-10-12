package com.vainolo.phd.opp.editor;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

  @Override
  public void createInitialLayout(IPageLayout layout) {
    // set a perspective programatically:
    // PlatformUI.getWorkbench().showPerspective("perspective.id",
    // PlatformUI.getWorkbench().getActiveWorkbenchWindow());
  }

}

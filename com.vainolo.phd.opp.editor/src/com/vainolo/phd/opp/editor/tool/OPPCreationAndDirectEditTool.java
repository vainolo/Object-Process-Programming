/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.vainolo.phd.opp.editor.tool;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.swt.widgets.Display;

public class OPPCreationAndDirectEditTool extends CreationTool {

  @Override
  protected void performCreation(int button) {
    super.performCreation(button);

    EditPartViewer viewer = getCurrentViewer();
    final Object model = getCreateRequest().getNewObject();
    if (model == null || viewer == null) {
      return;
    }

    final Object o = getCurrentViewer().getEditPartRegistry().get(model);
    if (o instanceof EditPart) {
      Display.getCurrent().asyncExec(() -> {
        EditPart part = (EditPart) o;
        Request request = new Request();
        request.setType(REQ_OPEN);
        part.performRequest(request);
      });
    }
  }
}

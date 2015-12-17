/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.action;

import org.eclipse.gef.Request;

import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;
import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.factory.OPPStateFactory;
import com.vainolo.phd.opp.editor.tool.OPPCreationAndDirectEditTool;

public class OPPCreateStateAction extends WorkbenchPartAction {

  public static final String ID = "CreateState";
  public static final String REQUEST = "CreateState";

  private final Request request;
  private CreationTool tool;

  public OPPCreateStateAction(IWorkbenchPart part) {
    super(part);
    request = new Request(REQUEST);
    setId(ID);
    setText("Create State");
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    tool = new OPPCreationAndDirectEditTool();
    tool.setFactory(new OPPStateFactory(editor.getIdManager()));
  }

  public Request getRequest() {
    return request;
  }

  @Override
  public void run() {
    OPPGraphicalEditor editor = (OPPGraphicalEditor) getWorkbenchPart();
    editor.getEditDomain().setActiveTool(tool);
  }

  @Override
  protected boolean calculateEnabled() {
    return true;
  }
}

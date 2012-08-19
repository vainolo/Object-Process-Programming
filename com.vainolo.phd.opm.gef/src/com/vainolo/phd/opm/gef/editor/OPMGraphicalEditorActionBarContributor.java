/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor;

import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;

import com.vainolo.phd.opm.gef.action.InterpretAction;
import com.vainolo.phd.opm.gef.action.StopInterpreterAction;

public class OPMGraphicalEditorActionBarContributor extends ActionBarContributor {

  @Override
  protected void buildActions() {
    addRetargetAction(new UndoRetargetAction());
    addRetargetAction(new RedoRetargetAction());
    addRetargetAction(new DeleteRetargetAction());
    addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, GEFMessages.ToggleGrid_Label,
        IAction.AS_CHECK_BOX));
    addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY,
        GEFMessages.ToggleSnapToGeometry_Label, IAction.AS_CHECK_BOX));
    addAction(new InterpretAction());
    addAction(new StopInterpreterAction());
  }

  @Override
  public void contributeToToolBar(IToolBarManager toolBarManager) {
    super.contributeToToolBar(toolBarManager);
    toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
    toolBarManager.add(getAction(ActionFactory.REDO.getId()));
    toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
    toolBarManager.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
    toolBarManager.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
    toolBarManager.add(getAction(InterpretAction.INTERPRET_ID));
    toolBarManager.add(getAction(StopInterpreterAction.STOP_INTERPRETER_ID));
  }

  @Override
  protected void declareGlobalActionKeys() {
    addGlobalActionKey(ActionFactory.SELECT_ALL.getId());
  }
}

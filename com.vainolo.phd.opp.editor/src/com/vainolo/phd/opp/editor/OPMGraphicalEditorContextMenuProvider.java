/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

import com.vainolo.phd.opp.editor.action.*;

public class OPMGraphicalEditorContextMenuProvider extends ContextMenuProvider {

  private ActionRegistry actionRegistry;

  public OPMGraphicalEditorContextMenuProvider(EditPartViewer viewer, final ActionRegistry actionRegistry) {
    super(viewer);
    setActionRegistry(actionRegistry);
  }

  @Override
  public void buildContextMenu(IMenuManager menu) {
    GEFActionConstants.addStandardActionGroups(menu);

    IAction action;

    action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
    menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
    action = getActionRegistry().getAction(ActionFactory.REDO.getId());
    menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
    action = getActionRegistry().getAction(OPMResizeToContentsAction.RESIZE_TO_CONTENTS_ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMToggledProceduralLinkSubkindAction.CONDITIONAL_SUBKIND_ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMToggledProceduralLinkSubkindAction.EVENT_SUBKIND_ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMToggledProceduralLinkSubkindAction.OPTIONAL_SUBKIND_ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMThingInZoomAction.THING_IN_ZOOM_ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMToggleThingMultiplicityAction.TOGGLE_MULTIPLICITY_ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMToggleStateValueAction.TOGGLE_VALUE_STATE_ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMCreateObjectAction.ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMCreateProcessAction.ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMCreateStateAction.ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMCreateConsumptionLinkAction.ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPMCreateResultLinkAction.ID);
    menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
  }

  private ActionRegistry getActionRegistry() {
    return actionRegistry;
  }

  private void setActionRegistry(final ActionRegistry actionRegistry) {
    this.actionRegistry = actionRegistry;
  }
}

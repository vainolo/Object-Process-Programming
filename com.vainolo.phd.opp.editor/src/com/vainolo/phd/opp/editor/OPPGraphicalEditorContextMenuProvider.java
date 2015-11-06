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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

import com.vainolo.phd.opp.editor.action.*;
import com.vainolo.phd.opp.editor.factory.OPPIdManager;

public class OPPGraphicalEditorContextMenuProvider extends ContextMenuProvider {

  private ActionRegistry actionRegistry;

  public OPPGraphicalEditorContextMenuProvider(EditPartViewer viewer, final ActionRegistry actionRegistry) {
    super(viewer);
    setActionRegistry(actionRegistry);
  }

  @Override
  public void buildContextMenu(IMenuManager menu) {
    GEFActionConstants.addStandardActionGroups(menu);

    IAction action;

    action = getActionRegistry().getAction(OPPToggledProceduralLinkSubkindAction.CONDITIONAL_SUBKIND_ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPPToggledProceduralLinkSubkindAction.EVENT_SUBKIND_ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPPToggledProceduralLinkSubkindAction.OPTIONAL_SUBKIND_ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPCreateObjectAction.ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPCreateProcessAction.ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPCreateStateAction.ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPCreateAgentLinkAction.ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPCreateInstrumentLinkAction.ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPCreateConsResLinkAction.ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPResizeToContentsAction.RESIZE_TO_CONTENTS_ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPToggleGlobalObjectAction.TOGGLE_GLOBALOBJECT_ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

    action = getActionRegistry().getAction(OPPThingInZoomAction.THING_IN_ZOOM_ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
    action = getActionRegistry().getAction(OPPThingUnfoldAction.THING_UNFOLD_ID);
    if (action.isEnabled())
      menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);

  }

  private ActionRegistry getActionRegistry() {
    return actionRegistry;
  }

  private void setActionRegistry(final ActionRegistry actionRegistry) {
    this.actionRegistry = actionRegistry;
  }
}

/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Create a context menu with undo and redo operations.
 * 
 * @author vainolo
 * 
 */
public class GEFEditorTemplateContextMenuProvider extends ContextMenuProvider {

	private ActionRegistry actionRegistry;

	/**
	 * Create a new menu provider for the given viewer and actionRegistry
	 * 
	 * @param viewer
	 *            the viewer which will use the menu
	 * @param actionRegistry
	 *            the registry from which the actions should be extracted
	 */
	public GEFEditorTemplateContextMenuProvider(EditPartViewer viewer, final ActionRegistry actionRegistry) {
		super(viewer);
		setActionRegistry(actionRegistry);
	}

	private ActionRegistry getActionRegistry() {
		return actionRegistry;
	}

	private void setActionRegistry(ActionRegistry actionRegistry) {
		this.actionRegistry = actionRegistry;
	}

	/**
	 * Build a context menu with undo and redo actions. This method is called
	 * every time before the menu is shown.
	 */
	@Override
	public void buildContextMenu(IMenuManager menu) {
		GEFActionConstants.addStandardActionGroups(menu);

		IAction action;

		action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
		action = getActionRegistry().getAction(ActionFactory.REDO.getId());
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
	}

}

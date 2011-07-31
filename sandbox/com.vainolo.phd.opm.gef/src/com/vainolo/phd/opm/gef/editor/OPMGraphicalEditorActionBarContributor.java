package com.vainolo.phd.opm.gef.editor;

// TODO remove access to this class if possible...
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.ui.actions.ActionBarContributor;
import org.eclipse.gef.ui.actions.DeleteRetargetAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoRetargetAction;
import org.eclipse.gef.ui.actions.UndoRetargetAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.RetargetAction;

public class OPMGraphicalEditorActionBarContributor extends ActionBarContributor {

	@Override
	protected void buildActions() {
		addRetargetAction(new UndoRetargetAction());
		addRetargetAction(new RedoRetargetAction());
		addRetargetAction(new DeleteRetargetAction());
		addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY, GEFMessages.ToggleGrid_Label, IAction.AS_CHECK_BOX));	
		addRetargetAction(new RetargetAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY, GEFMessages.ToggleSnapToGeometry_Label, IAction.AS_CHECK_BOX));
	}
	
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		toolBarManager.add(getAction(ActionFactory.UNDO.getId()));
		toolBarManager.add(getAction(ActionFactory.REDO.getId()));
		toolBarManager.add(getAction(ActionFactory.DELETE.getId()));
		toolBarManager.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
		toolBarManager.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));
	}
	
	@Override
	protected void declareGlobalActionKeys() {
		// Do nothing. This is an abstract function in the parent class.
	}
	
	@Override public void contributeToMenu(IMenuManager menuManager) {
	    super.contributeToMenu(menuManager);
	    MenuManager mnu = new MenuManager ("view");
	    mnu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
	    menuManager.insertAfter(IWorkbenchActionConstants.M_EDIT, mnu);	    
	}
}

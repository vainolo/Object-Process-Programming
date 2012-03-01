package com.vainolo.gef.template;

import java.util.EventObject;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ToggleGridAction;
import org.eclipse.gef.ui.actions.ToggleSnapToGeometryAction;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.ui.IEditorPart;

import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.part.TemplateEditPartFactory;

public class GEFEditorTemplate extends GraphicalEditorWithFlyoutPalette {

	Logger logger = Logger.getLogger(GEFEditorTemplate.class.getName());

	public GEFEditorTemplate() {
		setEditDomain(new DefaultEditDomain(this));
	}

	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getGraphicalViewer().setContents(new Canvas());
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		// Set your edit part factory here
		getGraphicalViewer().setEditPartFactory(new TemplateEditPartFactory());
		getActionRegistry().registerAction(new ToggleGridAction(getGraphicalViewer()));
		getActionRegistry().registerAction(new ToggleSnapToGeometryAction(getGraphicalViewer()));
		getGraphicalViewer().setContextMenu(
				new GEFEditorTemplateContextMenuProvider(getGraphicalViewer(), getActionRegistry()));
	}

	// This method should be used to save the editor contents without specifying
	// where is should be saved
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
	}

	// This method should be used when you want set the input to the editor
	/**
	 * @Override protected void setInput(IEditorInput input) { // TODO
	 *           Auto-generated method stub super.setInput(input); }
	 */

	@Override
	protected PaletteRoot getPaletteRoot() {
		return new GEFEditorTemplatePalette();
	}

	/**
	 * When the command stack changes we fire an {@link IEditorPart#PROP_DIRTY}
	 * property change so that the undo and redo can actions can calculate if
	 * they are enabled.
	 */
	@Override
	public void commandStackChanged(EventObject event) {
		firePropertyChange(PROP_DIRTY);
		super.commandStackChanged(event);
	}
}

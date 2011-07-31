package com.vainolo.phd.opm.gef.editor.part;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

import com.vainolo.phd.opm.gef.editor.figure.NamedNodeFigure;
import com.vainolo.phd.opm.gef.editor.policy.OPMThingDirectEditPolicy;
import com.vainolo.phd.opm.model.NamedElement;
import com.vainolo.phd.opm.model.Node;
import com.vainolo.phd.opm.model.OPMThing;

public abstract class OPMThingEditPart extends NodeEditPart {

	private OPMThingAdapter adapter;
	
	public OPMThingEditPart() {
		super();
		adapter = new OPMThingAdapter();
	}
	
	@Override protected void createEditPolicies() {
	    super.createEditPolicies();
	    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new OPMThingDirectEditPolicy());
	}

	@Override protected void refreshVisuals() {
		NamedNodeFigure figure = (NamedNodeFigure)getFigure();
		Node node = (Node)getModel();
		OPMObjectProcessDiagramEditPart parent = (OPMObjectProcessDiagramEditPart) getParent();
        parent.setLayoutConstraint(this, figure, node.getConstraints());

        NamedElement namedElement = (NamedElement) getModel();
		figure.getNameLabel().setText(namedElement.getName());
	}

	@Override public void activate() {
		if(!isActive()) {
			((OPMThing)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override public void deactivate() {
		if(isActive()) {
			((OPMThing)getModel()).eAdapters().remove(adapter);
		}

		super.deactivate();
	}
	
	@Override public void performRequest(Request req) {
		if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEditing();
		}
	}
	
	private void performDirectEditing() {
		Label label = ((NamedNodeFigure)getFigure()).getNameLabel();
		OPMThingDirectEditManager manager = new OPMThingDirectEditManager(this, TextCellEditor.class, new OPMThingCellEditorLocator(label), label);
		manager.show();
	}	
	
	class OPMThingAdapter implements Adapter {

		// Adapter interface
		@Override public void notifyChanged(Notification notification) {
			refreshVisuals();
            refreshChildren();
			refreshSourceConnections();
			refreshTargetConnections();
		}

		@Override public Notifier getTarget() {
			return (Notifier)getModel();
		}

		@Override public void setTarget(Notifier newTarget) {
			// Do nothing.
		}

		@Override public boolean isAdapterForType(Object type) {
			return type.equals(OPMThing.class);
		}
	}
	
	class OPMThingCellEditorLocator implements CellEditorLocator {

	    private Label nameLabel;
	    
	    public OPMThingCellEditorLocator(Label label) {
	        this.nameLabel = label;
	    }

	    @Override public void relocate(CellEditor celleditor) {
	        Text text = (Text) celleditor.getControl();
	        Point pref = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
	        Rectangle rect = nameLabel.getTextBounds().getCopy();
	        nameLabel.translateToAbsolute(rect);
	        text.setBounds(rect.x - 1, rect.y - 1, pref.x + 1, pref.y + 1);     
	    }
	}

	class OPMThingDirectEditManager extends DirectEditManager {

	    Label label;
	    
	    public OPMThingDirectEditManager(GraphicalEditPart source, @SuppressWarnings("rawtypes") Class editorType, CellEditorLocator locator, Label label) {
	        super(source, editorType, locator);
	        this.label = label;
	    }

	    @Override protected void initCellEditor() {
	        String initialLabelText = label.getText();
	        getCellEditor().setValue(initialLabelText);
	    }
	}
}
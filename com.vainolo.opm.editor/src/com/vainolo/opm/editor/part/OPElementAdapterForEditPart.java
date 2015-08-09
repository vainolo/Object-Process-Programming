package com.vainolo.opm.editor.part;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPart;

import com.vainolo.opm.model.opm.OPElement;

public class OPElementAdapterForEditPart implements Adapter {
	
	private EditPart part;

	public  OPElementAdapterForEditPart(EditPart part) {
		this.part = part;
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		part.refresh();
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void setTarget(Notifier newTarget) {

	}

	@Override
	public boolean isAdapterForType(Object type) {
		return OPElement.class.isInstance(type);
	}

}

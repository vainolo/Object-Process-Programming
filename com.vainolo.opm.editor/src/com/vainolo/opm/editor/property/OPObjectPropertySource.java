package com.vainolo.opm.editor.property;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.vainolo.opm.model.OPObject;

public class OPObjectPropertySource implements IPropertySource {

	private OPObject object;

	public OPObjectPropertySource(OPObject object) {
		this.object = object;
	}
	
	@Override
	public Object getEditableValue() {
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		TextPropertyDescriptor text = new TextPropertyDescriptor(0, "Name");
		return new IPropertyDescriptor[] { text };
	}

	@Override
	public Object getPropertyValue(Object id) {
		return object.getName();
	}

	@Override
	public boolean isPropertySet(Object id) {
		return true;
	}

	@Override
	public void resetPropertyValue(Object id) {
		object.setName("");
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		object.setName((String) value);
	}
}
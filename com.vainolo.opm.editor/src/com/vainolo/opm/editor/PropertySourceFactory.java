package com.vainolo.opm.editor;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.vainolo.opm.editor.part.OPObjectEditPart;
import com.vainolo.opm.model.OPObject;

public class PropertySourceFactory {

	public static IPropertySource getPropertySource(Object object) {
		if(object instanceof OPObjectEditPart) {
			return new OPObjectPropertySource((OPObject) ((OPObjectEditPart) object).getModel());
		}
		return null;
	}
	
	public static class OPObjectPropertySource implements IPropertySource {

		private OPObject object;

		public OPObjectPropertySource(OPObject object) {
			this.object = object;
		}
		
		public Object getEditableValue() {
			return null;
		}

		public IPropertyDescriptor[] getPropertyDescriptors() {
			TextPropertyDescriptor text = new TextPropertyDescriptor(0, "Name");
			return new IPropertyDescriptor[] { text };
		}

		public Object getPropertyValue(Object id) {
			return object.getName();
		}

		public boolean isPropertySet(Object id) {
			return true;
		}

		public void resetPropertyValue(Object id) {
			object.setName("");
		}

		public void setPropertyValue(Object id, Object value) {
			object.setName((String) value);
		}
		
	}
}

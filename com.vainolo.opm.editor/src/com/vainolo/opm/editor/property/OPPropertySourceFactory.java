package com.vainolo.opm.editor.property;

import org.eclipse.ui.views.properties.IPropertySource;

import com.vainolo.opm.editor.part.OPObjectEditPart;
import com.vainolo.opm.model.OPObject;

public class OPPropertySourceFactory {

	public static IPropertySource getPropertySource(Object object) {
		if(object instanceof OPObjectEditPart) {
			return new OPObjectPropertySource((OPObject) ((OPObjectEditPart) object).getModel());
		}
		return null;
	}
}

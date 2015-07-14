package com.vainolo.opm.editor.navigator;


import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.vainolo.opm.editor.OPEditorPlugin;

public class OPLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		OPEditorPlugin.INSTANCE.log("LabelProvider.addListener:"+listener);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		OPEditorPlugin.INSTANCE.log("isLabelProperty:"+element+", "+property);
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		OPEditorPlugin.INSTANCE.log("removeListener:"+listener);
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		OPEditorPlugin.INSTANCE.log("getText:");
		return null;
	}

}

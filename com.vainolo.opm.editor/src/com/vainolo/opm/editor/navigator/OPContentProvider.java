package com.vainolo.opm.editor.navigator;


import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.vainolo.opm.editor.OPEditorPlugin;

public class OPContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		OPEditorPlugin.INSTANCE.log("Viewer: "+viewer+", old:"+oldInput+", new:"+newInput);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		OPEditorPlugin.INSTANCE.log("getElements:"+inputElement);
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		OPEditorPlugin.INSTANCE.log("getChildren: "+parentElement);
		return null;
	}

	@Override
	public Object getParent(Object element) {
		OPEditorPlugin.INSTANCE.log("getParent"+element);
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		OPEditorPlugin.INSTANCE.log("hasChildren"+element);
		return false;
	}

}

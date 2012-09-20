/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opm.gef.editor.tool;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.swt.widgets.Display;

public class CreationAndDirectEditTool extends CreationTool {

	@Override protected void performCreation(int button) {
		super.performCreation(button);
		
		EditPartViewer viewer = getCurrentViewer();
		final Object model = getCreateRequest().getNewObject();
		if (model == null || viewer == null) {
			return;
		}
		
		final Object o = getCurrentViewer().getEditPartRegistry().get(model);
		if(o instanceof EditPart) {
			Display.getCurrent().asyncExec(new Runnable() {
				
				@Override public void run() {
					EditPart part = (EditPart)o;
					Request request = new DirectEditRequest();
					part.performRequest(request);
				}
			});
		}
	}
}

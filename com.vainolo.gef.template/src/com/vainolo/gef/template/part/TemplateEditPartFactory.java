/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.gef.template.part;

import java.util.logging.Logger;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.model.Node;

/**
 * Factory class to create edit parts depending on the provided model class.
 * 
 * @author vainolo
 * 
 */
public class TemplateEditPartFactory implements EditPartFactory {
	private final Logger logger = Logger.getLogger(TemplateEditPartFactory.class.getName());

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if (model.getClass().equals(Node.class)) {
			return new NodeEditPart((Node) model);
		} else if (model.getClass().equals(Canvas.class)) {
			return new CanvasEditPart((Canvas) model);
		} else {
			logger.warning("Class " + model.getClass() + " of model argument is not supported by factory");
			return null;
		}
	}
}

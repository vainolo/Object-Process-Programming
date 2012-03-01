package com.vainolo.gef.template.part;

import java.util.logging.Logger;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import com.vainolo.gef.template.model.Canvas;
import com.vainolo.gef.template.model.Node;

public class TemplateEditPartFactory implements EditPartFactory {
	Logger logger = Logger.getLogger(TemplateEditPartFactory.class.getName());

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

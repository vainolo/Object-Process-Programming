package tests.part;

import org.eclipse.gef.EditPart;

import tests.model.Canvas;
import tests.model.Link;
import tests.model.Node;

public class EditPartFactory implements org.eclipse.gef.EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if(model instanceof Node) {
			part = new MyNodeEditPart();
		} else if(model instanceof Canvas) {
			part = new CanvasEditPart();
		} else if(model instanceof Link) {
			part = new LinkEditPart();
		} else {
			throw new IllegalArgumentException("Model type "+model.getClass()+" not supported.");
		}
		
		if(part != null) {
			part.setModel(model);
		}
		
		return part;

	}

}

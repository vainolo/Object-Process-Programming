package tests.part;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

public class LinkEditPart extends AbstractConnectionEditPart {

    @Override
    protected void createEditPolicies() {

    }

    @Override
    protected IFigure createFigure() {
        Connection conn = (Connection) super.createFigure();
        if(getSource().getParent() instanceof MyNodeEditPart) {
            MyNodeEditPart parent = (MyNodeEditPart) getSource().getParent();
            conn.setConnectionRouter(new ShortestPathConnectionRouter(parent.getFigure()));
        }
        return conn;
    }

}

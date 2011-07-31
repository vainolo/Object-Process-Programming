package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMStateFigure extends Figure implements NamedNodeFigure {

    private ConnectionAnchor connectionAnchor;
    private RoundedRectangle rectangle;
    private Label nameLabel;

    public OPMStateFigure() {
        setLayoutManager(new XYLayout());
        rectangle = new RoundedRectangle();
        add(rectangle);
        nameLabel = new Label();
        add(nameLabel);
        setForegroundColor(ColorConstants.darkGray);
        setBackgroundColor(ColorConstants.lightGray);
        setBorder(new LineBorder(1));
        setOpaque(false);
    }
    
    @Override protected void paintFigure(Graphics graphics) {
        System.out.println("State paint figure.");
        System.out.println("Bounds: "+getBounds());
        Rectangle r = getBounds().getCopy();
        setConstraint(rectangle, new Rectangle(0, 0, r.width, r.height));
        setConstraint(nameLabel, new Rectangle(0, 0, r.width, r.height));
        nameLabel.invalidate();     
        rectangle.invalidate();
    }    
    
    private ConnectionAnchor getConnectionAnchor() {
        if (connectionAnchor == null) {
            connectionAnchor = new ChopboxAnchor(this);
        }
        return connectionAnchor;
    }
    
    @Override public ConnectionAnchor getSourceConnectionAnchor() {
        return getConnectionAnchor();
    }

    @Override public ConnectionAnchor getTargetConnectionAnchor() {
        return getConnectionAnchor();
    }

    @Override public Label getNameLabel() {
        return nameLabel;
    }
}

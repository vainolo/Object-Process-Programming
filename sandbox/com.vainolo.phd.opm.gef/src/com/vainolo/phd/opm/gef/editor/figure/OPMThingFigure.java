package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public abstract class OPMThingFigure extends Figure implements OPMNodeFigure {

    private final Label nameLabel;
    private final TooltipFigure tooltipFigure;

    /**
     * The figure on which this figure's childs should be added
     * instead of adding them directory.
     * @return a figure on which child figures can be added.
     */
    abstract public IFigure getContentPane();

    public OPMThingFigure() {
        setLayoutManager(new XYLayout());
        nameLabel = new Label();
        add(nameLabel);
        tooltipFigure = new TooltipFigure(); 
    }

    /**
     * Get the name {@link Label} of the figure.
     * @return the name {@link Label} of the figure.
     */
    public Label getNameLabel() {
        return nameLabel;
    }    

    public void setTooltipText(String tooltipText) {
        if(tooltipText != null && tooltipText != "") {
            tooltipFigure.setMessage(tooltipText);
            setToolTip(tooltipFigure);
        } else {
            setToolTip(null);
        }
    }

    @Override
    protected final boolean useLocalCoordinates() {
        return true;
    }    

    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        Dimension d = new Dimension();
        Rectangle textRectangle = getNameLabel().getTextBounds().getCopy();
        d.width = textRectangle.width;
        d.height = textRectangle.height;
        return d;
    }
}

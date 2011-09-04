package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;

public abstract class OPMThingFigure extends Figure implements OPMNodeFigure {
    
    private Label nameLabel;
    private TooltipFigure tooltipFigure;
    
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
        setToolTip(tooltipFigure);
    }
    
    /**
     * Get the name {@link Label} of the figure.
     * @return the name {@link Label} of the figure.
     */
    public Label getNameLabel() {
        return nameLabel;
    }    
    
    public void setTooltipText(String tooltipText) {
        tooltipFigure.setMessage(tooltipText);
    }
    
    protected final boolean useLocalCoordinates() {
        return true;
    }    
}

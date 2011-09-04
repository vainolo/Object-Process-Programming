package com.vainolo.phd.opm.gef.editor.figure;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;

public abstract class OPMThingFigure extends Figure implements OPMNodeFigure {
    
    private static final Border TOOLTIP_BORDER = new MarginBorder(0, 2, 1, 0);
    
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
    
    private class TooltipFigure extends FlowPage {
        private TextFlow message;
        
        public TooltipFigure() {
            setOpaque(true);
            message = new TextFlow();
            message.setText("");
            add(message);
        }
        
        @Override
        public Dimension getPreferredSize(int w, int h) {
            Dimension d = super.getPreferredSize(-1, -1);
            if (d.width > 150)
                d = super.getPreferredSize(150, -1);
            return d;
        }
        
        public void setMessage(String txt) {
            message.setText(txt);
            revalidate();
            repaint();
        }
    }
    
    protected IFigure createToolTip() {
        String message = "";
        if (message == null || message.length() == 0)
            return null;

        FlowPage fp = new FlowPage() {
            public Dimension getPreferredSize(int w, int h) {
                Dimension d = super.getPreferredSize(-1, -1);
                if (d.width > 150)
                    d = super.getPreferredSize(150, -1);
                return d;
            }
        };
        fp.setOpaque(true);
        fp.setBorder(TOOLTIP_BORDER);
        TextFlow tf = new TextFlow();
        tf.setText(message);
        fp.add(tf);
        return fp;
    }    

    protected final boolean useLocalCoordinates() {
        return true;
    }    
}

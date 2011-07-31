package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMProceduralLink;

/**
 * Command used to create a new bendpoint in an {@linkplain OPMProceduralLink}.
 * This class is declared final since it has a very specific functionality.
 *  * @author vainolo
 *
 */
public final class OPMProceduralLinkCreateBendpointCommand extends Command {

    /** Index on which the new bendpoint is added. */
    private int index;
    /** Location of new bendpoint. */
    private Point location;
    /** Link to which the bendpoint is added. */
    private OPMProceduralLink link;

    @Override public void execute() {
        link.getBendpoints().add(index, location);
    }

    @Override public void undo() {
        link.getBendpoints().remove(index);
    }

    /**
     * Set the index on which the bendpoint is added.
     * @param indexParam Index on which the bendpoint should be added.
     */
    public void setIndex(final int indexParam) {
        this.index = indexParam;
        //TODO:validation checks.
    }

    /**
     * Set the location where the new bendpoint is added.
     * @param locationParam point in the diagram where the new bendpoint
     * is added.
     */
    public void setLocation(final Point locationParam) {
        this.location = locationParam;
    }

    /**
     * Set the procedural link on which the new bendpoint is added.
     * @param linkParam link on which the bendpoint is added.
     */
    public void setOPMProceduralLink(final OPMProceduralLink linkParam) {
        this.link = linkParam;
    }
}

package com.vainolo.phd.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMThing;

/**
 * Command used to delete a procedural link.
 * @author vainolo
 */
public final class LinkDeleteCommand extends Command {
    /** Link to be deleted. */
    private OPMProceduralLink link;
    /** OPD that owns the link. */
    private OPMObjectProcessDiagram opd;
    /** Source of the link. */
    private OPMThing source;
    /** Target of the link. */
    private OPMThing target;

    /**
     * {@inheritDoc}
     */
    @Override public boolean canExecute() {
        return link != null;
    }

    /**
     * Disconnect link from source and target things and remove
     * from owner OPD.
     */
    @Override public void execute() {
        opd = link.getOpd();
        source = (OPMThing) link.getSource();
        target = (OPMThing) link.getTarget();

        link.setSource(null);
        link.setTarget(null);
        link.setOpd(null);
    }

    /**
     * Reconnect the link to the source and target and add
     * it to the owner OPD.
     */
    @Override public void undo() {
        link.setSource(source);
        link.setTarget(target);
        link.setOpd(opd);
    }

    /**
     * Set the link that will be delete from the diagram.
     * @param linkParam the link to delete from the diagram.
     */
    public void setLink(final OPMProceduralLink linkParam) {
        link = linkParam;
    }
}

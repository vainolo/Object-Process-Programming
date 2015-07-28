package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;
import static com.vainolo.opm.model.util.OPModelUtils.*;

import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;

public class OPCreateProceduralLinkCommand extends Command {

	private OPNodeView source;
	private OPNodeView target;
	private OPLinkView link;

	public void setSource(OPNodeView source) {
		this.source = source;
	}
	
	public void setTarget(OPNodeView target) {
		this.target = target;
	}
	
	public void setLink(OPLinkView link) {
		this.link = link;
	}
	
	@Override
	public void execute() {
		link.setSource(source);
		link.setTarget(target);
		link.setViewElementContainer(getObjectProcessDiagram(source));
	}
	
	@Override
	public void undo() {
		link.setSource(null);
		link.setTarget(null);
		link.setObjectProcessDiagram(null);
	}
	
	@Override
	public boolean canExecute() {
		return  (source != null) && 
				(target != null) &&
				(link != null) &&
				(source != target);
	}
	
}

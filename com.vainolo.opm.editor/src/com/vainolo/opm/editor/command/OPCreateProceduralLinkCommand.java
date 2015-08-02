package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import static com.vainolo.opm.model.util.OPModelUtils.*;

import com.vainolo.opm.model.OPObject;
import com.vainolo.opm.model.OPProceduralLink;
import com.vainolo.opm.model.OPProcess;
import com.vainolo.opm.model.OPState;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;
import com.vainolo.opm.model.view.OPProceduralLinkView;

public class OPCreateProceduralLinkCommand extends Command {

	private OPNodeView source;
	private OPNodeView target;
	private OPProceduralLinkView link;

	public void setSource(OPNodeView source) {
		this.source = source;
	}
	
	public void setTarget(OPNodeView target) {
		this.target = target;
	}
	
	public void setLink(OPProceduralLinkView link) {
		this.link = link;
	}
	
	@Override
	public void execute() {
		link.setSource(source);
		link.setTarget(target);
		link.setViewElementContainer(getObjectProcessDiagram(source));
		link.getElementViewContainer().addElementView(link);
	}
	
	@Override
	public void undo() {
		link.setSource(null);
		link.setTarget(null);
		link.getElementViewContainer().removeElementView(link);
		link.setViewElementContainer(null);
	}
	
	@Override
	public boolean canExecute() {
		if(source == null || target == null || link == null)
			return false;
		if(source == target)
			return false;
		OPProceduralLink model = (OPProceduralLink) link.getModel();
		switch(model.getKind()) {
		case AGENT:
		case INSTRUMENT:
		case CONSUMPTION:
			if(!OPObject.class.isInstance(source.getModel()) && !OPState.class.isInstance(source.getModel()))
				return false;
			if(!OPProcess.class.isInstance(target.getModel()))
				return false;
			break;
		case RESULT:
			if(!OPProcess.class.isInstance(source.getModel()))
				return false;
			if(!OPObject.class.isInstance(target.getModel()) && !OPState.class.isInstance(target.getModel()))
				return false;
			break;
		}
		return true;
				
	}
	
}

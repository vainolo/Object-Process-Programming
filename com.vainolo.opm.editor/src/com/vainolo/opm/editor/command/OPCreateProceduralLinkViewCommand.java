package com.vainolo.opm.editor.command;

import org.eclipse.gef.commands.Command;

import com.vainolo.opm.model.opm.OPNodeView;
import com.vainolo.opm.model.opm.OPObject;
import com.vainolo.opm.model.opm.OPProceduralLink;
import com.vainolo.opm.model.opm.OPProceduralLinkView;
import com.vainolo.opm.model.opm.OPProcess;
import com.vainolo.opm.model.opm.OPState;

public class OPCreateProceduralLinkViewCommand extends Command {

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
		link.setOpd(source.getOpd());
		link.getModel().setSystem(source.getModel().getSystem());
	}
	
	@Override
	public void undo() {
		link.setSource(null);
		link.setTarget(null);
		link.setOpd(null);
		link.getModel().setSystem(null);
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

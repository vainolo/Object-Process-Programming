package com.vainolo.opm.model.view.impl;

import com.vainolo.opm.model.OPLink;
import com.vainolo.opm.model.OPModelObserver;
import com.vainolo.opm.model.OPObjectProcessDiagram;
import com.vainolo.opm.model.view.OPLinkView;
import com.vainolo.opm.model.view.OPNodeView;

public class OPLinkViewImpl extends OPAbstractElementView implements OPLinkView {

	private OPLink model;
	private OPNodeView source;
	private OPNodeView target;
	private OPObjectProcessDiagram opd;

	public OPLinkViewImpl(int id) {
		super(id);
	}

	@Override
	public OPLink getModel() {
		return model;
	}

	@Override
	public void setModel(OPLink model) {
		if(this.model != null) {
			for(OPModelObserver observer:getObservers()) {
				this.model.removeObserver(observer);
			}
		}
		this.model = model;
		if(this.model != null) {
			for(OPModelObserver observer : getObservers()) {
				model.addObserver(observer);
			}
		}
		notifyObservers();
	}

	@Override
	public OPNodeView getSource() {
		return source;
	}

	@Override
	public void setSource(OPNodeView source) {
		if(source == null) {
			this.source.removeLink(this);
		}
		this.source = source;
		if(source != null)
			source.addLink(this);
		notifyObservers();
	}

	@Override
	public OPNodeView getTarget() {
		return target;
	}

	@Override
	public void setTarget(OPNodeView target) {
		if(target == null) {
			this.target.removeLink(this);
		}
		this.target = target;
		if(target != null)
			target.addLink(this);
		notifyObservers();
	}
}

package com.vainolo.opm.model.impl;

import com.vainolo.opm.model.OPNode;
import com.vainolo.opm.model.OPLink;

public abstract class OPAbstractLink extends OPAbstractElement implements OPLink {

	private OPNode source;
	private OPNode target;

	public OPAbstractLink(int id) {
		super(id);
	}

	@Override
	public OPNode getSource() {
		return source;
	}

	@Override
	public void setSource(OPNode source) {
		if(this.source != null) {
			this.source.removeLink(this);
		}
		this.source = source;
		if(source != null) {
			source.addLink(this);
		}
		notifyObservers();
	}

	@Override
	public OPNode getTarget() {
		return target;
	}

	@Override
	public void setTarget(OPNode target) {
		if(this.target != null) {
			this.target.removeLink(this);
		}
		this.target = target;
		if(target != null) {
			target.addLink(this);
		}
		notifyObservers();
	}
}

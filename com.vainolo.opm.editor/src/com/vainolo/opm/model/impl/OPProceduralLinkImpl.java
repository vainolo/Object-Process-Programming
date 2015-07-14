package com.vainolo.opm.model.impl;

import com.vainolo.opm.model.OPProceduralLink;
import com.vainolo.opm.model.OPProceduralLinkKind;

public class OPProceduralLinkImpl extends OPAbstractLink implements OPProceduralLink {

	private OPProceduralLinkKind kind;

	public OPProceduralLinkImpl(int id) {
		super(id);
	}

	@Override
	public OPProceduralLinkKind getKind() {
		return kind;
	}

	@Override
	public void setKind(OPProceduralLinkKind kind) {
		this.kind = kind;
		notifyObservers();
	}

}

package com.vainolo.opm.model.impl;

import com.vainolo.opm.model.OPStructuralLink;
import com.vainolo.opm.model.OPStructuralLinkKind;

public class OPStructuralLinkImpl extends OPAbstractLinkImpl implements OPStructuralLink {

	public OPStructuralLinkImpl(int id) {
		super(id);
	}

	private OPStructuralLinkKind kind;

	@Override
	public OPStructuralLinkKind getKind() {
		return kind;
	}

	@Override
	public void setKind(OPStructuralLinkKind kind) {
		this.kind = kind;
	}

}

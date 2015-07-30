package com.vainolo.opm.model;

public interface OPStructuralLink extends OPLink {
	OPStructuralLinkKind getKind();
	void setKind(OPStructuralLinkKind kind);
}

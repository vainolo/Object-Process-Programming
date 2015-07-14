package com.vainolo.opm.model;

public interface OPProceduralLink extends OPLink {
	OPProceduralLinkKind getKind();
	void setKind(OPProceduralLinkKind kind);
}

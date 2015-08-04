package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPProceduralLink;
import com.vainolo.opm.model.opm.OPProceduralLinkKind;
import com.vainolo.opm.model.opm.OPProceduralLinkView;

public class OPProceduralLinkViewFactory implements CreationFactory {

	private OPProceduralLinkKind kind;
	private OPFactory factory;
	
	public OPProceduralLinkViewFactory(OPFactory factory, OPProceduralLinkKind kind) {
		this.factory = factory;
		this.kind = kind;
	}

	@Override
	public Object getNewObject() {
		OPProceduralLinkView view = factory.createOPProceduralLinkView();
		OPProceduralLink model = factory.createOPProceduralLink();
		model.setKind(kind);
		view.setModel(model);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPProceduralLinkView.class;
	}

}

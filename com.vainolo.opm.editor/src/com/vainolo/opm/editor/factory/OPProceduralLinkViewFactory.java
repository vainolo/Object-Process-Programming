package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPProceduralLink;
import com.vainolo.opm.model.opm.OPProceduralLinkKind;
import com.vainolo.opm.model.opm.OPProceduralLinkView;

public class OPProceduralLinkViewFactory implements CreationFactory {

	private OPProceduralLinkKind kind;
	
	public OPProceduralLinkViewFactory(OPProceduralLinkKind kind) {
		this.kind = kind;
	}

	@Override
	public Object getNewObject() {
		OPProceduralLinkView view = OPFactory.eINSTANCE.createOPProceduralLinkView();
		OPProceduralLink model = OPFactory.eINSTANCE.createOPProceduralLink();
		model.setKind(kind);
		view.setModel(model);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPProceduralLinkView.class;
	}
}

package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.OPLinkView;
import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPProceduralLink;
import com.vainolo.opm.model.OPProceduralLinkKind;

public class OPProceduralLinkViewFactory implements CreationFactory {

	private OPProceduralLinkKind kind;
	
	public OPProceduralLinkViewFactory(OPProceduralLinkKind kind) {
		this.kind = kind;
	}

	@Override
	public Object getNewObject() {
		OPLinkView view = OPModelFactory.createLinkView();
		OPProceduralLink model = OPModelFactory.createProceduralLink();
		model.setKind(kind);
		view.setModel(model);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPLinkView.class;
	}

}

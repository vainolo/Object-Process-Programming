package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.OPModelFactory;
import com.vainolo.opm.model.OPProceduralLink;
import com.vainolo.opm.model.OPProceduralLinkKind;
import com.vainolo.opm.model.view.OPLinkView;

public class OPProceduralLinkViewFactory implements CreationFactory {

	private OPProceduralLinkKind kind;
	private OPModelFactory factory;
	
	public OPProceduralLinkViewFactory(OPModelFactory factory, OPProceduralLinkKind kind) {
		this.factory = factory;
		this.kind = kind;
	}

	@Override
	public Object getNewObject() {
		OPLinkView view = factory.createProceduralLinkView();
		OPProceduralLink model = factory.createProceduralLink();
		model.setKind(kind);
		view.setModel(model);
		return view;
	}

	@Override
	public Object getObjectType() {
		return OPLinkView.class;
	}

}

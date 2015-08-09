package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPStructuralLinkAggregatorView;
import com.vainolo.opm.model.opm.OPStructuralLinkKind;

public class OPStructuralLinkViewFactory implements CreationFactory {

	private OPStructuralLinkKind kind;

	public OPStructuralLinkViewFactory(OPStructuralLinkKind kind) {
		this.kind = kind;
	}

	@Override
	public Object getNewObject() {
		OPStructuralLinkAggregatorView aggregator = OPFactory.eINSTANCE.createOPStructuralLinkAggregatorView();
		aggregator.setKind(kind);	
		return aggregator;
	}

	@Override
	public Object getObjectType() {
		return OPStructuralLinkAggregatorView.class;
	}

}

package com.vainolo.opm.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.opm.model.opm.OPFactory;
import com.vainolo.opm.model.opm.OPProceduralLinkView;
import com.vainolo.opm.model.opm.OPStructuralLinkPartView;

public class OPStructuralLinkPartViewFactory implements CreationFactory {

		@Override
		public Object getNewObject() {
			OPStructuralLinkPartView view = OPFactory.eINSTANCE.createOPStructuralLinkPartView();
			return view;
		}

		@Override
		public Object getObjectType() {
			return OPProceduralLinkView.class;
		}

}

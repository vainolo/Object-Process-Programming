/*******************************************************************************
 * This is me!!!
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregator;
import com.vainolo.phd.opm.model.OPMStructuralLinkAggregatorKind;

/**
 * Factory used by palette tools to create {@link OPMStructuralLinkAggregator} of
 * {@link OPMStructuralLinkAggregatorKind#GENERALIZATION} kind.
 * 
 * @author vainolo
 * 
 */
public class OPMGeneralizationStructuralLinkAggregatorFactory implements CreationFactory {

  @Override
  public Object getNewObject() {
    OPMStructuralLinkAggregator aggregator = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
    aggregator.setKind(OPMStructuralLinkAggregatorKind.GENERALIZATION);
    aggregator.setId(OPMIdManager.getNextId());
    return aggregator;
  }

  @Override
  public Object getObjectType() {
    return OPMStructuralLinkAggregator.class;
  }

}

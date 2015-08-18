/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregator;
import com.vainolo.phd.opp.model.OPPStructuralLinkAggregatorKind;

/**
 * Factory used by palette tools to create {@link OPMStructuralLinkAggregator}
 * of {@link OPMStructuralLinkAggregatorKind#AGGREGATION} kind.
 * 
 * @author vainolo
 * 
 */
public class OPPAggregationStructuralLinkAggregatorFactory implements CreationFactory {

  private OPPIdManager idManager;

  public OPPAggregationStructuralLinkAggregatorFactory(OPPIdManager idManager) {
    this.idManager = idManager;
  }

  @Override
  public Object getNewObject() {
    OPPStructuralLinkAggregator aggregator = OPPFactory.eINSTANCE.createOPPStructuralLinkAggregator();
    aggregator.setKind(OPPStructuralLinkAggregatorKind.AGGREGATION);
    aggregator.setId(idManager.getNextId());
    return aggregator;
  }

  @Override
  public Object getObjectType() {
    return OPPStructuralLinkAggregator.class;
  }

}

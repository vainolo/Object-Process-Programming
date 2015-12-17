/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opm.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMState;

/**
 * Unit tests for the {@link OPMLinkValidator} class.
 * 
 * @author t-arib
 * 
 */
public class OPMLinkValidatorTest {
  OPMLinkValidator validator;
  OPMNode object;
  OPMNode process;
  OPMNode target;
  OPMLink link;
  private OPMState state;

  private OPMLink createProceduralLink(OPMProceduralLinkKind kind) {
    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(kind);
    return link;
  }

  @Test
  public void testValidateSource_ObjectSource_ConsumptionLink() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateAddSource(object, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ObjectSource_InstrumentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateAddSource(object, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ObjectSource_AgentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateAddSource(object, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ObjectSource_ResultLink() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateAddSource(object, link);
    assertFalse(result);
  }

  @Test
  public void testValidateSource_ObjectSource_EffectLink() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateAddSource(object, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ObjectSource_InvocationLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateAddSource(object, link);
    assertFalse(result);
  }

  @Test
  public void testValidateSource_ProcessSource_ConsumptionLink() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateAddSource(process, link);
    assertFalse(result);
  }

  @Test
  public void testValidateSource_ProcessSource_InstrumentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateAddSource(process, link);
    assertFalse(result);
  }

  @Test
  public void testValidateSource_ProcessSource_AgentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateAddSource(process, link);
    assertFalse(result);
  }

  @Test
  public void testValidateSource_ProcessSource_ResultLink() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateAddSource(process, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ProcessSource_EffectLink() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateAddSource(process, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ProcessSource_InvocationLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateAddSource(process, link);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_ConsumptionLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateAddTarget(link, object);
    assertFalse(result);
  }

  @Test
  public void testValidateTarget_InstrumentLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateAddTarget(link, object);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_AgentLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateAddTarget(link, object);
    assertFalse(result);
  }

  @Test
  public void testValidateTarget_ResultLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateAddTarget(link, object);
    assertFalse(result);
  }

  @Test
  public void testValidateTarget_EffectLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateAddTarget(link, object);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_InvocationLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateAddTarget(link, object);
    assertFalse(result);
  }

  @Test
  public void testValidateTarget_ConsumptionLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateAddTarget(link, process);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_InstrumentLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateAddTarget(link, process);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_AgentLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateAddTarget(link, process);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_ResultLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateAddTarget(link, process);
    assertFalse(result);
  }

  @Test
  public void testValidateTarget_EffectLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateAddTarget(link, process);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_InvocationLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateAddTarget(link, process);
    assertTrue(result);
  }

  @Test
  public void testValudateSource_AgentLink_StateSource() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateAddSource(state, link);
    assertTrue(result);
  }

  @Test
  public void testValudateSource_InstrumentLink_StateSource() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateAddSource(state, link);
    assertTrue(result);
  }

  @Test
  public void testValudateSource_ConsumptionLink_StateSource() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateAddSource(state, link);
    assertTrue(result);
  }

  @Before
  public void setUp() {
    validator = new OPMLinkValidator();
    object = OPMFactory.eINSTANCE.createOPMObject();
    process = OPMFactory.eINSTANCE.createOPMProcess();
    state = OPMFactory.eINSTANCE.createOPMState();
  }
}

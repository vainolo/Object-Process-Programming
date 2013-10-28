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

/**
 * Unit tests for the {@link OPMLinkValidator} class.
 * @author t-arib
 *
 */
public class OPMLinkValidatorTest {
  OPMLinkValidator validator;
  OPMNode object;
  OPMNode process;
  OPMNode target;
  OPMLink link;
  
  private OPMLink createProceduralLink(OPMProceduralLinkKind kind) {
    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(kind);
    return link;
  }
  
  @Test
  public void testValidateSource_ObjectSource_ConsumptionLink() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateSource(object, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_InstrumentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateSource(object, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_AgentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateSource(object, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_ResultLink() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateSource(object, link);
    assertEquals(false, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_EffectLink() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateSource(object, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_InvocationLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateSource(object, link);
    assertEquals(false, result);
  }

  @Test
  public void testValidateSource_ProcessSource_ConsumptionLink() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateSource(process, link);
    assertEquals(false, result);
  }
  
  @Test
  public void testValidateSource_ProcessSource_InstrumentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateSource(process, link);
    assertEquals(false, result);
  }

  @Test
  public void testValidateSource_ProcessSource_AgentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateSource(process, link);
    assertEquals(false, result);
  }

  @Test
  public void testValidateSource_ProcessSource_ResultLink() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateSource(process, link);
    assertEquals(true, result);
  }

  @Test
  public void testValidateSource_ProcessSource_EffectLink() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateSource(process, link);
    assertEquals(true, result);
  }
  @Test
  public void testValidateSource_ProcessSource_InvocationLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateSource(process, link);
    assertEquals(true, result);
  }

  @Test
  public void testValidateTarget_ConsumptionLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateTarget(link, object);
    assertEquals(false, result);
  }

  @Test
  public void testValidateTarget_InstrumentLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateTarget(link, object);
    assertEquals(false, result);
  }

  @Test
  public void testValidateTarget_AgentLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateTarget(link, object);
    assertEquals(false, result);
  }

  @Test
  public void testValidateTarget_ResultLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateTarget(link, object);
    assertEquals(true, result);
  }

  @Test
  public void testValidateTarget_EffectLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateTarget(link, object);
    assertEquals(true, result);
  }

  @Test
  public void testValidateTarget_InvocationLink_ObjectTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateTarget(link, object);
    assertEquals(false, result);
  }

  @Test
  public void testValidateTarget_ConsumptionLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateTarget(link, process);
    assertEquals(true, result);
  }

  @Test
  public void testValidateTarget_InstrumentLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateTarget(link, process);
    assertEquals(true, result);
  }

  @Test
  public void testValidateTarget_AgentLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateTarget(link, process);
    assertEquals(true, result);
  }

  @Test
  public void testValidateTarget_ResultLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateTarget(link, process);
    assertEquals(false, result);
  }
  
  @Test
  public void testValidateTarget_EffectLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateTarget(link, process);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateTarget_InvocationLink_ProcessTarget() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateTarget(link, process);
    assertEquals(true, result);
  }
  
  
  @Before
  public void setUp() {
    validator = new OPMLinkValidator();    
    object = OPMFactory.eINSTANCE.createOPMObject();
    process = OPMFactory.eINSTANCE.createOPMProcess();
  }
}

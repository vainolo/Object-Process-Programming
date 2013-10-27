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
  OPMNode objectSource;
  OPMNode processSource;
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
    boolean result = validator.validateSource(objectSource, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_InstrumentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateSource(objectSource, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_AgentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateSource(objectSource, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_ResultLink() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateSource(objectSource, link);
    assertEquals(false, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_EffectLink() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateSource(objectSource, link);
    assertEquals(true, result);
  }
  
  @Test
  public void testValidateSource_ObjectSource_InvocationLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateSource(objectSource, link);
    assertEquals(false, result);
  }

  @Test
  public void testValidateSource_ProcessSource_ConsumptionLink() {
    link = createProceduralLink(OPMProceduralLinkKind.CONSUMPTION);
    boolean result = validator.validateSource(processSource, link);
    assertEquals(false, result);
  }
  
  @Test
  public void testValidateSource_ProcessSource_InstrumentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INSTRUMENT);
    boolean result = validator.validateSource(processSource, link);
    assertEquals(false, result);
  }

  @Test
  public void testValidateSource_ProcessSource_AgentLink() {
    link = createProceduralLink(OPMProceduralLinkKind.AGENT);
    boolean result = validator.validateSource(processSource, link);
    assertEquals(false, result);
  }

  @Test
  public void testValidateSource_ProcessSource_ResultLink() {
    link = createProceduralLink(OPMProceduralLinkKind.RESULT);
    boolean result = validator.validateSource(processSource, link);
    assertEquals(true, result);
  }

  @Test
  public void testValidateSource_ProcessSource_EffectLink() {
    link = createProceduralLink(OPMProceduralLinkKind.EFFECT);
    boolean result = validator.validateSource(processSource, link);
    assertEquals(true, result);
  }
  @Test
  public void testValidateSource_ProcessSource_InvocationLink() {
    link = createProceduralLink(OPMProceduralLinkKind.INVOCATION);
    boolean result = validator.validateSource(processSource, link);
    assertEquals(true, result);
  }

  
  
  @Before
  public void setUp() {
    validator = new OPMLinkValidator();    
    objectSource = OPMFactory.eINSTANCE.createOPMObject();
    processSource = OPMFactory.eINSTANCE.createOPMProcess();
  }
}

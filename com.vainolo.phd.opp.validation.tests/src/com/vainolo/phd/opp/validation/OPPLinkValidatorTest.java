package com.vainolo.phd.opp.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.validation.OPPLinkValidator;

/**
 * Unit tests for the {@link OPPLinkValidator} class.
 * 
 * @author t-arib
 * 
 */
public class OPPLinkValidatorTest {
  OPPLinkValidator validator;
  OPPNode object;
  OPPNode process;
  OPPNode target;
  OPPLink link;
  private OPPState state;

  private OPPLink createProceduralLink(OPPProceduralLinkKind kind) {
    OPPProceduralLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setKind(kind);
    return link;
  }

  @Test
  public void testValidateSource_ObjectSource_DataLink() {
    link = createProceduralLink(OPPProceduralLinkKind.DATA);
    boolean result = validator.validateAddSource(object, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ObjectSource_AgentLink() {
    link = createProceduralLink(OPPProceduralLinkKind.AGENT);
    boolean result = validator.validateAddSource(object, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ProcessSource_DataLink() {
    link = createProceduralLink(OPPProceduralLinkKind.DATA);
    boolean result = validator.validateAddSource(process, link);
    assertTrue(result);
  }

  @Test
  public void testValidateSource_ProcessSource_AgentLink() {
    link = createProceduralLink(OPPProceduralLinkKind.AGENT);
    boolean result = validator.validateAddSource(process, link);
    assertFalse(result);
  }

  @Test
  public void testValidateTarget_DataLink_ObjectTarget() {
    link = createProceduralLink(OPPProceduralLinkKind.DATA);
    boolean result = validator.validateAddTarget(link, object);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_AgentLink_ObjectTarget() {
    link = createProceduralLink(OPPProceduralLinkKind.AGENT);
    boolean result = validator.validateAddTarget(link, object);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_DataLink_ProcessTarget() {
    link = createProceduralLink(OPPProceduralLinkKind.DATA);
    boolean result = validator.validateAddTarget(link, process);
    assertTrue(result);
  }

  @Test
  public void testValidateTarget_AgentLink_ProcessTarget() {
    link = createProceduralLink(OPPProceduralLinkKind.AGENT);
    boolean result = validator.validateAddTarget(link, process);
    assertTrue(result);
  }

  @Test
  public void testValudateSource_AgentLink_StateSource() {
    link = createProceduralLink(OPPProceduralLinkKind.AGENT);
    boolean result = validator.validateAddSource(state, link);
    assertTrue(result);
  }

  @Test
  public void testValudateSource_DataLink_StateSource() {
    link = createProceduralLink(OPPProceduralLinkKind.DATA);
    boolean result = validator.validateAddSource(state, link);
    assertTrue(result);
  }

  @Before
  public void setUp() {
    validator = new OPPLinkValidator();
    object = OPPFactory.eINSTANCE.createOPPObject();
    process = OPPFactory.eINSTANCE.createOPPProcess();
    state = OPPFactory.eINSTANCE.createOPPState();
  }
}

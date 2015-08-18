package com.vainolo.phd.opp.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPState;
import com.vainolo.phd.opp.validation.OPPNodeValidator;

public class OPPNodeValidatorTest {

  private OPPNodeValidator validator;
  private OPPObjectProcessDiagram opd;
  private OPPObject object;
  private OPPProcess process;
  private OPPState state;

  @Test
  public void test_ValidateAddNode_OPDContainer_ObjectNode() {
    boolean result = validator.validateAddNode(opd, object);
    assertTrue(result);
  }

  @Test
  public void test_ValidateAddNode_OPDContainer_ProcessNode() {
    boolean result = validator.validateAddNode(opd, process);
    assertTrue(result);
  }

  @Test
  public void test_ValidateAddNode_OPDContainer_StateNode() {
    boolean result = validator.validateAddNode(opd, state);
    assertFalse(result);
  }

  @Test
  public void test_ValidateAddNode_ObjectContainer_ObjectNode() {
    boolean result = validator.validateAddNode(object, object);
    assertFalse(result);
  }

  @Test
  public void test_ValidateAddNode_ObjectContainer_ProcessNode() {
    boolean result = validator.validateAddNode(object, process);
    assertFalse(result);
  }

  @Test
  public void test_ValidateAddNode_ObjectContainer_StateNode() {
    boolean result = validator.validateAddNode(object, state);
    assertTrue(result);
  }

  @Test
  public void test_ValidateAddNode_ProcessContainer_ObjectNode() {
    boolean result = validator.validateAddNode(process, object);
    assertTrue(result);
  }

  @Test
  public void test_ValidateAddNode_ProcessContainer_ProcessNode() {
    boolean result = validator.validateAddNode(process, process);
    assertTrue(result);
  }

  @Test
  public void test_ValidateAddNode_ProcessContainer_StateNode() {
    boolean result = validator.validateAddNode(process, state);
    assertFalse(result);
  }

  @Test
  public void test_ValidateAddNode_JavaObjectContainer_ObjectNode() {
    boolean result = validator.validateAddNode(new Object(), object);
    assertFalse(result);
  }

  @Test
  public void test_ValidateAddNode_ProcessContainer_JavaObjectNode() {
    boolean result = validator.validateAddNode(process, new Object());
    assertFalse(result);
  }

  @Test
  public void test_ValidateAddNode_JavaObjectContainer_JavaObjectNode() {
    boolean result = validator.validateAddNode(new Object(), new Object());
    assertFalse(result);
  }

  @Before
  public void setUp() throws Exception {
    validator = new OPPNodeValidator();
    opd = OPPFactory.eINSTANCE.createOPPObjectProcessDiagram();
    object = OPPFactory.eINSTANCE.createOPPObject();
    process = OPPFactory.eINSTANCE.createOPPProcess();
    state = OPPFactory.eINSTANCE.createOPPState();
  }

}

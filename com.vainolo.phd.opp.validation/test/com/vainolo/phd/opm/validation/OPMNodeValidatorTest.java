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

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;

public class OPMNodeValidatorTest {

  private OPMNodeValidator validator;
  private OPMObjectProcessDiagram opd;
  private OPMObject object;
  private OPMProcess process;
  private OPMState state;

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
    validator = new OPMNodeValidator();
    opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    object = OPMFactory.eINSTANCE.createOPMObject();
    process = OPMFactory.eINSTANCE.createOPMProcess();
    state = OPMFactory.eINSTANCE.createOPMState();
  }

}

/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.validation.OPPProceduralLinkValidator;

public class OPPProceduralLinkValiatorTests {

  private OPPProceduralLinkValidator validator;
  private OPPProceduralLink link;

  @Before
  public void setUp() throws Exception {
    link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    validator = new OPPProceduralLinkValidator();
  }

  @Test
  public void test_CanSubkindBeAdded_AddNewValidSubkind() {
    String subkind = "e";
    boolean result = validator.canSubkindBeAdded(link, subkind);
    assertTrue(result);
  }

  @Test
  public void test_CanSubkindBeAdded_AddNewInvalidSubkind() {
    String subkind = "q";
    boolean result = validator.canSubkindBeAdded(link, subkind);
    assertFalse(result);
  }

  @Test
  public void test_CanSubkindBeAdded_AddExistingValidSubkind() {
    String subkind = "e";
    link.getSubKinds().add(subkind);
    boolean result = validator.canSubkindBeAdded(link, subkind);
    assertFalse(result);
  }

  @Test
  public void test_CanSubkindBeAdded_AddExistingInvalidSubkind() {
    String subkind = "q";
    link.getSubKinds().add(subkind);
    boolean result = validator.canSubkindBeAdded(link, subkind);
    assertFalse(result);
  }

  @Test
  public void test_CanSubkindBeAdded_NullLinkValidSubkind() {
    boolean result = validator.canSubkindBeAdded(null, "e");
    assertFalse(result);
  }

  @Test
  public void test_CanSubkindBeRemoved_ExistingSubkind() {
    String subkind = "e";
    link.getSubKinds().add(subkind);
    boolean result = validator.canSubkindBeRemoved(link, subkind);
    assertTrue(result);
  }

  @Test
  public void test_CanSubkindBeRemoved_NonExistingSubkind() {
    boolean result = validator.canSubkindBeRemoved(link, "c");
    assertFalse(result);
  }

  public void test_CanSubkindBeRemoved_NullLink() {
    boolean result = validator.canSubkindBeRemoved(null, "c");
    assertFalse(result);
  }
}

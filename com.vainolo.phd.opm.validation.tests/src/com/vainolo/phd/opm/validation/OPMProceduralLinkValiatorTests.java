package com.vainolo.phd.opm.validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProceduralLink;

public class OPMProceduralLinkValiatorTests {

  private OPMProceduralLinkValidator validator;
  private OPMProceduralLink link;

  @Before
  public void setUp() throws Exception {
    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    validator = new OPMProceduralLinkValidator();
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

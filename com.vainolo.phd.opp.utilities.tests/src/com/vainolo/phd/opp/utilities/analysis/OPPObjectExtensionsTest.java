package com.vainolo.phd.opp.utilities.analysis;

import static org.junit.Assert.*;
import static com.vainolo.phd.opp.utilities.OPPTestUtilities.*;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;

public class OPPObjectExtensionsTest {
  
  private OPPObject object;
  private OPPProceduralLink link1, link2;
  private OPPObjectExtensions ext;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    ext = new OPPObjectExtensions();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testFindOutgoingDataLinks() {
    object = createOPPObject("");
    link1 = createOPPProceduralLink(object, null, OPPProceduralLinkKind.INSTRUMENT, null);    
    Collection<OPPProceduralLink> result = ext.findOutgoingDataLinks(object);
    assertEquals(1, result.size());
    assertTrue(result.contains(link1));
    
    link2 = createOPPProceduralLink(object, null, OPPProceduralLinkKind.CONS_RES, null);
    result = ext.findOutgoingDataLinks(object);
    assertEquals(2, result.size());
    assertTrue(result.contains(link1));
    assertTrue(result.contains(link2));
  }

  @Test
  public void testFindStates() {
    
  }
//
//  @Test
//  public void testHasOutgoingDataLinks() {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testHasIncomingResultLink() {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testFindOutgoingAgentLinks() {
//    fail("Not yet implemented");
//  }
//
//  @Test
//  public void testFindOutgoingEventLinks() {
//    fail("Not yet implemented");
//  }
//
}

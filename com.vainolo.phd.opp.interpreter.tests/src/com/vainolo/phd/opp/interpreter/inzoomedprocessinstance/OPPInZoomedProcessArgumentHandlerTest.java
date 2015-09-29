package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static com.vainolo.phd.opp.utilities.OPPTestUtils.*;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessArgumentHandler;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessExecutableInstance;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

public class OPPInZoomedProcessArgumentHandlerTest {
  private OPPInZoomedProcessArgumentHandler loader;
  private OPPOPDAnalyzer analyzer;
  private OPPInZoomedProcessInstanceHeap heap;
  private OPPInZoomedProcessExecutableInstance instance;
  private OPPProcess process;
  private OPPObjectInstance objectInstanceMock1, objectInstanceMock2, objectInstanceMock3;
  private OPPObject anonObj1;
  private OPPObject namedObj1, namedObj2, namedObj3;
  private String objNames[] = { "a", "b", "c" };

  @Test
  public void test_LoadArguments_NamedArgument() {
    createOPPProceduralLink(anonObj1, process, OPPProceduralLinkKind.CONS_RES, "a");
    when(heap.getVariable(anonObj1)).thenReturn(objectInstanceMock1);
    when(instance.getIncomingParameters()).thenReturn(Lists.newArrayList(new OPPParameter("a")));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
  }

  @Test
  public void test_LoadArguments_OnlyAnonymousArgumentsFromNamedObjects() {
    createOPPProceduralLink(namedObj1, process, OPPProceduralLinkKind.CONS_RES, "");
    createOPPProceduralLink(namedObj2, process, OPPProceduralLinkKind.CONS_RES, "");
    when(heap.getVariable(namedObj1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(namedObj2)).thenReturn(objectInstanceMock2);
    when(instance.getIncomingParameters()).thenReturn(Lists.newArrayList(new OPPParameter("a"), new OPPParameter("b")));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_MixedNamedArgumentsAnonymousArgumentsFromNamedObjects() {
    createOPPProceduralLink(namedObj1, process, OPPProceduralLinkKind.CONS_RES, "");
    createOPPProceduralLink(anonObj1, process, OPPProceduralLinkKind.CONS_RES, "b");
    when(heap.getVariable(namedObj1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(anonObj1)).thenReturn(objectInstanceMock2);
    when(instance.getIncomingParameters()).thenReturn(Lists.newArrayList(new OPPParameter("a"), new OPPParameter("b")));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_NamedArgumentsAnonymousFromNamedObjectsAndAnonymousFromParameterNames() {
    createOPPProceduralLink(namedObj1, process, OPPProceduralLinkKind.CONS_RES, "x");
    createOPPProceduralLink(namedObj2, process, OPPProceduralLinkKind.CONS_RES, "");
    createOPPProceduralLink(namedObj3, process, OPPProceduralLinkKind.CONS_RES, "");
    when(heap.getVariable(namedObj1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(namedObj2)).thenReturn(objectInstanceMock2);
    when(heap.getVariable(namedObj3)).thenReturn(objectInstanceMock3);
    when(instance.getIncomingParameters()).thenReturn(Lists.newArrayList(new OPPParameter("x"), new OPPParameter("y"), new OPPParameter("z")));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("x", objectInstanceMock1);
    verify(instance).setArgument("y", objectInstanceMock2);
    verify(instance).setArgument("z", objectInstanceMock3);
  }

  @Test
  public void test_LoadArguments_AnonymousArgumentsWithNoMatchingParameters() {
    createOPPProceduralLink(namedObj1, process, OPPProceduralLinkKind.CONS_RES, "");
    createOPPProceduralLink(namedObj2, process, OPPProceduralLinkKind.CONS_RES, "");
    createOPPProceduralLink(namedObj3, process, OPPProceduralLinkKind.CONS_RES, "");
    when(heap.getVariable(namedObj1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(namedObj2)).thenReturn(objectInstanceMock2);
    when(heap.getVariable(namedObj3)).thenReturn(objectInstanceMock3);
    when(instance.getIncomingParameters()).thenReturn(new ArrayList<OPPParameter>());
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("arg0", objectInstanceMock1);
    verify(instance).setArgument("arg1", objectInstanceMock2);
    verify(instance).setArgument("arg2", objectInstanceMock3);
  }

  @Before
  public void initialize() {
    objectInstanceMock1 = mock(OPPObjectInstance.class);
    objectInstanceMock2 = mock(OPPObjectInstance.class);
    objectInstanceMock3 = mock(OPPObjectInstance.class);
    instance = mock(OPPInZoomedProcessExecutableInstance.class);
    analyzer = spy(new OPPOPDAnalyzer());
    heap = mock(OPPInZoomedProcessInstanceHeap.class);
    loader = new OPPInZoomedProcessArgumentHandler(analyzer, heap);
    process = createOPPProcess("");
    anonObj1 = createOPPObject("");
    namedObj1 = createOPPObject(objNames[0]);
    namedObj2 = createOPPObject(objNames[1]);
    namedObj3 = createOPPObject(objNames[2]);
  }
}

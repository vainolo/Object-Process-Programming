package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.google.common.collect.Lists;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPParameter;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessArgumentHandler;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessExecutableInstance;
import com.vainolo.phd.opp.interpreter.inzoomedprocessinstance.OPPInZoomedProcessInstanceHeap;
import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.model.OPPProceduralLinkKind;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDAnalyzer;

public class OPPInZoomedProcessArgumentLoaderTest {
  private OPPInZoomedProcessArgumentHandler loader;
  private OPPOPDAnalyzer analyzer;
  private OPPInZoomedProcessInstanceHeap heap;
  private OPPInZoomedProcessExecutableInstance instance;
  private OPPProcess process;
  private List<OPPProceduralLink> argumentLinks;
  private OPPProceduralLink link1, link2, link3;
  private OPPObject object1, object2, object3;
  private OPPObjectInstance objectInstanceMock1, objectInstanceMock2, objectInstanceMock3;

  private OPPProceduralLink createProceduralLink(OPPNode source, OPPNode target, OPPProceduralLinkKind kind,
      String center) {
    OPPProceduralLink link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    link.setKind(kind);
    link.setSource(source);
    link.setTarget(target);
    link.setCenterDecoration(center);
    return link;
  }

  private OPPObject createObject(String name) {
    OPPObject object = OPPFactory.eINSTANCE.createOPPObject();
    object.setName(name);
    return object;
  }

  @Test
  public void test_LoadArguments_OnlyNamedArguments() {
    process = OPPFactory.eINSTANCE.createOPPProcess();
    object1 = createObject("");
    link1 = createProceduralLink(object1, process, OPPProceduralLinkKind.DATA, "a");
    argumentLinks.add(link1);
    object2 = createObject("");
    link2 = createProceduralLink(object2, process, OPPProceduralLinkKind.DATA, "b");
    argumentLinks.add(link2);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPPParameter("a", false), new OPPParameter("b", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_OnlyAnalymousArgumentsFromNamedObjects() {
    process = OPPFactory.eINSTANCE.createOPPProcess();
    object1 = createObject("a");
    link1 = createProceduralLink(object1, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link1);
    object2 = createObject("b");
    link2 = createProceduralLink(object2, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link2);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPPParameter("a", false), new OPPParameter("b", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_MixedNamedArgumentsAnonymousArgumentsFromNamedObjects() {
    process = OPPFactory.eINSTANCE.createOPPProcess();
    object1 = createObject("a");
    link1 = createProceduralLink(object1, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link1);
    object2 = createObject("");
    link2 = createProceduralLink(object2, process, OPPProceduralLinkKind.DATA, "b");
    argumentLinks.add(link2);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPPParameter("a", false), new OPPParameter("b", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_NamedArgumentsAnonymousFromNamedObjectsAndAnonymousFromParameterNames() {
    process = OPPFactory.eINSTANCE.createOPPProcess();
    object1 = createObject("X");
    link1 = createProceduralLink(object1, process, OPPProceduralLinkKind.DATA, "a");
    argumentLinks.add(link1);
    object2 = createObject("b");
    link2 = createProceduralLink(object2, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link2);
    object3 = createObject("Q");
    link3 = createProceduralLink(object2, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link3);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(heap.getVariable(object3)).thenReturn(objectInstanceMock3);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(analyzer.getObject(link3)).thenReturn(object3);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPPParameter("a", false), new OPPParameter("b", false), new OPPParameter("c", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
    verify(instance).setArgument("c", objectInstanceMock3);
  }

  @Test
  public void test_LoadArguments_AnonymousArgumentsWithNoMatchingParameters() {
    process = OPPFactory.eINSTANCE.createOPPProcess();
    object1 = createObject("a");
    link1 = createProceduralLink(object1, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link1);
    object2 = createObject("b");
    link2 = createProceduralLink(object2, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link2);
    object3 = createObject("c");
    link3 = createProceduralLink(object2, process, OPPProceduralLinkKind.DATA, "");
    argumentLinks.add(link3);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(heap.getVariable(object3)).thenReturn(objectInstanceMock3);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(analyzer.getObject(link3)).thenReturn(object3);
    when(instance.getIncomingParameterNames()).thenReturn(new ArrayList<OPPParameter>());
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("arg0", objectInstanceMock1);
    verify(instance).setArgument("arg1", objectInstanceMock2);
    verify(instance).setArgument("arg2", objectInstanceMock3);
  }

  @Before
  public void initialize() {
    argumentLinks = Lists.newArrayList();
    objectInstanceMock1 = mock(OPPObjectInstance.class);
    objectInstanceMock2 = mock(OPPObjectInstance.class);
    objectInstanceMock3 = mock(OPPObjectInstance.class);
    instance = mock(OPPInZoomedProcessExecutableInstance.class);
    analyzer = mock(OPPOPDAnalyzer.class);
    heap = mock(OPPInZoomedProcessInstanceHeap.class);
    loader = new OPPInZoomedProcessArgumentHandler(analyzer, heap);
  }
}

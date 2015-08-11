package com.vainolo.phd.opm.interpreter.inzoomedprocessinstance;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.google.common.collect.Lists;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMParameter;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProceduralLinkKind;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPMInZoomedProcessArgumentLoaderTest {
  private OPMInZoomedProcessArgumentHandler loader;
  private OPDAnalyzer analyzer;
  private OPMInZoomedProcessInstanceHeap heap;
  private OPMInZoomedProcessExecutableInstance instance;
  private OPMProcess process;
  private List<OPMProceduralLink> argumentLinks;
  private OPMProceduralLink link1, link2, link3;
  private OPMObject object1, object2, object3;
  private OPMObjectInstance objectInstanceMock1, objectInstanceMock2, objectInstanceMock3;

  private OPMProceduralLink createProceduralLink(OPMNode source, OPMNode target, OPMProceduralLinkKind kind,
      String center) {
    OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    link.setKind(kind);
    link.setSource(source);
    link.setTarget(target);
    link.setCenterDecoration(center);
    return link;
  }

  private OPMObject createObject(String name) {
    OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
    object.setName(name);
    return object;
  }

  @Test
  public void test_LoadArguments_OnlyNamedArguments() {
    process = OPMFactory.eINSTANCE.createOPMProcess();
    object1 = createObject("");
    link1 = createProceduralLink(object1, process, OPMProceduralLinkKind.CONSUMPTION, "a");
    argumentLinks.add(link1);
    object2 = createObject("");
    link2 = createProceduralLink(object2, process, OPMProceduralLinkKind.CONSUMPTION, "b");
    argumentLinks.add(link2);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPMParameter("a", false), new OPMParameter("b", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_OnlyAnalymousArgumentsFromNamedObjects() {
    process = OPMFactory.eINSTANCE.createOPMProcess();
    object1 = createObject("a");
    link1 = createProceduralLink(object1, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link1);
    object2 = createObject("b");
    link2 = createProceduralLink(object2, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link2);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPMParameter("a", false), new OPMParameter("b", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_MixedNamedArgumentsAnonymousArgumentsFromNamedObjects() {
    process = OPMFactory.eINSTANCE.createOPMProcess();
    object1 = createObject("a");
    link1 = createProceduralLink(object1, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link1);
    object2 = createObject("");
    link2 = createProceduralLink(object2, process, OPMProceduralLinkKind.CONSUMPTION, "b");
    argumentLinks.add(link2);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPMParameter("a", false), new OPMParameter("b", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
  }

  @Test
  public void test_LoadArguments_NamedArgumentsAnonymousFromNamedObjectsAndAnonymousFromParameterNames() {
    process = OPMFactory.eINSTANCE.createOPMProcess();
    object1 = createObject("X");
    link1 = createProceduralLink(object1, process, OPMProceduralLinkKind.CONSUMPTION, "a");
    argumentLinks.add(link1);
    object2 = createObject("b");
    link2 = createProceduralLink(object2, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link2);
    object3 = createObject("Q");
    link3 = createProceduralLink(object2, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link3);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(heap.getVariable(object3)).thenReturn(objectInstanceMock3);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(analyzer.getObject(link3)).thenReturn(object3);
    when(instance.getIncomingParameterNames()).thenReturn(
        Lists.newArrayList(new OPMParameter("a", false), new OPMParameter("b", false), new OPMParameter("c", false)));
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("a", objectInstanceMock1);
    verify(instance).setArgument("b", objectInstanceMock2);
    verify(instance).setArgument("c", objectInstanceMock3);
  }

  @Test
  public void test_LoadArguments_AnonymousArgumentsWithNoMatchingParameters() {
    process = OPMFactory.eINSTANCE.createOPMProcess();
    object1 = createObject("a");
    link1 = createProceduralLink(object1, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link1);
    object2 = createObject("b");
    link2 = createProceduralLink(object2, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link2);
    object3 = createObject("c");
    link3 = createProceduralLink(object2, process, OPMProceduralLinkKind.CONSUMPTION, "");
    argumentLinks.add(link3);
    when(heap.getVariable(object1)).thenReturn(objectInstanceMock1);
    when(heap.getVariable(object2)).thenReturn(objectInstanceMock2);
    when(heap.getVariable(object3)).thenReturn(objectInstanceMock3);
    when(analyzer.findIncomingDataLinks(process)).thenReturn(argumentLinks);
    when(analyzer.getObject(link1)).thenReturn(object1);
    when(analyzer.getObject(link2)).thenReturn(object2);
    when(analyzer.getObject(link3)).thenReturn(object3);
    when(instance.getIncomingParameterNames()).thenReturn(new ArrayList<OPMParameter>());
    loader.loadInstanceArguments(process, instance);
    verify(instance).setArgument("arg0", objectInstanceMock1);
    verify(instance).setArgument("arg1", objectInstanceMock2);
    verify(instance).setArgument("arg2", objectInstanceMock3);
  }

  @Before
  public void initialize() {
    argumentLinks = Lists.newArrayList();
    objectInstanceMock1 = mock(OPMObjectInstance.class);
    objectInstanceMock2 = mock(OPMObjectInstance.class);
    objectInstanceMock3 = mock(OPMObjectInstance.class);
    instance = mock(OPMInZoomedProcessExecutableInstance.class);
    analyzer = mock(OPDAnalyzer.class);
    heap = mock(OPMInZoomedProcessInstanceHeap.class);
    loader = new OPMInZoomedProcessArgumentHandler(analyzer, heap);
  }
}

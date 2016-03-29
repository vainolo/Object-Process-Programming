/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

//import static com.google.common.base.Preconditions.*;
//
//import java.util.Collection;
//import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.*;
import org.eclipse.ui.part.ViewPart;
//import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
//import org.jgrapht.graph.DefaultEdge;
//import org.jgrapht.traverse.BreadthFirstIterator;

//import com.google.common.collect.Lists;
//import com.vainolo.phd.opp.interpreter.utils.OPPOPDExecutionAnalyzer;
import com.vainolo.phd.opp.model.*;

//import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer;

public class OPPOPLViewPart extends ViewPart {
  private Browser browser;
  private OPPObjectProcessDiagram opd;
  // private OPPAnalyzer analyzer;
  // private OPPOPDExecutionAnalyzer executionAnalyzer;
  private OPPObjectProcessDiagramAdapter adapter;

  public OPPOPLViewPart() {
    // analyzer = new OPPAnalyzer();
    // executionAnalyzer = new OPPOPDExecutionAnalyzer();
    adapter = new OPPObjectProcessDiagramAdapter();
  }

  @Override
  public void createPartControl(Composite parent) {
    browser = new Browser(parent, SWT.NONE);

    IPartListener partListener = new IPartListener() {

      @Override
      public void partActivated(IWorkbenchPart part) {
        if (IEditorPart.class.isInstance(part)) {
          if (OPPGraphicalEditor.class.isInstance(part)) {
            OPPGraphicalEditor editor = (OPPGraphicalEditor) part;
            OPPObjectProcessDiagram editorOpd = editor.getOPD();
            opd = editorOpd;
            opd.eAdapters().add(adapter);
            refresh();
          } else {
            if (opd != null) {
              opd.eAdapters().remove(adapter);
              opd = null;
              clear();
            }
          }
        }
      }

      @Override
      public void partClosed(IWorkbenchPart part) {
        if (IEditorPart.class.isInstance(part) && OPPGraphicalEditor.class.isInstance(part) && opd != null) {
          opd.eAdapters().remove(adapter);
          opd = null;
          clear();
        }
      }

      @Override
      public void partBroughtToTop(IWorkbenchPart part) {
      }

      @Override
      public void partDeactivated(IWorkbenchPart part) {
      }

      @Override
      public void partOpened(IWorkbenchPart part) {
      }
    };

    getViewSite().getPage().addPartListener(partListener);
  }

  @Override
  public void setFocus() {
    browser.setFocus();
  }

  private void clear() {
    if (browser.isDisposed())
      return;
    browser.setText("");
  }

  @Override
  public void dispose() {
    if (opd != null) {
      opd.eAdapters().remove(adapter);
      opd = null;
      clear();
    }
    super.dispose();
  }

  private void refresh() {

    if (browser.isDisposed())
      return;

    browser.setText("");
    return;
    //
    // StringBuilder oplBuilder = new StringBuilder();
    // oplBuilder.append("<html>\n" + getStyleSheet() + "</head>\n" + "<body>\n");
    // switch (opd.getKind()) {
    // case COMPOUND:
    // oplBuilder.append(buildInZoomedProcessOPL(opd));
    // break;
    // case UNFOLDED:
    // oplBuilder.append(buildUnfoldedOPL(opd));
    // break;
    // case SYSTEM:
    // oplBuilder.append(buildSystemOPL(opd));
    // break;
    // }
    // oplBuilder.append("</body>\n" + "</html>");
    // browser.setText(oplBuilder.toString());
  }

  // private String buildUnfoldedOPL(OPPObjectProcessDiagram opd) {
  // StringBuilder oplBuilder = new StringBuilder();
  // OPPThing unfoldedThing = analyzer.getUnfoldedThing(opd);
  // if (unfoldedThing != null)
  // oplBuilder.append("<p>Unfolding of " + unfoldedThing.getName() + "</p>");
  // return oplBuilder.toString();
  // }
  //
  // private String buildSystemOPL(OPPObjectProcessDiagram opd) {
  // StringBuilder oplBuilder = new StringBuilder();
  // OPPProcess system = analyzer.getSystemProcess(opd);
  // if (system != null)
  // oplBuilder.append("<p>System " + system.getName() + "</p>");
  // return oplBuilder.toString();
  // }
  //
  // private String buildInZoomedProcessOPL(OPPObjectProcessDiagram opd) {
  // checkArgument(OPPObjectProcessDiagramKind.COMPOUND.equals(opd.getKind()));
  // StringBuilder oplBuilder = new StringBuilder();
  // oplBuilder.append("<p>" + format(opd) + " is a <span class='process'>process</span>.<p>");
  // oplBuilder.append(buildParametersOPL(opd));
  // oplBuilder.append(buildProcessListOPL(opd));
  // oplBuilder.append(buildExecutionOrderOPL(opd));
  // oplBuilder.append(buildResultsOPL(opd));
  // return oplBuilder.toString();
  // }
  //
  // private String buildParametersOPL(OPPObjectProcessDiagram opd) {
  // StringBuilder builder = new StringBuilder();
  //
  // Collection<OPPObject> parameters = analyzer.findParameters(opd);
  // if (parameters.size() == 0) {
  // return "";
  // }
  //
  // builder.append("<p>The parameters of " + format(opd) + " are ");
  // if (parameters.size() == 1) {
  // builder.append(format(parameters.iterator().next()));
  // } else {
  // OPPObject[] parametersArray = parameters.toArray(new OPPObject[0]);
  // builder.append(buildCommaSeparatedNamedElementSentence(parametersArray));
  // }
  //
  // return builder.append(".</p>").toString();
  // }
  //
  // private String buildProcessListOPL(OPPObjectProcessDiagram opd) {
  // StringBuilder processListOPLBuilder = new StringBuilder();
  // OPPProcess process = analyzer.getInZoomedProcess(opd);
  // Collection<OPPProcess> processes = analyzer.findProcesses(process);
  // if (processes.size() == 0) {
  // return "";
  // }
  //
  // processListOPLBuilder.append("<p>" + format(opd) + " consists of ");
  // if (processes.size() == 1) {
  // processListOPLBuilder.append(format(processes.iterator().next()) + "</p>\n");
  // } else {
  // OPPProcess[] processArray = processes.toArray(new OPPProcess[0]);
  // for (int i = 0; i < processArray.length - 1; i++) {
  // processListOPLBuilder.append(format(processArray[i]) + ", ");
  // }
  // processListOPLBuilder.append("and " + format(processArray[processArray.length - 1]) + ".</p>\n");
  // }
  //
  // return processListOPLBuilder.toString();
  // }
  //
  // private String buildObjectDependenciesOPL(OPPObjectProcessDiagram opd) {
  // StringBuilder builder = new StringBuilder();
  // OPPProcess inZoomedProcess = analyzer.getInZoomedProcess(opd);
  // Collection<OPPObject> objects = analyzer.findObjects(inZoomedProcess);
  // for (OPPObject object : objects) {
  // builder.append(buildObjectDependencyOPL(object));
  // }
  // return builder.toString();
  // }
  //
  // private String buildObjectDependencyOPL(OPPObject object) {
  // // Collection<OPMProceduralLink> incomingDataLinks =
  // // analyzer.findIncomingInstrumentLinks(object);
  // // if(incomingDataLinks.size() == 0) {
  // return "";
  // // } else {
  // // OPMProceduralLink link = incomingDataLinks.iterator().next();
  // // OPMObject source = (OPMObject) link.getSource();
  // // OPMObject target = (OPMObject) link.getTarget();
  // // return "<p>" + format(target) + " gets its value from " + format(source)
  // // + "</p>";
  // // }
  //
  // }
  //
  // private String buildExecutionOrderOPL(OPPObjectProcessDiagram opd) {
  // StringBuilder builder = new StringBuilder();
  // OPPProcess inZoomedProcess = analyzer.getInZoomedProcess(opd);
  // DirectedAcyclicGraph<OPPProcess, DefaultEdge> opdDag = executionAnalyzer.createExecutionDAG(inZoomedProcess);
  //
  // @SuppressWarnings({ "rawtypes", "unchecked" })
  // BreadthFirstIterator<OPPProcess, DefaultEdge> bfIterator = new BreadthFirstIterator(opdDag);
  // if (!bfIterator.hasNext()) {
  // return "";
  // }
  //
  // List<OPPProcess> initialProcesses = Lists.newArrayList();
  // StringBuilder initialProcessDetails = new StringBuilder();
  // StringBuilder noninitialProcessDetails = new StringBuilder();
  // while (bfIterator.hasNext()) {
  // OPPProcess p = bfIterator.next();
  // if (opdDag.inDegreeOf(p) == 0) {
  // initialProcesses.add(p);
  // initialProcessDetails.append("<div class='indent'>" + buildProcessDetailsOPL(p) + "</div>");
  // } else {
  // noninitialProcessDetails.append("<p>" + format(p) + " is executed after ");
  // OPPProcess[] requiredProcesses = executionAnalyzer.findRequiredProcesses(opdDag, p).toArray(new OPPProcess[0]);
  // noninitialProcessDetails.append(buildCommaSeparatedNamedElementSentence(requiredProcesses));
  // noninitialProcessDetails.append(":</p>");
  // noninitialProcessDetails.append("<div class='indent'>" + buildProcessDetailsOPL(p) + "</div>");
  // }
  // }
  //
  // builder.append("<p>The execution of " + format(opd) + " starts with "
  // + buildCommaSeparatedNamedElementSentence(initialProcesses.toArray(new OPPProcess[0])) + ":</p>");
  // builder.append(initialProcessDetails);
  // builder.append("<div class='indent'>" + buildObjectDependenciesOPL(opd) + "</div>");
  // builder.append(noninitialProcessDetails);
  // return builder.toString();
  // }
  //
  // private String buildResultsOPL(OPPObjectProcessDiagram opd) {
  // StringBuilder builder = new StringBuilder();
  // Collection<OPPObject> parameters = analyzer.findParameters(opd);
  // for (OPPObject parameter : parameters) {
  // builder.append(buildObjectDependencyOPL(parameter));
  // }
  // return builder.toString();
  // }
  //
  // private String buildProcessDetailsOPL(OPPProcess process) {
  // StringBuilder processDetailsOPLBuilder = new StringBuilder();
  // processDetailsOPLBuilder.append("<p>" + format(process));
  // Collection<OPPProceduralLink> incomingDataLinks = analyzer.findIncomingDataLinks(process);
  // List<String> processDetails = Lists.newArrayList();
  // if (incomingDataLinks.size() == 0) {
  // processDetailsOPLBuilder.append(" has no arguments.</p>");
  // } else {
  // String agentsOPL = buildProcessAgentsOPL(incomingDataLinks);
  // if (!"".equals(agentsOPL)) {
  // processDetails.add(agentsOPL);
  // }
  // String instrumentsOPL = buildProcessInstrumentsOPL(incomingDataLinks);
  // if (!"".equals(instrumentsOPL)) {
  // processDetails.add(instrumentsOPL);
  // }
  // String consumeesOPL = buildProcessConsumeesOPL(incomingDataLinks);
  // if (!"".equals(consumeesOPL)) {
  // processDetails.add(consumeesOPL);
  // }
  // }
  //
  // Collection<OPPProceduralLink> outgoingDataLinks = analyzer.findOutgoingDataLinks(process);
  // if (outgoingDataLinks.size() != 0) {
  // String resultsOPL = buildProcessResultsOPL(outgoingDataLinks);
  // if (!"".equals(resultsOPL)) {
  // processDetails.add(resultsOPL + ".");
  // }
  // }
  //
  // processDetailsOPLBuilder.append(buildCommaSeparatedList(processDetails.toArray(new String[0])));
  //
  // return processDetailsOPLBuilder.toString();
  // }
  //
  // private String buildProcessResultsOPL(Collection<OPPProceduralLink> outgoingDataLinks) {
  // StringBuilder builder = new StringBuilder();
  // if (outgoingDataLinks.size() == 0) {
  // return "";
  // } else {
  // builder.append(" yields ");
  // builder.append(buildCommaSeparatedProceduralLinksSentenceByTarget(outgoingDataLinks));
  // }
  // return builder.toString();
  // }
  //
  // private String buildProcessAgentsOPL(Collection<OPPProceduralLink> incomingDataLinks) {
  // StringBuilder builder = new StringBuilder();
  // Collection<OPPProceduralLink> agentLinks = analyzer.findAgentLinks(incomingDataLinks);
  // if (agentLinks.size() == 0) {
  // return "";
  // } else {
  // builder.append(" is driven by ");
  // builder.append(buildCommaSeparatedProceduralLinksSentenceBySource(agentLinks));
  // }
  // return builder.toString();
  // }
  //
  // private String buildProcessInstrumentsOPL(Collection<OPPProceduralLink> incomingDataLinks) {
  // // StringBuilder builder = new StringBuilder();
  // // Collection<OPPProceduralLink> instrumentLinks =
  // // analyzer.findInstrumentLinks(incomingDataLinks);
  // // if(instrumentLinks.size() == 0) {
  // return "";
  // // } else {
  // // builder.append(" requires ");
  // // builder.append(buildCommaSeparatedProceduralLinksSentenceBySource(instrumentLinks));
  // // }
  // // return builder.toString();
  // }

  // private String buildProcessConsumeesOPL(Collection<OPPProceduralLink> incomingDataLinks) {
  // StringBuilder builder = new StringBuilder();
  // Collection<OPPProceduralLink> consumptionLinks = analyzer.findConsumptionLinks(incomingDataLinks);
  // if (consumptionLinks.size() == 0) {
  // return "";
  // } else {
  // builder.append(" consumes ");
  // builder.append(buildCommaSeparatedProceduralLinksSentenceBySource(consumptionLinks));
  // }
  // return builder.toString();
  // }
  //
  // private String buildCommaSeparatedProceduralLinksSentenceBySource(Collection<OPPProceduralLink> links) {
  // String[] elements = new String[links.size()];
  // OPPProceduralLink[] linksArray = links.toArray(new OPPProceduralLink[0]);
  // for (int i = 0; i < linksArray.length; i++) {
  // if (linksArray[i].getCenterDecoration() == null || "".equals(linksArray[i].getCenterDecoration())) {
  // elements[i] = format((OPPNamedElement) linksArray[i].getSource());
  // } else {
  // elements[i] = format((OPPNamedElement) linksArray[i].getSource()) + " as " +
  // formatParameter(linksArray[i].getCenterDecoration());
  // }
  // }
  // return buildCommaSeparatedList(elements);
  // }
  //
  // private String buildCommaSeparatedProceduralLinksSentenceByTarget(Collection<OPPProceduralLink> links) {
  // String[] elements = new String[links.size()];
  // OPPProceduralLink[] linksArray = links.toArray(new OPPProceduralLink[0]);
  // for (int i = 0; i < linksArray.length; i++) {
  // OPPNamedElement target = (OPPNamedElement) linksArray[i].getTarget();
  // if (linksArray[i].getCenterDecoration() == null || "".equals(linksArray[i].getCenterDecoration())) {
  // elements[i] = format(target);
  // } else {
  // elements[i] = formatParameter(linksArray[i].getCenterDecoration()) + " as " + format(target);
  // }
  // }
  // return buildCommaSeparatedList(elements);
  // }
  //
  // private String buildCommaSeparatedNamedElementSentence(OPPNamedElement[] elements) {
  // String[] names = new String[elements.length];
  // for (int i = 0; i < elements.length; i++) {
  // names[i] = format(elements[i]);
  // }
  // return buildCommaSeparatedList(names);
  // }
  //
  // private String buildCommaSeparatedList(String[] elements) {
  // if (elements.length == 0) {
  // return "";
  // } else if (elements.length == 1) {
  // return elements[0];
  // } else {
  // StringBuilder builder = new StringBuilder();
  // for (int i = 0; i < elements.length - 1; i++) {
  // builder.append(elements[i] + ", ");
  // }
  // builder.append(elements[elements.length - 1]);
  // return builder.toString();
  // }
  // }
  //
  // public String getStyleSheet() {
//    // @formatter:off
//    return "<style>\n" 
//        + "p {margin:0;}\n"
//        + "* {font-family:sans-serif;font-size:1em;}\n" 
//        + ".process {color:blue;}\n"
//        + ".object {color:green;}\n"
//        + ".state {color:brown;}\n"
//        + ".parameter {color:purple;}\n" 
//        + ".indent {text-indent: 5em;}\n"
//        + "</style>\n";
//    // @formatter:on
  // }
  //
  // public String formatParameter(String parameter) {
  // return "<span class='parameter'>" + parameter + "</span>";
  // }
  //
  // public String format(OPPNamedElement element) {
  // if (element == null)
  // return "";
  //
  // if (OPPObjectProcessDiagram.class.isInstance(element)) {
  // return formatOPD((OPPObjectProcessDiagram) element);
  // } else if (OPPProcess.class.isInstance(element)) {
  // return formatProcess((OPPProcess) element);
  // } else if (OPPObject.class.isInstance(element)) {
  // return formatObject((OPPObject) element);
  // } else if (OPPState.class.isInstance(element)) {
  // return formatState((OPPState) element);
  // } else
  // throw new IllegalArgumentException(element.toString());
  // }
  //
  // public String formatProcess(OPPProcess process) {
  // return "<span class='process'>" + process.getName() + "</span>";
  // }
  //
  // public String formatObject(OPPObject object) {
  // String name = "";
  // if ((object.getName() == null) || (object.getName().matches("\\s*"))) {
  // name = "anonymous";
  // } else {
  // name = object.getName();
  // }
  // return "<span class='object'>" + name + "</span>";
  // }
  //
  // public String formatState(OPPState state) {
  // OPPObject o = (OPPObject) state.getContainer();
  // return "<span class='object'>" + o.getName() + "</span> in state " + "<span class='state'>" + state.getName() +
  // "</span>";
  // }
  //
  // public String formatOPD(OPPObjectProcessDiagram opd) {
  // return "<span class='process'>" + opd.getName() + "</span>";
  // }

  public class OPPObjectProcessDiagramAdapter extends EContentAdapter {
    @Override
    public void notifyChanged(Notification notification) {
      super.notifyChanged(notification);
      refresh();
    }
  }
}

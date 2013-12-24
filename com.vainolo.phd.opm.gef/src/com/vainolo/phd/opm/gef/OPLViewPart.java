/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.*;
import org.eclipse.ui.part.ViewPart;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.BreadthFirstIterator;

import com.google.common.collect.Lists;
import com.vainolo.phd.opm.gef.editor.OPMGraphicalEditor;
import com.vainolo.phd.opm.interpreter.utils.OPDExecutionAnalyzer;
import com.vainolo.phd.opm.model.*;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;

public class OPLViewPart extends ViewPart {
  private Browser browser;
  private OPMObjectProcessDiagram opd;
  private OPDAnalyzer analyzer;
  private OPDExecutionAnalyzer executionAnalyzer;
  private OPMObjectProcessDiagramAdapter adapter;

  public OPLViewPart() {
    analyzer = new OPDAnalyzer();
    executionAnalyzer = new OPDExecutionAnalyzer();
    adapter = new OPMObjectProcessDiagramAdapter();
  }

  @Override
  public void createPartControl(Composite parent) {
    browser = new Browser(parent, SWT.NONE);

    IPartListener partListener = new IPartListener() {

      @Override
      public void partActivated(IWorkbenchPart part) {
        if(IEditorPart.class.isInstance(part)) {
          if(OPMGraphicalEditor.class.isInstance(part)) {
            OPMGraphicalEditor editor = (OPMGraphicalEditor) part;
            OPMObjectProcessDiagram editorOpd = editor.getOPD();
            opd = editorOpd;
            opd.eAdapters().add(adapter);
            refresh();
          } else {
            if(opd != null) {
              opd.eAdapters().remove(adapter);
              opd = null;
              clear();
            }
          }
        }
      }

      @Override
      public void partClosed(IWorkbenchPart part) {
        if(IEditorPart.class.isInstance(part)) {
          if(OPMGraphicalEditor.class.isInstance(part)) {
            if(opd != null) {
              opd.eAdapters().remove(adapter);
              opd = null;
              clear();
            }
          }
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
    if(browser.isDisposed())
      return;
    browser.setText("");
  }

  @Override
  public void dispose() {
    if(opd != null) {
      opd.eAdapters().remove(adapter);
      opd = null;
      clear();
    }
    super.dispose();
  }

  private void refresh() {
    if(browser.isDisposed())
      return;

    StringBuilder oplBuilder = new StringBuilder();
    oplBuilder.append("<html>\n" + getStyleSheet() + "</head>\n" + "<body>\n");
    oplBuilder.append("<p>" + format(opd) + " is a <span class='process'>process</span><p>");
    oplBuilder.append(buildParametersOPL(opd));
    oplBuilder.append(buildProcessListOPL(opd));
    oplBuilder.append(buildExecutionOrderOPL(opd));
    oplBuilder.append("</body>\n" + "</html>");
    browser.setText(oplBuilder.toString());
  }

  private String buildParametersOPL(OPMObjectProcessDiagram opd) {
    Collection<OPMObject> parameters = analyzer.findParameters(opd);
    StringBuilder builder = new StringBuilder();
    if(parameters.size() == 0) {
      return "";
    }

    builder.append("<p>The parameters of " + format(opd) + " are ");
    if(parameters.size() == 1) {
      builder.append(format(parameters.iterator().next()) + "</p>");
    } else {
      OPMObject[] parametersArray = parameters.toArray(new OPMObject[0]);
      builder.append(buildCommaSeparatedNamedElementSentence(parametersArray) + "</p>");
    }

    return builder.toString();
  }

  private String buildProcessListOPL(OPMObjectProcessDiagram opd) {
    StringBuilder processListOPLBuilder = new StringBuilder();
    OPMProcess process = analyzer.getInZoomedProcess(opd);
    Collection<OPMProcess> processes = analyzer.findProcesses(process);
    if(processes.size() == 0) {
      return "";
    }

    processListOPLBuilder.append("<p>" + format(opd) + " consists of ");
    if(processes.size() == 1) {
      processListOPLBuilder.append(format(processes.iterator().next()) + "</p>\n");
    } else {
      OPMProcess[] processArray = processes.toArray(new OPMProcess[0]);
      for(int i = 0; i < processArray.length - 1; i++) {
        processListOPLBuilder.append(format(processArray[i]) + ", ");
      }
      processListOPLBuilder.append("and " + format(processArray[processArray.length - 1]) + "</p>\n");
    }

    return processListOPLBuilder.toString();
  }

  private String buildObjectDependenciesOPL(OPMObjectProcessDiagram opd) {
    StringBuilder builder = new StringBuilder();
    OPMProcess inZoomedProcess = analyzer.getInZoomedProcess(opd);
    Collection<OPMObject> objects = analyzer.findObjects(inZoomedProcess);
    for(OPMObject object : objects) {
      builder.append(buildObjectDependencyOPL(object));
    }
    return builder.toString();
  }

  private String buildObjectDependencyOPL(OPMObject object) {
    Collection<OPMProceduralLink> incomingDataLinks = analyzer.findIncomingInstrumentLinks(object);
    if(incomingDataLinks.size() == 0) {
      return "";
    } else {
      OPMProceduralLink link = incomingDataLinks.iterator().next();
      OPMObject source = (OPMObject) link.getSource();
      OPMObject target = (OPMObject) link.getTarget();
      return "<p>" + format(target) + " gets its value from " + format(source) + "</p>";
    }

  }

  private String buildExecutionOrderOPL(OPMObjectProcessDiagram opd) {
    StringBuilder builder = new StringBuilder();
    OPMProcess inZoomedProcess = analyzer.getInZoomedProcess(opd);
    DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag = executionAnalyzer.createExecutionDAG(inZoomedProcess);

    @SuppressWarnings({ "rawtypes", "unchecked" })
    BreadthFirstIterator<OPMProcess, DefaultEdge> bfIterator = new BreadthFirstIterator(opdDag);
    if(!bfIterator.hasNext()) {
      return "";
    }

    List<OPMProcess> initialProcesses = Lists.newArrayList();
    StringBuilder processDetails = new StringBuilder();
    while(bfIterator.hasNext()) {
      OPMProcess p = bfIterator.next();
      if(opdDag.inDegreeOf(p) == 0) {
        initialProcesses.add(p);
        processDetails.append("<div class='indent'>" + getProcessDetailsOPL(p) + "</div>");
      } else {
        // TODO: print process with predecessors
      }
    }

    builder.append("<p>The execution of " + format(opd) + " starts with "
        + buildCommaSeparatedNamedElementSentence(initialProcesses.toArray(new OPMProcess[0])) + "</p>");
    builder.append(processDetails);
    builder.append("<div class='indent'>" + buildObjectDependenciesOPL(opd) + "</div>");

    return builder.toString();
  }

  private String getProcessDetailsOPL(OPMProcess process) {
    StringBuilder processDetailsOPLBuilder = new StringBuilder();
    processDetailsOPLBuilder.append("<p>" + format(process));
    Collection<OPMProceduralLink> incomingDataLinks = analyzer.findIncomingDataLinks(process);
    List<String> processDetails = Lists.newArrayList();
    if(incomingDataLinks.size() == 0) {
      processDetailsOPLBuilder.append(" has no arguments.</p>");
    } else {
      String agentsOPL = getProcessAgentsOPL(incomingDataLinks);
      if(!"".equals(agentsOPL)) {
        processDetails.add(agentsOPL);
      }
      String instrumentsOPL = getProcessInstrumentsOPL(incomingDataLinks);
      if(!"".equals(instrumentsOPL)) {
        processDetails.add(instrumentsOPL);
      }
      String consumeesOPL = getProcessConsumeesOPL(incomingDataLinks);
      if(!"".equals(consumeesOPL)) {
        processDetails.add(consumeesOPL);
      }
    }

    Collection<OPMProceduralLink> outgoingDataLinks = analyzer.findOutgoingDataLinks(process);
    if(outgoingDataLinks.size() != 0) {
      String resultsOPL = getProcessResultsOPL(outgoingDataLinks);
      if(!"".equals(resultsOPL)) {
        processDetails.add(resultsOPL);
      }
    }

    processDetailsOPLBuilder.append(buildCommaSeparatedList(processDetails.toArray(new String[0])));

    return processDetailsOPLBuilder.toString();
  }

  private String getProcessResultsOPL(Collection<OPMProceduralLink> outgoingDataLinks) {
    StringBuilder builder = new StringBuilder();
    if(outgoingDataLinks.size() == 0) {
      return "";
    } else {
      builder.append(" yields ");
      builder.append(buildCommaSeparatedProceduralLinksSentenceByTarget(outgoingDataLinks));
    }
    return builder.toString();
  }

  private String getProcessAgentsOPL(Collection<OPMProceduralLink> incomingDataLinks) {
    StringBuilder builder = new StringBuilder();
    Collection<OPMProceduralLink> agentLinks = analyzer.findAgentLinks(incomingDataLinks);
    if(agentLinks.size() == 0) {
      return "";
    } else {
      builder.append(" is driven by ");
      builder.append(buildCommaSeparatedProceduralLinksSentenceBySource(agentLinks));
    }
    return builder.toString();
  }

  private String getProcessInstrumentsOPL(Collection<OPMProceduralLink> incomingDataLinks) {
    StringBuilder builder = new StringBuilder();
    Collection<OPMProceduralLink> instrumentLinks = analyzer.findInstrumentLinks(incomingDataLinks);
    if(instrumentLinks.size() == 0) {
      return "";
    } else {
      builder.append(" requires ");
      builder.append(buildCommaSeparatedProceduralLinksSentenceBySource(instrumentLinks));
    }
    return builder.toString();
  }

  private String getProcessConsumeesOPL(Collection<OPMProceduralLink> incomingDataLinks) {
    StringBuilder builder = new StringBuilder();
    Collection<OPMProceduralLink> consumptionLinks = analyzer.findConsumptionLinks(incomingDataLinks);
    if(consumptionLinks.size() == 0) {
      return "";
    } else {
      builder.append(" consumes ");
      builder.append(buildCommaSeparatedProceduralLinksSentenceBySource(consumptionLinks));
    }
    return builder.toString();
  }

  private String buildCommaSeparatedProceduralLinksSentenceBySource(Collection<OPMProceduralLink> links) {
    String[] elements = new String[links.size()];
    OPMProceduralLink[] linksArray = links.toArray(new OPMProceduralLink[0]);
    for(int i = 0; i < linksArray.length; i++) {
      if(linksArray[i].getCenterDecoration() == null || "".equals(linksArray[i].getCenterDecoration())) {
        elements[i] = format((OPMNamedElement) linksArray[i].getSource());
      } else {
        elements[i] = format((OPMNamedElement) linksArray[i].getSource()) + " as "
            + formatParameter(linksArray[i].getCenterDecoration());
      }
    }
    return buildCommaSeparatedList(elements);
  }

  private String buildCommaSeparatedProceduralLinksSentenceByTarget(Collection<OPMProceduralLink> links) {
    String[] elements = new String[links.size()];
    OPMProceduralLink[] linksArray = links.toArray(new OPMProceduralLink[0]);
    for(int i = 0; i < linksArray.length; i++) {
      if(linksArray[i].getCenterDecoration() == null || "".equals(linksArray[i].getCenterDecoration())) {
        elements[i] = format((OPMNamedElement) linksArray[i].getTarget());
      } else {
        elements[i] = formatParameter(linksArray[i].getCenterDecoration()) + " as "
            + format((OPMNamedElement) linksArray[i].getTarget());
      }
    }
    return buildCommaSeparatedList(elements);
  }

  private String buildCommaSeparatedNamedElementSentence(OPMNamedElement[] elements) {
    String[] names = new String[elements.length];
    for(int i = 0; i < elements.length; i++) {
      names[i] = format(elements[i]);
    }
    return buildCommaSeparatedList(names);
  }

  private String buildCommaSeparatedList(String[] elements) {
    if(elements.length == 0) {
      return "";
    } else if(elements.length == 1) {
      return elements[0];
    } else {
      StringBuilder builder = new StringBuilder();
      for(int i = 0; i < elements.length - 1; i++) {
        builder.append(elements[i] + ", ");
      }
      builder.append(elements[elements.length - 1]);
      return builder.toString();
    }
  }

  public String getStyleSheet() {
    // @formatter:off
    return "<style>\n" 
        + "p {margin:0;}\n"
        + "* {font-family:sans-serif;font-size:1em;}\n" 
        + ".process {color:blue;}\n"
        + ".object {color:green;}\n"
        + ".state {color:brown;}\n"
        + ".parameter {color:purple;}\n" 
        + ".indent {text-indent: 5em;}\n"
        + "</style>\n";
    // @formatter:on
  }

  public String formatParameter(String parameter) {
    return "<span class='parameter'>" + parameter + "</span>";
  }

  public String format(OPMNamedElement element) {
    if(element == null)
      return "";

    if(OPMObjectProcessDiagram.class.isInstance(element)) {
      return formatOPD((OPMObjectProcessDiagram) element);
    } else if(OPMProcess.class.isInstance(element)) {
      return formatProcess((OPMProcess) element);
    } else if(OPMObject.class.isInstance(element)) {
      return formatObject((OPMObject) element);
    } else if(OPMState.class.isInstance(element)) {
      return formatState((OPMState) element);
    } else
      throw new IllegalArgumentException(element.toString());
  }

  public String formatProcess(OPMProcess process) {
    return "<span class='process'>" + process.getName() + "</span>";
  }

  public String formatObject(OPMObject object) {
    return "<span class='object'>" + object.getName() + "</span>";
  }

  public String formatState(OPMState state) {
    return "<span class='state'>" + state.getName() + "</span>";
  }

  public String formatOPD(OPMObjectProcessDiagram opd) {
    return "<span class='process'>" + opd.getName() + "</span>";
  }

  public class OPMObjectProcessDiagramAdapter extends EContentAdapter {
    @Override
    public void notifyChanged(Notification notification) {
      super.notifyChanged(notification);
      refresh();
    }
  }
}

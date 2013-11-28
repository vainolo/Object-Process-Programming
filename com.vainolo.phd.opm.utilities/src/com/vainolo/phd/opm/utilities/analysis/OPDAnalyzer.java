package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;
import java.util.Set;

import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMPackage;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPDAnalyzer {
  private OPDAnalysis analyzer = OPDAnalysis.INSTANCE;

  /**
   * Calculate the processes that should be executed when the OPD is invoked.
   * These are the processes that have no predecessors in the OPD DAG.
   * 
   * @param opdDag
   *          the OPD DAG that is analyzed.
   * @return the processes that should be executed when the OPD is invoked.
   */
  public Set<OPMProcess> calculateInitialProcesses(final DirectedAcyclicGraph<OPMProcess, DefaultEdge> opdDag) {
    Preconditions.checkArgument(opdDag != null, "OPD DAG cannot be null.");

    final Set<OPMProcess> retVal = Sets.newHashSet();

    for(final OPMProcess process : opdDag.vertexSet()) {
      if(opdDag.inDegreeOf(process) == 0) {
        retVal.add(process);
      }
    }

    return retVal;
  }

  /**
   * Recursively find the OPD that contains the node.
   * 
   * @param node
   *          that is contained in the OPD (maybe down many levels).
   * @return the OPD where the node is contained.
   */
  public OPMObjectProcessDiagram findOPD(OPMNode node) {
    OPMContainer currentContainer = node.getContainer();
    while(!(currentContainer instanceof OPMObjectProcessDiagram)) {
      currentContainer = ((OPMNode) currentContainer).getContainer();
    }
    return (OPMObjectProcessDiagram) currentContainer;
  }

  /**
   * Find all the variables directly contained in an {@link OPMContainer}.
   * 
   * @param container
   *          to search.
   * @return all variables directly contained in the {@link OPMContainer}.
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPMObject> findObjects(OPMContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsOPMObjectNode.INSTANCE);
  }

  /**
   * Find all the parameter {@link OPMObject}s directly below an
   * {@link OPMObjectProcessDiagram}
   * 
   * @param opd
   *          to search.
   * @return all parameters directly contained in an OPD.
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Collection<OPMObject> findParameters(OPMObjectProcessDiagram opd) {
    return (Collection) Collections2.filter(opd.getNodes(), IsOPMParameter.INSTANCE);
  }

  /**
   * Find all the incoming structural {@link OPMLink}s of a {@link OPMNode}.
   * 
   * @param node
   *          that is being searched.
   * @return all incoming structural links.
   */
  public Collection<OPMLink> findIncomingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getIncomingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  /**
   * Find all the outgoing structural {@link OPMLink}s of a {@link OPMNode}
   * 
   * @param node
   *          that is being searched.
   * @return all outgoing structural links.
   */
  public Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node) {
    return Collections2.filter(node.getOutgoingLinks(), IsOPMStructuralLink.INSTANCE);
  }

  /**
   * Find all the incoming data links of the process.
   * 
   * @param process
   *          to search.
   * @return all incoming data links.
   */
  public Collection<OPMProceduralLink> findIncomingDataLinks(OPMProcess process) {
    return (Collection) Collections2.filter(process.getIncomingLinks(), new IsOPMProcessIncomingDataLink());
  }

  /**
   * Find all outgoing data links of a process.
   * 
   * @param process
   *          to search.
   * @return all outgoing data links
   */
  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process) {
    return (Collection) Collections2.filter(process.getOutgoingLinks(), IsOPMProcessOutgoingDataLink.INSTANCE);
  }

  /**
   * Find all outgoing data links of an object.
   * 
   * @param object
   *          to search.
   * @return all outgoing data links
   */
  public Collection<OPMProceduralLink> findOutgoingDataLinks(OPMObject object) {
    return (Collection) Collections2.filter(object.getOutgoingLinks(), new IsOPMObjectOutgoingDataLink());
  }

  /**
   * Find the main {@link OPMProcess} in an in-zoomed process
   * {@link OPMObjectProcessDiagram}.
   * 
   * @param opd
   *          an in-zoomed {@link OPMProcess} {@link OPMObjectProcessDiagram}.
   * @return
   * @throws IllegalStateException
   *           if there is no main {@link OPMProcess} or there is more than one
   *           {@link OPMProcess} directly below the
   *           {@link OPMObjectProcessDiagram}
   */
  public OPMProcess getInZoomedProcess(OPMObjectProcessDiagram opd) {
    OPMProcess inZoomedProcess = null;
    for(OPMNode node : opd.getNodes()) {
      if(OPMProcess.class.isInstance(node)) {
        if(inZoomedProcess != null) {
          throw new IllegalStateException("More than one process found in an in-zoomed OPD");
        } else {
          inZoomedProcess = (OPMProcess) node;
        }
      }
    }
    if(inZoomedProcess == null) {
      throw new IllegalStateException("No process found in an in-zoomed OPD");
    }
    return inZoomedProcess;
  }

  /**
   * Predicate that matches {@link OPMLink}s which are structural.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPMStructuralLink implements Predicate<OPMLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPMLink link) {
      if(OPMPackage.eINSTANCE.getOPMStructuralLinkAggregator().isInstance(link.getSource())
          || OPMPackage.eINSTANCE.getOPMStructuralLinkAggregator().isInstance(link.getTarget()))
        return true;

      return false;
    }
  }

  /**
   * Predicate that matches {@link OPMObject}s which are parameters.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPMParameter implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMObject.class.isInstance(node)) {
        OPMObject o = (OPMObject) node;
        if(o.isParameter()) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Predicate that matches all {@link OPMObject}s which are not parameters.
   * 
   * @author Arieh "Vainolo" Bibliowicz
   * 
   */
  public enum IsOPMVariable implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMObject.class.isInstance(node)) {
        OPMObject o = (OPMObject) node;
        if(!o.isParameter()) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * Predicate that matches {@link OPMProcess} incoming {@link OPMLink}s.
   * 
   * @author
   * 
   */
  private static class IsOPMDataLink implements Predicate<OPMLink> {
    @Override
    public boolean apply(final OPMLink link) {
      if(!OPMProceduralLink.class.isInstance(link))
        return false;
      else {
        OPMProceduralLink localLink = OPMProceduralLink.class.cast(link);
        switch(localLink.getKind()) {
        case AGENT:
        case CONSUMPTION:
        case INSTRUMENT:
          return true;
        default:
          return false;
        }
      }
    }
  }

  private static class IsOPMProcessIncomingDataLink extends IsOPMDataLink {
  }

  private static class IsOPMObjectOutgoingDataLink extends IsOPMDataLink {
  }

  /**
   * Predicate that matches {@link OPMProcess} outgoing
   * {@link OPMProceduralLink}s.
   */
  private enum IsOPMProcessOutgoingDataLink implements Predicate<OPMLink> {
    INSTANCE;

    @Override
    public boolean apply(final OPMLink link) {
      if(!OPMProceduralLink.class.isInstance(link))
        return false;
      else {
        OPMProceduralLink localLink = OPMProceduralLink.class.cast(link);
        switch(localLink.getKind()) {
        case RESULT:
          return true;
        default:
          return false;
        }
      }
    }
  }

  /**
   * Predicate that matches {@link OPMNode} instances that are also
   * {@link OPMObject} instances.
   * 
   */
  public enum IsOPMObjectNode implements Predicate<OPMNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPMNode node) {
      if(OPMPackage.eINSTANCE.getOPMObject().isInstance(node))
        return true;
      return false;
    }
  }

}

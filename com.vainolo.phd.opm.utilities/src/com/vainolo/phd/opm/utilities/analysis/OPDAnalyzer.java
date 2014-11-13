package com.vainolo.phd.opm.utilities.analysis;

import java.util.Collection;

import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.model.OPMProcess;
import com.vainolo.phd.opm.model.OPMState;

public interface OPDAnalyzer {

  public abstract Collection<OPMProcess> findFirstLevelContainedProcesses(OPMContainer container);

  /**
   * Return the {@link OPMObject} connected to an {@link OPMProceduralLink},
   * when there is no ambiguity.
   * 
   * @param link
   *          connected to an {@link OPMObject}
   * @return the source or target {@link OPMObject} of the
   *         {@link OPMProceduralLink}, if there is no ambiguity, or
   *         <code>null</code> if there is ambiguity.
   */
  public abstract OPMObject getObject(OPMLink link);

  /**
   * Return the {@link OPMProcess} connected to an {@link OPMLink}, when there
   * is no ambiguity.
   * 
   * @param link
   *          connected to an {@link OPMProcess}
   * @return the source or target {@link OPMProcess} of the {@link OPMLink}, if
   *         there is no ambiguity, or <code>null</code> if there is ambiguity.
   */
  public abstract OPMProcess getProcess(OPMLink link);

  /**
   * Recursively find the OPD that contains the node.
   * 
   * @param node
   *          that is contained in the OPD (maybe down many levels).
   * @return the OPD where the node is contained.
   */
  public abstract OPMObjectProcessDiagram findOPD(OPMNode node);

  /**
   * Find all the parameters of the OPD. The definition of a parameter is based
   * on how the process is being modeled. Currently, parameters are all the
   * objects directly below the OPD, which are not inside the main process, and
   * are not part of a compound object.
   * 
   * @param opd
   *          to search.
   * @return the parameters of the OPD.
   */
  public abstract Collection<OPMObject> findParameters(OPMObjectProcessDiagram opd);

  public abstract Collection<OPMObject> findIncomingParameters(OPMObjectProcessDiagram opd);

  public abstract Collection<OPMObject> findOutgoingParameters(OPMObjectProcessDiagram opd);

  public abstract boolean hasOutgoingDataLinks(OPMObject object);

  /**
   * Find all the {@link OPMObject} instances directly contained in an
   * {@link OPMContainer}.
   * 
   * @param container
   *          to search.
   * @return all {@link OPMObject} instances directly contained in the
   *         {@link OPMContainer}.
   */
  public abstract Collection<OPMObject> findObjects(OPMContainer container);

  /**
   * Find all the {@link OPMProcess} instances directly contained in an
   * {@link OPMContainer}.
   * 
   * @param container
   *          to search.
   * @return all {@link OPMProcess} insatnces directly contained in the
   *         {@link OPMContainer}.
   */
  public abstract Collection<OPMProcess> findProcesses(OPMContainer container);

  /**
   * Find all the incoming structural {@link OPMLink}s of a {@link OPMNode}.
   * 
   * @param node
   *          that is being searched.
   * @return all incoming structural links.
   */
  public abstract Collection<OPMLink> findIncomingStructuralLinks(OPMNode node);

  /**
   * Find all the outgoing structural {@link OPMLink}s of a {@link OPMNode}
   * 
   * @param node
   *          that is being searched.
   * @return all outgoing structural links.
   */
  public abstract Collection<OPMLink> findOutgoingStructuralLinks(OPMNode node);

  /**
   * Find all incoming procedural links of an {@link OPMProcess}
   * 
   * @param process
   *          to search.
   * @result all incoming procedural links.
   */
  public abstract Collection<OPMProceduralLink> findIncomingProceduralLinks(OPMProcess process);

  /**
   * Find all the incoming data links of an {@link OPMProcess}.
   * 
   * @param process
   *          to search.
   * @return all incoming data links.
   */
  public abstract Collection<OPMProceduralLink> findIncomingDataLinks(OPMProcess process);

  /**
   * Find all the incoming driver links of an {@link OPMProcess}.
   * 
   * @param process
   *          to search.
   * @return all incoming driver links.
   */
  public abstract Collection<OPMProceduralLink> findIncomingDriverLinks(OPMProcess process);

  /**
   * Find all the incoming data links of an {@link OPMObject}.
   * 
   * @param process
   *          to search.
   * @return all incoming data links.
   */
  public abstract Collection<OPMProceduralLink> findIncomingInstrumentLinks(OPMObject object);

  /**
   * Find all agent links in a {@link Collection} of {@link OPMProceduralLink}
   * instances.
   * 
   * @param links
   *          to search
   * @return all agent links in collection
   */
  public abstract Collection<OPMProceduralLink> findAgentLinks(Collection<OPMProceduralLink> links);

  /**
   * Find all instrument links in a {@link Collection} of
   * {@link OPMProceduralLink} instances.
   * 
   * @param links
   *          to search
   * @return all instrument links in collection
   */
  public abstract Collection<OPMProceduralLink> findInstrumentLinks(Collection<OPMProceduralLink> links);

  /**
   * Find all consumption links in a {@link Collection} of
   * {@link OPMProceduralLink} instances.
   * 
   * @param links
   *          to search
   * @return all consumption links in collection
   */
  public abstract Collection<OPMProceduralLink> findConsumptionLinks(Collection<OPMProceduralLink> links);

  /**
   * Find all outgoing data links of a process.
   * 
   * @param process
   *          to search.
   * @return all outgoing data links
   */
  public abstract Collection<OPMProceduralLink> findOutgoingDataLinks(OPMProcess process);

  /**
   * Findl all outgoing data links of an {@link OPMState}.
   * 
   * @param state
   *          to search.
   * @return all outgoing data links
   */
  public abstract Collection<OPMProceduralLink> findOutgoingDataLinks(OPMState state);

  /**
   * Find all outgoing data links of an {@link OPMObject}, including links that
   * start at an inner {@link OPMState}.
   * 
   * @param object
   *          to search.
   * @return all outgoing data links
   */
  public abstract Collection<OPMProceduralLink> findOutgoingDataTrasferLinks(OPMObject object);

  public abstract boolean isLinkTargetAnObject(OPMProceduralLink link);

  /**
   * Find all outgoing data links of an object that are event links.
   * 
   * @param object
   *          to search
   * @return all outgoing event links
   */
  public abstract Collection<OPMProceduralLink> findOutgoingEventLinks(OPMObject object);

  /**
   * Find all states contained in an {@link OPMObject}.
   * 
   * @param object
   *          to search
   * @return all states contained in the {@link OPMObject}.
   */
  public abstract Collection<OPMState> findStates(OPMObject object);

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
  public abstract OPMProcess getInZoomedProcess(OPMObjectProcessDiagram opd);

  public abstract boolean isObjectPartOfAnotherObject(OPMObject object);

  /**
   * Find the aggregate parent of this {@link OPMObject}, or <code>null</code>
   * if the {@link OPMObject} has no parent.
   * 
   * @param object
   *          being searched.
   * @return the parent of this {@link OPMObject} if it has one,
   *         <code>null</code> otherwise.
   */
  public abstract OPMObject findParent(OPMObject object);

}
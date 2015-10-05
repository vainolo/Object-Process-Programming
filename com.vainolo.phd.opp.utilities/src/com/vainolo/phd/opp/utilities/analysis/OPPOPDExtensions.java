package com.vainolo.phd.opp.utilities.analysis;

import static com.vainolo.phd.opp.utilities.OPPLogger.logWarning;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.model.OPPThing;

public class OPPOPDExtensions {
  private OPPContainerExtensions containerExt = new OPPContainerExtensions();
  private OPPObjectExtensions objectExt = new OPPObjectExtensions();

  public Collection<OPPObject> findParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> firstLevelObjects = containerExt.findObjects(opd);
    return Collections2.filter(firstLevelObjects, ObjectNotPartOfAnotherObject.INSTANCE);
  }

  public Collection<OPPObject> findIncomingParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> incomingParameters = Lists.newArrayList();
    for (OPPObject parameter : findParameters(opd)) {
      if (objectExt.hasOutgoingDataLinks(parameter)) {
        incomingParameters.add(parameter);
      }
    }
    return incomingParameters;
  }

  public Collection<OPPObject> findOutgoingParameters(OPPObjectProcessDiagram opd) {
    Collection<OPPObject> outgoingParameters = Lists.newArrayList();
    for (OPPObject parameter : findParameters(opd)) {
      if (objectExt.hasIncomingResultLink(parameter)) {
        outgoingParameters.add(parameter);
      }
    }
    return outgoingParameters;
  }

  public OPPProcess getInZoomedProcess(OPPObjectProcessDiagram opd) {
    OPPProcess inZoomedProcess = null;
    for (OPPNode node : opd.getNodes()) {
      if (node instanceof OPPProcess) {
        if (inZoomedProcess != null) {
          throw new IllegalStateException("More than one process found in an in-zoomed OPD");
        } else {
          inZoomedProcess = (OPPProcess) node;
        }
      }
    }
    if (inZoomedProcess == null) {
      logWarning("Tried to get an in-zoomed process when none exist in the diagram. OPD: {0}.", opd.getName());
    }
    return inZoomedProcess;
  }

  public OPPThing getUnfoldedThing(OPPObjectProcessDiagram opd) {
    OPPThing unfoldedThing = getThingByName(opd, opd.getName());
    if (unfoldedThing == null)
      logWarning("Tried to get an unfolded thing when none exist in the diagram. OPD: {0}.", opd.getName());
    return unfoldedThing;
  }

  private OPPThing getThingByName(OPPObjectProcessDiagram opd, String name) {
    for (OPPNode node : opd.getNodes()) {
      if (node instanceof OPPThing) {
        OPPThing thing = OPPThing.class.cast(node);
        if (thing.getName().equals(opd.getName())) {
          return thing;
        }
      }
    }
    return null;
  }

  public OPPProcess getSystemProcess(OPPObjectProcessDiagram opd) {
    OPPThing systemThing = getThingByName(opd, opd.getName());
    if (systemThing == null)
      logWarning("Tried to get a system thing when none exist in the diagram. OPD: {0}.", opd.getName());
    return OPPProcess.class.cast(systemThing);
  }

  // Predicates
  public enum ObjectNotPartOfAnotherObject implements Predicate<OPPObject> {
    INSTANCE;

    private OPPOPDAnalyzer analyzer = new OPPOPDAnalyzer();

    @Override
    public boolean apply(OPPObject object) {
      return !analyzer.isObjectPartOfAnotherObject(object);
    }
  }
}

package com.vainolo.phd.opp.utilities.analysis;

import java.util.Collection;
import java.util.stream.Collectors;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProcess;

public class OPPContainerExtensions {

  /**
   * Find {@link OPPObject}s directly inside a container.
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public Collection<OPPObject> findObjects(OPPContainer container) {
    return (Collection) container.getNodes().stream().filter(n -> n instanceof OPPObject).collect(Collectors.toList());
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProcess> getProcesses(OPPContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsProcessNode.INSTANCE);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Collection<OPPProcess> findFirstLevelContainedProcesses(OPPContainer container) {
    return (Collection) Collections2.filter(container.getNodes(), IsProcessNode.INSTANCE);
  }

  public enum IsProcessNode implements Predicate<OPPNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPPNode node) {
      if (OPPProcess.class.isInstance(node))
        return true;
      return false;
    }
  }

  public enum IsObjectNode implements Predicate<OPPNode> {
    INSTANCE;

    @Override
    public boolean apply(final OPPNode node) {
      if (OPPObject.class.isInstance(node))
        return true;
      return false;
    }
  }

}

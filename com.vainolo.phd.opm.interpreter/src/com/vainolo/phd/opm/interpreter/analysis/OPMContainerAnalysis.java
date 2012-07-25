/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.analysis;

import java.util.Collection;

import com.google.common.base.Preconditions;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMObjectNode;
import com.vainolo.phd.opm.interpreter.predicates.IsOPMProcessNode;
import com.vainolo.phd.opm.interpreter.predicates.OPMNamedElementNameEquals;
import com.vainolo.phd.opm.model.OPMContainer;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMProcess;

import static java.util.Collections.checkedCollection;

import static com.google.common.base.Preconditions.checkNotNull;

import static com.google.common.collect.Collections2.filter;

public class OPMContainerAnalysis {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  static Collection<OPMObject> findContainedObjects(OPMContainer container) {
    return checkedCollection((Collection) filter(container.getNodes(), IsOPMObjectNode.INSTANCE), OPMObject.class);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  static Collection<OPMProcess> findContainedProcesses(OPMContainer container) {
    checkNotNull(container);
    return checkedCollection((Collection) filter(container.getNodes(), IsOPMProcessNode.INSTANCE), OPMProcess.class);
  }

  static Collection<OPMProcess> findContainedProcesses(OPMContainer container, String name) {
    Preconditions.checkNotNull(container);
    Preconditions.checkNotNull(name);

    return filter(findContainedProcesses(container), new OPMNamedElementNameEquals(name));
  }
}

/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter.inzoomedprocessinstance;

import static com.google.common.base.Preconditions.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.model.OPPProcess;
import com.vainolo.phd.opp.utilities.analysis.OPPContainerExtensions;
import com.vainolo.phd.opp.utilities.analysis.OPPOPDExtensions;

public class OPPInZoomedProcessIntanceProgramCounter {
  private int pc = 0;
  private OPPObjectProcessDiagram opd;
  List<OPPProcess> sortedProcesses;

  public OPPInZoomedProcessIntanceProgramCounter(OPPObjectProcessDiagram opd) {
    pc = 0;
    this.opd = opd;
    initialize();
  }

  private void initialize() {
    OPPContainerExtensions contExt = new OPPContainerExtensions();

    OPPProcess inZoomedProcess = OPPOPDExtensions.getInZoomedProcess(opd);
    OPPProcessOrdering ordering = new OPPProcessOrdering();
    sortedProcesses = ordering.sortedCopy(contExt.getProcesses(inZoomedProcess));
  }

  public int getNextPC() {
    for (OPPProcess process : sortedProcesses) {
      if (process.getY() > pc) {
        return process.getY();
      }
    }
    return Integer.MAX_VALUE;
  }

  private List<OPPProcess> getProcessesAtPC() {
    List<OPPProcess> processesAtPC = Lists.newArrayList();
    for (OPPProcess process : sortedProcesses) {
      if (process.getY() == pc)
        processesAtPC.add(process);
      if (process.getY() > pc)
        break;
    }
    return processesAtPC;
  }

  public List<OPPProcess> getNextProcesses(Collection<OPPProcess> P_waiting, Collection<OPPProcess> P_executing) {
    List<OPPProcess> nextPossibleProcess = getProcessesAtPC();
    if (nextPossibleProcess.size() == 0)
      return Collections.emptyList();

    OPPProcess firstPossibleProcess = nextPossibleProcess.get(0);
    for (OPPProcess waitingProcess : P_waiting) {
      if (firstPossibleProcess.getY() > (waitingProcess.getY() + waitingProcess.getHeight()))
        return Collections.emptyList();
    }

    for (OPPProcess executingProcess : P_executing) {
      if (firstPossibleProcess.getY() > (executingProcess.getY() + executingProcess.getHeight()))
        return Collections.emptyList();
    }

    return nextPossibleProcess;
  }

  public void setPC(int pc) {
    checkArgument(pc >= 0, "Tried to set a negative PC.");
    this.pc = pc;
  }

  class OPPProcessOrdering extends Ordering<OPPProcess> {

    @Override
    public int compare(OPPProcess arg1, OPPProcess arg2) {
      return arg1.getY() - arg2.getY();
    }

  }

}

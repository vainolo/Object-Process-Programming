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
    OPPOPDExtensions opdExt = new OPPOPDExtensions();
    OPPContainerExtensions contExt = new OPPContainerExtensions();

    OPPProcess inZoomedProcess = opdExt.getInZoomedProcess(opd);
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

    for (OPPProcess waitingProcess : P_waiting) {
      if (nextPossibleProcess.get(0).getY() > (waitingProcess.getY() + waitingProcess.getHeight()))
        return Collections.emptyList();
    }

    for (OPPProcess executingProcess : P_executing) {
      if (nextPossibleProcess.get(0).getY() > (executingProcess.getY() + executingProcess.getHeight()))
        return Collections.emptyList();
    }

    return nextPossibleProcess;
  }

  // private List<OPPProcess> getFirstProcessesBelowPC() {
  // List<OPPProcess> processes = Lists.newArrayList();
  // boolean found = false;
  // int foundY = 0;
  // for (OPPProcess process : sortedProcesses) {
  // if (!found && (process.getY() > pcTop)) {
  // processes.add(process);
  // found = true;
  // foundY = process.getY();
  // } else if (found && (process.getY() == foundY)) {
  // processes.add(process);
  // } else {
  // break;
  // }
  // }
  //
  // return processes;
  // }

  // public OPPProcess getNextProcesses() {
  // List<OPPProcess> nextProcesses = Lists.newArrayList();
  // OPPProcess currentProcess = null;
  // int i;
  // for (i = 0; i < sortedProcesses.size(); i++) {
  // currentProcess = sortedProcesses.get(i);
  // if (currentProcess.getY() >= pcTop) {
  // break;
  // }
  // }
  // if (currentProcess == null)
  // return nextProcesses;
  //
  // nextProcesses.add(currentProcess);
  // int maxBottom = currentProcess.getY() + currentProcess.getHeight();
  // int j = i + 1;
  // for (; j < sortedProcesses.size(); j++) {
  // currentProcess = sortedProcesses.get(j);
  // if (currentProcess.getY() < maxBottom) {
  // nextProcesses.add(currentProcess);
  // if (maxBottom > currentProcess.getY() + currentProcess.getHeight())
  // maxBottom = currentProcess.getY() + currentProcess.getHeight();
  // } else {
  // break;
  // }
  // }
  //
  // return nextProcesses;
  // }

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

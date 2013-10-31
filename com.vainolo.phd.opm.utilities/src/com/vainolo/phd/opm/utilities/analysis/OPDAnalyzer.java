package com.vainolo.phd.opm.utilities.analysis;

import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;

public class OPDAnalyzer {
  private OPDAnalysis analyzer = OPDAnalysis.INSTANCE;

  public OPMObjectProcessDiagram findOPD(OPMNode node) {
    return analyzer.findOPD(node);
  }

}

package com.vainolo.phd.opm.utilities.analysis;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMObject;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.model.OPMProcess;

public class OPDAnalysisTest {

  private OPMObjectProcessDiagram opd;
  private Map<Integer, OPMProcess> processes = Maps.newHashMap();
  private Map<Integer, OPMObject> objects = Maps.newHashMap();

  @Test
  public void testFindOPD() {

  }

  @Before
  public void setUp() {
    opd = OPMFactory.eINSTANCE.createOPMObjectProcessDiagram();
    for(int i = 0; i < 5; i++) {
      OPMProcess process = OPMFactory.eINSTANCE.createOPMProcess();
      process.setName(Integer.toString(i));
      opd.getNodes().add(process);
    }

    for(int i = 0; i < 5; i++) {
      OPMObject object = OPMFactory.eINSTANCE.createOPMObject();
      object.setName(Integer.toString(i + 5));
      opd.getNodes().add(object);
    }

  }
}
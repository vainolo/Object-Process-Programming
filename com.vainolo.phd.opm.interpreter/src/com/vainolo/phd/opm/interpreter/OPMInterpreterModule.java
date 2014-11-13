package com.vainolo.phd.opm.interpreter;

import com.google.inject.AbstractModule;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzerImpl;

public class OPMInterpreterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(OPMObjectInstanceValueAnalyzer.class).to(OPMObjectInstanceValueAnalyzerImpl.class);
    bind(OPDAnalyzer.class).to(OPDAnalyzerImpl.class);
  }
}

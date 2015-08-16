package com.vainolo.phd.opp.interpreter;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Singleton class implementing dependency injection.
 */
public enum OPMInterpreterInjector {
  INSTANCE;

  private final Injector injector;

  private OPMInterpreterInjector() {
    injector = Guice.createInjector(new OPMInterpreterModule());
  }

  public <T> T getInstance(Class<T> clazz) {
    return injector.getInstance(clazz);
  }

}

package com.vainolo.phd.opp.interpreter;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Singleton class implementing dependency injection.
 */
public enum OPPInterpreterInjector {
  INSTANCE;

  private final Injector injector;

  private OPPInterpreterInjector() {
    injector = Guice.createInjector(new OPPInterpreterModule());
  }

  public <T> T getInstance(Class<T> clazz) {
    return injector.getInstance(clazz);
  }

}

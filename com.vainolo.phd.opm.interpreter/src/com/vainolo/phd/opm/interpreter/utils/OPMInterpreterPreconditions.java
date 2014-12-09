package com.vainolo.phd.opm.interpreter.utils;

import static com.google.common.base.Preconditions.*;

import com.vainolo.phd.opm.interpreter.OPMObjectInstance;
import com.vainolo.phd.opm.interpreter.OPMObjectInstance.InstanceType;

/**
 * General preconditions used when executing an OPP program
 * 
 * @author Arieh Bibliowicz
 * 
 */
public class OPMInterpreterPreconditions {
  public static void checkInstanceIsComposite(OPMObjectInstance instance, String message) {
    checkState(InstanceType.COMPOSITE.equals(instance.type), message);
  }

  public static void checkInstanceIsNotComposite(OPMObjectInstance instance, String message) {
    checkState(!InstanceType.COMPOSITE.equals(instance.type), message);
  }

  public static void checkInstanceIsCollection(OPMObjectInstance instance, String message) {
    checkState(InstanceType.COLLECTION.equals(instance.type), message);
  }

  public static void checkInstanceIsNotCollection(OPMObjectInstance instance, String message) {
    checkState(!InstanceType.COLLECTION.equals(instance.type), message);
  }
}

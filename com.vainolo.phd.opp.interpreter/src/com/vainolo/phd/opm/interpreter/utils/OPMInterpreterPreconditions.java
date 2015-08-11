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
  public static void checkInstanceArgumentIsComposite(OPMObjectInstance instance, String message) {
    checkArgument(InstanceType.COMPOSITE.equals(instance.type), message);
  }

  public static void checkInstanceArgumentIsNotComposite(OPMObjectInstance instance, String message) {
    checkArgument(!InstanceType.COMPOSITE.equals(instance.type), message);
  }

  public static void checkInstanceArgumentIsCollection(OPMObjectInstance instance, String message) {
    checkArgument(InstanceType.COLLECTION.equals(instance.type), message);
  }

  public static void checkInstanceArgumentIsNotCollection(OPMObjectInstance instance, String message) {
    checkArgument(!InstanceType.COLLECTION.equals(instance.type), message);
  }
}

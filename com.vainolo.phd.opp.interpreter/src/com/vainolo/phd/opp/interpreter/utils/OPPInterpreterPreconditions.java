package com.vainolo.phd.opp.interpreter.utils;

import static com.google.common.base.Preconditions.*;

import com.vainolo.phd.opp.interpreter.OPPObjectInstance;
import com.vainolo.phd.opp.interpreter.OPPObjectInstance.InstanceType;

/**
 * General preconditions used when executing an OPP program
 * 
 * @author Arieh Bibliowicz
 * 
 */
public class OPPInterpreterPreconditions {
  public static void checkInstanceArgumentIsComposite(OPPObjectInstance instance, String message) {
    checkArgument(InstanceType.COMPOSITE.equals(instance.type), message);
  }

  public static void checkInstanceArgumentIsNotComposite(OPPObjectInstance instance, String message) {
    checkArgument(!InstanceType.COMPOSITE.equals(instance.type), message);
  }

  public static void checkInstanceArgumentIsCollection(OPPObjectInstance instance, String message) {
    checkArgument(InstanceType.COLLECTION.equals(instance.type), message);
  }

  public static void checkInstanceArgumentIsNotCollection(OPPObjectInstance instance, String message) {
    checkArgument(!InstanceType.COLLECTION.equals(instance.type), message);
  }
}

/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.interpreter;

import static com.vainolo.phd.opp.utilities.OPPLogger.*;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPObject;
import com.vainolo.phd.opp.model.OPPProcess;

public class OPPJavaProcessExecutableInstance extends OPPAbstractProcessInstance implements OPPProcessInstance {

  private final Pattern classAndMethodAndParametersPattern = Pattern.compile("(.*)\\.([^\\.]*)\\((.*)\\)");

  private String className = null;
  private String methodName = null;
  private String[] parameters = new String[0];
  private Method method;
  private Object[] arguments;
  // private Object target = null;

  private OPPProcess process;

  public OPPJavaProcessExecutableInstance(OPPProcess process) {
    this.process = process;
  }

  @Override
  public String getName() {
    return process.getName();
  }

  @Override
  protected void executing() {
    loadMethod();
    for (String parameter : parameters) {
      OPPObject object = OPPFactory.eINSTANCE.createOPPObject();
      object.setName(parameter);
    }

    arguments = new Object[parameters.length];
    for (int i = 0; i < parameters.length; i++) {
      arguments[i] = getArgument("arg" + i);
    }

    // if(!Modifier.isStatic(method.getModifiers()))
    // target = getArgument("this");

    // final Object result = callMethod(method);
    // OPPObjectInstance instance = null; // OPMObjectInstance.createFromValue(result);
    // if (!method.getReturnType().equals(Void.TYPE)) {
    // setArgument("result", instance);
    // }
  }

  // private Object callMethod(Method method) {
  // Preconditions.checkNotNull(method);
  //
  // Object result = null;
  // try {
  // result = method.invoke(target, arguments);
  // } catch(ReflectiveOperationException e) {
  // logger.info("Method " + methodName +
  // " could not be called. See log for details.");
  // throw new RuntimeException(e);
  // }
  // return result;
  // }

  private Method loadMethod() {
    final Matcher classAndMethodAndParametersMatcher = classAndMethodAndParametersPattern.matcher(process.getDescription());

    if (!classAndMethodAndParametersMatcher.find()) {
      logInfo("Could not parse method definition " + process.getDescription() + " for process " + process.getName());
      throw new RuntimeException("Could not parse method definition " + process.getDescription() + " for process " + process.getName());
    }

    className = classAndMethodAndParametersMatcher.group(1);
    methodName = classAndMethodAndParametersMatcher.group(2);
    String methodParameters = classAndMethodAndParametersMatcher.group(3);

    if (!methodParameters.isEmpty()) {
      methodParameters = methodParameters.replaceAll("\\s*", "");
      parameters = methodParameters.split(",");
    }

    Method method = null;
    try {

      Class<?> cls = null;
      Class<?>[] parameterClasses = null;
      cls = getClass(className);

      if (parameters.length != 0) {
        parameterClasses = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
          parameterClasses[i] = getClass(parameters[i]);
        }
      }
      method = cls.getMethod(methodName, parameterClasses);

    } catch (ClassNotFoundException e) {
      logInfo("Could not load class " + className + " for process " + process.getName() + ". Check that the class is in the classpath.");
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      logInfo("Could not find methdod " + methodName + " in class " + className + ". Please check that you have given the correct parameters and try again.");
      throw new RuntimeException(e);
    } catch (SecurityException e) {
      logInfo("Some security exception happened. Don't know what this means :-)");
      throw new RuntimeException(e);
    }

    return method;
  }

  private Class<?> getClass(String name) throws ClassNotFoundException {
    if (byte.class.getName().equals(name))
      return byte.class;
    if (short.class.getName().equals(name))
      return short.class;
    if (int.class.getName().equals(name))
      return int.class;
    if (long.class.getName().equals(name))
      return long.class;
    if (float.class.getName().equals(name))
      return float.class;
    if (double.class.getName().equals(name))
      return double.class;
    if (boolean.class.getName().equals(name))
      return boolean.class;
    if (char.class.getName().equals(name))
      return char.class;

    if (name.charAt(0) == '[')
      throw new UnsupportedOperationException("Array parameters are not supported yet.");

    return Class.forName(name);
  }
}

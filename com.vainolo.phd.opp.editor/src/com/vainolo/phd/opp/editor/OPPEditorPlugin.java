/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor;

public class OPPEditorPlugin {

  private OPPEditorPlugin() {
  };

  public static OPPEditorPlugin INSTANCE = new OPPEditorPlugin();

  public void log(String s) {
    System.out.println(s);
  }

  public void log(Exception exception) {
    System.out.println(exception.getLocalizedMessage());
  }
}

/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.factory;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPPIdManager {
  private long _id = 0;

  public synchronized long getNextId() {
    long idToReturn = _id;
    _id++;
    return idToReturn;
  }

  public synchronized void setInitialId(long id) {
    _id = id;
  }
}

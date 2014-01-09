/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMIdManager {
  private static long _id = 0;

  public synchronized long getNextId() {
    long idToReturn = _id;
    _id++;
    return idToReturn;
  }

  public synchronized void setInitialId(long id) {
    _id = id;
  }
}

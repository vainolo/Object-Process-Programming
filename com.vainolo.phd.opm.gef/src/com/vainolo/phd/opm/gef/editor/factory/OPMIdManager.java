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
  private static long id = 0;

  public static synchronized long getNextId() {
    long idToReturn = id;
    id++;
    return idToReturn;
  }

  public static synchronized void setId(long _id) {
    id = _id;
  }
}

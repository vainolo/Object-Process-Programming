/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.gef.editor.factory;

import java.util.logging.Logger;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * 
 */
public class OPMIdManager {
  Logger logger = Logger.getLogger(OPMIdManager.class.getName());
  private long _id = 0;

  public synchronized long getNextId() {
    long idToReturn = _id;
    _id++;
    logger.info("Next id is " + _id);
    return idToReturn;
  }

  public synchronized void setInitialId(long id) {
    _id = id;
  }
}

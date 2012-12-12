/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.dvora.model.view;

import java.util.List;

import com.vainolo.dvora.model.common.Identifiable;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @model
 */
public interface Container extends Identifiable {

  /**
   * @model
   */
  public List<Node> getNodes();
}

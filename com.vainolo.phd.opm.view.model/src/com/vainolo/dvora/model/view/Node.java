/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.dvora.model.view;

import java.util.List;

import com.vainolo.dvora.model.common.Identifiable;

/**
 * @author Arieh 'Vainolo' Bibliowicz
 * @model
 */
public interface Node extends Identifiable {

  /**
   * @model
   */
  public List<Link> getIncomingLinks();

  /**
   * @model
   */
  public List<Link> getOutgoingLinks();

}

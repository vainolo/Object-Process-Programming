/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.dvora.model.view;

/**
 * 
 * @author Arieh 'Vainolo' Bibliowicz
 * @model
 */
public interface Link {

  /**
   * @model
   */
  public Node getSource();

  /**
   * @model
   */
  public Node getTarget();

}

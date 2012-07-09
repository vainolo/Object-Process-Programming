/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public interface OPMProceduralLinkFilter {
  public boolean filter(final OPMProceduralLinkKind link);

  public OutgoingLinkFilter outgoingFilter = new OutgoingLinkFilter();
  public IncomingLinkFilter incomingFilter = new IncomingLinkFilter();

}
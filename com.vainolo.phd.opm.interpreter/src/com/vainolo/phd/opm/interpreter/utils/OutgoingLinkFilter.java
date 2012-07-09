/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/
package com.vainolo.phd.opm.interpreter.utils;

import com.vainolo.phd.opm.model.OPMProceduralLinkKind;

public class OutgoingLinkFilter implements OPMProceduralLinkFilter {
  @Override
  public boolean filter(final OPMProceduralLinkKind kind) {
    switch(kind) {
      case RESULT:
      case EFFECT:
      case EFFECT_CONDITION:
      case EFFECT_EVENT:
        return true;
      default:
        return false;
    }
  }
}
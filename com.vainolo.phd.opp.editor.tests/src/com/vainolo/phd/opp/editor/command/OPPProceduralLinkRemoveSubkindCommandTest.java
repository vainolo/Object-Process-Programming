/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.vainolo.phd.opp.editor.command;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.editor.command.OPPProceduralLinkRemoveSubkindCommand;
import com.vainolo.phd.opp.validation.OPPProceduralLinkValidator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OPPProceduralLinkRemoveSubkindCommandTest {

  private OPPProceduralLink link;
  private OPPProceduralLinkValidator validatorMock;
  private String subkind;

  @Before
  public void setUp() throws Exception {
    link = OPPFactory.eINSTANCE.createOPPProceduralLink();
    validatorMock = mock(OPPProceduralLinkValidator.class);
    subkind = new String();
  }

  @Test
  public void test_Execute_RemoveExistingSubkind() {
    OPPProceduralLinkRemoveSubkindCommand command = new OPPProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    link.getSubKinds().add(subkind);
    command.execute();
    assertFalse(link.getSubKinds().contains(subkind));
  }

  @Test
  public void test_Undo_AddNewSubkind() {
    OPPProceduralLinkRemoveSubkindCommand command = new OPPProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    command.execute();
    command.undo();
    link.getSubKinds().add(subkind);
    assertTrue(link.getSubKinds().contains(subkind));
  }

  @Test
  public void test_CanExecute_ValidLinkAndSubkind() {
    OPPProceduralLinkRemoveSubkindCommand command = new OPPProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    when(validatorMock.canSubkindBeRemoved(link, subkind)).thenReturn(true);
    boolean result = command.canExecute();
    assertTrue(result);
  }

  @Test
  public void test_CanExecute_InvalidLinkAndSubkind() {
    OPPProceduralLinkRemoveSubkindCommand command = new OPPProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    when(validatorMock.canSubkindBeRemoved(link, subkind)).thenReturn(false);
    boolean result = command.canExecute();
    assertFalse(result);
  }
}

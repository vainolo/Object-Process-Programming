package com.vainolo.phd.opp.editor.command;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.model.OPPProceduralLink;
import com.vainolo.phd.opp.editor.command.OPPProceduralLinkAddSubkindCommand;
import com.vainolo.phd.opp.validation.OPPProceduralLinkValidator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OPPProceduralLinkAddSubkindCommandTest {

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
  public void test_Execute_AddNewSubkind() {
    OPPProceduralLinkAddSubkindCommand command = new OPPProceduralLinkAddSubkindCommand(link, subkind, validatorMock);
    command.execute();
    assertTrue(link.getSubKinds().contains(subkind));
  }

  @Test
  public void test_Undo_AddNewSubkind() {
    OPPProceduralLinkAddSubkindCommand command = new OPPProceduralLinkAddSubkindCommand(link, subkind, validatorMock);
    command.execute();
    command.undo();
    assertFalse(link.getSubKinds().contains(subkind));
  }

  @Test
  public void test_CanExecute_ValidLinkAndSubkind() {
    OPPProceduralLinkAddSubkindCommand command = new OPPProceduralLinkAddSubkindCommand(link, subkind, validatorMock);
    when(validatorMock.canSubkindBeAdded(link, subkind)).thenReturn(true);
    boolean result = command.canExecute();
    assertTrue(result);
  }

  @Test
  public void test_CanExecute_InvalidLinkAndSubkind() {
    OPPProceduralLinkAddSubkindCommand command = new OPPProceduralLinkAddSubkindCommand(link, subkind, validatorMock);
    when(validatorMock.canSubkindBeAdded(link, subkind)).thenReturn(false);
    boolean result = command.canExecute();
    assertFalse(result);
  }
}

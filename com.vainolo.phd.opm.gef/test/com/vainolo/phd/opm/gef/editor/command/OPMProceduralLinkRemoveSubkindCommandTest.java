package com.vainolo.phd.opm.gef.editor.command;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.model.OPMProceduralLink;
import com.vainolo.phd.opm.validation.OPMProceduralLinkValidator;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class OPMProceduralLinkRemoveSubkindCommandTest {

  private OPMProceduralLink link;
  private OPMProceduralLinkValidator validatorMock;
  private String subkind;

  @Before
  public void setUp() throws Exception {
    link = OPMFactory.eINSTANCE.createOPMProceduralLink();
    validatorMock = mock(OPMProceduralLinkValidator.class);
    subkind = new String();
  }

  @Test
  public void test_Execute_RemoveExistingSubkind() {
    OPMProceduralLinkRemoveSubkindCommand command = new OPMProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    link.getSubKinds().add(subkind);
    command.execute();
    assertFalse(link.getSubKinds().contains(subkind));
  }

  @Test
  public void test_Undo_AddNewSubkind() {
    OPMProceduralLinkRemoveSubkindCommand command = new OPMProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    command.execute();
    command.undo();
    link.getSubKinds().add(subkind);
    assertTrue(link.getSubKinds().contains(subkind));
  }

  @Test
  public void test_CanExecute_ValidLinkAndSubkind() {
    OPMProceduralLinkRemoveSubkindCommand command = new OPMProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    when(validatorMock.canSubkindBeRemoved(link, subkind)).thenReturn(true);
    boolean result = command.canExecute();
    assertTrue(result);
  }

  @Test
  public void test_CanExecute_InvalidLinkAndSubkind() {
    OPMProceduralLinkRemoveSubkindCommand command = new OPMProceduralLinkRemoveSubkindCommand(link, subkind,
        validatorMock);
    when(validatorMock.canSubkindBeRemoved(link, subkind)).thenReturn(false);
    boolean result = command.canExecute();
    assertFalse(result);
  }
}

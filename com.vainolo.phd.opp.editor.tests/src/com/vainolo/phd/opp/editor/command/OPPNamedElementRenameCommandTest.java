package com.vainolo.phd.opp.editor.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.editor.command.OPPNamedElementRenameCommand;
import com.vainolo.phd.opp.model.OPPNamedElement;

public class OPPNamedElementRenameCommandTest {

  @Test
  public void testExecute() {
    String newName = "hello";
    OPPNamedElement namedElement = mock(OPPNamedElement.class);

    OPPNamedElementRenameCommand command = new OPPNamedElementRenameCommand();
    command.setNewName(newName);
    command.setModel(namedElement);
    command.execute();

    verify(namedElement).setName(newName);
  }

  @Test
  public void testUndo() {
    String oldName = "hello";
    String newName = "world";

    OPPNamedElement namedElement = mock(OPPNamedElement.class);
    when(namedElement.getName()).thenReturn(oldName);

    OPPNamedElementRenameCommand command = new OPPNamedElementRenameCommand();
    command.setNewName(newName);
    command.setModel(namedElement);
    command.execute();
    command.undo();
    verify(namedElement).getName();
    verify(namedElement).setName(newName);
    verify(namedElement).setName(oldName);
  }

  @Before
  public void setUp() {

  }

}

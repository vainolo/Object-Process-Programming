package com.vainolo.phd.opm.gef.editor.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.model.OPMNamedElement;

public class OPMNamedElementRenameCommandTest {

  @Test
  public void testExecute() {
    String newName = "hello";
    OPMNamedElement namedElement = mock(OPMNamedElement.class);

    OPMNamedElementRenameCommand command = new OPMNamedElementRenameCommand();
    command.setNewName(newName);
    command.setModel(namedElement);
    command.execute();

    verify(namedElement).setName(newName);
  }

  @Test
  public void testUndo() {
    String oldName = "hello";
    String newName = "world";

    OPMNamedElement namedElement = mock(OPMNamedElement.class);
    when(namedElement.getName()).thenReturn(oldName);

    OPMNamedElementRenameCommand command = new OPMNamedElementRenameCommand();
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

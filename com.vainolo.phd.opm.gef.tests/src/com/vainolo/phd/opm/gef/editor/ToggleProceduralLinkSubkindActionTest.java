package com.vainolo.phd.opm.gef.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IWorkbenchPart;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.vainolo.phd.opm.gef.editor.action.ToggleProceduralLinkSubkindAction;
import com.vainolo.phd.opm.gef.editor.part.OPMNodeEditPart;
import com.vainolo.phd.opm.gef.editor.part.OPMProceduralLinkEditPart;
import com.vainolo.phd.opm.model.OPMFactory;
import com.vainolo.phd.opm.utilities.OPMConstants;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 * Test cases for {@link ToggleProceduralLinkSubkindAction}.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class ToggleProceduralLinkSubkindActionTest extends ToggleProceduralLinkSubkindAction {

  /**
   * Dummy constructor. We are subclassing the original class in order to access
   * it's protected methods.
   */
  public ToggleProceduralLinkSubkindActionTest() {
    super(null, CONDITIONAL_SUBKIND_ID);
  }

  @SuppressWarnings("rawtypes")
  private List selectedObjects;
  private Request requestMock;
  private Command executedCommand;

  @Before
  public void setUp() throws Exception {
    requestMock = mock(Request.class);
  }

  @SuppressWarnings("rawtypes")
  @Test
  public void test_CalculateEnabled_NoSelectedObjects() {
    setSelectedObjects(new ArrayList());
    boolean result = calculateEnabled();
    assertFalse(result);
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Test
  public void test_CalculateEnabled_NonProceduralLinkObjectsSelected() {
    List selectedObjects = new ArrayList();
    selectedObjects.add(new Object());
    selectedObjects.add(OPMFactory.eINSTANCE.createOPMLink());
    setSelectedObjects(selectedObjects);
    boolean result = calculateEnabled();
    assertFalse(result);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Test
  public void test_CalculateEnabled_MixedProceduralLinkAndNonProceduralLinkObjectsSelected() {
    List selectedObjects = new ArrayList();
    selectedObjects.add(new Object());
    selectedObjects.add(mock(OPMNodeEditPart.class));
    selectedObjects.add(mock(OPMProceduralLinkEditPart.class));
    setSelectedObjects(selectedObjects);
    boolean result = calculateEnabled();
    assertFalse(result);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Test
  public void test_CalculateEnabled_OneProceduralLinkSelected() {
    List selectedObjects = new ArrayList();
    selectedObjects.add(mock(OPMProceduralLinkEditPart.class));
    setSelectedObjects(selectedObjects);
    boolean result = calculateEnabled();
    assertTrue(result);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Test
  public void test_CalculateEnabled_MultipleProceduralLinksSelected() {
    List selectedObjects = new ArrayList();
    selectedObjects.add(mock(OPMProceduralLinkEditPart.class));
    selectedObjects.add(mock(OPMProceduralLinkEditPart.class));
    selectedObjects.add(mock(OPMProceduralLinkEditPart.class));
    setSelectedObjects(selectedObjects);
    boolean result = calculateEnabled();
    assertFalse(result);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Test
  public void test_Run_OneProceduralLink() {
    List selectedObjects = new ArrayList();
    OPMProceduralLinkEditPart proceduralLinkEditPartMock = mock(OPMProceduralLinkEditPart.class);
    selectedObjects.add(proceduralLinkEditPartMock);
    setSelectedObjects(selectedObjects);
    Command commandMock = mock(Command.class);
    when(proceduralLinkEditPartMock.getCommand(requestMock)).thenReturn(commandMock);
    run();
    assertNotNull(executedCommand);
    assertTrue(CompoundCommand.class.isInstance(executedCommand));
    CompoundCommand command = CompoundCommand.class.cast(executedCommand);
    assertEquals(1, command.getCommands().size());
  }

  @Test
  public void test_Constructor_ToggleConditional() {
    ToggleProceduralLinkSubkindAction action = new ToggleProceduralLinkSubkindAction(mock(IWorkbenchPart.class),
        CONDITIONAL_SUBKIND_ID);
    Request request = action.getRequest();
    assertEquals(OPMConstants.OPM_CONDITIONAL_LINK_SUBKIND, request.getExtendedData().get("subkind"));
  }

  @Test
  public void test_Constructor_ToggleEvent() {
    ToggleProceduralLinkSubkindAction action = new ToggleProceduralLinkSubkindAction(mock(IWorkbenchPart.class),
        EVENT_SUBKIND_ID);
    Request request = action.getRequest();
    assertEquals(OPMConstants.OPM_EVENT_LINK_SUBKIND, request.getExtendedData().get("subkind"));
  }

  @Test
  public void test_Constructor_ToggleOptional() {
    ToggleProceduralLinkSubkindAction action = new ToggleProceduralLinkSubkindAction(mock(IWorkbenchPart.class),
        OPTIONAL_SUBKIND_ID);
    Request request = action.getRequest();
    assertEquals(OPMConstants.OPM_OPTIONAL_LINK_SUBKIND, request.getExtendedData().get("subkind"));
  }

  /**
   * Private function to set the mock objects currently selected.
   */
  private void setSelectedObjects(List objects) {
    selectedObjects = objects;
  }

  /**
   * Override for tests.
   */
  @Override
  protected List getSelectedObjects() {
    return selectedObjects;
  }

  /**
   * Override for tests.
   */
  @Override
  public Request getRequest() {
    return requestMock;
  }

  @Override
  protected void execute(Command command) {
    executedCommand = command;
  }
}

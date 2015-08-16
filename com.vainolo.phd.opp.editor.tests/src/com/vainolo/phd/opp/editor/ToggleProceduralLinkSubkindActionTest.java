package com.vainolo.phd.opp.editor;

import java.util.ArrayList; 
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.IWorkbenchPart;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.model.OPPFactory;
import com.vainolo.phd.opp.utilities.OPPConstants;
import com.vainolo.phd.opp.editor.action.OPMToggledProceduralLinkSubkindAction;
import com.vainolo.phd.opp.editor.part.OPMNodeEditPart;
import com.vainolo.phd.opp.editor.part.OPMProceduralLinkEditPart;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Test cases for {@link OPMToggledProceduralLinkSubkindAction}.
 * 
 * @author Arieh "Vainolo" Bibliowicz
 * 
 */
public class ToggleProceduralLinkSubkindActionTest extends OPMToggledProceduralLinkSubkindAction {

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
    selectedObjects.add(OPPFactory.eINSTANCE.createOPPLink());
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
    OPMToggledProceduralLinkSubkindAction action = new OPMToggledProceduralLinkSubkindAction(mock(IWorkbenchPart.class),
        CONDITIONAL_SUBKIND_ID);
    Request request = action.getRequest();
    assertEquals(OPPConstants.OPP_CONDITIONAL_LINK_SUBKIND, request.getExtendedData().get("subkind"));
  }

  @Test
  public void test_Constructor_ToggleEvent() {
    OPMToggledProceduralLinkSubkindAction action = new OPMToggledProceduralLinkSubkindAction(mock(IWorkbenchPart.class),
        EVENT_SUBKIND_ID);
    Request request = action.getRequest();
    assertEquals(OPPConstants.OPP_EVENT_LINK_SUBKIND, request.getExtendedData().get("subkind"));
  }

  @Test
  public void test_Constructor_ToggleOptional() {
    OPMToggledProceduralLinkSubkindAction action = new OPMToggledProceduralLinkSubkindAction(mock(IWorkbenchPart.class),
        OPTIONAL_SUBKIND_ID);
    Request request = action.getRequest();
    assertEquals(OPPConstants.OPP_OPTIONAL_LINK_SUBKIND, request.getExtendedData().get("subkind"));
  }

  /**
   * Private function to set the mock objects currently selected.
   */
  @SuppressWarnings("rawtypes")
  private void setSelectedObjects(List objects) {
    selectedObjects = objects;
  }

  /**
   * Override for tests.
   */
  @SuppressWarnings("rawtypes")
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

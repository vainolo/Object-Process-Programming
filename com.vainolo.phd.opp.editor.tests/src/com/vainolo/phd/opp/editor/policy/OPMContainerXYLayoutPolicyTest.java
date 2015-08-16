package com.vainolo.phd.opp.editor.policy;

import org.eclipse.draw2d.Figure; 
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.vainolo.phd.opp.editor.command.OPPNodeCreateCommand;
import com.vainolo.phd.opp.editor.policy.OPPContainerXYLayoutPolicy;
import com.vainolo.phd.opp.model.OPPContainer;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.validation.OPPNodeValidator;

public class OPMContainerXYLayoutPolicyTest {

  private OPPNodeValidator validator;
  private OPPContainer containerMock;
  private OPPNode nodeMock;
  private CreateRequest requestMock;
  private GraphicalEditPart editPartMock;
  private OPPContainerXYLayoutPolicy policy;
  private Figure figureMock;
  private XYLayout layoutManagerMock;

  @Test
  public void testGetCreateCommand_InvaidNode_ReturnNull() {
    when(editPartMock.getModel()).thenReturn(containerMock);
    when(requestMock.getNewObject()).thenReturn(nodeMock);
    when(validator.validateAddNode(containerMock, nodeMock)).thenReturn(false);
    policy.setHost(editPartMock);

    Command result = policy.getCreateCommand(requestMock);

    assertNull(result);
  }

  @Test
  public void testGetCreateCommand_ValidNode_ReturnCommand() {
    when(editPartMock.getModel()).thenReturn(containerMock);
    when(requestMock.getNewObject()).thenReturn(nodeMock);
    when(validator.validateAddNode(containerMock, nodeMock)).thenReturn(true);
    when(requestMock.getSize()).thenReturn(null);
    when(requestMock.getLocation()).thenReturn(new PrecisionPoint(0, 0));
    when(editPartMock.getContentPane()).thenReturn(figureMock);
    when(figureMock.getLayoutManager()).thenReturn(layoutManagerMock);
    when(layoutManagerMock.getOrigin(figureMock)).thenReturn(new PrecisionPoint(0, 0));
    policy.setHost(editPartMock);

    Command result = policy.getCreateCommand(requestMock);

    assertNotNull(result);
    assertTrue(OPPNodeCreateCommand.class.isInstance(result));
    OPPNodeCreateCommand command = OPPNodeCreateCommand.class.cast(result);
    assertEquals(containerMock, command.getContainer());
    assertEquals(nodeMock, command.getNode());

  }

  @Before
  public void setUp() throws Exception {
    editPartMock = mock(GraphicalEditPart.class);
    validator = mock(OPPNodeValidator.class);
    containerMock = mock(OPPContainer.class);
    nodeMock = mock(OPPNode.class);
    requestMock = mock(CreateRequest.class);
    figureMock = mock(Figure.class);
    layoutManagerMock = mock(XYLayout.class);

    policy = new OPPContainerXYLayoutPolicy(validator);

  }

}

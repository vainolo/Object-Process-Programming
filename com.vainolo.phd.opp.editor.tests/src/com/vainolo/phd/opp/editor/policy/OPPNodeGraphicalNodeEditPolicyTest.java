package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.commands.Command; 
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.editor.command.OPPCreateLinkCommand;
import com.vainolo.phd.opp.editor.factory.OPPIdManager;
import com.vainolo.phd.opp.editor.part.OPPNodeEditPart;
import com.vainolo.phd.opp.editor.part.OPPStructuralLinkAggregatorEditPart;
import com.vainolo.phd.opp.editor.policy.OPPLinkConnectionEditPolicy;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.utilities.analysis.OPPAnalyzer;
import com.vainolo.phd.opp.validation.OPPLinkValidator;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class OPPNodeGraphicalNodeEditPolicyTest {

  private OPPLinkConnectionEditPolicy policy;
  private OPPLinkValidator validatorMock;
  private CreateConnectionRequest requestMock;
  private Command command;
  private OPPNodeEditPart nodeEditPartMock;
  private OPPNode nodeMock;
  private OPPLink linkMock;
  private OPPAnalyzer opdAnalyzerMock;
  private OPPObjectProcessDiagram opdMock;

  @Test
  public void testGetConnectionCreateCommand_StartingAtStructuralLinkAggregator_ReturnNull() {
    policy = new OPPLinkConnectionEditPolicy(validatorMock, opdAnalyzerMock, new OPPIdManager());
    policy.setHost(nodeEditPartMock);

    command = policy.getConnectionCreateCommand(requestMock);

    assertNull(command);
  }

  @Test
  public void testGetConnectionCreateCommand_InvalidSource_ReturnNull() {
    policy = new OPPLinkConnectionEditPolicy(validatorMock, opdAnalyzerMock, new OPPIdManager());
    policy.setHost(nodeEditPartMock);
    when(nodeEditPartMock.getModel()).thenReturn(nodeMock);
    when(requestMock.getNewObject()).thenReturn(linkMock);
    when(validatorMock.validateAddSource(nodeMock, linkMock)).thenReturn(false);

    command = policy.getConnectionCreateCommand(requestMock);

    assertNull(command);
  }

  @Test
  public void testGetConnectionCreateCommand_ValidSource_ValidCommand() {
    policy = new OPPLinkConnectionEditPolicy(validatorMock, opdAnalyzerMock, new OPPIdManager());
    policy.setHost(nodeEditPartMock);
    when(nodeEditPartMock.getModel()).thenReturn(nodeMock);
    when(requestMock.getNewObject()).thenReturn(linkMock);
    when(validatorMock.validateAddSource(nodeMock, linkMock)).thenReturn(true);
    when(opdAnalyzerMock.findOPD(nodeMock)).thenReturn(opdMock);

    command = policy.getConnectionCreateCommand(requestMock);
    assertNotNull(command);
    assertTrue(OPPCreateLinkCommand.class.isInstance(command));
    OPPCreateLinkCommand linkCreateCommand = OPPCreateLinkCommand.class.cast(command);
    assertEquals(nodeMock, linkCreateCommand.getSource());
    assertEquals(linkMock, linkCreateCommand.getLink());
  }

  @Before
  public void setUp() {
    validatorMock = mock(OPPLinkValidator.class);
    requestMock = mock(CreateConnectionRequest.class);
    mock(OPPStructuralLinkAggregatorEditPart.class);
    nodeEditPartMock = mock(OPPNodeEditPart.class);
    nodeMock = mock(OPPNode.class);
    linkMock = mock(OPPLink.class);
    opdAnalyzerMock = mock(OPPAnalyzer.class);
    opdMock = mock(OPPObjectProcessDiagram.class);
  }

}

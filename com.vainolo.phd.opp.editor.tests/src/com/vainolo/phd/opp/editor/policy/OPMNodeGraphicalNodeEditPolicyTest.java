package com.vainolo.phd.opp.editor.policy;

import org.eclipse.gef.commands.Command; 
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opp.editor.command.OPMLinkCreateCommand;
import com.vainolo.phd.opp.editor.factory.OPMIdManager;
import com.vainolo.phd.opp.editor.part.OPMNodeEditPart;
import com.vainolo.phd.opp.editor.part.OPMStructuralLinkAggregatorEditPart;
import com.vainolo.phd.opp.editor.policy.OPMNodeConnectionEditPolicy;
import com.vainolo.phd.opp.model.OPPLink;
import com.vainolo.phd.opp.model.OPPNode;
import com.vainolo.phd.opp.model.OPPObjectProcessDiagram;
import com.vainolo.phd.opp.utilities.analysis.OPDAnalyzer;
import com.vainolo.phd.opp.validation.OPMLinkValidator;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class OPMNodeGraphicalNodeEditPolicyTest {

  private OPMNodeConnectionEditPolicy policy;
  private OPMLinkValidator validatorMock;
  private CreateConnectionRequest requestMock;
  private Command command;
  private OPMNodeEditPart nodeEditPartMock;
  private OPPNode nodeMock;
  private OPPLink linkMock;
  private OPDAnalyzer opdAnalyzerMock;
  private OPPObjectProcessDiagram opdMock;

  @Test
  public void testGetConnectionCreateCommand_StartingAtStructuralLinkAggregator_ReturnNull() {
    policy = new OPMNodeConnectionEditPolicy(validatorMock, opdAnalyzerMock, new OPMIdManager());
    policy.setHost(nodeEditPartMock);

    command = policy.getConnectionCreateCommand(requestMock);

    assertNull(command);
  }

  @Test
  public void testGetConnectionCreateCommand_InvalidSource_ReturnNull() {
    policy = new OPMNodeConnectionEditPolicy(validatorMock, opdAnalyzerMock, new OPMIdManager());
    policy.setHost(nodeEditPartMock);
    when(nodeEditPartMock.getModel()).thenReturn(nodeMock);
    when(requestMock.getNewObject()).thenReturn(linkMock);
    when(validatorMock.validateAddSource(nodeMock, linkMock)).thenReturn(false);

    command = policy.getConnectionCreateCommand(requestMock);

    assertNull(command);
  }

  @Test
  public void testGetConnectionCreateCommand_ValidSource_ValidCommand() {
    policy = new OPMNodeConnectionEditPolicy(validatorMock, opdAnalyzerMock, new OPMIdManager());
    policy.setHost(nodeEditPartMock);
    when(nodeEditPartMock.getModel()).thenReturn(nodeMock);
    when(requestMock.getNewObject()).thenReturn(linkMock);
    when(validatorMock.validateAddSource(nodeMock, linkMock)).thenReturn(true);
    when(opdAnalyzerMock.findOPD(nodeMock)).thenReturn(opdMock);

    command = policy.getConnectionCreateCommand(requestMock);
    assertNotNull(command);
    assertTrue(OPMLinkCreateCommand.class.isInstance(command));
    OPMLinkCreateCommand linkCreateCommand = OPMLinkCreateCommand.class.cast(command);
    assertEquals(nodeMock, linkCreateCommand.getSource());
    assertEquals(linkMock, linkCreateCommand.getLink());
  }

  @Before
  public void setUp() {
    validatorMock = mock(OPMLinkValidator.class);
    requestMock = mock(CreateConnectionRequest.class);
    mock(OPMStructuralLinkAggregatorEditPart.class);
    nodeEditPartMock = mock(OPMNodeEditPart.class);
    nodeMock = mock(OPPNode.class);
    linkMock = mock(OPPLink.class);
    opdAnalyzerMock = mock(OPDAnalyzer.class);
    opdMock = mock(OPPObjectProcessDiagram.class);
  }

}

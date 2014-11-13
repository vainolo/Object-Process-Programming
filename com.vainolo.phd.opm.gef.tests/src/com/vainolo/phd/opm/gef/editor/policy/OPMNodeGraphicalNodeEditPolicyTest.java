package com.vainolo.phd.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command; 
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.junit.Before;
import org.junit.Test;

import com.vainolo.phd.opm.gef.editor.command.OPMLinkCreateCommand;
import com.vainolo.phd.opm.gef.editor.factory.OPMIdManager;
import com.vainolo.phd.opm.gef.editor.part.OPMNodeEditPart;
import com.vainolo.phd.opm.gef.editor.part.OPMStructuralLinkAggregatorEditPart;
import com.vainolo.phd.opm.model.OPMLink;
import com.vainolo.phd.opm.model.OPMNode;
import com.vainolo.phd.opm.model.OPMObjectProcessDiagram;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzerImpl;
import com.vainolo.phd.opm.utilities.analysis.OPDAnalyzer;
import com.vainolo.phd.opm.validation.OPMLinkValidator;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class OPMNodeGraphicalNodeEditPolicyTest {

  private OPMNodeConnectionEditPolicy policy;
  private OPMLinkValidator validatorMock;
  private CreateConnectionRequest requestMock;
  private Command command;
  private OPMNodeEditPart nodeEditPartMock;
  private OPMNode nodeMock;
  private OPMLink linkMock;
  private OPDAnalyzer opdAnalyzerMock;
  private OPMObjectProcessDiagram opdMock;

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
    nodeMock = mock(OPMNode.class);
    linkMock = mock(OPMLink.class);
    opdAnalyzerMock = mock(OPDAnalyzerImpl.class);
    opdMock = mock(OPMObjectProcessDiagram.class);
  }

}

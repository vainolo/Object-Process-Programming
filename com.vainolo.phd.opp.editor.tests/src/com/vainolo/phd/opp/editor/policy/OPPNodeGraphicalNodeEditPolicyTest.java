/*******************************************************************************
 * Copyright (c) 2015 Arieh "Vainolo" Bibliowicz and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
import com.vainolo.phd.opp.utilities.analysis.OPPNodeExtensions;
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
  private OPPObjectProcessDiagram opdMock;

  @Test
  public void testGetConnectionCreateCommand_StartingAtStructuralLinkAggregator_ReturnNull() {
    policy = new OPPLinkConnectionEditPolicy(validatorMock, new OPPIdManager());
    policy.setHost(nodeEditPartMock);

    command = policy.getConnectionCreateCommand(requestMock);

    assertNull(command);
  }

  @Test
  public void testGetConnectionCreateCommand_InvalidSource_ReturnNull() {
    policy = new OPPLinkConnectionEditPolicy(validatorMock, new OPPIdManager());
    policy.setHost(nodeEditPartMock);
    when(nodeEditPartMock.getModel()).thenReturn(nodeMock);
    when(requestMock.getNewObject()).thenReturn(linkMock);
    when(validatorMock.validateAddSource(nodeMock, linkMock)).thenReturn(false);

    command = policy.getConnectionCreateCommand(requestMock);

    assertNull(command);
  }

  @Test
  public void testGetConnectionCreateCommand_ValidSource_ValidCommand() {
    policy = new OPPLinkConnectionEditPolicy(validatorMock, new OPPIdManager());
    policy.setHost(nodeEditPartMock);
    when(nodeEditPartMock.getModel()).thenReturn(nodeMock);
    when(requestMock.getNewObject()).thenReturn(linkMock);
    when(validatorMock.validateAddSource(nodeMock, linkMock)).thenReturn(true);
    when(OPPNodeExtensions.findOPD(nodeMock)).thenReturn(opdMock);

    command = policy.getConnectionCreateCommand(requestMock);
    assertNotNull(command);
    assertTrue(command instanceof OPPCreateLinkCommand);
    OPPCreateLinkCommand linkCreateCommand = (OPPCreateLinkCommand) command;
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
    opdMock = mock(OPPObjectProcessDiagram.class);
  }

}

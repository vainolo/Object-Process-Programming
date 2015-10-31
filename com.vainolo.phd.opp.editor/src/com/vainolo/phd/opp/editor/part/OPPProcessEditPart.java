/*******************************************************************************
 * Copyright (c) 2012 Arieh 'Vainolo' Bibliowicz
 * You can use this code for educational purposes. For any other uses
 * please contact me: vainolo@gmail.com
 *******************************************************************************/

package com.vainolo.phd.opp.editor.part;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.WorkbenchPart;

import com.vainolo.phd.opp.editor.OPPGraphicalEditor;
import com.vainolo.phd.opp.editor.action.OPPResizeToContentsAction;
import com.vainolo.phd.opp.editor.figure.OPPFigureConstants;
import com.vainolo.phd.opp.editor.figure.OPPProcessFigure;
import com.vainolo.phd.opp.editor.figure.OPPThingFigure;
import com.vainolo.phd.opp.model.OPPProcess;

public class OPPProcessEditPart extends OPPThingEditPart {

  @Override
  protected IFigure createFigure() {
    return new OPPProcessFigure();
  }

  @Override
  protected void refreshVisuals() {
    final OPPProcessFigure figure = getFigure();
    final OPPProcess model = getModel();
    final GraphicalEditPart parent = (GraphicalEditPart) getParent();

    if (!model.isMain()) {
      figure.getNameFigure().setText(model.getName());

      final IFileEditorInput input = (IFileEditorInput) ((DefaultEditDomain) getViewer().getEditDomain()).getEditorPart().getEditorInput();
      final IFile oppFile = input.getFile().getParent().getFile(new Path(model.getName() + ".opp"));
      if (oppFile.exists()) {
        figure.setBorderWidth(OPPFigureConstants.IN_ZOOMED_THING_BORDER_WIDTH);
      } else {
        figure.setBorderWidth(OPPFigureConstants.ENTITY_BORDER_WIDTH);
      }

    }
    figure.setTooltipText(model.getDescription());
    parent.setLayoutConstraint(this, figure, new Rectangle(model.getX(), model.getY(), model.getWidth(), model.getHeight()));

    if (!model.isManualSize()) {
      Display.getCurrent().asyncExec(new Runnable() {
        @Override
        public void run() {
          OPPProcess model = getModel();
          if (model.isMain())
            return;
          OPPProcessFigure figure = getFigure();
          Dimension prefSize = figure.getPreferredSize();

          if (prefSize.width != model.getWidth() || prefSize.height != model.getHeight()) {
            model.setWidth(figure.getPreferredSize().width);
            model.setHeight(figure.getPreferredSize().height);
          }
        }
      });
    }
  }

  @Override
  public IFigure getContentPane() {
    return ((OPPThingFigure) getFigure()).getContentPane();
  }

  @Override
  public OPPProcessFigure getFigure() {
    return OPPProcessFigure.class.cast(super.getFigure());
  }

  @Override
  public OPPProcess getModel() {
    return OPPProcess.class.cast(super.getModel());
  }
}

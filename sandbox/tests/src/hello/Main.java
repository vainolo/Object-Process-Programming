package hello;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.ManhattanConnectionRouter;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

  public static void main(String[] args) {
    Display d = new Display();
    final Shell shell = new Shell(d);
    shell.setSize(400, 400);
    shell.setText("Draw2d Test");
    LightweightSystem lws = new LightweightSystem(shell);
    Figure contents = new Figure();
    XYLayout layout = new XYLayout();
    contents.setLayoutManager(layout);

    // create figures
    TestFigure f1 = new TestFigure("Test 1");
    TestFigure f2 = new TestFigure("Test 2");

    MouseManager mm = new MouseManager();

    contents.addMouseListener(mm);

    // register mouse listeners
    f1.addMouseMotionListener(mm);
    f1.addMouseListener(mm);
    f2.addMouseMotionListener(mm);
    f2.addMouseListener(mm);

    // set constraints to layout manager
    layout.setConstraint(f1, new Rectangle(10, 10, -1, -1));
    layout.setConstraint(f2, new Rectangle(200, 200, -1, -1));

    // add to layout manager
    contents.add(f1);
    contents.add(f2);

    // add connection
    // When uncommenting these lines, dragging works fine
    PolylineConnection c = new PolylineConnection();
    c.setSourceAnchor(new ChopboxAnchor(f1));
    c.setTargetAnchor(new ChopboxAnchor(f2));
    c.setConnectionRouter(new ManhattanConnectionRouter());
    contents.add(c);

    lws.setContents(contents);
    shell.open();
    while(!shell.isDisposed()) {
      while(!d.readAndDispatch()) {
        d.sleep();
      }
    }
  }

  public static class MouseManager implements MouseMotionListener, MouseListener {
    Figure selection;
    private Point lastDragLocation;

    @Override
    public void mousePressed(MouseEvent me) {
      System.out.println("mouse pressed");
      selection = (Figure) me.getSource();
      // layout.setConstraint(f2, new Rectangle(me.getLocation().x, me.getLocation().y, -1, -1));
      // contents.revalidate();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
      System.out.println("mouse released");
      selection = null;
      lastDragLocation = null;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
      if(lastDragLocation != null && selection != null) {
        int offsetX = me.getLocation().x - lastDragLocation.x;
        int offsetY = me.getLocation().y - lastDragLocation.y;
        int newX = selection.getLocation().x + offsetX;
        int newY = selection.getLocation().y + offsetY;
        System.out.println(String.format("NewX: %d, NewY: %d", newX, newY));
        // selection.setBounds(selection.getBounds().getTranslated(offsetX, offsetY)); <-- this does not work
        selection.getParent().getLayoutManager()
            .setConstraint(selection, selection.getBounds().getTranslated(offsetX, offsetY));
        selection.getParent().revalidate();

      }
      lastDragLocation = me.getLocation();

    }

    @Override
    public void mouseDoubleClicked(MouseEvent me) {
      // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent me) {
      // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent me) {
      // TODO Auto-generated method stub

    }

    @Override
    public void mouseHover(MouseEvent me) {
      // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent me) {
      // TODO Auto-generated method stub

    }
  }

  public static class TestFigure extends RectangleFigure {
    public Color classColor;

    public TestFigure(String name) {
      ToolbarLayout layout = new ToolbarLayout();
      setLayoutManager(layout);
      setOpaque(true);

      classColor = new Color(null, 255, 255, 206);
      setBackgroundColor(classColor);

      Label lbl_name = new Label(name);
      add(lbl_name);
    }

    @Override
    protected void finalize() throws Throwable {
      classColor.dispose();
      super.finalize();
    }
  }
}

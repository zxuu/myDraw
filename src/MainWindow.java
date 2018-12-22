import model.Circle;
import model.Rect;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import view.Board;

public class MainWindow {
    private static GC gcMian = null;
    private static int startx;
    private static int starty;
    private static boolean leftButtonDown = false;
    private static int lastwidth = 0;
    private static int lastheight = 0;

    public static void main(String[] args) {
        Board board = new Board();
        Display display = Display.getDefault();
        Shell shell = new Shell();
        gcMian = new GC(shell);
        shell.addMouseMoveListener(new MouseMoveListener() {
            @Override
            public void mouseMove(MouseEvent mouseEvent) {
                if (leftButtonDown) {
                    gcMian.setLineStyle(SWT.LINE_DOT);
                    gcMian.setForeground(shell.getBackground());
                    gcMian.drawRectangle(startx, starty, lastwidth, lastheight);
                    gcMian.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
                    gcMian.drawRectangle(startx,starty,mouseEvent.x-startx,mouseEvent.y-starty);
                    lastwidth = mouseEvent.x - startx;
                    lastheight = mouseEvent.y - starty;
                    gcMian.setLineStyle(SWT.LINE_SOLID);
                }
            }
        });
        shell.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                super.mouseDoubleClick(e);
            }

            @Override
            public void mouseDown(MouseEvent e) {
                leftButtonDown = true;
                startx = e.x;
                starty = e.y;
            }

            @Override
            public void mouseUp(MouseEvent e) {
                if (e.button == 1) {
                    leftButtonDown = false;
                    int weight = e.x - startx;
                    int height = e.y - starty;
                    gcMian.setLineStyle(SWT.LINE_DOT);
                    gcMian.setForeground(shell.getBackground());
                    gcMian.drawRectangle(startx,starty,weight,height);
                    gcMian.setLineStyle(SWT.LINE_SOLID);
                    gcMian.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
                    Circle circle = new Circle(startx, starty, weight, height, gcMian);
                    board.addShape(circle);
                    board.refresh();
                }
            }
        });

        shell.setSize(900,500);
        shell.setText("SWT Application");
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}

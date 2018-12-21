import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainWindow {
    private static GC gcMian = null;
    private static int startx;
    private static int starty;

    public static void main(String[] args) {
        Display display = Display.getDefault();
        Shell shell = new Shell();
        gcMian = new GC(shell);
        shell.addMouseMoveListener(new MouseMoveListener() {
            @Override
            public void mouseMove(MouseEvent mouseEvent) {

            }
        });
        shell.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                super.mouseDoubleClick(e);
            }

            @Override
            public void mouseDown(MouseEvent e) {
                startx = e.x;
                starty = e.y;
            }

            @Override
            public void mouseUp(MouseEvent e) {
                if (e.button == 1) {
                    int weight = e.x - startx;
                    int height = e.y - starty;
                    Rect rect = new Rect(startx, starty, weight, height, gcMian);
                    rect.draw();
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

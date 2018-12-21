import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MainWindow {
    private static GC gcMian = null;

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

            }

            @Override
            public void mouseUp(MouseEvent e) {
                Rect rect = new Rect(e.x,e.x,100,100,gcMian);
                rect.draw();
            }
        });

        shell.setSize(450,300);
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

import org.eclipse.swt.graphics.GC;

public class Rect implements IShape{
    private int top;
    private int left;
    private int width;
    private int height;
    private GC gcMain;

    public Rect(int top, int left, int height, int width, GC gcMain) {
        this.top = top;
        this.left = left;
        this.height = height;
        this.width = width;
        this.gcMain = gcMain;
    }

    @Override
    public void draw() {
        gcMain.drawRectangle(top,left,width,height);
    }
}

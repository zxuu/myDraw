package model;

import org.eclipse.swt.graphics.GC;

public class Rect implements IShape {
    private int top;
    private int left;
    private int width;
    private int height;
    private GC gcMain;

    public Rect(int top, int left, int width, int height, GC gcMain) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
        this.gcMain = gcMain;
    }

    @Override
    public void draw() {
        gcMain.drawRectangle(top,left,width,height);
    }
}

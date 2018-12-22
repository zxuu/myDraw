package view;

import model.IShape;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<IShape> shapes = new ArrayList<>();

    public void addShape(IShape shape) {
        shapes.add(shape);
    }

    public void refresh() {
        for (IShape shape : shapes) {
            shape.draw();
        }
    }
}

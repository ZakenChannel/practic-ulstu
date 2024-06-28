package ru.practice.thirdpractice.secondtask;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FilledSquare extends Shape implements Drawable {
    private final int side;

    public FilledSquare(int x, int y, int side) {
        super(x, y);
        this.side = side;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, side, side);
    }
}

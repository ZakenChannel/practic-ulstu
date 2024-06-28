package ru.practice.thirdpractice.secondtask;

import javafx.scene.canvas.GraphicsContext;

public class Oval extends Shape implements Drawable {
    private final int width;
    private final int height;

    public Oval(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.strokeOval(x, y, width, height);
    }
}

package ru.practice.thirdpractice.firsttask;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Table {
    private final StringProperty material;
    private final IntegerProperty height;
    private final IntegerProperty width;
    private final IntegerProperty length;
    private final StringProperty color;

    public Table(String material, int height, int width, int length, String color) {
        this.material = new SimpleStringProperty(material);
        this.height = new SimpleIntegerProperty(height);
        this.width = new SimpleIntegerProperty(width);
        this.length = new SimpleIntegerProperty(length);
        this.color = new SimpleStringProperty(color);
    }

    public StringProperty materialProperty() {
        return material;
    }

    public String getMaterial() {
        return material.get();
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("материал не может быть нулевым или пустым");
        }
        this.material.set(material);
    }

    public IntegerProperty heightProperty() {
        return height;
    }

    public int getHeight() {
        return height.get();
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("высота должна быть больше 0");
        }
        this.height.set(height);
    }

    public IntegerProperty widthProperty() {
        return width;
    }

    public int getWidth() {
        return width.get();
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("ширина должна быть больше 0");
        }
        this.width.set(width);
    }

    public IntegerProperty lengthProperty() {
        return length;
    }

    public int getLength() {
        return length.get();
    }

    public void setLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("длина должна быть больше 0");
        }
        this.length.set(length);
    }

    public StringProperty colorProperty() {
        return color;
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("цвет не может быть пустым");
        }
        this.color.set(color);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

import java.io.Serializable;

/**
 *
 * @author afahrer
 */
public class Rectangle extends GeometricObject implements Comparable<Rectangle>, Serializable {

    private int width;
    private int height;
    private MyPoint location;

    public Rectangle() {
        this.setColor("black");
        this.setFilled(true);
        this.width = 1;
        this.height = 2;
        this.location = new MyPoint();
    }

    public Rectangle(int width, int height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
        this.location = new MyPoint();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public MyPoint getLocation() {
        return location;
    }

    public void setLocation(MyPoint location) {
        this.location = location;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return height * width;
    }

    public int getPerimeter() {
        return (height + width) * 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            return (this.height == ((Rectangle) obj).height || this.height == ((Rectangle) obj).width)
                    && (this.width == ((Rectangle) obj).width || this.width == ((Rectangle) obj).height);
        }
        return false;
    }

    @Override
    public int compareTo(Rectangle o) {
        return this.getArea() - o.getArea();
    }

    @Override
    public String toString() {
        return "Rectangle: " + width + " x " + height + " at " + location.toString();
    }
}

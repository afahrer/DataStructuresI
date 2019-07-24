/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author afahrer
 */
public class Square extends Rectangle {

    public Square() {
        this.setWidth(1);
        this.setHeight(1);
    }

    public Square(int size, String color, boolean filled) {
        super(size, size, color, filled);
    }

    @Override
    public void setWidth(int size) {
        this.setSize(size);
    }

    @Override
    public void setHeight(int size) {
        this.setSize(size);
    }

    @Override
    public String toString() {
        return "Square: " + this.getWidth() + " x " + this.getWidth() + " at " + this.getLocation().toString();
    }

    private void setSize(int size) {
        super.setHeight(size);
        super.setWidth(size);
    }
}

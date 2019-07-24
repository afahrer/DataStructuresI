/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.io.Serializable;

/**
 *
 * @author afahrer
 */
public class MyPoint implements Serializable {

    private int x;
    private int y;

    public MyPoint() {

    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (this.x >= 0) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (this.y >= 0) {
            this.y = y;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyPoint) {
            return this.x == ((MyPoint) obj).x && this.y == ((MyPoint) obj).y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

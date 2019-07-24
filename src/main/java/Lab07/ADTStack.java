/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab07;

/**
 *
 * @author afahrer
 */
public class ADTStack {
    private Character[] list = new Character[MAX_SIZE];
    private int size = 0;
    private static final int MAX_SIZE = 25;
    
    public void push(char letter) {
        list[size] = letter;
        size++;
    }
    
    public Character pop() {
        Character last = peek();
        size--;
        return last;
    }
    
    public Character peek() {
        return list[size-1];
    }
    
    public void popAll() {
        list = new Character[MAX_SIZE];
        size = 0;
    }
}

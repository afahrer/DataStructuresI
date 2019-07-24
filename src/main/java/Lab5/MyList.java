/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author afahrer
 */
public class MyList<T> implements MyListInterface<T>{

    private Object[] groceries;
    private int size;
    private final int MAX_SIZE;

    public MyList() {
        this(10);
    }
    public MyList(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        groceries = new Object[MAX_SIZE];
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int position, T o) {
        if(position < 1 || position > size+1)
            throw new ListOutOfBoundsException("Position not valid");
        if(size == MAX_SIZE) {
            throw new ListOutOfBoundsException("List is full");
        }
        if(groceries[position-1] == null) {
            groceries[position-1] = o;
            size++;
            return;
        }
        for (int i = size; i >= position; i--) {
            groceries[i] = groceries[i-1];
        }
        groceries[position-1] = o;
        size++;
    }

    @Override
    public void remove(int position) {
        if(position < 1 || position > size)
            throw new ListOutOfBoundsException("Position not valid");
        for (int i = position - 1; i < size; i++) {
            groceries[i] = groceries[i+1];
        }
        size--;
    }

    @Override
    public T get(int position) {
        return (T)groceries[position-1];
    }

    @Override
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.println((T)groceries[i]);
        }      
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab05;

/**
 *
 * @author afahrer
 */
public interface MyListInterface<T> {
    public boolean isEmpty();
    public int size();
    public void add(int position, T o);
    public void remove(int position);
    public T get(int position);
    public void printList();
}

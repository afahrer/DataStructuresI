/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author afahrer
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst("Hello");
        list.addFirst("world");  
        list.addFirst("Java");
        list.deleteFirst();
        list.deleteLast();
        list.addLast("Last");
        list.printList();
    }
    
}

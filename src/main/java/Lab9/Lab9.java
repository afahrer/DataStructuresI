/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab9;

/**
 *
 * @author afahrer
 */
public class Lab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(queue.dequeue());
        }
        queue.enqueue(55);
        System.out.println(queue.dequeue());
    }   
}

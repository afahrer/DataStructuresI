/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab06;

/**
 *
 * @author afahrer
 */
public class Node {
    String item;
    Node next;

    public Node(String item, Node next) {
        this.item = item;
        this.next = next;
    }
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}

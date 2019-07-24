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
public class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void addFirst(String str) {
        Node curr = head;        
        head = new Node(str, curr);
    }

    public void deleteFirst() {
        if(isEmpty()) return;
        head = head.getNext();
    }

    public void addLast(String str) {
        Node curr = null;
        Node prev = head;
        while(prev.getNext() != null) {
            prev = prev.getNext();
        }
        prev.setNext(new Node(str, curr));
    }

    public void deleteLast() {
        if(isEmpty()) return;
        Node prev = null;
        Node curr = head;
        while(curr.getNext() != null){
            prev = curr;
            curr = curr.getNext();
        }
        prev.setNext(null);
    }

    public int size() {
        int size = 0;
        Node curr = head;
        while (curr.getItem() != null) {
            curr = curr.getNext();
            size++;
            if(curr == null) break;
        }
        return size;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public void printList() {
        Node curr = head;
        for (int i = 0; i < size(); i++) {
            System.out.println(curr.getItem());
            curr = curr.getNext();
        }
    }
}

package Assignment4.Qu2;

import Assignment4.Qu1.ADTListInterface;

public class DoublyList<T extends Comparable<T>> implements ADTListInterface<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;
        Node(){
            item = null;
            prev = this;
            next = this;
        }
        Node(T item, Node prev, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }
    private Node head;

    public DoublyList() {
        this.head = new Node();
    }

    public boolean isEmpty(){
        return head.next == head;
    }
    public int size(){
        return 0;
    }
    public void add(T item){
        Node curr = head.next;
        while(curr != head && curr.item.compareTo(item) < 0) {
            curr = curr.next;
        }
        Node newNode = new Node(item,curr.prev,curr);
        curr.prev.next = newNode;
        curr.prev = newNode;
    }
    public void remove(){

    }
    public void printList() {
        Node curr = head.next;
        while(curr != head) {
            System.out.println(curr.item);
            curr = curr.next;
        }
    }
}

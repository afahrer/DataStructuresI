package Assignment4.Qu2;

import Assignment4.Qu1.ADTListInterface;

public class DoublyList<T> implements ADTListInterface<T> {
    private class Node<T> {
        private T item;
        private Node prev;
        private Node next;
        Node(){
            item = null;
            prev = this;
            next = this;
        }
        Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

    }
    private Node head;
    public boolean isEmpty(){
        return head.next == head.prev;
    }
    public int size(){
        return 0;
    }
    public void add(T item){
        Node prev = head;
        Node curr = head.next;
        while(curr != head) {
            curr = curr.next;
        }
        curr = new Node();
    }
    public void remove(){

    }
}

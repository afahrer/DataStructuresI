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
        Node(T item, Node next, Node prev) {
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
        return head.next == head.prev;
    }
    public int size(){
        return 0;
    }
    public void add(T item){
        if(isEmpty()){
            head.next = new Node(item,head,head);
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while(curr.item.compareTo(item) < 0) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node(item,curr,prev.next);
    }
    public void remove(){

    }
}

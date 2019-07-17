package Assignment4.Qu2;

import Assignment4.Qu1.ADTListInterface;

public class DoublyList<T extends Comparable<T>> implements ADTListInterface<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;
        private Node(){
            item = null;
            prev = this;
            next = this;
        }
        private Node(T item, Node prev, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node head;
    private Object[] temp = new Object[10];

    public DoublyList() {
        this.head = new Node();
    }

    public boolean isEmpty(){
        return head.next == head;
    }
    public int size(){
        int size = 0;
        Node curr = head.next;
        while(curr != head) {
            curr = curr.next;
            size++;
        }
        return size;
    }
    public void add(T item){
        Node curr = head.next;
        while(curr != head && curr.item.compareTo(item) < 0) {
            curr = curr.next;
        }
        if(curr != head && curr.item.compareTo(item) == 0){
            System.out.println("The item " + item + " is not unique");
            return;
        }
        Node newNode = new Node(item,curr.prev,curr);
        curr.prev.next = newNode;
        curr.prev = newNode;
    }

    public void remove() {

    }

    public T josephus(int m) {
        Node curr = head.prev;
        int index = 0;
        while(head.prev != head.next) {
            for (int i = 0; i < m; i++) {
                if (curr.next == head) curr = curr.next.next;
                else curr = curr.next;
            }
            temp[index] = curr;
            index++;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        curr = head.next;
        for (Object node: temp) {
            if(node!= null) add(((Node)node).item);
        }
        return curr.item;
    }
    public void printList() {
        Node curr = head.next;
        while(curr != head) {
            System.out.println(curr.item);
            curr = curr.next;
        }
    }
}

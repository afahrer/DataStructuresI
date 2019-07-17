package Assignment4.Qu1;

public class ADTList<T extends Comparable<T>> implements ADTListInterface<T> {

    private class Node {
        private T item;
        private Node next;
        Node(){
            item = null;
            next = this;
        }
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

    }
    private Node head;

    public ADTList() {
        head = new Node();
    }
    public int size() {
        int size = 0;
        Node curr = head.next;
        while(curr != head) {
            curr = curr.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public void add(T item){
        if(isEmpty()){
            head.next = new Node(item,head);
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while(curr.item.compareTo(item) < 0){
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node(item,curr);
    }

    public void remove()  {
        if(isEmpty()) return;
        Node curr = head.next;
        head.next = curr.next;
    }
}

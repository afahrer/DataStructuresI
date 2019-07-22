package Assignment5.Qu2;

public class Queue<T> implements QueueInterface<T>, Cloneable {
    private Node lastNode;

    private class Node {
        private T item;
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

    public Queue() {
        lastNode = null;
    }

    public boolean isEmpty() {
        return lastNode == null;
    }

    public void enqueue(T item) {
        if (isEmpty()) {
            lastNode = new Node(item, null);
            lastNode.next = lastNode;
        }
        else {
            lastNode.next = new Node(item, lastNode.next);
        }
    }

    public T dequeue() throws QueueException {
        if (isEmpty()) throw new QueueException("Queue is empty");
        if(lastNode.next == lastNode) {
            T item = lastNode.item;
            lastNode = null;
            return item;
        }
        T item = lastNode.item;
        Node curr = lastNode;
        while (curr.next != lastNode) {
            curr = curr.next;
        }
        curr.next = lastNode.next;
        lastNode = curr;
        return item;
    }

    public void dequeueAll() {
        lastNode = null;
    }

    public T peek() {
        if(isEmpty()) return null;
        return lastNode.item;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

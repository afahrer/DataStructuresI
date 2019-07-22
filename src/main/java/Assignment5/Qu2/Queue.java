package Assignment5.Qu2;
/*

    Author:     Adam Fahrer
    Date:       July 22, 2019
    Purpose:    Generic queue implementation using a circular linked list
*/
public class Queue<T> implements QueueInterface<T> {
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
        Node newNode = new Node(item, null);
        if (isEmpty()) {
            newNode.next = newNode;
        }
        else {
            newNode.next = lastNode.next;
            lastNode.next = newNode;
        }
        lastNode = newNode;
    }

    public T dequeue() {
        if (isEmpty()) throw new QueueException("Queue is empty");
        Node firstNode = lastNode.next;
        if(firstNode == lastNode) lastNode = null;
        else lastNode.next = firstNode.next;
        return firstNode.item;
    }

    public void dequeueAll() {
        lastNode = null;
    }

    public T peek() {
        if(isEmpty()) throw new QueueException("Queue is empty");
        return lastNode.item;
    }
}

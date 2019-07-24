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
public class Queue<T extends Comparable<T>> {

    private Object[] list;
    private int front;
    private int back;
    private final int MAX_SIZE = 10;

    public Queue() {
        list = new Object[MAX_SIZE];
        front = 1;
        back = 1;
    }

    public boolean isEmpty() {
        return back == front;
    }

    public boolean isFull() {
        return front == 1 && back == MAX_SIZE;
    }

    public void enqueue(T item) {
        if (!isFull()) {
            if (back != MAX_SIZE) {
                back = back - front + 1;
                list[back] = item;
                back++;
            } else {
                back = MAX_SIZE - 1;
            }

        } else {
            throw new QueueException("Queue is Full");
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            Object queueFront = list[front];
            front++;
            if (front == MAX_SIZE) {
                front = 1;
                back = 1;
            } else if (front == MAX_SIZE - 1) {
                back++;
            }
            return (T) queueFront;
        }
        throw new QueueException("Queue is Empty");
    }

    public T peek() {
        if (!isEmpty()) {
            return (T) list[front];
        }
        throw new QueueException("Can't Peek, Queue is Empty");
    }

    public void dequeueAll() {
        list = new Object[MAX_SIZE];
        front = 1;
        back = MAX_SIZE - 1;
    }
}

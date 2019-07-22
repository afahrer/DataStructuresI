package Assignment5.Qu2;

public interface QueueInterface<T> {
    boolean isEmpty();

    void enqueue(T item);

    T dequeue() throws QueueException;

    void dequeueAll();

    T peek();

}

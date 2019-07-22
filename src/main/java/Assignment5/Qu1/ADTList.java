package Assignment5.Qu1;

public class ADTList<T extends Comparable<T>> {
    private Object[] list;
    private static final int MAX_SIZE = 50;
    private int size;

    public ADTList() {
        size = 0;
        list = new Object[MAX_SIZE];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T item) {
        list[size] = item;
        size++;
    }

    public T pop() {
        if (isEmpty()) return null;
        size--;
        return (T) list[size];
    }

    public T peek() {
        if (isEmpty()) return null;
        return (T) list[size - 1];
    }
}

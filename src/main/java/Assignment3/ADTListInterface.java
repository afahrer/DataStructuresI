package Assignment3;

public interface ADTListInterface<T> {
    void createSortedList();
    boolean sortedIsEmpty();
    int sortedSize();
    void sortedAdd(T item) throws SKUException;
    void sortedRemove(T item) throws SKUException;
    T sortedGet(int index);
    int locateIndex(T item);
}

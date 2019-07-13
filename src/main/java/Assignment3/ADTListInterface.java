package Assignment3;
/*

    Author:     Adam Fahrer
    Date:       July 13, 2019
    Purpose:    Specifies the methods that are to be implemented by lists

*/
public interface ADTListInterface<T> {
    void createSortedList();
    boolean sortedIsEmpty();
    int sortedSize();
    void sortedAdd(T item) throws SKUException;
    void sortedRemove(T item) throws SKUException;
    T sortedGet(int index);
    int locateIndex(T item);
}

package Assignment4.Qu1;

/*

    Author:     Adam Fahrer
    Date:       July 17, 2019
    Purpose:    Specifies the methods that are to be implemented by lists

*/
public interface ADTListInterface<T> {
    boolean isEmpty();
    int size();
    void add(T item);
    void remove();
}

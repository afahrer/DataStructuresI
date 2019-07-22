package Assignment4.Qu1;
/*

    Author:     Adam Fahrer
    Date:       July 17, 2019
    Purpose:    PostFixCalculator program for ADTList that adds 400 items then removes 385 items to
                demonstrate the expandability of the linked list

*/
public class Test {
    public static void main(String[] args) {
        ADTList<SKU> list = new ADTList<SKU>();
        System.out.println("List is Empty: " + list.isEmpty());
        for (int i = 0; i < 400; i++) {
            if(i % 50 == 0) System.out.println("Size " + list.size());
            list.add(new SKU("A99-2399X-Q"));
        }
        System.out.println();
        for (int i = 0; i < 385; i++) {
            if(i % 50 == 0) System.out.println("Size " + list.size());
            list.remove();
        }
        System.out.println("Size " + list.size());
    }
}

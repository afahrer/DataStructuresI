package Assignment3.Qu3;

public class Test {
    /*

    Author:     Adam Fahrer
    Date:       July 13, 2019
    Purpose:    PostFixCalculator Program for the SKUList, adding and removing sku items, resizing the array's MAX_SIZE

    */
    public static void main(String[] args) {
        SKUList sku = new SKUList();
        sku.sortedAdd("P23-1499X-M");
        sku.sortedAdd("B99-2399X-Q");
        sku.sortedAdd("C99-9499X-W");
        sku.sortedAdd("Q99-2949X-E");
        sku.sortedAdd("P89-3939X-X");
        sku.sortedAdd("X99-9929X-T");
        sku.sortedAdd("B88-9929X-Y");
        sku.sortedAdd("F98-9999X-J");
        sku.sortedAdd("D99-8299X-K");
        sku.sortedAdd("D89-9299X-I");
        sku.sortedAdd("Q23-1499X-M");
        sku.sortedAdd("A99-2399X-Q");
        sku.sortedAdd("S99-9499X-W");
        sku.sortedAdd("V99-2949X-E");
        sku.sortedAdd("X89-3939X-X");
        sku.sortedAdd("T99-9929X-T");
        sku.sortedAdd("M88-9929X-Y");
        sku.sortedAdd("N98-9999X-J");
        sku.sortedAdd("B99-8299X-K");
        sku.sortedAdd("V89-9299X-I");

        System.out.println("\nMax Size: " + sku.getMAX_SIZE());
        System.out.println("List Size: " + sku.sortedSize());
        sku.sortedRemove("F98-9999X-J");
        System.out.println("List Size: " + sku.sortedSize() + "\n" + sku.getSortedList());
        System.out.println("sku.locateIndex(\"N98-9999X-J\"): " + sku.locateIndex("N98-9999X-J")
                + "\nsku.locateIndex(\"F98-9999X-J\"): " + sku.locateIndex("F98-9999X-J"));

        sku.sortedAdd("T79-9929X-T");
        sku.sortedAdd("M78-9929X-Y");
        sku.sortedAdd("N78-9999X-J");
        sku.sortedAdd("B79-8299X-K");
        sku.sortedAdd("V79-9299X-I");
        sku.sortedAdd("V79-9259X-I");
        sku.sortedAdd("V79-9259R-U");
        System.out.println("\nList Size: " + sku.sortedSize()
                + "\nMax Size: " + sku.getMAX_SIZE()
                + "\n" + sku.getSortedList());
    }
}

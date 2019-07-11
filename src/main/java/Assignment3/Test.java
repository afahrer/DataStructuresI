package Assignment3;

public class Test {
    public static void main(String[] args) {
        SKUList sku = new SKUList();
        sku.sortedAdd("X99-9999X-X");
        sku.sortedAdd("A99-9999X-X");
        System.out.println(sku.toString());
    }
}

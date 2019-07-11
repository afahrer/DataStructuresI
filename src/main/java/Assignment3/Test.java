package Assignment3;

public class Test {
    public static void main(String[] args) {
        SKUList sku = new SKUList();
        sku.sortedAdd("X23-1499X-X");
        sku.sortedAdd("B99-2399X-X");
        sku.sortedAdd("C99-9499X-X");
        sku.sortedAdd("D99-2949X-X");
        sku.sortedAdd("D89-3939X-X");
        sku.sortedAdd("X99-9929X-X");
        sku.sortedAdd("B88-9929X-X");
        sku.sortedAdd("C98-9999X-X");
        sku.sortedAdd("D99-8299X-X");
        sku.sortedAdd("D89-9299X-X");
        System.out.println(sku.toString());
    }
}

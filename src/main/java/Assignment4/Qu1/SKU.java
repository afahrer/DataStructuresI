package Assignment4.Qu1;

public class SKU implements Comparable<SKU>{
    private String value;
    private static final String SKU_PATTERN = "[A-Z][0-9]{2}-[0-9]{4}[A-Z]-[A-Z]";

    public SKU(String value) {
        if(!value.matches(SKU_PATTERN)) throw new SKUException("SKU not valid");
        this.value = value;
    }

    public int compareTo(SKU o) {
        return this.value.compareTo(o.value);
    }
}

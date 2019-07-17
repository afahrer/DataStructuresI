package Assignment4.Qu2;

public class Person {
    private final int SIN;
    private String name;
    private String address;
    private String cellNumber;
    public Person() {
        this(0,"Person","Someplace", "1234567890");
    }
    public Person(int SIN, String name, String address, String cellNumber) {
        this.SIN = SIN;
        this.name = name;
        this.address = address;
        this.cellNumber = cellNumber;
    }
}

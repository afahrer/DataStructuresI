package Assignment4.Qu2;

public class Person implements Comparable<Person>{
    private final String SIN;
    private static final String SIN_PATTERN = "[0-9]{9}";
    private String name;
    private String address;
    private String cellNumber;
    public Person(String SIN, String name, String address, String cellNumber) {
        if(!SIN.matches(SIN_PATTERN)) throw new SINInvalidException("SIN is Invalid");
        this.SIN = SIN;
        this.name = name;
        this.address = address;
        this.cellNumber = cellNumber;
    }

    public int compareTo(Person o) {
        return Integer.parseInt(this.SIN) - Integer.parseInt(o.SIN);
    }
    @Override
    public String toString() {
        return this.SIN;
    }
}

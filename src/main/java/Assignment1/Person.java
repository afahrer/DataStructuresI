package Assignment1;

public class Person {
    private final String name;
    private final int ID;
    public Person(String name, int id) {
        this.name = name;
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
    @Override
    public String toString() {
        return "Name: " + name + " ID: " + ID;
    }
}

package Assignment1;

import java.io.Serializable;

public class Person implements Serializable {
    private final String name;
    private final int ID;

    public Person(String name, int id) {
        this.name = name;
        this.ID = IDIsValid(id);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nID: " + ID + "\n";
    }

    public static int IDIsValid(int id) {
        if (id > 999999) {
            int divider = id / 10;
            int sum = 0;
            int lastDigit = id % 10;
            for (int i = 0; i < 7; i++) {
                sum += (divider % 10);
                divider /= 10;
            }
            if (sum % 7 != lastDigit) {
                throw new InvalidStudentIDException("Invalid ID");
            }
            return id;
        }
        throw new InvalidStudentIDException("Invalid ID");
    }
}

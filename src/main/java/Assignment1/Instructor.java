package Assignment1;

public class Instructor extends Person {
    private final int FACULTY_ID;
    private String department;

    public Instructor(String name, int FACULTY_ID) {
        super(name);
        this.FACULTY_ID = FACULTY_ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

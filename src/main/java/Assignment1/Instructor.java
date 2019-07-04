package Assignment1;

public class Instructor extends Person {

    private String department;

    public Instructor(String name, int id) {
        super(name, id);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

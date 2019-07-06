package Assignment1;

/*
    Purpose: Class that stores Instructors
    Author: Adam Fahrer
    Date: July 05, 2019
    Input/Output: Stores department and extends Person
 */
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

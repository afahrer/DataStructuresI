package Assignment1;

/*
    Purpose: Class that is used to test the methods in the Storage Classes, Course, Student, Instructor and Person
    Author: Adam Fahrer
    Date: July 05, 2019
    Input/Output: Test Data for testing the various methods in each class
 */
public class Test {
    public static void main(String[] args) {
        Course course = new Course("Data Structures", "COSC2006", 1);
        Student adam = new Student("Adam", 1111116);
        Instructor mike = new Instructor("Mike", 2222225);

        // Test Student Methods
        adam.setCreditsEarned(33);
        adam.setGradePointsEarned(100);
        System.out.println("Name: " + adam.getName() +
                "\nGrade Points: " + adam.getGradePointsEarned() +
                "\nCredits Earned: " + adam.getCreditsEarned() +
                "\nAdam's GPA: " + adam.getGPA() +
                "\nAdam = Adam " + adam.equals(adam));

        // Test Instructor Methods
        mike.setDepartment("Computer Science");
        System.out.println("\nMike's Department: " + mike.getDepartment());

        // Test Course Methods
        System.out.println("\ncourse.addStudentToCourse()\n" + course.addStudentToCourse(adam));
        System.out.println("course.addStudentToCourse()\n" + course.addStudentToCourse(adam));
        System.out.println("course.findStudentByID()\n" + course.findStudentByID(1));
        System.out.println("course.removeStudentFromCourse()\n" + course.removeStudentFromCourse(adam));
        System.out.println("course.findStudentByID()\n" + course.findStudentByID(1));
        course.setCourseInstructor(mike);
        System.out.println("course.getCourseInstructor()\n" + course.getCourseInstructor());
    }
}

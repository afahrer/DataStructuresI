package Assignment1;

public class Test {
    public static void main(String[] args) {
        Course course = new Course("Data Structures", "COSC2006",20);
        Student adam = new Student("Adam", 1);
        Instructor mike = new Instructor("Mike", 2);

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
        System.out.println("\ncourse.addStudent()\n" + course.addStudent(adam));
        System.out.println("course.addStudent()\n" + course.addStudent(adam));
        System.out.println("course.findStudentByID()\n" + course.findStudentByID(1));
        System.out.println("course.removeStudent()\n" + course.removeStudent(adam));
        System.out.println("course.findStudentByID()\n" + course.findStudentByID(1));
        course.setCourseInstructor(mike);
        System.out.println("course.getCourseInstructor()\n" + course.getCourseInstructor());
    }
}

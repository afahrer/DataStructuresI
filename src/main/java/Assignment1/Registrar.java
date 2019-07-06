package Assignment1;

import java.util.Scanner;

public class Registrar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Course course;
        Student student;

        do {
            System.out.println("1: Create a Course\n" +
                    "2: Add Student to Course\n" +
                    "3: Check to see if a student is registered in a Course\n" +
                    "4: Remove a Student from a Course\n");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    course = selectCourse();
                    student = selectStudent();
                    course.addStudent(student);
                    break;
                case 3:
                    course = selectCourse();
                    student = selectStudent();
                    course.findStudentByID(student.getID());
                    break;
                case 4:
                    course = selectCourse();
                    student = selectStudent();
                    course.removeStudent(student);
                case 5:

                default:
                    option = 0;
            }
        } while (option != 0);
    }

    private static Student selectStudent() {
        return null;
    }

    private static Course selectCourse() {
        return null;
    }

    private static void createCourse() {
    }
}
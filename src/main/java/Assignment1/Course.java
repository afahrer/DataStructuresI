package Assignment1;
/*
    Purpose: Class that stores Course objects
    Author: Adam Fahrer
    Date: July 05, 2019
    Input/Output: Course Title, Code, number of students, and classlist is stored in this object
 */

import java.io.Serializable;

public class Course implements Serializable {

    private String name;
    private final String courseCode;
    private Student[] studentsInCourse = new Student[35];
    private Instructor courseInstructor;
    private int numberOfStudents;
    private final int maxNumberOfStudents;

    public Course(String name, String courseCode, int maxNumberOfStudents) {
        this.name = name;
        this.courseCode = courseCode;
        if (maxNumberOfStudents > 35) {
            this.maxNumberOfStudents = 35;
        } else {
            this.maxNumberOfStudents = maxNumberOfStudents;
        }
    }

    public Instructor getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(Instructor courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String findStudentByID(int id) {
        for (Student student : studentsInCourse) {
            if (student == null) {
                continue;
            }
            if (student.getID() == id) {
                return student.toString() + " is Emrolled in the Course";
            }
        }
        return "Student is not enrolled in the Course\n";
    }

    public String addStudentToCourse(Student student) {

        if (numberOfStudents == maxNumberOfStudents) throw new CourseFullException("Course Is Full");

        for (Student classmate : studentsInCourse) {
            if (classmate == null) {
                continue;
            }
            if (classmate.getID() == student.getID()) {
                return student.toString() + "is Already Enrolled in the Course\n";
            }
        }
        studentsInCourse[numberOfStudents] = student;
        numberOfStudents++;
        return student.toString() + "Has Been Added to The Course\n";
    }

    public String removeStudentFromCourse(Student student) {

        for (int i = 0; i < numberOfStudents; i++) {
            if (studentsInCourse[i] == null) {
                continue;
            }
            if (studentsInCourse[i].getID() == student.getID()) {
                while (i < maxNumberOfStudents) {
                    studentsInCourse[i] = studentsInCourse[i + 1];
                    i++;
                }
                return student.toString() + "has been removed from the class\n";
            }
        }
        return "Student is not enrolled in the Course\n";
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nCode: " + courseCode;
    }
}

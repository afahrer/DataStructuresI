package Assignment1;


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
        if(maxNumberOfStudents > 35) {
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

    public String findStudentByID(int id) {
        for(Student student: studentsInCourse) {
            if(student == null) {
                continue;
            }
            if(student.getID() == id) {
                return student.toString() + " is Emrolled in the Course";
            }
        }
        return "Student is not enrolled in the Course\n";
    }
    public String addStudent(Student student) {
        if(numberOfStudents == maxNumberOfStudents) {
            //Throw Custom Exception Here
        }
        for(Student classmate: studentsInCourse) {
            if(classmate == null) {
                continue;
            }
            if(classmate.getID() == student.getID()) {
                return student.toString() + "is Already Enrolled in the Course\n";
            }
        }
        studentsInCourse[numberOfStudents] = student;
        numberOfStudents++;
        return student.toString() + "Has Been Added to The Course\n";
    }
    public String removeStudent(Student student) {

        for (int i = 0; i < numberOfStudents; i++) {
            if(studentsInCourse[i] == null) {
                continue;
            }
            if(studentsInCourse[i].getID() == student.getID()) {
                while(i < maxNumberOfStudents) {
                    studentsInCourse[i] = studentsInCourse[i+1];
                    i++;
                }
                return student.toString() + "has been removed from the class\n";
            }
        }
        return "Student is not enrolled in the Course\n";
    }
}

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

    public Student findStudentByID(int id) {
        for(Student student: studentsInCourse) {
            if(student.getSTUDENT_ID() == id) {
                return student;
            }
        }
        return null;
    }
    public String addStudent(Student student) {
        if(numberOfStudents == maxNumberOfStudents) {
            //Throw Custom Exception Here
        }
        for(Student classmate: studentsInCourse) {
            if(classmate.getSTUDENT_ID() == student.getSTUDENT_ID()) {
                return "Student is Already Enrolled in the Course";
            }
        }
        return "Student Name: " + student.getName() + " ID " + student.getSTUDENT_ID() + " Has Been Added to The Course";
    }
}

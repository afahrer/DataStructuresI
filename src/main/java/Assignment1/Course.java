package Assignment1;


import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {

    private String name;
    private final String courseCode;
    private List<Student> studentsInCourse;
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
            if(student.getID() == id) {
                return student;
            }
        }
        return null;
    }
    public String addStudent(int id) {
        if(numberOfStudents == maxNumberOfStudents) {
            //Throw Custom Exception Here
        }
        Student student = findStudentByID(id);
        for(Student classmate: studentsInCourse) {
            if(classmate.getID() == student.getID()) {
                return student.toString() + " is Already Enrolled in the Course";
            }
        }
        studentsInCourse.add(student);
        numberOfStudents = studentsInCourse.size();
        return student.toString() + " Has Been Added to The Course";
    }
}

package Assignment1;

import java.io.*;
import java.util.Scanner;

public class Registrar {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Course course;
        Person person;

        do {
            System.out.println("1: Create a Course\n" +
                    "2. Create Student or Instructor\n" +
                    "3: Add Student to Course\n" +
                    "4: Check to see if a student is registered in a Course\n" +
                    "5: Remove a Student from a Course\n" +
                    "6. View All\n" +
                    "0. Close");
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            }catch (Exception e) {
                option = 0;
            }

            switch (option) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    createPerson();
                    break;
                case 3:
                    System.out.println("Course Code: ");
                    course = selectCourse(scanner.nextLine());
                    System.out.println("Student ID: ");
                    //no try catch
                    person = selectPerson(scanner.nextInt());
                    scanner.nextLine();
                    course.addStudentToCourse((Student)person);
                    writeObjectToFile(course);
                    break;
                case 4:
                    System.out.println("Course Code: ");
                    course = selectCourse(scanner.nextLine());
                    System.out.println("Student ID: ");
                    person = selectPerson(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println(course.findStudentByID(person.getID()));
                    break;
                case 5:
                    System.out.println("Course Code: ");
                    course = selectCourse(scanner.nextLine());
                    System.out.println("Student ID: ");
                    person = selectPerson(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println(course.removeStudentFromCourse((Student)person));
                    writeObjectToFile(course);
                    break;
                case 6:
                    viewObjects();
                    break;
                default:
                    option = 0;
            }
        } while (option != 0);
    }

    public static void writeObjectToFile(Object serObj) {
        try {
            boolean exists = new File("data.txt").isFile();
            FileOutputStream fileOut = new FileOutputStream("data.txt", true);
            ObjectOutputStream objectOut = exists ?
                    new ObjectOutputStream(fileOut) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    }:new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            fileOut.close();
            System.out.println("The Object  was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void createCourse() throws IOException {

        System.out.println("Course Name: ");
        String name = scanner.nextLine();

        System.out.println("Course Code: ");
        String code = scanner.nextLine();
        int max;
        int instructorID;
        try {
            System.out.println("Max Number of Students: ");
            max = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Instructor ID: ");
            instructorID = scanner.nextInt();
            scanner.nextLine();
        }
        catch (Exception e){
            System.out.println("Invalid Selection");
            return;
        }
        Course course = new Course(name, code, max);
        course.setCourseInstructor((Instructor)selectPerson(instructorID));
        writeObjectToFile(course);
    }

    private static void createPerson() {
        Person person = null;
        System.out.println("Name: ");

        String name = scanner.nextLine();
        int id;
        try{
            System.out.println("Person ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
        }
        catch (Exception e) {
            System.out.println("Invalid Selection");
            return;
        }

        System.out.println("Enter s for Student or i for Instructor");
        String selection = scanner.nextLine();

        if(selection.equals("s") || selection.equals("S")) {
            person = getStudentGrades(name, id);
        }
        else if (selection.equals("i") || selection.equals("I")) {
            person = getDepartment(name, id);
        }
        writeObjectToFile(person);
    }

    private static Student getStudentGrades(String name, int id) {
        int gradePoints;
        int credits;
        try{
            System.out.println("Grade Points Earned: ");
            gradePoints = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Credits Earned: ");
            credits = scanner.nextInt();
            scanner.nextLine();
        }
        catch (Exception e) {
            System.out.println("Invalid Selection");
            return null;
        }
        Student student = new Student(name, id);
        student.setGradePointsEarned(gradePoints);
        student.setCreditsEarned(credits);
        return student;
    }

    private static Instructor getDepartment(String name, int id) {
        System.out.println("Department: ");
        String department = scanner.nextLine();
        Instructor instructor = new Instructor(name, id);
        instructor.setDepartment(department);
        return instructor;
    }

    private static Course selectCourse(String code) throws IOException {
        ObjectInputStream ioStream = null;
        FileInputStream filestream = null;
        Object courseObject;
        try {
            filestream = new FileInputStream(new File("data.txt"));
            ioStream = new ObjectInputStream(filestream);
            while((courseObject = ioStream.readObject()) != null) {
                if (courseObject instanceof Course) {
                    if (((Course)courseObject).getCourseCode().equals(code))
                        return (Course)courseObject;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Not Found");
        }
        finally {
            ioStream.close();
            filestream.close();
        }
        return null;
    }

    private static Person selectPerson(int id) throws IOException {
        ObjectInputStream ioStream = null;
        FileInputStream filestream = null;
        Object personObject;
        boolean found = false;
        try {
            filestream = new FileInputStream(new File("data.txt"));
            ioStream = new ObjectInputStream(filestream);
            while((personObject = ioStream.readObject()) != null) {
                if (personObject instanceof Person) {
                    if (((Person)personObject).getID() == id)
                        return (Person)personObject;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Person Not Found");
        }
        finally {
            ioStream.close();
            filestream.close();
        }
        return null;
    }

    private static void viewObjects() throws IOException {
        ObjectInputStream ioStream = null;
        FileInputStream filestream = null;
        Object courseObject;
        try {
            filestream = new FileInputStream("data.txt");
            ioStream = new ObjectInputStream(filestream);
            while((courseObject = ioStream.readObject()) != null) {
                System.out.println(courseObject + "\n");
            }
        }
        catch(EOFException e) {
            return;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ioStream.close();
            filestream.close();
        }
    }
}
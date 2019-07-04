package Assignment1;

public class Student extends Person {
    private final int STUDENT_ID;
    private int creditsEarned;
    private int gradePointsEarned;

    public Student(String name, int STUDENT_ID) {
        super(name);
        this.STUDENT_ID = STUDENT_ID;
    }

    public int getSTUDENT_ID() {
        return STUDENT_ID;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(int creditsEarned) {
        this.creditsEarned = creditsEarned;
    }

    public int getGradePointsEarned() {
        return gradePointsEarned;
    }

    public void setGradePointsEarned(int gradePointsEarned) {
        this.gradePointsEarned = gradePointsEarned;
    }

    public int getGPA() {
        return this.gradePointsEarned / this.creditsEarned;
    }
    @Override
    public boolean equals(Object student) {
        return this.STUDENT_ID == ((Student)student).STUDENT_ID;
    }
}

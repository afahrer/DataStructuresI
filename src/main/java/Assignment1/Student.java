package Assignment1;

public class Student extends Person {

    private int creditsEarned;
    private int gradePointsEarned;

    public Student(String name, int id) {
        super(name, id);
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

    public float getGPA() {
        return (float) (this.gradePointsEarned) / this.creditsEarned;
    }

    @Override
    public boolean equals(Object student) {
        return this.getID() == ((Student) student).getID();
    }
}

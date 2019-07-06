package Assignment2;

public class CountTheStars {
    public static void main(String[] args) {
        printStars(10);
    }

    public static int countTheStars(int numInLastRow) {
        if (numInLastRow <= 1) return 1;
        return numInLastRow + countTheStars(numInLastRow - 1);
    }

    private static int starsInRow;
    public static void printStars(int numInLastRow) {
        if(numInLastRow == 0) {
            System.out.println("\nNumber of Stars: " + countTheStars(starsInRow));
            starsInRow = 0;
            return;
        }
        // https://stackoverflow.com/questions/2255500/can-i-multiply-strings-in-java-to-repeat-sequences
        System.out.println(new String(new char[numInLastRow]).replace("\0", " ") +
                           new String(new char[++starsInRow]).replace("\0", "* "));
        printStars(numInLastRow - 1);
    }
}

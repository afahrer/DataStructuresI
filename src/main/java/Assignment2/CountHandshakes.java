package Assignment2;

public class CountHandshakes {
    public static void main(String[] args) {
        System.out.println(countHandshakes(111));
    }

    private static int countHandshakes(int numOfAttendees) {
        if (numOfAttendees == 1) return 0;
        return numOfAttendees - 1 + countHandshakes(numOfAttendees - 1);
    }
}

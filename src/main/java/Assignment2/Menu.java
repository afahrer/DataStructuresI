package Assignment2;


import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    // https://stackoverflow.com/questions/5323502/how-to-set-thousands-separator-in-java/12682507
    private static NumberFormat moneyFormatter = NumberFormat.getInstance(new Locale("en_US"));
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("1. Replace at\n" +
                    "2. Shaking Hands\n" +
                    "3. Count stars and print the Pyramid\n" +
                    "4. Count files on a drive\n" +
                    "5. The Job Offer\n" +
                    "0. Exit");
            option = tryInt();
            switch (option) {
                case 1:
                    System.out.println("Enter String: ");
                    String testAt = scanner.nextLine();
                    System.out.println("Original String: " + testAt + "\nAt replaced: " + changeAt(testAt) + "\n");
                    break;
                case 2:
                    System.out.println("Number of Athletes: ");
                    int athletes = tryInt();
                    System.out.println("Number of Athleles: " + athletes + "\nNumber of Handshakes: " + countHandshakes(athletes) + "\n");
                    break;
                case 3:
                    System.out.println("Number of stars in last row: ");
                    int stars = tryInt();
                    printStarsInPyramid(stars);
                    break;
                case 4:
                    System.out.println("Enter Drive Letter: ");
                    String drive = scanner.nextLine().substring(0,1) + ":\\\\";
                    System.out.println("Number of files in " + drive + " " + countFiles(drive) + "\n");
                    break;
                case 5:
                    System.out.println("Total Weeks Worked (Max 52): ");
                    int weeks = tryInt();
                    if(weeks > 52) {
                        System.out.println("Invalid Weeks\n");
                        continue;
                    }
                    // https://stackoverflow.com/questions/35758179/convert-int-to-bigdecimal-with-decimal-java
                    // https://stackoverflow.com/questions/5323502/how-to-set-thousands-separator-in-java/12682507
                    System.out.println("Pay during Week " + weeks + ": $" + moneyFormatter.format(BigDecimal.valueOf(payThisWeek(weeks)).movePointLeft(2))
                            + "\nTotal Pay to date: $" + moneyFormatter.format(BigDecimal.valueOf(totalPayToDate(weeks)).movePointLeft(2)) + "\n");
                    break;
                default:
                    option = 0;
            }
        }while (option != 0);
    }

    private static int tryInt() {
        int num;
        try {
            num = scanner.nextInt();

        }catch (InputMismatchException e) {
            System.out.println("Invalid Number Provided\n");
            return 0;
        } finally {
            scanner.nextLine();
        }
        return num;
    }

    private static String changeAt(String str) {
        if (str.length() <= 1) return str;
        if (str.substring(0, 2).toLowerCase().equals("at")) return "@" + changeAt(str.substring(2));
        return str.substring(0, 1) + changeAt(str.substring(1));
    }

    private static int countHandshakes(int numOfAttendees) {
        if (numOfAttendees <= 1) return 0;
        return numOfAttendees - 1 + countHandshakes(numOfAttendees - 1);
    }

    private static int countTheStars(int numInLastRow) {
        if (numInLastRow <= 1) return 1;
        return numInLastRow + countTheStars(numInLastRow - 1);
    }

    private static int starsInRow;
    private static void printStarsInPyramid(int numInLastRow) {
        if (numInLastRow <= 0) {
            System.out.println("\nNumber of Stars: " + countTheStars(starsInRow) + "\n");
            starsInRow = 0;
            return;
        }
        // https://stackoverflow.com/questions/2255500/can-i-multiply-strings-in-java-to-repeat-sequences
        System.out.println(new String(new char[numInLastRow]).replace("\0", " ") +
                new String(new char[++starsInRow]).replace("\0", "* "));
        printStarsInPyramid(numInLastRow - 1);
    }

    private static int countFiles(String directory) {
        File fileDirectory = new File(directory);
        if(fileDirectory.listFiles() == null) return 0;
        int files = 0;
        for (int i = 0; i < fileDirectory.listFiles().length; i++) {
            if(fileDirectory.listFiles()[i].isFile()) files++;
            else if(fileDirectory.listFiles()[i].isDirectory()) files += countFiles(fileDirectory.listFiles()[i].toString());
        }
        return files;
    }

    private static long payThisWeek(int i) {
        if(i <= 1) return 1;
        return payThisWeek(i - 1)*2;
    }

    private static long totalPayToDate(int i) {
        if(i <= 1) return 1;
        return payThisWeek(i) + totalPayToDate(i-1);
    }

}

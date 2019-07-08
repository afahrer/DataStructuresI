package Assignment2;
/*

Author:     Adam Fahrer
Date:       July 8, 2019
Input:      User provides input for the various algorithm that
            can be ran using the menu interface

How to use: Enter the number of the program you want to run
            then enter input data for the selected algorithm

Exceptions: Stack Overflow Error if the number of attendees shaking hands is very large

Methods:    changeAt(String str) :
                replaces "at" with "@" in a given string. Not case sensitive.
            countHandshakes(int attendees) :
                count the number of handshakes for a given number of attendees.
            countTheStars(int numInLastRow):
                count the total stars in a pyramid given the number of stars in the bottom row.
            printStarsInPyramid(int numInLastRow):
                public method that calls printStarsInPyramid(int stars, int spaces) to print the pyramid
            printStarsInPyramid(int stars, int spaces):
                private method called by printStarsInPyramid(int numInLastRow).
                Needed to keep track of stars and spaces while printing the pyramid.
            payThisWeek(int weeks):
                calculates salary for the given week. Salary starts at $0.01 and doubles every week.
                Maximum number of weeks is 52.
            totalPayToDate(int weeks):
                calls payThisWeek(int weeks) for every week including the week provided.
                Returns total sum of earnings to date.
*/

import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Assignment2 {
    private static Scanner scanner = new Scanner(System.in);
    //https://stackoverflow.com/questions/5323502/how-to-set-thousands-separator-in-java/12682507
    private static NumberFormat moneyFormatter = NumberFormat.getInstance(new Locale("en_US"));

    //Looping Menu For running the programs within
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
                    System.out.println("Number of attendees: ");
                    int attendees = tryInt();
                    System.out.println("Number of Athleles: " + attendees + "\nNumber of Handshakes: " + countHandshakes(attendees) + "\n");
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
        } while (option != 0);
    }
    //Try Catch for getting integers from a user
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
    //Part A
    public static String changeAt(String str) {
        if (str.length() <= 1) return str;
        if (str.substring(0, 2).toLowerCase().equals("at")) return "@" + changeAt(str.substring(2));
        return str.substring(0, 1) + changeAt(str.substring(1));
    }
    //Part B
    public static int countHandshakes(int numOfAttendees) {
        if (numOfAttendees <= 1) return 0;
        return numOfAttendees - 1 + countHandshakes(numOfAttendees - 1);
    }
    //Part C
    public static int countTheStars(int numInLastRow) {
        if (numInLastRow <= 1) return 1;
        return numInLastRow + countTheStars(numInLastRow - 1);
    }
    //Part D
    public static void printStarsInPyramid(int numInLastRow) {
        printStarsInPyramid(1, numInLastRow);
    }

    private static void printStarsInPyramid(int stars, int spaces) {
        if (spaces <= 0) {
            System.out.println("\nThe total number of stars is: " + countTheStars(stars) + "\n");
            return;
        }
        // https://stackoverflow.com/questions/2255500/can-i-multiply-strings-in-java-to-repeat-sequences
        System.out.println(new String(new char[spaces]).replace("\0", " ") +
                new String(new char[stars]).replace("\0", "* "));
        printStarsInPyramid(stars + 1, spaces - 1);
    }
    //Part E
    public static int countFiles(String directory) {
        File fileDirectory = new File(directory);
        if(fileDirectory.listFiles() == null) return 0;
        int files = 0;
        for (int i = 0; i < fileDirectory.listFiles().length; i++) {
            if(fileDirectory.listFiles()[i].isFile()) files++;
            else if(fileDirectory.listFiles()[i].isDirectory()) files += countFiles(fileDirectory.listFiles()[i].toString());
        }
        return files;
    }
    //Part F
    public static long payThisWeek(int i) {
        if(i <= 1) return 1;
        return payThisWeek(i - 1)*2;
    }

    public static long totalPayToDate(int i) {
        if(i <= 1) return 1;
        return payThisWeek(i) + totalPayToDate(i-1);
    }

}

package Assignment3.Qu1;

import java.util.InputMismatchException;
import java.util.Scanner;

   /*

    Author:     Adam Fahrer
    Date:       July 13, 2019
    Input:      User provides input for the number of weeks

    Methods:    Returns number of plans available for the given weeks
    */

public class Tables {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int weeks = 0;
        System.out.println("Enter number of weeks: ");
        try{
            weeks = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("Invalid weeks");
            weeks = 0;
        }
        System.out.println("Number of Plans: " + numberOfPlans(weeks));
    }
    public static int numberOfPlans(int weeks) {
        if(weeks < 0) return 0;
        if(weeks < 3) return weeks;
        return numberOfPlans(weeks-1) + numberOfPlans(weeks-2);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;

/**
 *
 * @author afahrer
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(minChar("Hello"));
        System.out.println(minChar("goodbye"));
        System.out.println(minChar("hello"));

        printNumReverse(12345);
        System.out.println();

        printNumReverse(-432);
        System.out.println();

        printNumReverse2(-28183);
        System.out.println(reverseNum(49232));
    }

    public static char minChar(String str) {

        if (str.length() == 1) {
            return str.charAt(0);
        }
        if ((int) str.charAt(0) >= (int) str.charAt(str.length() - 1)) {
            return minChar(str.substring(1));
        }
        return minChar(str.substring(0, str.length() - 1));

    }

    public static void printNumReverse(int num) {
        if (num > 0) {
            System.out.print(num % 10);
            printNumReverse(num / 10);
        } else if (num < 0) {
            System.out.println("Negative Number Issued");
        }
    }

    public static void printNumReverse2(int num) {
        if (num != 0) {
            System.out.print(num % 10 * -1);
            printNumReverse2(num / 10);
        } else {
            System.out.println("-");
        }
    }

    public static String reverseNum(int num) {
        if (num == 0) {
            return "";
        }
        return (num % 10 + reverseNum(num / 10));
    }
}

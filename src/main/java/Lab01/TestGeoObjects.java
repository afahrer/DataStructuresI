/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab01;

/**
 *
 * @author afahrer
 */
public class TestGeoObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeometricObject[] arr = {new Rectangle(),
            new Rectangle(2, 1, "blue", true),
            new Square(),
            new Square(3, "green", true)};
        for (Object obj : arr) {
            System.out.println(obj.toString());
        }
        System.out.println("\nDifference in area between Rectangle 1 and 2 = "
                + ((Rectangle) arr[0]).compareTo(((Rectangle) arr[1])));

        if (((Square) arr[2]).compareTo(((Square) arr[3])) == 0) {
            System.out.println("Squares are the same size");
        } else if (((Square) arr[2]).compareTo(((Square) arr[3])) > 0) {
            System.out.println("The First Square is Bigger");
        } else {
            System.out.println("The First Square is Smaller");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab04;

import java.util.Scanner;
import static Lab04.CreditCard.validate;

/**
 *
 * @author afahrer
 */
public class Lab4 {

    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String accountNumber = "4556737586899855";
        CreditCard card = null;
        if(validate(accountNumber)) {
            card = new CreditCard("Adam", accountNumber);
        }
        card.charge(3.00);
        card.payment(1.00);
        System.out.println(card.toString());
    }
}

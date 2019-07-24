/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab04;

/**
 *
 * @author afahrer
 */
public class CreditCard {

    private String customerName;
    private final String accountNumber;
    private final double creditLimit = 5000.0;
    private int rewardPoints;
    private double accountBalance;

    public CreditCard(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void charge(double amount) {
        if (accountBalance + amount < creditLimit) {
            this.accountBalance += amount;
            addRewards((int) amount);
            applyInterest(amount);
        } else {
            System.out.println("Charge will exceed the credit limit.");
        }
    }

    public void cashAdvance(double amount) {
        charge(amount);
    }

    public void payment(double amount) {
        if (this.accountBalance - amount >= 0) {
            this.accountBalance -= amount;
        } else {
            System.out.println("Please make a payment less than or equal to the current account balance $" + accountBalance);
        }
    }

    private void applyInterest(double amount) {
        this.accountBalance += (amount * 0.03);
    }

    private void addRewards(int points) {
        this.rewardPoints += points;
    }
    public static boolean validate(String num) {
        int lastDigit = Integer.parseInt(num.substring(num.length()-1));
        num = num.substring(0,num.length()-1);
        int digit;
        for (int i = 0; i < num.length(); i+=2) {
            digit = Integer.parseInt(num.substring(i,i+1));
            digit *= 2;
            if(digit > 9) {
                digit -= 9;
            }
            num = num.substring(0,i) + digit + num.substring(i+1,num.length()) ; 
        }
        int sum= 0;
        for (int i = 0; i < num.length(); i++) {
            digit = Integer.parseInt(num.substring(i,i+1));
            sum+=digit;
        }
        return sum % 10 == lastDigit;
    }
    @Override
    public String toString() {
        return "Customer Name: " + customerName
                + "\nAccount Number: " + accountNumber
                + "\nCredit Limit: $" + creditLimit
                + "\nReward Points: " + rewardPoints
                + "\nAccount Balance: $" + accountBalance;
    }
}

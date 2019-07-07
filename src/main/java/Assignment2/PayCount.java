package Assignment2;

import java.math.BigDecimal;

public class PayCount {
    public static void main(String[] args) {
        // https://stackoverflow.com/questions/35758179/convert-int-to-bigdecimal-with-decimal-java
        System.out.println("Pay this week: $" + BigDecimal.valueOf(payThisWeek(10)).movePointLeft(2));
        System.out.println("Pay up to this week: $" + BigDecimal.valueOf(totalPay(16)).movePointLeft(2));
    }

    private static long payThisWeek(int i) {
        if(i <= 1) return 1;
        return payThisWeek(i - 1)*2;
    }
    private static long totalPay(int i) {
        if(i <= 1) return 1;
        return payThisWeek(i) + totalPay(i-1);
    }
}

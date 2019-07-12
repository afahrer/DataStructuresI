package Assignment3.Qu1;

public class Tables {
    public static void main(String[] args) {
        System.out.println(numberOfPlans(1));
    }
    public static int numberOfPlans(int weeks) {
        if(weeks < 0) return 0;
        if(weeks < 3) return weeks;
        return numberOfPlans(weeks-1) + numberOfPlans(weeks-2);
    }
}

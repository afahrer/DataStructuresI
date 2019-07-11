package Assignment3;

public class Tables {
    public static void main(String[] args) {
        System.out.println(numberOfPlans(30));
    }
    public static int numberOfPlans(int weeks) {
        if(weeks < 1) return 0;
        if(weeks == 1) return 1;
        if(weeks == 2) return 2;
        return numberOfPlans(weeks-1) + numberOfPlans(weeks-2);
    }
}

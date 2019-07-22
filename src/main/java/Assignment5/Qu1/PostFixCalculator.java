package Assignment5.Qu1;

import java.util.StringTokenizer;

public class PostFixCalculator {

    public static ADTList stack;
    private static String[] operators = {"+", "-", "*", "^", "%", "/"};

    public static void main(String[] args) {
        stack = new ADTList();
        String infix = "2 / ( 3  + 76 ) - 6 ^ 3 * 2 % 3";
        StringTokenizer tokenizer = new StringTokenizer(infix);
        System.out.println("Infix: " + infix + "\nPostfix: " + postFix(tokenizer));
    }

    public static String postFix(StringTokenizer str) {
        String postfixExp = "";
        while (str.hasMoreTokens()) {
            String item = str.nextToken();
            if (item.equals("(")) {
                stack.push(item);
                continue;
            }
            if (item.equals(")")) {
                while (!stack.peek().equals("(")) {
                    postfixExp = postfixExp + stack.pop();
                }
                stack.pop();
                continue;
            }
            if (isOperator(item)) {
                while ((!stack.isEmpty()) && (!stack.peek().equals("("))
                        && (precedance(item) <= precedance((String) stack.peek()))) {
                    postfixExp = postfixExp + stack.pop();
                }
                stack.push(item);
                continue;
            }
            postfixExp = postfixExp + item;
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != "(" && stack.peek() != ")")
                postfixExp = postfixExp + stack.pop();
            else {
                stack.pop();
            }
        }
        return postfixExp;
    }

    public static boolean isOperator(String item) {
        for (String operator : operators) {
            if (item.equals(operator)) return true;
        }
        return false;
    }

    public static int precedance(String oper) {
        if (stack.isEmpty()) return 0;
        if (oper.equals("^")) return 3;
        if (oper.equals("*") || oper.equals("/") || oper.equals("%")) return 2;
        return 1;
    }
}

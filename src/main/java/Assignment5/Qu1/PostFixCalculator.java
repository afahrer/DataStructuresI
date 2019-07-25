package Assignment5.Qu1;

import java.util.StringTokenizer;
/*

    Author:     Adam Fahrer
    Date:       July 22, 2019
    Purpose:    Uses the ADT stack to convert an infix expression to postfix.
    Methods:    String postFix(StringTokenizer str):
                    converts infix to postfix
                boolean isOperator(String item):
                    determine whether or not the string passed is an operator
                int precedence(String oper):
                    determines the order in which operations take place by returning an
                    integer based on the operator provided
*/
public class PostFixCalculator {

    public static ADTList stack;

    private static String[] operators = {"+", "-", "*", "^", "%", "/"};

    public static void main(String[] args) {
        stack = new ADTList();
        String infix = "( 10 + 90 ) * 6 / 60 + 7 ";
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
                        && (precedence(item) <= precedence((String) stack.peek()))) {
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

    public static int precedence(String oper) {
        if (oper.equals("^")) return 3;
        if (oper.equals("*") || oper.equals("/") || oper.equals("%")) return 2;
        return 1;
    }
}

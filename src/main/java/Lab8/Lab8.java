/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8;

/**
 *
 * @author afahrer
 */
public class Lab8 {

    static char[] operators = {'+', '-', '/', '*', '^', '%'};
    public static void main(String[] args) {
        
        System.out.println("PostFix");
        System.out.println(isPostfix("423+9/-2*"));
        System.out.println(isPostfix("4213+9/-2"));
        System.out.println(isPostfix("4-23+9/2*"));
        System.out.println(isPostfix("423+9/-2*+"));
        
        System.out.println("Infix");
        System.out.println(isInfix("3+9-2"));
        System.out.println(isInfix("3+9-5/2^3"));
        System.out.println(isInfix("6+-9/-6+2-2%8"));
        
        System.out.println("PreFix");
        System.out.println(isPrefix("*-423-92"));
        System.out.println(isPrefix("*/+4239-2"));
        System.out.println(isPrefix("/+%-/84368-95"));
    }
    public static boolean isPostfix(String post) {
        int count = 0;
        for (int i = 0; i < post.length(); i++) {
            if(Character.isDigit(post.charAt(i))) count++;
            else if(isOperator(post.charAt(i))) count--;
            if(count < 0) return false;
        }
        return count == 1;
    }
    public static boolean isInfix(String in) {
        int count = 0;
        for (int i = 0; i < in.length(); i++) {
            if(in.length() - i != 1){
                if(isOperator(in.charAt(i)) && isOperator(in.charAt(i+1))) return false;
                continue;
            }
            if(isOperator(in.charAt(i))) return false;
        }
        return true;
    }
    public static boolean isPrefix(String pre){
        int count = 0;
        for (int i = 0; i < pre.length(); i++) {
            if(Character.isDigit(pre.charAt(i))) count++;
            else if(isOperator(pre.charAt(i))) count--;
            if(count > 1) return false;
        }
        return count == 1;
    }
    public static boolean isOperator(char c) {
        for (int i = 0; i < operators.length; i++) {
            if(c == operators[i]) return true;
        }
        return false;
    }
}

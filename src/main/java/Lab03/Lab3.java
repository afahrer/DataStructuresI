/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab03;

/**
 *
 * @author afahrer
 */
public class Lab3 {

    public static void main(String[] args) {
        System.out.println(f(6));
        System.out.println(f(7));
        System.out.println(f(10));
        System.out.println(f(12));
        System.out.println(f2(6));
        System.out.println(f2(7));
        System.out.println(f2(10)); 
        System.out.println(f2(12));
        printAsterisk(7);
    }
    public static int f(int n){
        if(n<4) return n;
        if(n<6) return n/2;
        return 2 * f(n-1) + f(n-5);
    }
    public static int f2(int n) {
        int a=1;
        int b=2;
        int c=3;
        int d=2;
        int e=2;
        int f=2*e+a;
        for (int i = 6; i < n; i++) {
            a=b;
            b=c;
            c=d;
            d=e;
            e=f;
            f=2*e+a;
        }
        return f;        
    }
    public static void printAsterisk(int n) {
        starsUp(n);
        starsDown(n);
    }
    private static void starsDown(int n) {
        if(n==0) return;
        System.out.println(new String(new char[n]).replace("\0", "*"));      
        starsDown(n-1);
    }
    private static void starsUp(int n) {
        if(n==0) return;
        starsUp(n-1);
        System.out.println(new String(new char[n]).replace("\0", "*"));      
    }
}

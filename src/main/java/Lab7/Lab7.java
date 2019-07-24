/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

/**
 *
 * @author afahrer
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        System.out.println("racecar " + isInLanguage("racecar"));
        System.out.println("asantaatnasa " + isInLanguage("asantaatnasa"));
        System.out.println("namenowoneman " + isInLanguage("namenowoneman"));
        System.out.println("ahsatanseesnatasha " + isInLanguage("ahsatanseesnatasha"));
        System.out.println("poohanimalsslaminahoop " + isInLanguage("poohanimalsslaminahoop"));
        System.out.println("abutttuba " + isInLanguage("abutttuba"));
        System.out.println("evillove " + isInLanguage("evillove"));
    }

    private static boolean isInLanguage(String word) {
        if(word.length() % 2 != 0) return false;
        ADTStack list = new ADTStack();
        int storedLetters = word.length() / 2;
        for (int i = 0; i < storedLetters; i++) {
             list.push(word.charAt(i));
        }
        for (int i = storedLetters; i < word.length(); i++) {
            if(list.pop() != word.charAt(i)) return false;
        }
        return true;
    }
    
}

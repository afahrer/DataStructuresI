package Assignment2;

public class ReplaceAt {
    public static void main(String args[]) {
        System.out.println("changeAt(\"catcatdogatfishatt\") returns\n" + changeAt("catcatdogatfishatt"));
    }
    public static String changeAt(String str) {
        if(str.length() <= 1) return str;
        if(str.substring(0, 2).equals("at")) return "@" + changeAt(str.substring(2));
        return str.substring(0,1) + changeAt(str.substring(1));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

/**
 *
 * @author afahrer
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyList<String> list = new MyList<String>();
        list.add(1, "Butter");
        list.add(2, "Eggs");
        list.add(1, "Cereal");
        list.add(2, "Milk");
        list.add(1, "Coffee");
        list.add(1, "Bread");
        list.printList();
        swap(list, 1,2);
        System.out.println();
        list.printList();
    }
    static void swap(MyList l, int i, int j) {
        Object temp = l.get(i);
        l.add(i, l.get(j));
        l.remove(i+1);
        l.remove(j);
        l.add(j, temp);
    }
    
}

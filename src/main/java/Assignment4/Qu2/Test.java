package Assignment4.Qu2;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        DoublyList<Person> list = new DoublyList<Person>();
        list.add(new Person("123456789", "adam", "543", "1234566778"));
        list.add(new Person("323656789", "phil", "543", "2234566778"));
        list.add(new Person("223446789", "mike", "343", "3234566778"));
        list.add(new Person("423453789", "bill", "343", "4234566778"));
        list.add(new Person("623456489", "jill", "243", "434566778"));
        list.add(new Person("523456739", "nick", "143", "5234566778"));
        list.add(new Person("723456739", "john", "543", "6234566778"));
        list.add(new Person("923456739", "tom", "533", "7234566778"));
        list.add(new Person("823456739", "jim", "523", "8234566778"));
        list.add(new Person("023456739", "james", "553", "9234566778"));
        Random rand = new Random();
        int m = rand.nextInt(list.size()) + 1;
        System.out.println("\nAfter josephus using frequency of " + m);
        System.out.println(list.josephus(m));
        System.out.println("\nRegenerated list");
        list.printList();
    }
}

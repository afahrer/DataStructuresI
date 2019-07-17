package Assignment4.Qu2;

public class Test {
    public static void main(String[] args) {
        DoublyList<Person> list = new DoublyList<Person>();
        list.add(new Person("123456789", "adam", "543", "1234566778"));
        list.add(new Person("223656789", "adam", "543", "1234566778"));
        list.add(new Person("323446789", "adam", "543", "1234566778"));
        list.add(new Person("423453789", "adam", "543", "1234566778"));
        list.add(new Person("523456489", "adam", "543", "1234566778"));
        list.add(new Person("623456739", "adam", "543", "1234566778"));
        list.printList();
        list.josephus(2);
        System.out.println();
        list.printList();
    }
}

package Assignment4.Qu2;

public class Test {
    public static void main(String[] args) {
        DoublyList<Person> list = new DoublyList<Person>();
        list.add(new Person("323456789", "adam", "543", "1234566778"));
        list.add(new Person("423456789", "adam", "543", "1234566778"));
        list.add(new Person("223456789", "adam", "543", "1234566778"));
        list.printList();
    }
}

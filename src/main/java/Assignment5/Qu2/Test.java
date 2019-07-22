package Assignment5.Qu2;
/*

    Author:     Adam Fahrer
    Date:       July 22, 2019
    Purpose:    Tests the methods of the Queue class and contains methods that
                perform different operations using the queue
*/
public class Test {

    private static Queue<Integer> queue;

    public static void main(String[] args) {
        queue = new Queue();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }

        displayQueue();
        System.out.println("\nCount: " +countQueuedItems());
        System.out.println("Sum: " + sumQueuedItems());
        System.out.println("Max: " + maxQueuedItem());
        System.out.println("Min: " + minQueuedItem());
    }

    public static void displayQueue() {
        Integer last = queue.dequeue();
        System.out.println(last);
        queue.enqueue(last);
        Integer item;
        while ((item = queue.dequeue()) != last) {
            System.out.println(item);
            queue.enqueue(item);
        }
        queue.enqueue(last);
    }

    public static int countQueuedItems() {
        Integer last = queue.dequeue();
        queue.enqueue(last);
        int count = 1;
        Integer item;
        while ((item = queue.dequeue()) != last) {
            queue.enqueue(item);
            count++;
        }
        queue.enqueue(last);
        return count;
    }

    public static int sumQueuedItems() {
        Integer last = queue.dequeue();
        queue.enqueue(last);
        int sum = last;
        Integer item;
        while ((item = queue.dequeue()) != last) {
            sum += item;
            queue.enqueue(item);
        }
        queue.enqueue(last);
        return sum;
    }

    public static int maxQueuedItem() {
        Integer last = queue.dequeue();
        queue.enqueue(last);
        int max = last;
        Integer item;
        while ((item = queue.dequeue()) != last) {
            if(item > max)
                max = item;
            queue.enqueue(item);
        }
        queue.enqueue(last);
        return max;
    }

    public static int minQueuedItem() {
        Integer last = queue.dequeue();
        queue.enqueue(last);
        int min = last;
        Integer item;
        while ((item = queue.dequeue()) != last) {
            if(item < min)
                min = item;
            queue.enqueue(item);
        }
        queue.enqueue(last);
        return min;
    }
}

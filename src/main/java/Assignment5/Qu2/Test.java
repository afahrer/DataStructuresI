package Assignment5.Qu2;

public class Test {
    private static Queue queue;
    public static void main(String[] args) {
        queue = new Queue();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        displayQueue(queue);
        System.out.println("\nCount: " +countQueuedItems(queue));
        System.out.println("Sum: " + sumQueuedItems(queue));
        System.out.println("Max: " + maxQueuedItem(queue));
        System.out.println("Min: " + minQueuedItem(queue));
    }

    public static void displayQueue(Queue queue) {
        Queue temp = null;
        try {
            temp = (Queue)queue.clone();
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        while (!temp.isEmpty()) {
            System.out.println(temp.dequeue());
        }
    }

    public static int countQueuedItems(Queue queue) {
        Queue temp = null;
        try {
            temp = (Queue)queue.clone();
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int count = 0;

        while (!temp.isEmpty()) {
            temp.dequeue();
            count++;
        }

        return count;
    }

    public static int sumQueuedItems(Queue queue) {
        Queue temp = null;
        try {
            temp = (Queue)queue.clone();
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int sum = 0;
        while (!temp.isEmpty()) {
            sum += (Integer)temp.dequeue();
        }
        return sum;
    }

    public static int maxQueuedItem(Queue queue) {
        Queue temp = null;
        int item = 0;
        try {
            temp = (Queue)queue.clone();
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int max = 0;
        while (!temp.isEmpty()) {
            item = (Integer)temp.dequeue();
            if(item > max) max = item;
        }
        return item;
    }

    public static int minQueuedItem(Queue queue) {
        Queue temp = null;
        int item = 0;
        try {
            temp = (Queue)queue.clone();
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int min = 0;
        while (!temp.isEmpty()) {
            item = (Integer)temp.dequeue();
            if(item < min) min = item;
        }
        return item;
    }
}

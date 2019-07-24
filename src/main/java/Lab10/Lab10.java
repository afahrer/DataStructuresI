package Lab10;

import java.util.Random;

public class Lab10 {

    public static void main(String[] args) {
	    Integer[] arr = new Integer[10000];
	    Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50000 + 50000) - 50000;
        }
        long startTime = System.nanoTime();
        quicksort(arr,0,arr.length);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000.0);
    }
    public static void swap(Integer[] arr, int index1, int index2) {
        Integer temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static void quicksort(Integer[] arr, int first, int last) {
        if(last-first <= 1) return;
        int pivot = partition(arr, first, last);
        quicksort(arr, first, pivot);
        quicksort(arr, ++pivot, last);
    }
    public static int partition(Integer[] arr, int first, int last) {
        int pivot = first;
        int u = first + 1;
        int low = first;
        while(u < last) {
            if(arr[u] < arr[pivot]) {
                low++;
                swap(arr, low, u);
            }
            u++;
        }
        swap(arr, pivot, low);
        return low;
    }
}

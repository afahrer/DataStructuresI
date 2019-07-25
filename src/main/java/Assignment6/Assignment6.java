package Assignment6;

import java.util.Random;
/*

    Author:     Adam Fahrer
    Date:       July 25, 2019
    Purpose:    To demonstrate the quick sort and merge sort algorithms.

*/
public class Assignment6 {

    public static void main(String[] args) {
        Random rand = new Random();

        int[] merge = new int[10];
        int[] quick = new int[10];
        for (int i = 0; i < merge.length; i++) {
            merge[i] = rand.nextInt(1000000) - 500000;
            quick[i] = rand.nextInt(1000000) - 500000;
        }
// merge sort
        System.out.print("Merge Sort Unsorted:\n\t[ ");
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i] + " ");
        }
        System.out.print("]");

        mergeSort(merge,0,merge.length);

        System.out.print("\nSorted:\n\t[ ");
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i] + " ");
        }
        System.out.print("]");

// quick sort

        System.out.print("\nQuick Sort Unsorted:\n\t[ ");
        for (int i = 0; i < quick.length; i++) {
            System.out.print(quick[i] + " ");
        }
        System.out.print("]");

        quicksort(quick, 0, quick.length);

        System.out.print("\nSorted:\n\t[ ");
        for (int i = 0; i < quick.length; i++) {
            System.out.print(quick[i] + " ");
        }
        System.out.print("]");
    }

    private static void mergeSort(int[] arr, int first, int last) {
        if (last - first <= 1) return;
        int mid = (first + last) / 2;
        mergeSort(arr, first, mid);
        mergeSort(arr, mid, last);

        int[] temp = new int[last - first];

        int left = first;
        int right = mid;
        int currPos = 0;

        while (left < mid && right < last) {
            if (arr[left] < arr[right]) temp[currPos++] = arr[left++];
            else temp[currPos++] = arr[right++];
        }

        while (left < mid) {
            temp[currPos++] = arr[left++];
        }

        while (right < last) {
            temp[currPos++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[first++] = temp[i];
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static void quicksort(int[] arr, int first, int last) {
        if(last-first <= 1) return;
        int pivot = partition(arr, first, last);
        quicksort(arr, first, pivot);
        quicksort(arr, ++pivot, last);
    }
    public static int partition(int[] arr, int first, int last) {
        swap(arr,first,(first+last)/2);
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

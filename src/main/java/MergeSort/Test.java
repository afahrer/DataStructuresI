package MergeSort;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(50) - 25;
        }

        System.out.print("Unsorted:\n\t[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");

        mergeSort(arr);

        System.out.print("\nSorted:\n\t[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int first, int last) {
        if (last - first <= 1) return;
        int mid = (first + last) / 2;
        mergeSort(arr, first, mid); //This is splitting the left side.
        mergeSort(arr, mid, last); //This is splitting the right side.

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
}

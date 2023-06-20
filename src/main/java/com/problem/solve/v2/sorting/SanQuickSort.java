package com.problem.solve.v2.sorting;

import java.util.Arrays;

public class SanQuickSort {
    public static void main(String args[])
    {
        int[] data = { 8, 7, 2, 1, 0, 9, 6 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;

        // call quicksort() on array data
        quickSort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
    public static void quickSort(int[] arr, int lower, int high)
    {
        if(lower< high) {
            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pivot = partition(arr, lower, high);
            // recursive call on the left of pivot
            quickSort(arr, lower, pivot-1);

            // recursive call on the right of pivot
            quickSort(arr,pivot+1, high);
        }
    }
    private static int partition(int[] arr, int lower, int high)
    {
        // set high position with pivot element;
        int pivotEle = arr[high];
        int firstPointer = lower-1;
        for(int i=lower;i< arr.length;i++) {
            if(arr[i]<pivotEle) {
                //swap
                firstPointer++;
                int tmp = arr[i];
                arr[i] = arr[firstPointer];
                arr[firstPointer] = tmp;
            }
        }
        // swap pivot into correct place
        arr[high] = arr[firstPointer+1];
        arr[firstPointer+1] = pivotEle;

        return firstPointer+1;
    }
}

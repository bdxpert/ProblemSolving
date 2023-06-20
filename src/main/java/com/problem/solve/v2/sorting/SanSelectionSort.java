package com.problem.solve.v2.sorting;

public class SanSelectionSort {
    public static void main(String args[]) {
        int[] arr = {5,3,2, 7};
        selectionSort(arr);
        for(int i=0; i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
    public static void selectionSort(int[] arr)
    {
        for(int i=0; i< arr.length; i++) {
            //int min = arr[i];
            int minIndex = i;
            for(int j=i+1;j<arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    //min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i) {
                //swap
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}

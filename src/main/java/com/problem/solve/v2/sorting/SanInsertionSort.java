package com.problem.solve.v2.sorting;

public class SanInsertionSort {
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };
        sort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
    static void sort(int[] arr)
    {
        int n = arr.length;
//        { 12, 11, 13, 5, 6 };
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public void insertionSort(int[] arr)
    {
        for(int i=1;i<arr.length;i++){
            int k = i;
            while(k>=1){
                if(arr[k-1]>arr[k]) {
                    //swap
                    int tmp = arr[k];
                    arr[k] = arr[k-1];
                    arr[k-1] = tmp;
                }
                k--;
            }
        }
    }
}

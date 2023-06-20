package com.problem.solve.v2.sorting;

public class SanMergeSort {
    public static void main(String args[])
    {

    }
    public static void mergeSort(int[] arr, int l, int r)
    {
        if(l<r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            sanMerge(arr, l, m ,r);
        }
    }
    static int[] sanMerge(int arr[], int p, int q, int r)
    {
        int n1 = q-p+1;
        int n2 = r-q;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for(int i=0;i<n1; i++){
            arr1[i] = arr[i+p];
        }
        for(int i=0;i<n2;i++) {
            arr2[i] = arr[q+1+i];
        }
        int i=0;
        int j=0;
        int k = 1;
        while (i<n1 && j < n2) {
            if(arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (j<n2) {
            arr[k] = arr2[j];
            j++;k++;
        }
        while (i<n1) {
            arr[k] = arr1[i];
            i++;k++;
        }
        return arr;
    }
}

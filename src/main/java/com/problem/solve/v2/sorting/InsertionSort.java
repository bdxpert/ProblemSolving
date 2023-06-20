package com.problem.solve.v2.sorting;

public class InsertionSort {
    public static void main(String args[])
    {
        Integer[] arr = {11,12,3,4,5,1};
        insertionSort(arr);

        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static Integer[] insertionSort(Integer[] data) {
        for (int i=1;i<data.length;i++)
        {
            int j = i;
            while(j >0 && data[j-1]>data[j])
            {
                //swap(data[j-1], data[j]);
                int tmp = data[j-1];
                data[j-1] = data[j];
                data[j] = tmp;
                j--;
            }
        }
        return data;
    }
    /*public swap(Integer dataj1, Integer dataj) {

    }*/
}

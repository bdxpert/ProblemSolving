package com.problem.solve.v2.sum;

import java.util.Arrays;

public class ProductivePair {
    public static void productivePairs(int N, int a[],
                                       int K){
        int value=0;
        int sum=0;
        Arrays.sort(a);

        for(int i=0;i<a.length; i++) {
            int l = i;
            int m = a.length-1;
            while (l < m) {
                if (a[l] * a[m] >= K) {
                    System.out.println(a[l] +"*"+ a[m]);
                    sum = sum + a[l] * a[m];
                    //l++;
                    value++;
                    m--;
                } else {
                    m--;
                }
            }
        }

        System.out.print(value+""+sum);
    }
    public static void main(String args[])
    {
        int n= 5, k=6;
        int[] a = {5,4,3,2,1};
        productivePairs(5, a, k);

    }
}

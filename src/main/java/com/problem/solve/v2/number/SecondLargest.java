package com.problem.solve.v2.number;

public class SecondLargest {
    public static int secondLarge2(int[] a) {
        int firL = Integer.MIN_VALUE;
        int secL = Integer.MIN_VALUE;
        for(int i=0;i< a.length;i++){
            if(a[i]>firL){
                secL = firL;
                firL = a[i];
            } else if(secL < a[i]){
                secL = a[i];
            }
        }
        return secL;
    }
    private static int largestPairSum(int[] arr, int n)
    {
        int j = 0;
        int max = n == 1 ? arr[0] + arr[1] : arr[0];
        for (int i = 0; i < n; i++) {
            int sum = arr[j] + arr[i];
            if (sum > max) {
                max = sum;
                if (arr[j] < arr[i]) {
                    j = i;
                }
            }
        }
        return max;
    }
    public static void main(String args[]) {
        int[] a = {2,4,1,3};
        System.out.println(secondLarge2(a));
    }

}

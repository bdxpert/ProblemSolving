package com.problem.solve.v2.number;

public class LargestPairSum {

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        int arr[] = { 12, 34, 10, 6, 40};
        System.out.println(largestPairSum(arr, arr.length));
    }
    // photon
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
}

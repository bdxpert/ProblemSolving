package com.problem.solve.v2.array;

public class SlidingWindowGFG {
    /*
    Input  : arr[] = {100, 200, 300, 400}, k = 2
    Output : 700

    Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4
    Output : 39
    We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.

    Input  : arr[] = {2, 3}, k = 3
    Output : Invalid
    There is no subarray of size 3 as size of whole array is 2.
     */
    public static void main(String args[])
    {
        int[] arr = {100, 200, 300, -400};
        int k = 2;
        System.out.println(getMaxSum(arr, k));
    }
    static int getMaxSum(int[] nums, int k) {
        // window size k =2
        int max =Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<k;i++) {
            sum += nums[i];
        }
        if(sum> max) {
            max = sum;
        }
        for(int i=k;i<nums.length;i++) {
            sum += nums[i]-nums[i-k];
            max = Math.max(max, sum);
        }
        return max;
    }
    static int maxSumV2(int arr[], int n, int k)
    {
        // Initialize result
        int max_sum = Integer.MIN_VALUE;

        // Consider all blocks starting with i.
        for (int i = 0; i < n - k + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < k; j++)
                current_sum = current_sum + arr[i + j];

            // Update result if required.
            max_sum = Math.max(current_sum, max_sum);
        }

        return max_sum;
    }

}

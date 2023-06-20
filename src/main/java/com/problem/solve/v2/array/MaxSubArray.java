package com.problem.solve.v2.array;

public class MaxSubArray {
    //https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    /*
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            currSum = Math.max(nums[i], currSum+nums[i]);
            if(currSum > maxSum) maxSum = currSum;
        }
        return maxSum;
    }
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        int startIndex = 0;

        for(int i=0;i<n;i++) {
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0) {
                sum = 0;
                startIndex = i;
            }
        }

        return max;
    }
    static void maxSubArraySum(int a[], int size)
    {
        int max = Integer.MIN_VALUE,
                sum = 0, start = 0, end = 0, s = 0;

        for (int i = 0; i < size; i++) {
            sum += a[i];

            if (max < sum) {
                max = sum;
                start = s;
                end = i;
            }

            if (sum < 0) {
                sum = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}
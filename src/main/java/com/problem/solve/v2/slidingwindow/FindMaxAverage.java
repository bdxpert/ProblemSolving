package com.problem.solve.v2.slidingwindow;

public class FindMaxAverage {

    public double optimizedFindMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i ++)
            sum += nums[i];
        int maxSum = sum;
        for(int i = k; i < nums.length; i ++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }

    public double findMaxAverage(int[] nums, int k) {
        double avg = -Double.MAX_VALUE;

        for(int i=0;i<nums.length-k+1;i++) {

            int pointer =0;
            int sum = 0;
            while(pointer < k ) {
                sum = sum + nums[i+pointer];
                pointer++;
            }

            avg = Math.max(avg, (double)sum/(double)k);
            sum = 0;
        }
        return avg;
    }
}

package com.problem.solve.v2.dynamic;

import java.util.Arrays;

public class Robber {
    public int rob(int[] nums) {
        int dp[]= new int[nums.length+1];  // create dp array
        Arrays.fill(dp,-1);  // initialize dp array with -1
        return backtrack(nums,0,dp);
    }
    public int backtrack(int[] nums,int i,int []dp){
        if(i>=nums.length) return 0;  //base condition
        if(dp[i]!=-1) return dp[i];  // if element present int dp array
//         include
        int a= backtrack(nums,i+2,dp)+nums[i];  // include the given element
//         exclude
        int b= backtrack(nums,i+1,dp);  // exclude the element
        dp[i]= Math.max(a,b);  // update dp array
        return dp[i];
    }
    public int robV2(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (final int num : nums) {
            final int dp = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }
    public int robV3(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return backtrackv2(nums, 0, dp);
    }
    int backtrackv2(int[] nums, int i, int[] dp) {
        if(i>=nums.length) return 0;
        if(dp[i] !=-1) return dp[i];
        int a = backtrackv2(nums, i+2, dp) + nums[i];
        int b = backtrackv2(nums, i+1, dp);

        dp[i] = Math.max(a,b);

        return dp[i];
    }
}

package com.problem.solve.v2.array;

public class ProductExceptSelf {
    /*
     Input: nums = [1,2,3,4]
     Output: [24,12,8,6]
    */
    /*
     Input: nums = [-1,1,0,-3,3]
     Output: [0,0,9,0,0]
    */
    public int[] productExceptSelf(int[] nums) {
        //Approach: Using prefix and postfix
        //Idea: Just find prefix and postfix product and keep them in the ans array

        int ans[] = new int[nums.length];
        int pre = 1, post = 1;

        //find pre product
        for(int i=0;i<nums.length;i++) {
            ans[i] = pre;
            pre*=nums[i];
        }

        //find post product
        for(int i=nums.length-1;i>=0;i--) {
            ans[i]*=post;
            post*=nums[i];
        }

        return ans;
    }
}

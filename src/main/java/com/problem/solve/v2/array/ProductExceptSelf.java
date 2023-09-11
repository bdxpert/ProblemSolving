package com.problem.solve.v2.array;

public class ProductExceptSelf {
    public static void main(String args[])
    {
        int[] nums = {1,2,3,4};
        productExceptSelf(nums);
    }
    /*
     Input: nums = [1,2,3,4]
     Output: [24,12,8,6]
    */
    /*
     Input: nums = [-1,1,0,-3,3]
     Output: [0,0,9,0,0]
    */
    public static int[] productExceptSelf(int[] nums) {
        //Approach: Using prefix and postfix
        //Idea: Just find prefix and postfix product and keep them in the ans array

        // pre =1
        // data 1 2 3 4
        // 1 1*1 2*1 2*3 (neglecting self product)
        // asending 1 1 2 6 ans[]

        // post = 1
        // asending 6 2 1 1 ans[]
        // data 4 3 2 1 (* reverse of asending)
        // post = 1 4 12 24
        // now decending 6*1 2*4 1*12 1*24
        // res 24 12 8 6

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

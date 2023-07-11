package com.problem.solve.v2.sum;

import java.util.Arrays;

public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        if(nums.length ==0) return nums[0];

        for(int i=0;i<nums.length;i+=2) {
            if(i%2 ==0)
                nums[i] = Math.min(nums[i*2], nums[i*2+1]);
            else
                nums[i] = Math.max(nums[i*2], nums[i*2+1]);
        }
        return minMaxGame(Arrays.copyOf(nums, nums.length/2));
}
}
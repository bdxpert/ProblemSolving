package com.problem.solve.v2.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = {-1,-1};
        Map<Integer, Integer> data = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int diff = target-nums[i];
            if(data.containsKey(diff)) {
                res[0] = data.get(diff);
                res[1] = i;
                break;
            } else {
                data.put(target-nums[i], i);
            }
        }
        return res;
    }
}

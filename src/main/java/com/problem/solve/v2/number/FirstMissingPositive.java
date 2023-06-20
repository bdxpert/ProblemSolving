package com.problem.solve.v2.number;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> data = new HashSet<>();
        int max =0;
        for (int i=0;i<nums.length;i++) {
            data.add(nums[i]);
            if (max <nums[i]) {
                max = nums[i];
            }
        }
        int missing =1;
        boolean found =false;
        for (int i=1;i<max;i++){
            if(!data.contains(i)){
                found = true;
                missing = i;
                break;
            }
        }
        return found?missing:missing+max;
    }
}

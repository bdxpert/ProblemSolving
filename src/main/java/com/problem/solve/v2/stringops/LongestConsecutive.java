package com.problem.solve.v2.stringops;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String args[])
    {
        int[] nums = {100,4,200,1,3,2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums3 = {0,0};
        int[] nums4 = {0};
        int[] nums5 = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums5));
    }
    public static int longestConsecutive2(int[] nums) {
        if(nums.length == 0) return 0;
        int min = nums[0];
        Map<Integer, Integer> data = new HashMap<>();
//        data.put(0,min);
        for (int i=0; i<nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
            }
            if(data.containsKey(nums[i])) {
                int val = data.get(nums[i]);
                data.put(nums[i], val+1);
            } else {
                data.put(nums[i], 1);
            }
        }

        int counter = 0;
        int longestSeq = 0;
        for (int i=0; i<nums.length; i++) {
            int searchItem = min;
            if(data.containsKey(searchItem)) {
                counter=counter+1;//data.get(searchItem);
                searchItem = min+1;
            }else{
                longestSeq = counter;
                counter =0;
                searchItem = data.get(nums[i]);
            }

            min = searchItem;
            /*
            if(min == nums[i]) {
                counter ++;
            } else if( ((min+1)==nums[i])) {
                counter++;
                min = min+1;
            }

             */
        }
        return counter;//==1?0:counter;
    }
    //int[] nums5 = {9,1,4,7,3,-1,0,5,8,-1,6};
    public static  int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> dataSet = new HashSet<>();
        for(int num : nums) dataSet.add(num);
        int res = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(dataSet.remove(left)) left--;
            while(dataSet.remove(right)) right++;
            res = Math.max(res,right - left - 1);
            if(dataSet.isEmpty()) return res;//save time if there are items in nums, but no item in hashset.
        }
        return res;
    }
}

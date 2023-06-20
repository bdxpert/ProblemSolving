package com.problem.solve.v2.searching;

public class SortColors {
    // 0,1,2
    public static void main(String args[]) {
        int[] data = {0,1,2,0,1,2,2};
        sortColors(data);
        for(int i=0;i<data.length; i++) {
            System.out.println(data[i]+"-");
        }

    }
    public static int[] sortColors(int[] nums) {
        int high = nums.length-1; // high is for 2
        int low = 0; // is for 0
        int middle = 0;
        while(middle <= high) {
            if(nums[middle]== 0) {
                // swap
                swap(nums, low, middle);
                low++;
                middle++;
            } else if(nums[middle] == 2) {
                swap(nums, high, middle);
                high--;
            } else {
                middle++;
            }
        }
        return nums;
    }
    private static Boolean swap(int[] nums, int low, int high) {
        int temp =0;
        temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
        return Boolean.TRUE;
    }
}
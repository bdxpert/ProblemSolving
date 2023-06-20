package com.problem.solve.v2.array;

public class MinimumInRoatedArray {

    public static void main(String[] args)
    {
//        int[] inp = {3,4,5,1,2};
//        int[] inp = {4,5,6,7,0,1,2};
        int[] inp = {11,13,15,17};

        //System.out.println(findMin(inp));
        int[] inp2 = {3,2,1}; //{1,2,1,3,5,6,4};
        int[] inp3 = {1,2,3,4,5,4};
        int[] inp4 = {1};//{1,2,3,1};
        int[] inp5 = {3,4,3,2,1};
        int[] inp6 = {1,2,3,1};
        int[] inp7 = {5,4,3,4,5};
        int[] inp8 = {1,2,1,3,5,6,4};
        int[] inp9 = {3,4,3,2,1};

        System.out.println(findPeakElement(inp7));
    }
    public static int findMin(int[] nums) {
        int minimum = nums[nums.length-1];
        int mid;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            mid = (start+end)/2;
            if(nums[mid] < minimum ) {
                minimum = nums[mid];
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return minimum;
    }
    public static int findPeakElement(int[] nums) {
        int peak = nums[nums.length-1];
        int n = nums.length-1;
        int mid;
        int index = 0;
        int start = 0;
        int end = nums.length-1;
        if((n) ==0) {
            return 0;
        } if((n) == 1) {
            if(nums[0] > nums[1]){
                return 0;
            } else
                return 1;
        }
        while (start <= end) {
            mid = (start+end)/2;
            if(mid < n && mid > 0) {//&& nums[mid] > peak
//                if(nums[end] > nums[end-1]) {
//                    peak = nums[end];
//                    index = end;
//                } else
                    if (mid > 0 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                    peak = nums[mid];
                    index = mid;
                    return index;
                } else if(mid >0 && nums[mid] < nums[mid-1]) {
                    peak = nums[mid-1];
                    index = mid-1;
                    if((mid-1) ==0)
                        return index;
                    end = mid-1;
                } else if (mid < n && nums[mid] < nums[mid+1]) {
                    peak = nums[mid+1];
                    index = mid+1;
                    if((mid+1) ==(n))
                        return index;
                    start = mid + 1;
                }
            } else {
                if(index> 0 && nums[index-1] >nums[index]) {
                    return index-1;
                } else {
                    return index;
                }
                /*if(nums[mid] < peak) {
                    start = mid + 1;
                } else {
                    end = mid-1;
                }*/
            }
        }
        //System.out.println("Peak:"+peak);

        /*if(peak == nums[nums.length-1]) {
            return nums.length-1;
        }*/
        return index;
    }
}
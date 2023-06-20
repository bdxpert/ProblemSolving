package com.problem.solve.v2.searching;

public class RotatedSorted {
    public int search(int[] nums, int target) {
        int n= nums.length;
        int start= 0;
        int end= n-1;
        int mid= (start+end)/2;


        //array size is 1
        if(n == 1){
            if(nums[0] == target){
                return 0;
            }
            return -1;
        } else if(n == 2) { // array size is 2
            if(nums[0] == target){
                return 0;
            } else if(nums[1] == target){
                return 1;
            }
            return -1;
        }

        //array is not rotated
        if(nums[n-1] > nums[0]){
            return binarySearch(nums, 0, n-1, target);
        }

        int rotatePoint= -1;

        //  Finding point where rotation has taken place
        while(start<= end) {
            mid= (start+end)/2;

            if(nums[mid-1] > nums[mid]) {
                if(mid+1 >= n){
                    rotatePoint= mid;
                    break;
                }

                if( mid+1 < n && nums[mid] < nums[mid+1]){
                    rotatePoint= mid;
                    break;
                }
            }

            //  Case (If start+1 == end)
            //  case mid value won't update
            if(start+1 == end) {
                start= end;
                mid= (start+end)/2;
            }

            if(nums[start] > nums[mid]) {
                //  Discarding the right subarray
                end= mid;
            } else {
                //  Discarding the left subarray
                start= mid;
            }
        }
        // check the search value is larger than the last value then target contains in first half of data
        if(target > nums[n-1]){
            return binarySearch(nums, 0, rotatePoint, target);
        }
        else{
            // check the search value is less than the last value then target contains in second half of data
            return binarySearch(nums, rotatePoint, n-1, target);
        }
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        int mid= (start+end)/2;

        while(start<= end){
            mid= (start+end)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                end= mid-1;
            }
            else{
                start= mid+1;
            }
        }
        return -1;
    }

}

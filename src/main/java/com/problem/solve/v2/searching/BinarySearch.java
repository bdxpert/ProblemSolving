package com.problem.solve.v2.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String args[]) {
//        int[] inp = {-1,0,1,2,-1,-4};
//        int[] inp = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        //int[] inp = {0,0,0};
        int[] inp = {1};//{5,7,7,8,8,10}; //{-1, 0, 1, 2, -1, -4};
        int[] inp2 = {5,7,7,8,8,10};
        int[] res = searchRange(inp2, 8);
        System.out.println(Arrays.toString(res));

        //[[-4,1,3],[-4,0,4],[-2,1,1],[-2,-2,4],[-5,1,4]]
        //[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
        //[[-4,1,3],[-4,0,4],[-2,1,1],[-2,-2,4],[-5,1,4]]
        //[[-4, 1, 3], [-4, 0, 4], [-2, 1, 1], [-2, -2, 4], [-5, 1, 4]]
        //My result
        //{-1,0,1,2,-1,-4};
        //[[-1, 0, 1], [-1, -1, 2], [-4, 2, 2]]
        //[[-1,-1,2],[-1,0,1]]

    }
    public static int[] searchRange(int[] nums, int target) {
        List<Integer> res = new ArrayList<Integer>();
        int[] exRes = {-1,-1};
        int index = 0;

        int start = 0;
        int end = nums.length-1;
        if(nums.length == 0) return exRes;

        while (start <= end) {
            int middle =  (end+start)/2; //(end - start == 0)? 0:
            if(nums[middle] == target) {
                res.add(middle);
                int pointer = middle -1;

                while (pointer >=0 && nums[pointer] == target ) {
                    res.add(pointer);
                    pointer--;
                }

                pointer = middle + 1;

                while (pointer <=nums.length-1 && nums[pointer] == target) {
                    res.add(pointer);
                    pointer++;
                }

                if(res.size() == 1){
                    res.add(res.get(0));
                }
                Collections.sort(res);
                int[] arr = new int[2];

                // ArrayList to Array Conversion
                //for (int i = 0; i < res.size(); i++)
                arr[0] = res.get(0);
                arr[1] = res.get(res.size()-1);

                return arr;
            }
            if(nums[middle] > target) {
                end = middle-1;
            }
            if(nums[middle] < target) {
                start = middle+1;
            }
        }
        if(res.size() == 0) return exRes;
        if(res.size() == 1){
            res.add(res.get(0));
        }
        Collections.sort(res);
        int[] arr = new int[2];

        //for (int i = 0; i < res.size(); i++)
        arr[0] = res.get(0);
        arr[1] = res.get(res.size()-1);
            //arr[i] = res.get(i);


        return arr;
    }
}

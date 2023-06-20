package com.problem.solve.v2.array;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectArray {
    public static void main(String args[])
    {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] nums11 = {1,2,2,1};
        int [] nums21 = {2,2};
        int[] result = intersect( nums11,  nums21);

    }
    public static int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();


        int i;


        for(i = 0; i < nums1.length; i++)
        {

            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }


        for(i = 0; i < nums2.length; i++)
        {

            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        // create a new array of list size.
        int [] arr = new int[list.size()];


        // traverse the list and add elements in the array.
        for(i = 0; i < list.size(); i++)
        {
            arr[i] = list.get(i);
        }

        // finally, return the resultant array.
        return arr;
    }
    /*
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> data = new HashMap<>();
        int len = nums1.length > nums2.length?nums1.length:nums2.length;
        for (int i=0;i<nums1.length; i++) {

                if (!data.containsKey(nums1[i])) {
                    data.put(nums1[i], 1);
                }



        }
        for (int i=0;i<nums2.length; i++) {
//            if(i<nums2.length) {
                if(data.containsKey(nums2[i])) {

//                    list.add(nums2[i]);
                    data.put(nums2[i], data.get(nums2[i])+1);
                }
//            }
        }
        data.forEach((key, val)->{
            if(val>1){
                list.add(key);
            }
        });
        //int[] res = new int[data.size()];
        int j=0;

        int [] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }

        return res;
    }
    */
}

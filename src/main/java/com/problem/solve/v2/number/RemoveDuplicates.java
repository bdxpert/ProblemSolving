package com.problem.solve.v2.number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class RemoveDuplicates {
    public static void main(String args[]) {
        int[] arr = {2,2,4,5,6,7};
        removeDuplicatesv2(arr);
        System.out.println("Hello");

        HashSet<Character> s = new HashSet<>();
        Iterator<Character> data = s.iterator();
        char ch[] = {'w','l'};
        String a = new String(ch);
        while(data.hasNext()) {
             a = a + data.next();
            //s.add();
        }

    }
    public static int removeDuplicatesv2(int[] nums) {

        int newIndex = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i+1]) {
                nums[newIndex] = nums[i+1];
                newIndex++;
            }
        }
        for(int i=newIndex; i<nums.length;i++) {
            nums[i] = Integer.MIN_VALUE;
        }
        return newIndex;
    }
    public int singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:nums) {
            Boolean a = set.add(num);
            if(!a)
                set.remove(num);
        }


        Iterator<Integer> it = set.iterator();
        return it.next();
    }


    static String removeDupsSorted(String str)
    {
        int res_ind = 1, ip_ind = 1;

        // Character array for removal of duplicate characters
        char arr[] = str.toCharArray();

        /* In place removal of duplicate characters*/
        while (ip_ind != arr.length)
        {
            if(arr[ip_ind] != arr[ip_ind-1])
            {
                arr[res_ind] = arr[ip_ind];
                res_ind++;
            }
            ip_ind++;

        }

        str = new String(arr);
        return str.substring(0,res_ind);
    }

    /* Method removes duplicate characters from the string
       This function work in-place and fills null characters
       in the extra space left */
    static String removeDups(String str)
    {
        // Sort the character array
        char temp[] = str.toCharArray();
        Arrays.sort(temp);
        str = new String(temp);

        // Remove duplicates from sorted
        return removeDupsSorted(str);
    }

}

package com.problem.solve.v2.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String args[])
    {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());

        for(int num:nums) {
            int n = res.size();
            for(int i=0;i<n;i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}

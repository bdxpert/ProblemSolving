package com.problem.solve.v2.sum;

import java.util.*;

class ThreeSum {
    public static void main(String args[]) {
//        int[] inp = {-1,0,1,2,-1,-4};
//        int[] inp = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        //int[] inp = {0,0,0};
        int[] inp = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumV2(inp));

        //[[-4,1,3],[-4,0,4],[-2,1,1],[-2,-2,4],[-5,1,4]]
        //[[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
        //[[-4,1,3],[-4,0,4],[-2,1,1],[-2,-2,4],[-5,1,4]]
        //[[-4, 1, 3], [-4, 0, 4], [-2, 1, 1], [-2, -2, 4], [-5, 1, 4]]
        //My result
        //{-1,0,1,2,-1,-4};
        //[[-1, 0, 1], [-1, -1, 2], [-4, 2, 2]]
        //[[-1,-1,2],[-1,0,1]]

    }
    static Set<List<Integer>> threeSumV3(int[] arr)
    {
        int n = arr.length;
        int target = 9;
        Arrays.sort(arr);
        Set<List<Integer>> data = new HashSet<>();
        for(int i=0;i<n;i++) {
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int sum = arr[i]+arr[j]+arr[k];
                if(sum == target) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(arr[i]);
                    lst.add(arr[j]);
                    lst.add(arr[k]);
                    data.add(lst);
                    j++;
                } else if(sum > target) {
                    k--;
                } else if(sum< target) {
                    j++;
                }
            }
        }
        return data;

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != j && j != k && i != k) {
                        if ((nums[i] + nums[j] + nums[k]) == 0 && isDistinct(res, nums[i], nums[j], nums[k])) {
                            data = new ArrayList<>();
                            data.add(nums[i]);
                            data.add(nums[j]);
                            data.add(nums[k]);
                            //Collections.sort(data);
                            res.add(data);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static Boolean isDistinct(List<List<Integer>> res, int i, int j, int k) {
        if (i == 0 && j == 0 && k == 0) {
            if (res.parallelStream().filter(re -> re.get(0).equals(i) && re.get(1).equals(j) && re.get(2).equals(k)).count() > 0)
                return false;
        } else if (res.parallelStream().filter(re -> re.contains(i) && re.contains(j) && re.contains(k)).count() > 0)
            return false;
        return true;
    }

    public static List<List<Integer>> threeSumV2(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length < 3) return new ArrayList<>(res);
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int sum = -1;
            for (int k = nums.length - 1; j < k; ) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > 0) k--;
                  else if (sum < 0) j++;
            }
        }

        return new ArrayList<>(res);
    }//[[-1, -1, 2], [-1, 0, 1]]
}
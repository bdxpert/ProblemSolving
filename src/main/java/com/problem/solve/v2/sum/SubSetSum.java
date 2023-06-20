package com.problem.solve.v2.sum;

public class SubSetSum {
    //https://leetcode.com/problems/partition-equal-subset-sum/solutions/1624101/java-memoization-to-optimized-dp-detailed-explanation/
    static Boolean mem[][];
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i : nums) sum+=i;
        if(sum%2!=0) return false;
        sum /= 2;
        mem = new Boolean[n+1][sum+1];

        subsetSum(nums,0,sum);
        for (int i=0;i<n+1;i++) {
            System.out.println("");
             System.out.println("i:"+ i +"-");
             for (int j=0;j<sum+1;j++) {
                 System.out.print("{["+i+ "]"+mem[i][j]+"["+j+"]}-");
             }
        }
        return true;
    }

    static boolean  subsetSum(int[] nums, int pos, int sum) {
        if(sum==0)
            return true;
        else if(pos>=nums.length || sum<0)
            return false;

        if(mem[pos][sum]!=null)
            return mem[pos][sum];

        return mem[pos][sum] = subsetSum(nums,pos+1,sum-nums[pos]) ||
                               subsetSum(nums,pos+1,sum);
    }
    public static void main(String args[])
    {
        int[] arr = {1,5,11,5};//{1,2,3,5};
        canPartition(arr);
    }
}

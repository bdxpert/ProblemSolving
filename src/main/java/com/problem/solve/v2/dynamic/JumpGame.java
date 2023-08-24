package com.problem.solve.v2.dynamic;

import java.util.LinkedList;
import java.util.Queue;

/*
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String args[]) {
        int[] data = {2, 3, 1, 1, 4};
        //System.out.println(canJump(data));
        int[] data1 = {3, 2, 1, 0, 4};
        int[] data2 = {1};
        int[] data3 = {2, 0};
        int[] data4 = {1, 0, 2};
        int[] data5 = {1, 2, 3};
        int[] data6 = {1, 3, 2};
        System.out.println(helper(data, 0));
        System.out.println(canJump(data));
    }

    public static boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int maxReach = 0; // Maximum index we can reach

        for (int i = 0; i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= last) {
                return true; // We can reach the last index
            }
        }

        return false; // Cannot reach the last index
    }

    // recursion
    public static boolean helper(int[] nums, int currIndex) {
        int len = nums.length - 1;
        if (currIndex >= len) return true;
        boolean ans = false;
        for (int i = nums[currIndex]; i >= 1; i--) {
            System.out.println(i + "||" + currIndex);
            ans = helper(nums, currIndex + i);
            if (ans) break;
        }
        System.out.println("||" + currIndex);
        return ans;
    }

    // bfs solution
    public static boolean canJumpBFS(int[] nums) {

        Queue<Integer> q = new LinkedList();
        int n = nums.length;
        boolean[] added = new boolean[n];

        if (n == 1) return true;
        q.add(0);
        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < nums[temp]; i++) {
                if (temp + i + 1 == n - 1) return true;
                if (added[temp + i + 1]) continue;
                if (temp + i + 1 <= n - 1) {
                    q.add(temp + i + 1);
                    added[temp + i + 1] = true;
                }
            }
        }
        return false;
    }

    public static boolean canJumpV2(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) return true;
        return canJump2(nums, nums[nums.length - 1]);
        /*
        for(int i=0; i< nums.length; i++) {
            if(nums[i] < nums[nums.length-1]) {
                if(nums[i]==0) return false;
                int length = nums.length - nums[i] ==0? 1: nums.length - nums[i];
                if(length > nums.length) return false;
                int[] subNum = new int[length];
                int index =-1;
                for(int k =nums[i];k < (nums.length); k++) {
                    ++index;
                    subNum[index] = nums[k];
                }
                return canJump2(subNum, nums[length-1]);
            } else if(nums[i] == nums[nums.length-1]) {
                return true;
            }
//             else if(nums[i] > nums[nums.length-1]){
//                 return false;
//             }
        }
         */
        // return false;
    }

    public static boolean canJump2(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length - 1) {
                if (nums[i] == 0) return false;
                int length = nums.length - nums[i] == 0 ? 1 : nums.length - nums[i];
                if (length > nums.length) return false;
                int[] subNum = new int[length];
                int index = -1;
                for (int k = nums[i]; k < (nums.length); k++) {
                    ++index;
                    subNum[index] = nums[k];
                }
                return canJump2(subNum, target);
            } else if (nums[i] == target/*nums[nums.length-1]*/) {
                return true;
            } else if (nums[i] == 2 && nums[i] > nums[nums.length - 1] && nums[nums.length - 1] == target) {
                return true;
            } else if (nums[i] > nums[nums.length - 1]) {
                return false;
            }
        }
        return false;
    }
    /*
    Algorithm sortRBG (L)
    first := L.first()
    last := L.last()

    current := L.first()
    while current != last && L.after(last) != current do

    if current.element() = "red" then
    L.swapElements(first, current)
    first := L.after(first)
    current := L.after(current)

            if current.element() == "green" then
     L.swapElements(last, current)
    last := L.before(last)
            else
    current := L.after(current)
    */
    /*}*/
    /*
    public static boolean canJump(int[] nums) {
        if(nums.length==1 && nums[0] == 1) return true;
        for(int i=0; i< nums.length; i++) {
             if(nums[i] < nums[nums.length-1]) {
                 if(nums[i]==0) return false;
                 int length = nums.length - nums[i] ==0? 1: nums.length - nums[i];
                 if(length > nums.length) return false;
                 int[] subNum = new int[length];
                 int index =-1;
                 for(int k =nums[i];k < (nums.length); k++) {
                     ++index;
                     subNum[index] = nums[k];
                 }
                 return canJump(subNum);
             } else if(nums[i] == nums[nums.length-1]) {
                 return true;
             }
//             else if(nums[i] > nums[nums.length-1]){
//                 return false;
//             }
        }
        return false;
    }
}
*/
    /*
    public static boolean canJump(int[] nums) {
        if (nums[0] == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length - 1) {
                if (nums[i] == 0) return false;
                int length = nums.length - nums[i];
                if (length > nums.length) return false;
                int[] subNum = new int[length];
                int index = -1;
                for (int k = nums[i]; k < (nums.length); k++) {
                    ++index;
                    subNum[index] = nums[k];
                }
                return canJump(subNum);
            } else if (nums[i] == nums.length - 1) {
                return true;
            } else if (nums[i] > nums.length) {
                return false;
            }
        }
        return false;
    }
    */
    /*
    public static boolean canJump(int[] nums) {
        if(nums[0] == 1) return true;
        for(int i=0; i< nums.length; i++) {
             if(nums[i] < nums.length-1) {
                 if(nums[i]==0) return false;
                 int length =  nums.length - nums[i];
                 if(length > nums.length) return false;
                 int[] subNum = new int[length];
                 int index =-1;
                 for(int k =nums[i];k < (nums.length); k++) {
                     ++index;
                     subNum[index] = nums[k];
                 }
                 return canJump(subNum);
             } else if(nums[i] == nums.length-1) {
                 return true;
             } else if(nums[i] > nums.length){
                 return false;
             }
        }
        return false;
    }
     */

}
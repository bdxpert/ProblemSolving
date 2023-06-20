package com.problem.solve.v2.miscellaneous;

public class JumpGame {
    public static void main(String args[]) {
        int[] data = {2, 3, 1, 1, 4};
        //System.out.println(canJump(data));
        int[] data1 = {3, 2, 1, 0, 4};
        int[] data2 = {1};
        int[] data3 = {2, 0};
        int[] data4 = {1, 0, 2};
        int[] data5 = {1, 2, 3};
        int[] data6 = {1,3,2};

        System.out.println(canJump(data6));
    }
    public static boolean canJump(int[] nums) {
        if(nums.length==1 && nums[0] == 1) return true;
        return canJump2(nums, nums[nums.length-1]);
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
        if(nums.length==1 && nums[0] == 1) return true;
        for(int i=0; i< nums.length; i++) {
            if(nums[i] < nums.length-1) {
                if(nums[i]==0) return false;
                int length = nums.length - nums[i] ==0? 1: nums.length - nums[i];
                if(length > nums.length) return false;
                int[] subNum = new int[length];
                int index =-1;
                for(int k =nums[i];k < (nums.length); k++) {
                    ++index;
                    subNum[index] = nums[k];
                }
                return canJump2(subNum, target);
            } else if(nums[i] == target/*nums[nums.length-1]*/) {
                return true;
            } else if(nums[i] ==2 && nums[i] > nums[nums.length-1] && nums[nums.length-1] == target) {
                return true;
            } else if(nums[i] > nums[nums.length-1]) {
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
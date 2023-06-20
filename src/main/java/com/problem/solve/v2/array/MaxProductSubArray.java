package com.problem.solve.v2.array;

public class MaxProductSubArray {
    /*
        Approach 3: Two pointer Approach
        Explanation :
        1.) Through intution explanation we know that if all the elements are positive or
            the negative elements are even then ur answer will be product of
            complete array which u will get in variable l and r at the last iteration.
        2.) But if negative elements are odd then u have to remove one negative element and
            it is sure that it will be either right of max prefix product or left of max suffix product.
            So u need not to modify anything in your code as u are getting prefix product in l and
            suffix prduxt in r.
        3.) If array also contains 0 then your l and r will become 0 at that point...
            then just update it to 1(or else u will keep multiplying with 0)
            to get the product ahead making another subarray.

        We are also keeping min because on multiplying with any negative number
        your min will become max and max will become min.
    */
    public int maxProductV2(int[] nums) {

        int n = nums.length;
        int l=1,r=1;
        int ans=nums[0];

        for(int i=0;i<n;i++){

            //if any of l or r become 0 then update it to 1
            l = l==0 ? 1 : l;
            r = r==0 ? 1 : r;

            l *= nums[i];   //prefix product
            r *= nums[n-1-i];    //suffix product

            ans = Math.max(ans,Math.max(l,r));

        }

        return ans;
    }
    /*
    Approach 1: For each index i keep updating the max and min.
    We are also keeping min because on multiplying with any negative number
    your min will become max and max will become min.
    So for every index i we will take max of (i-th element, prevMax * i-th element, prevMin * i-th element).
     */
    //    Maximum Product Subarray
    public int maxProduct(int[] nums) {

        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int temp = max;  // store the max because before updating min your max will already be updated

            max = Math.max(
                    Math.max(max * nums[i], min * nums[i]),
                    nums[i]
                    );
            min = Math.min(
                    Math.min(temp * nums[i], min * nums[i]),
                    nums[i]
                    );

            if (max > ans) {
                ans = max;
            }
        }

        return ans;
    }

}

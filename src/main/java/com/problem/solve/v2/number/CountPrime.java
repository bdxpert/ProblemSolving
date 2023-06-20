package com.problem.solve.v2.number;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountPrime {
    public static void main(String args[])
    {
//        [1,2,3,4,5,6,7], k = 3
        int[] arr = {1,2,3,4,5,6,7};
        //[1,2] 3
        int[] arr2 = {1,2};
        int[] arr3 = {1,2, 3};

        //rotate(arr3,4);
        rotateV2(arr, 3);
        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        boolean arr[]=new boolean[n];
        long c=0;
        for(long i=2;i<n;i++)
        {
            if(arr[(int)i])
                continue;
            c++;
            for(long j=i*i;j<n;j+=i)
                arr[(int)j]=true;
        }
        return (int)c;
    }
    public static int countPrimesv2(int n)
    {
        int countPri = 0;
        for(int i=1; i<n;i++){
            //if(n>2 && i==2) countPri++;
            //else
            if(i%2 !=0){
                Boolean isPrime =true;
                //int limit = i>4?i/2+1:i;
                for(int j=i+1;j<Math.sqrt(i);j+=2){
                    if(i%j ==0) {
                        isPrime=false;
                    }
                }
                if(isPrime) {
                    //System.out.println(i);
                    countPri++;}
            }
        }
        if(n==2) return 0;
        return (n==0 || n==1 )? 0 : countPri;
    }
    public static void rotate(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        k %= nums.length;

        for (int i=0; i<nums.length; i++) {//nums.length-k
            deq.add(nums[i]);
        }

        for (int i =0 ; i <Math.abs(nums.length -k); i++) {
            int item = deq.remove();
            deq.addLast(item);
        }
        for(int i=0;i<nums.length; i++){
            nums[i] = deq.pop();
        }
        //nums = deq.toArray();
    }

    public static void rotateV2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

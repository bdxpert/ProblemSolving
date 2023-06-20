package com.problem.solve.v2.searching;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(int i:nums) {
            queue.offer(i);
            if(queue.size()>k)
                queue.poll();
        }

        return queue.peek();
    }
}

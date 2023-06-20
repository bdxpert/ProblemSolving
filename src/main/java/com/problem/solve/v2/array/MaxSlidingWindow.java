package com.problem.solve.v2.array;

import java.util.*;

public class MaxSlidingWindow {

    public static void main(String args[])
    {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindowV5(arr, 3);
        System.out.println(maxSlidingWindowV5(arr, 3));
    }
    public static int[] maxSlidingWindowV5(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    /*
    Normal approach O(n*k)
    time limit exits
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numOfWindow = nums.length - k + 1;
        int[] result = new int[numOfWindow];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            result[i] = (max);
        }
        return result;
    }
    public int[] maxSlidingWindowv2(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-k+1;i++) {
            max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                if(max<nums[j]) {
                    max = nums[j];
                }
            }
            list.add(max);
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    // Priority Queue Approach -> T.C. -> O(NlogK) -> TLE
    public int[] maxSlidingWindowV4(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        int numOfWindow = nums.length - k + 1;
        int[] ans = new int[numOfWindow];
        for (int i = 0; i < k; i++)
            pq.add(nums[i]);

        ans[0] = pq.peek();
        pq.remove(nums[0]);
        int ansIndex = 1;
        for (int i = k; i < n; i++) {
            pq.add(nums[i]);
            ans[ansIndex] = pq.peek();
            ansIndex++;
            pq.remove(nums[i - k + 1]);
        }
        return ans;
    }
    // Priority Queue Approach -> T.C. -> O(NlogK) -> TLE
    public int[] maxSlidingWindowv3(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        ans.add(pq.peek());
        pq.remove(arr[0]);

        for (int i = k; i < n; i++) {
            pq.add(arr[i]);
            ans.add(pq.peek());
            pq.remove(arr[i - k + 1]);
        }

        int a[] = new int[ans.size()];
        for (int j = 0; j < ans.size(); j++)
            a[j] = ans.get(j);

        return a;
    }
}

package com.problem.solve.v2.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    class Pair implements Comparable<Pair>{
        int num, count;
        public Pair(int num, int count)
        {
            this.num = num;
            this.count = count;
        }
        public int compareTo(Pair p2)
        {
            return p2.count-this.count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue();
        for(Map.Entry<Integer, Integer> val: map.entrySet()) {
            pq.add(new Pair(val.getKey(), val.getValue()));
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++) {
            ans[i] = pq.remove().num;
        }
        return ans;
    }
}

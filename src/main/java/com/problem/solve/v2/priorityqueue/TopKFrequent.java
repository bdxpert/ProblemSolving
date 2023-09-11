package com.problem.solve.v2.priorityqueue;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {

    public static void main(String args[]) {
        /*
        Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
         */
        int[] arr = {1, 1, 1, 2, 2, 3};

        topKFrequentV2(arr, 2);

    }

    class Pair implements Comparable<Pair> {
        int num, count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int compareTo(Pair p2) {
            return p2.count - this.count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue();
        for (Map.Entry<Integer, Integer> val : map.entrySet()) {
            pq.add(new Pair(val.getKey(), val.getValue()));
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove().num;
        }
        return ans;
    }

    public static int[] topKFrequentV2(int[] nums, int k) {
        /*Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

return map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).map(ent -> ent.getKey()).limit(k).mapToInt(i->i).toArray();
 */

        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(i->i, Collectors.counting() ))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(ent -> ent.getKey()).limit(k).mapToInt(i->i).toArray();
    }
}



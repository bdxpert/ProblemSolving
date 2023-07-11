package com.problem.solve.v2.dynamic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquare {
    public static void main(String args[])
    {
        System.out.println(numSquares(12));
    }
    //https://leetcode.com/problems/perfect-squares/solutions/317378/java-3-solutions-bfs-dp-maths-with-explanation/
    //https://leetcode.com/problems/perfect-squares/solutions/2837992/java-recursion-memoization-dp-3-square-theorem-explained/
    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> reviewedSet = new HashSet<>();

        if(n >0) queue.offer(n);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int val = queue.poll();
                if(!reviewedSet.add(val)) continue;

                for(int j=1; j<=Math.sqrt(val); j++) {
                    if(val-(j*j) == 0) return level;
                    queue.offer(val-(j*j));
                }
            }
        }

        return level;
    }

    // v2 dp///
    public int numSquaresDP(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    public int helper(int n, int[] memo) {
        if (n < 4)
            return n;

        if (memo[n] != 0)
            return memo[n];

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }

        return memo[n] = ans;
    }
}

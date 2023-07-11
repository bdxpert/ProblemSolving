package com.problem.solve.v2.sum;

//https://leetcode.com/problems/minimum-path-sum/solutions/2677369/recursion-to-space-optimized-in-java/?orderBy=most_votes
public class MinPathSum {
    public static void main(String args[])
    {
        int[][] data = { {1,3,1},
                         {1,5,1},
                         {4,2,1}
                       };
        int[][] data2 ={{1,2,3},
                        {4,5,6}
                       };
        System.out.println(minPathSum(data2));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
    //=====V2====
    static int[][] memo;
    public int minPathSumv2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        return find(grid, m-1, n-1, memo);
    }

    private int find(int[][] grid, int m, int n, int[][] memo){
        if(m==0 && n==0)
            return grid[0][0];
        else if(m<0 || n<0)
            return Integer.MAX_VALUE;
        else if(memo[m][n]!=0)
            return memo[m][n];
        return memo[m][n] = grid[m][n] + Math.min(find(grid, m-1, n, memo), find(grid, m, n-1, memo));
    }
}

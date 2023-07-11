package com.problem.solve.v2.dynamic.twodarray;

//https://www.geeksforgeeks.org/maximum-sum-path-in-a-matrix-from-top-left-to-bottom-right/
public class MinPathSum {
    int[][] input = {{1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}};

    int[][] direction = {
            {
                    0, 1
            }, {
            1, 0
    }
    };

    public static void main(String args[]) {
        MinPathSum t1 = new MinPathSum();
        int result = minPathSumV2(t1.input);
        System.out.println(result);
    }

    static int minimizePath(int[][] nums) {
        int[][] dp = new int[nums.length][nums[0].length];
        dp[0][0] = nums[0][0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i][0];
        }

        for (int j = 1; j < nums[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + nums[0][j];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[i].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + nums[i][j];
            }
        }

        return dp[nums.length - 1][nums[0].length - 1];
    }

    static int minPathSumV2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    //* recursion *//
    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        return min(grid, m - 1, n - 1);

    }

    public static int min(int[][] grid, int m, int n) {

        // this is the exit of the recursion
        if (m == 0 && n == 0) return grid[m][n];
        /* when we reach the first row, we could only move horizontally.*/
        if (m == 0) return grid[m][n] + min(grid, m, n - 1);
        /* when we reach the first column, we could only move vertically.*/
        if (n == 0) return grid[m][n] + min(grid, m - 1, n);
        /* we want the min sum path so we pick the cell with the less value */
        return grid[m][n] + Math.min(min(grid, m - 1, n), min(grid, m, n - 1));
    }
}

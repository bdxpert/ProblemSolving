package com.problem.solve.v2.dynamic;

import java.util.Arrays;

public class UniquePathsWithObstacles {


    /////////////v2///////////////
    public int uniquePathsWithObstaclesV2(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) Arrays.fill(dp[i], -1);
        return helper(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length, dp);
    }

    private int helper(int[][] obstacleGrid, int r, int c, int m, int n, int[][] dp) {
        if (r == m - 1 && c == n - 1) return 1;
        if (r >= m || c >= n || obstacleGrid[r][c] == 1) return 0;
        if (dp[r][c] != -1) return dp[r][c];

        int count = 0;
        count += helper(obstacleGrid, r + 1, c, m, n, dp);
        count += helper(obstacleGrid, r, c + 1, m, n, dp);
        return dp[r][c] = count;
    }

    ///////v3 goo solution beats 100% ///////////
    public int fun(int i, int j, int[][] g, int[][] dp) {

        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        // if any obstacle found set dp value 0
        if (g[i][j] == 1) return dp[i][j] = 0;

        if (i == 0 && j == 0) return dp[i][j] = 1;
        // go top to right and left direction
        return dp[i][j] = fun(i - 1, j, g, dp) + fun(i, j - 1, g, dp);
    }

    public int uniquePathsWithObstaclesV3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        // if any obstacle at begining or at end terminate
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int a = fun(m - 1, n - 1, obstacleGrid, dp);
        return dp[m - 1][n - 1];
    }

    // tabulation methods
    public int uniquePathsWithObstaclesV4(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for(int i=0;i<m;i++){
            //if we found obstacle then make flag true which means now path cannot be considered
            if(obstacleGrid[i][0]==1)
                flag = true;
            // if we found 0 on path and we have not found any obstacle yet then we can mark that step as 1
            if(obstacleGrid[i][0]==0 && !flag)
                dp[i][0] = 1;
                // here condition is obstacle is found so path cannot be considered so marked as 0
            else
                dp[i][0] = 0;
        }
        flag = false;
        for(int j=0;j<n;j++){
            //if we found obstacle then make flag true which means now path cannot be considered
            if(obstacleGrid[0][j]==1)
                flag = true;
            // if we found 0 on path and we have not found any obstacle yet then we can mark that step as 1
            if(obstacleGrid[0][j]==0 && !flag)
                dp[0][j] = 1;
            else
                // here condition is obstacle is found so path cannot be considered so marked as 0
                dp[0][j] = 0;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                // if no obstacle then we can consider the step
                if(obstacleGrid[i][j]==0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

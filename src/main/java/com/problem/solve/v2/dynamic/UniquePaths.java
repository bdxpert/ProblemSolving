package com.problem.solve.v2.dynamic;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for(int i=0;i<m;i++){
            paths[i][0] = 1;
        }

        for(int j=0;j<n;j++){
            paths[0][j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        return paths[m-1][n-1];
    }
    //v2////
    public int uniquePathsV2(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int count = 0;
                if(i == 0 && j == 0) continue;

                if(j-1 >= 0) count += dp[i][j-1];
                if(i-1 >= 0) count += dp[i-1][j];
                dp[i][j] = count;
            }
        }
        return dp[m-1][n-1];
    }

    ////v3///
    public int uniquePathsV3(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return helper(m, n, dp);
    }

    private int helper(int m, int n, int[][] dp) {
        if(m == 1 && n == 1) return 1;
        if(m < 1 || n < 1) return 0;
        if(dp[m][n] != -1) return dp[m][n];

        int count = 0;
        count += helper(m-1, n, dp);
        count += helper(m, n-1, dp);

        return dp[m][n] = count;
    }
}

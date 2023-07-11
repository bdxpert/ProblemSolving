package com.problem.solve.v2.dynamic;

public class CoinChange2 {
    public static void main(String args[]){
        int[] coins = {2,3};
        System.out.println(change(5, coins));
    }
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case
        for (int i = 0; i < n; i++)
            for (int j = 1; j <= amount; j++)
                if (j - coins[i] >= 0)
                    dp[j] = dp[j] + dp[j-coins[i]];

        return dp[amount];
    }
}

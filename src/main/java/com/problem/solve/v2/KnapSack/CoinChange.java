package com.problem.solve.v2.KnapSack;

import java.util.Arrays;

public class CoinChange {
    public static void main(String args[])
    {
        int[] coin = {1, 2, 5};
        System.out.println(coinChangeForward(coin, 7));
    }
    public static int coinChangeLookBackward(int[] coins, int amount) {
        if(amount==0) {
            return 0;
        }

        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1; i<=amount; i++) {
            for(int coin: coins) {
                if(i==coin){
                    dp[i]=1;
                }else if(i>coin){
                    if(dp[i-coin]==Integer.MAX_VALUE){
                        continue;
                    }
                    dp[i]=Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];
    }
    static public int coinChangeForward(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0; i<=amount; i++){
            if(dp[i]==Integer.MAX_VALUE){
                continue;
            }

            for(int coin: coins){
                if(i<=amount-coin){ //handle case when coin is Integer.MAX_VALUE
                    dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }

        return dp[amount];
    }
}

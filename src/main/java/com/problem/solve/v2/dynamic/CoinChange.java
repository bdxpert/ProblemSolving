package com.problem.solve.v2.dynamic;

import java.util.Arrays;

public class CoinChange {
    public static void main(String args[]) {
        int[] coin ={1,2,5}; //amount 11
        int[] coin2 = {186,419,83,408};
//        System.out.println(coinChange(coin2, 6249));
//        System.out.println(coinChangev2(coin, 6));
        System.out.println(coinChangev3(coin, 6));
    }


    public static int coinChangev2(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private static int helper(int[] coins, int remminder, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if(remminder<0) return -1; // not valid
        if(remminder==0) return 0; // completed
        if(count[remminder-1] != 0) return count[remminder-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, remminder-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[remminder-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[remminder-1];
    }
    // reference https://www.youtube.com/watch?v=NNcN5X1wsaw
    public static int coinChangev3(int[] coins, int amount) {
        if(amount <1) return -1;
        int[] dp = new int[amount+1];
        for(int i=1;i<=amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int coin:coins) {
                if(coin <=i && dp[i-coin] !=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;

        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {
       // int max = -1;
//        Set<Integer> coin = new HashSet<>();
        Arrays.sort(coins);
        /*
        for (int i=0;i<coins.length;i++) {
            if(max < coins[i]) {
                max = coins[i];
            }
            if(!coin.contains(coins[i])) {
                coin.add(coins[i]);
            }
        }
        */
        int totalCount = 0;
        int remaining = -1;
        if(amount == 0) {
            return 0;
        }
        for (int i=coins.length-1; i>=0; i--) {
            if(coins[i] <= amount) {
                int count = amount / coins[i];

                remaining = amount % coins[i];
                totalCount +=count;
                if(remaining == 0) {
                    return totalCount;
                } else {
                    amount = remaining;
                }
            }
        }
        return -1;
    }
    /*
     * solution using recursion
     */
    public int coinChangeRecursion(int[] coins, int amount) {
        int res = recursion(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public int recursion(int[] coins, int n, int number) {
        if(n == 0)
            return number;
        if(n<0)
            return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++)
            res = Math.min(res, recursion(coins, n-coins[i], number+1));

        return res;
    }
}

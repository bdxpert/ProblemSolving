package com.problem.solve.v2.array;

public class MaxProfit {
    public static int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String args[]) {
        int[] a = {2,4,1};
        System.out.println(maxProfit1(a));
    }
}

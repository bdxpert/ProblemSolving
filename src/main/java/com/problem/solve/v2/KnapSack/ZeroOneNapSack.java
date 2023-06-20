package com.problem.solve.v2.KnapSack;
public class ZeroOneNapSack {
    // maximum of two integers
    static int max(int a, int b) {
        if(a>b) return a;
        else return b;
    }

    static int knapSack(int W,int N,int v[],int w[],int [][]dp) {
        /* Base case 0 items left or knapsack is full */
        if(N == 0 || W == 0)
            return 0;

        if(dp[N][W] == -1)
            return dp[N][W];

    /* if weight of current element is less than or equal to capacity we can
    either include or exclude the item. */
        if(w[N] <= W){
            return dp[N][W] = max(v[N]+knapSack(W-w[N],N-1,v,w, dp),knapSack(W,N-1,v,w, dp));
        }
    /* if weight of current element is greater than the capacity we will
    not include it thus returning just the ignoring part. */
        return dp[N][W] = knapSack(W,N-1,v,w, dp);
    }

    static int knapsack01(int W,int N,int v[],int w[]){

        // Defining Dp and initializing with -1.
        int DP[][] = new int [N+1][W+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=W;j++){
                DP[i][j] = -1;
            }
        }
        return knapSack(W,N,v,w,DP);
    }
}

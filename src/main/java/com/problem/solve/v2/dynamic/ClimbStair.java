package com.problem.solve.v2.dynamic;

public class ClimbStair {
    //fibonace series
    public int climbStairsV3(int n) {
        if (n == 1) {
            return n;
        }

        int n1 = 1;
        int n2 = 2;

        for (int i = 3; i <= n; i++) {
            int next = n1;
            n1 = n2;
            n2 = next + n2;
        }

        return n2;
    }
    public int climbStairs(int n, int[] output) {
        if (n <= 1) {
            return 1;
        }

        if (output[n] != 0) {
            return output[n];
        }
        output[n] = climbStairs(n - 1, output) + climbStairs(n - 2, output);
        return output[n];
    }

    public int climbStairs(int n) {
        int output[] = new int[n + 1];
        return climbStairs(n, output);
    }

    //    Second approach
    public int climbStairsV2(int n) {
        if (n == 1) return 1;

        if (n == 2) return 2;

        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }
}

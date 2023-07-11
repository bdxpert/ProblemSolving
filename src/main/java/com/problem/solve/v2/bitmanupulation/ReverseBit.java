package com.problem.solve.v2.bitmanupulation;

//https://leetcode.com/problems/reverse-bits/solutions/2680791/handwritten-solution/
public class ReverseBit {
    int reverseBit(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;
            int tmp = lsb << (31 - i);

            ans = ans | tmp;
            n = n >> 1;
        }
        return ans;
    }
}

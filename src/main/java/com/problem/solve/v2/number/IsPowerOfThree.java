package com.problem.solve.v2.number;

public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n==1) return true;
        if(n>0 && n%3 ==0) {
            int res =1;
            while( res <n){
                res = res*3;
            }
            System.out.println(res);
            if(res == n) return true;
        }
        return false;
    }
}

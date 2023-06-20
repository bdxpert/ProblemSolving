package com.problem.solve.v2.number;

public class Fibonacci {
    static  int counter=0;
    static int fibo(int n) {
        counter++;
        if(n==0) {
            return 0;
        } else if (n ==1) {
            return 1;
        }
        else
            return (fibo(n-1) + fibo(n-2));
    }
    public static void main(String args[])
    {
        int n= 9;
        System.out.println("For "+ n +" sum of fibonacci series:"+fibo(n));
        System.out.println("Counter:" + counter);
    }

}

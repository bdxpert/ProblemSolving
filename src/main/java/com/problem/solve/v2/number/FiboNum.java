package com.problem.solve.v2.number;

public class FiboNum {
    static  int counter=0;
    static int fibo(int n) {
        int f1=0;
        int f2=1;
        int sum = 0;
        counter =1;
        for (int i=0; i<n; i++) {
            counter++;
            System.out.println("Fibo:"+f1);
            sum = f1+f2;
            f1 = f2;
            f2 = sum;
        }

        return sum;
    }
    public static void main(String args[])
    {
        int n= 9;
        System.out.println("For "+ n +" sum of fibonacci series:"+fibo(n));

        System.out.println("Counter:" + counter);
    }
}

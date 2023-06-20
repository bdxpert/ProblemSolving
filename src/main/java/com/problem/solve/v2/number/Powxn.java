package com.problem.solve.v2.number;

public class Powxn {
    public static void main(String[] args)
    {
        System.out.println(myPow(2, 3));
    }

    public static double myPow(double x, int n) {
        if(n < 0){
            n =(-n);
            x = 1/x;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }

            x *= x;
            n >>>= 1;

        }

        return pow;
    }

    /*
    public static double myPow(double x, int n) {
        if(-100 < x && x < 100) {
            if(n==0)
                return 1.0;
            if(n==-1) {

            }

            if(n < 0) {
                x = 1/x;
                return (1 / x) * myPow(x, n + 1);
            }
            else if(n > 0)
                return x* myPow(x, n-1);
        }
        return -1;
    }

     */

}
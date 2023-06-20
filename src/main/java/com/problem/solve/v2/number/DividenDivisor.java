package com.problem.solve.v2.number;

public class DividenDivisor {
    public static void main(String args[]) {
        System.out.println(dividev2(10, 3));
    }
    public int divide(int dividend, int divisor) {
        // System.out.println(-2147483648<<3);
        // System.out.println(Integer.toBinaryString(-1<<0));
        int quotient = 0;
        int sign = 1;
        int max = Integer.MAX_VALUE,  min = Integer.MIN_VALUE;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            sign = -1;
        if(dividend > 0)
            dividend = -dividend;
        if(divisor > 0)
            divisor = -divisor;
        while(dividend <= divisor){
            int shift = 1;
            while((divisor<<shift) < divisor && dividend <= (divisor<<shift))shift++;
            quotient -= 1<<(shift-1);
            // System.out.println(quotient+"-"+shift);
            dividend -= divisor<<(shift-1);
        }
        if(sign == 1){
            if(quotient == min)
                return max;
            return -quotient;
        }else{
            return quotient;
        }
    }
    /*
     * dividend = 10 divisor = 3
     */
    public static int dividev2(int dividend, int divisor) {
        int sign,result=0,value=31;

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            sign = 1;
        else
            sign = -1;

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        while (ldividend >= ldivisor) {
            while (ldividend < ldivisor << value) {
                value--;
            }
            ldividend -= ldivisor << value;
            result += 1 << value;
        }
        if (result > Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            result=Integer.MAX_VALUE;

        result = sign > 0 ? result : -result;

        return result;
    }
}

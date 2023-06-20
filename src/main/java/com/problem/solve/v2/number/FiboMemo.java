package com.problem.solve.v2.number;

import java.util.HashMap;
import java.util.Map;

public class FiboMemo {
    static  int counter=0;
    static Map<Integer, Integer> series = new HashMap<>();
    static int fibo(int n) {
        int result = 0;
        if(series.containsKey(n)) {
            result = series.get(n);
        } else if(n==0) {
            result = 0;
        } else if (n ==1) {
            result = 1;
        } else
            result = (fibo(n-1) + fibo(n-2));
        series.put(n, result);
        counter++;
        return result;
    }
    public static void main(String args[])
    {
        int n= 30;
        fibo(n);
        int sum = 0;
        for (Map.Entry<Integer,Integer> entry : series.entrySet()){
            System.out.println("Fibonacci Number = " + entry.getValue());
            sum += entry.getValue();
        }
        System.out.println("For "+ n +" sum of fibonacci series:"+sum);

        System.out.println("Counter:" + counter);
    }
}

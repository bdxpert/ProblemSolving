package com.problem.solve.v2.number;

import java.util.ArrayList;
import java.util.List;

//Amazon assessment
/*
Array of Integer
Multiply consecutive numbers and if it is divisible by 3 then put this new number until there is no divisible number by 3 available.
Return number of iteration.
Input 34, 56, 20, 90, 100
Output: Iteration 3

 */
public class ConsecutiveNumberGame {

    public static void main(String[] args)
    {
        List<Integer> arr = new ArrayList<>();
        arr.add(34);
        arr.add(56);
        arr.add(20);
        arr.add(90);
        arr.add(100);
        // output = 3
        System.out.println(numberOfIteration(arr));
    }

    static int numberOfIteration(List<Integer> arr) {
        Boolean hasIteration = true;
        int round = 0;
        do {
            hasIteration = false;
            List<Integer> interRes = new ArrayList<>();
            for(int i=0; i < arr.size()-1; i++) {
                int a = arr.get(i);
                int b = arr.get(i+1);
                int product = a*b;
                if((product) % 3 ==0) {
                    interRes.add(product);
                    hasIteration = true;
                } else {
                    interRes.add(arr.get(i));
                }
            }
            if(arr.size()%2 ==1) {
                interRes.add(arr.get(arr.size()-1));
            }
            arr = interRes;
            round++;

        } while (hasIteration);

        return round-1;
    }
}

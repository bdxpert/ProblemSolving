package com.problem.solve.v2.number;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public boolean isHappy(int n) {
        //if(n>1 && n<10){
        //  return false;
        //} else {
        int sum = 0;
        while(n !=1){
            String val = ""+n;
            //char[] valChr = val.toCharArray();
            sum =0;
            while(n > 0){
                int rem = n %10;
                sum = sum + rem * rem;
                n = n/10;
            }

            n = sum;
        }
        //}
        if(n==1) return true;
        return false;
    }
    public boolean isHappyWrong(int n) {
        if(n<10){
            return false;
        } else {
            int sum = 0;
            while(n !=1){
               String val = ""+n;
               char[] valChr = val.toCharArray();
               for (int i=0;i<valChr.length;i++){
                   double dval = Math.sqrt(Integer.parseInt(""+valChr[i]));
                   sum = sum + Integer.parseInt(""+dval);
               }
               n = sum;
            }
        }
        if(n==1) return true;
        return false;
    }

    public boolean isHappyV2(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            n=getNext(n);
        }
        return n==1;
    }
    public int getNext(int n){
        int sum=0;
        while(n>0){
            int d = n%10;
            sum+=d*d;
            n=n/10;
        }
        return sum;
    }
}

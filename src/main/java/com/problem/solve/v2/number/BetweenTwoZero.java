package com.problem.solve.v2.number;

public class BetweenTwoZero {
    public static void main(String args[]){
        String str = "10101";
        System.out.println(betweenTwoZero(str));
    }
    public static String betweenTwoZero(String str)
    {
        // second approach

        int n = str.length();
        for(int i=1; i< n-1; i++){
            if(str.charAt(i-1) == '0' && str.charAt(i+1) == '0' && str.charAt(i) == '1'){
                str = str.substring(0,i) + str.substring(i+1);
                i--;
                if(i>0 && str.charAt(i-1) == '0')
                    i--;
                n = str.length();
            }
        }
        return str;
    }
}

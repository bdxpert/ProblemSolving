package com.problem.solve.v2.number;

public class ReverseInteger {
    public static void main(String args[]) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        String str = "" +x;
        char[] arr = str.toCharArray();
        String newStr = new String();
        if(arr[0] == '-') {
            newStr = "-";
            for (int i=arr.length-1;i>0;i--){
                newStr +=arr[i];
            }
        } else {
            for (int i=arr.length-1;i>=0;i--){
                newStr +=arr[i];
            }
        }
        try{
           return Integer.parseInt(newStr);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

}

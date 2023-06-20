package com.problem.solve.v2.stringops;

public class FishBowl {
    public static void main(String args[]){
        int[] arr = {3,2,1,6};
        System.out.println(rotateArr(arr));
    }
    public static String rotateArr(int[] arr)
    {
        String res = "";
        for(int i= arr[0]; i< arr.length; i++) {
            res += ""+arr[i];
        }
        for(int i=0;i<arr[0]; i++) {
            res +=""+arr[i];
        }
        System.out.println(res);
        String makeup ="7zedios";
        String finalOut = "";
        int i;
        for(i=0;i<res.length();i++) {
            finalOut +=""+res.charAt(i) + makeup.charAt(i);
        }
        finalOut = res.length()<makeup.length()?finalOut+makeup.substring(i): finalOut;
        return finalOut;
    }

}

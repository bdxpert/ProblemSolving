package com.problem.solve.v2.number;

public class SecondHighest {
    public static int secondHighest(String s) {
        int firL = Integer.MIN_VALUE;
        int secL = Integer.MIN_VALUE;
        String[] arr = s.split("");
        for(int i=0;i<arr.length;i++) {
            if(arr[i].equals("0") || arr[i].equals("1")||arr[i].equals("2")||arr[i].equals( "3")||arr[i].equals("4")||arr[i].equals( "5")||arr[i].equals( "6")||arr[i].equals("7")||arr[i].equals("8")||arr[i].equals( "9")) {
                int data = Integer.parseInt(arr[i]);
                System.out.println(data);
                if(data>firL) {
                    if( secL == Integer.MIN_VALUE) {
                        secL = data;
                    } else {
                        secL = firL;
                    }

                    firL = data;
                } else if(data==firL ) {

                }
                else if(secL < data || secL == firL) {
                    secL = data;
                }
            }
        }
        if(firL == secL) return -1 ;
        else return secL;
    }
    public static void main(String args[]) {
        int[] a = {2,4,1,3};
        //"abc1111"
        //"sjhtz8344"
        //"dfa12321afd"
        //unqclirrea85188733589
        System.out.println(secondHighest("sjhtz8344"));
    }
}

package com.problem.solve.v2.number;

import java.util.TreeMap;

public class IntToRoman {

    public static void main(String args[]) {


        System.out.println(intToRoman(58));
    }
    public static String intToRoman(int num) {
        String intRoman = "";
        //Map<Integer, String> roman = new HashMap<>();
        TreeMap<Integer, String> roman = new TreeMap<Integer, String>();
/*
TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    map.put(1, "abc1");
    map.put(2, "abc2");
    map.put(3, "abc3");
    NavigableMap<Integer, String> nmap = map.descendingMap();
    for (NavigableMap.Entry<Integer, String> entry : nmap.entrySet()) {
        System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
    }
 */


        roman.put(400,"CD");
        roman.put(100,"C");
        roman.put(90,"XC");
        roman.put(50,"L");
        roman.put(40,"XL");
        roman.put(10,"X");
        roman.put(9,"IX");
        roman.put(5,"V");
        roman.put(4,"IV");
        roman.put(3,"III");
        roman.put(2,"II");
        roman.put(1,"I");
        roman.put(500,"D");
        roman.put(900,"CM");
        roman.put(1000,"M");

//        for (NavigableMap.Entry<Integer, String> entry : roman.entrySet()) {
        for(Integer key : roman.descendingKeySet()) {
            System.out.println("Key : " + key + " Value : " + roman.get(key));
            //System.out.println("key: " + entry.getKey());
            if(num == 0) break;
            int div = num / key;
            if (div >= 1) {
                for (int i = 0; i < div; i++) {
                    intRoman += roman.get(key);
                }
            }
            num = num % key;
        }
        /*for (Integer val : roman.keySet()) {
            System.out.println("key: " + val);
            if(num == 0) break;
            int div = num / val;
            if (div >= 1) {
                for (int i = 0; i < div; i++) {
                    intRoman += roman.get(val);
                }
            }
            num = num % val;
        }*/
        return intRoman;











/*

        int  div = num/1000;
        if(div >=1) {
            for(int i=0;i<div;i++) {
                intRoman +="M";
            }
        }
        num = num%1000;
        div = num/900;
        if(div >=1) {
            for(int i=0;i<div;i++) {
                intRoman +="CM";
            }
        }
        num = num%900;
        div = num/500;
        if(div >=1) {
            for(int i=0;i<div;i++) {
                intRoman +="D";
            }
        }
        num = num%500;
        div = num/400;
        if(div >=1) {
            for(int i=0;i<div;i++) {
                intRoman +="CD";
            }
        }
        num = num%400;
        div = num/100;
        if(div >=1) {
            for(int i=0;i<div;i++) {
                intRoman +="CD";
            }
        }
        num = num%100;
        div = num/100;
        if(div >=1) {
            for(int i=0;i<div;i++) {
                intRoman +="CD";
            }
        }


        }
        for (Integer val : roman.keySet())
            System.out.println("key: " + val);
        if(val< num)

        num

*/


    }
}

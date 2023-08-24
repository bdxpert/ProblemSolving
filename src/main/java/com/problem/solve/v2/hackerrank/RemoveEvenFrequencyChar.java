package com.problem.solve.v2.hackerrank;

import java.util.HashMap;

public class RemoveEvenFrequencyChar {
    public static void main(String args[]){
        System.out.println((removeEvenFreChar("aabbaaa")));
    }
    public static String removeEvenFreChar(String str)
    {
        //input "aabbaaa" output abaa;
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< str.length();i++) {
               if(map.containsKey(str.charAt(i))) {
                   map.remove(new Character(str.charAt(i)));
               } else {
                   map.put(new Character(str.charAt(i)), 1);
                   sb.append(str.charAt(i));
               }
        }
        return sb.toString();
    }
}

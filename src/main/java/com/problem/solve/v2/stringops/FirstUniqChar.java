package com.problem.solve.v2.stringops;

import java.util.HashMap;

public class FirstUniqChar {
    int firstUniqueChar(String s)
    {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i=0; i<s.length();i++){
            count.put(chars[i], count.getOrDefault(chars[i],0)+1);
        }
        for (int i=0;i<s.length();i++) {
            if(count.get(chars[i]) == 1) return i;
        }
        return -1;
    }
}

package com.problem.solve.v2.stringops;

import java.util.HashMap;
import java.util.Map;

// Amazon assessment
public class TwoStringAnagram {
    String isTwoStringAnagram(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str1.length();i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0)+1);
        }
        for(int i=0;i<str2.length();i++) {
            int count = map.get(str2.charAt(i));
            if(count == 0) return "NO";
            if(!map.containsKey(str2.charAt(i))) {
                return "NO";
            } else {
                map.put(str2.charAt(i), map.get(str2.charAt(i))-1);
            }
        }
        return "YES";
    }
}
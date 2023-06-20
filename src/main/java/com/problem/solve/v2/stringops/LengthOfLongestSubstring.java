package com.problem.solve.v2.stringops;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    static int lengthOfLongestSubstring(String str)
    {
//        "abcabcbb"
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            while(!set.add(str.charAt(right))) {
                set.remove(str.charAt(left++));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    boolean isAnagram(String arr1, String arr2)
    {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<arr1.length(); i++) {
            map.put(arr1.charAt(i), map.getOrDefault(arr1.charAt(i), 0)+1);
        }
        for(int i=0;i<arr2.length(); i++) {
            if(map.containsKey(arr2.charAt(i)))
                map.put(arr2.charAt(i), map.getOrDefault(arr2.charAt(i),0)-1);
            else
                map.put(arr2.charAt(i), map.getOrDefault(arr2.charAt(i), 0)+1);
        }
        for(Map.Entry<Character, Integer> data: map.entrySet()) {
            if(data.getValue()>0) return false;
        }
        return true;
    }
}

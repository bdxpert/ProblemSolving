package com.problem.solve.v2.slidingwindow;
/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {

        int n = s.length();
        int ans = 0, val = 0;
        int i=0;
        while(i<k){
            if(isVowel(s.charAt(i)))    val++;
            i++;
        }
        ans = val;
        while( i<n) {

            if(isVowel(s.charAt(i))) val++;
            if(isVowel(s.charAt(i-k)))   val--;
            ans = Math.max(ans , val);
            i++;
        }
        return ans;
    }
    Boolean isVowel(char chr)
    {
        if(Character.toLowerCase(chr) == 'a' ||
                Character.toLowerCase(chr) == 'e' ||
                Character.toLowerCase(chr) == 'i' ||
                Character.toLowerCase(chr) == 'o' ||
                Character.toLowerCase(chr) == 'u') return true;

        return false;
    }
}

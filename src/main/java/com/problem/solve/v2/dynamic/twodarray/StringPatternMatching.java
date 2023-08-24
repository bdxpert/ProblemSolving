package com.problem.solve.v2.dynamic.twodarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringPatternMatching {
    static int countFreq(String pattern, String source)
    {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
        HashSet<Character> vowel = new HashSet<Character>(list);
        int M = pattern.length();
        int N = source.length();
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            /* For current index i, check for
        pattern match */
            int j;
            for (j = 0; j < M; j++) {
                if(pattern.charAt(j) == '0') {
                    if (!vowel.contains(source.charAt(i + j))) {
                        break;
                    }
                }else {
                    if (vowel.contains(source.charAt(i + j))) {
                        break;
                    }
                }
            }

            // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                res++;
                j = 0;
            }
        }
        return res;
    }

    static boolean IsVowel(Character c)
    {
        if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u' ||c == 'y')
            return true;
        return false;
    }

    static int CountMatchingSubstrings(String pattern, String source)
    {
        int count = 0;
        int patternLength = pattern.length();
        int sourceLength = source.length();

        for (int i = 0; i <= sourceLength - patternLength; i++)
        {
            boolean isMatch = true;

            for (int j = 0; j < patternLength; j++)
            {
                char patternChar = pattern.charAt(j);
                char sourceChar = source.charAt(i + j);

                if ((patternChar == '0' && !IsVowel(sourceChar)) ||
                        (patternChar == '1' && IsVowel(sourceChar)))
                {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch)
            {
                count++;
            }
        }

        return count;
    }
    public static int matchPatternV3(String pattern, String source)
    {
        int match =0;
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');set.add('y');

        for(int i=0;i<source.length()-pattern.length()+1;i++) {
            int j = 0, index=0;
            while(j<pattern.length()) {
                if(pattern.charAt(j) == '0' && set.contains(source.charAt(i+j))){
                    index++;
                } else if(pattern.charAt(j) == '1' && !set.contains(source.charAt(i+j))){
                    index++;
                } else {
                    break;
                }
                j++;
            }
            if(index == pattern.length()) {
                match++;
            }
        }
        return match;
    }
    public static void main(String[] args) {

        //System.out.println(CountMatchingSubstrings("00", "aaaaaa"));
        System.out.println(matchPatternV3("00", "aaaaaa"));
        System.out.println(matchPatternV3("010", "amazing"));
        System.out.println(matchPatternV3("100", "codesignal"));

    }
}

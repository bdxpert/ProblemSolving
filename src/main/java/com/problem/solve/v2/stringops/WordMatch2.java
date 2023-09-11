package com.problem.solve.v2.stringops;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordMatch2 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("aaaa", "dog dog dog dog"));
        System.out.println(wordPattern("aaa", "aa aa aa aa"));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (words.length != chars.length) return false;
        Map<Character, String> charToWord = new HashMap<>(chars.length);
        Map<String, Character> wordToChar = new HashMap<>(words.length);
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            String currentWord = words[i];
            String retrievedWord = charToWord.get(currentChar);
            if (Objects.nonNull(retrievedWord)) {
                if (!currentWord.equals(retrievedWord)) {
                    return false;
                }
            } else {
                charToWord.put(currentChar, currentWord);
            }
            if (!currentWord.isBlank()) {
                wordToChar.put(currentWord, currentChar);
            }
        }
        return charToWord.keySet().size() == wordToChar.keySet().size();
    }
}

/*
Moni, Mistu r tomar hat dore hete jabo onek dur
Kokhono sobai mile vora purnimai jochona dekhe
kokhono ba somudro jole pa vijiya
kokhono ba chooto gore sobai mile eksathe golpo kore
kete jabe din mas bochor
 */
package com.problem.solve.v2.stringops;

public class LongestCommonPrefix {
    public static void main(String args[]) {

    }

    public String longestCommonPrefix(String[] strs) {

        String str1 = strs[0];
        char[] str1char = str1.toCharArray();
        String max = null;
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 1; i < strs.length; i++) {
            String str2 = strs[i];
            char[] str2char = str2.toCharArray();
            int k = 0;
            String match = "";
            int maxLength = str1char.length;
            if (maxLength > str2char.length)
                maxLength = str2char.length;
            while (k < maxLength && str1char[k] == str2char[k]) {
                match = match + str1char[k];
                k++;
            }

            if (max == null) {
                max = match;
            } else {
                if (max.length() > match.length())
                    max = match;
            }
            if (match.length() == 0) break;
        }
        return max == null ? "" : max;
    }
}

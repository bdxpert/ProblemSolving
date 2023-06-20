package com.problem.solve.v2.stringops;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrom {

    public static void main(String[] args) {
        String data1 = "babad";
        String data2 = "cbbd";
        String data3 = "bb";
        String data4 = "ccc";
        String data5 = "aba";
        String data6 = "ac";
        System.out.println(longestPalindrome(data1));
        String s = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "aab";

        //System.out.println(lengthOfLongestSubstring(s3));
        String strr = "()[]{}";
        String strr2 = "{[]}";
        String strr3 = "(]";
        String strr4 = "]";
        String strr5 = "([]){";
        String strr6 = "({{{{}}}))";

        System.out.println(isValid(strr6));
    }
    public static String longestPalindrome(String str) {
        int n = str.length(); // calculating size of string
        if (n == 1) {
            return "" + str.charAt(0);
        }
        if (n == 2 && str.charAt(0) == str.charAt(1)) {
            return str;
        }
        //return n; // if string is empty then size will be 0.
        // if n==1 then, answer will be 1(single
        // character will always palindrome)

        int maxLength = 1, start = 0;
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while (high < n && str.charAt(high) == str.charAt(i)) //increment 'high'
                high++;

            while (low >= 0 && str.charAt(low) == str.charAt(i)) // decrement 'low'
                low--;

            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }
        System.out.print("Longest palindrome substring is: ");
        System.out.println(str.substring(start, start + maxLength));
        //return maxLength;
        return str.substring(start, start + maxLength);
    }

    public static String longestPalindromeold(String s) {
        String buf = ""+s.charAt(0);
        String longSub = "";
        /*
        if(s.length() ==2) {
            if(s.charAt(0) == s.charAt(1)) {
                return s;
            }
            else return ""+s.charAt(0);
        }
        */
        for (int i=1;i< s.length(); i++) {
            if(i<(s.length()-1)) {
            /*
            if( s.charAt(i-1) == s.charAt(i) ) {
                buf = buf + s.charAt(i);
            } else if(i<(s.length()-1) && s.charAt(i-1) == s.charAt(i+1)) {
                buf = buf + s.charAt(i);
            }*/
                if (s.charAt(i - 1) == s.charAt(i) || s.charAt(i - 1) == s.charAt(i + 1)) {
                    buf = buf + s.charAt(i);
                } else {
                    if(longSub.length() < buf.length())
                        longSub = buf;
                    buf = "" + s.charAt(i);
                }
            } else {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    buf = buf + s.charAt(i);
                } else if (i > 2 && s.charAt(i - 2) == s.charAt(i)) {
                    buf = buf + s.charAt(i);
                } else {
                    if(longSub.length() < buf.length())
                    longSub = buf;
                    buf = "" + s.charAt(i);
                }
            }
        }
        /*if(s.charAt( s.length()-1) == s.charAt( s.length()-2)) {
            longSub = longSub +""+s.charAt(s.length()-1);
            buf = buf +""+s.charAt(s.length()-1);
        }*/
        return longSub.length() > buf.length() ? longSub : buf;
    }
    public static int lengthOfLongestSubstring(String s) {
        String buf = "";
        String longSub = "";

        for(int i=0; i < s.length(); i++) {
            int foundIndex = buf.indexOf(s.charAt(i));
            if(foundIndex > -1 ) {
                // make
                if(buf.length() > longSub.length()) {
                    longSub = buf;
                }

                buf = ""+buf.substring(foundIndex+1) + s.charAt(i);
            } else {
                buf = buf + s.charAt(i);
            }
        }
        if(buf.length() > longSub.length())
        {
            return buf.length();
        }
        return longSub.length();
    }

    public static boolean isValid(String s) {
        //(){}[]
        Boolean isValidStr = false;
        //([]){

        List<Character> data = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            // push
            if(s.charAt(i) == '(') {
                data.add('(');
            }
            if(s.charAt(i) == '[') {
                data.add('[');
            }
            if(s.charAt(i) == '{') {
                data.add('{');
            }
            //pop
            if(s.charAt(i) == ')') {
                if(data.size()>0) {
                    isValidStr = data.get(data.size()-1).equals('(');
                    data.remove(data.size()-1);
                } else {
                    isValidStr = false;
                }
                if(!isValidStr) break;
            }
            if(s.charAt(i) == ']') {
                if(data.size()>0) {
                    isValidStr = data.get(data.size() - 1).equals('[');
                    data.remove(data.size() - 1);
                } else {
                    isValidStr = false;
                }
                if(!isValidStr) break;
            }
            if (s.charAt(i) == '}') {
                if (data.size() > 0) {
                    isValidStr = data.get(data.size() - 1).equals('{');
                    data.remove(data.size() - 1);
                } else {
                    isValidStr = false;
                }
                if(!isValidStr) break;
            }
        }

        return isValidStr && data.size()==0;
    }
    /*
    /*
        for (int i=0; i<s.length(); i++) {
            if(nextChar.equals("") && s.charAt(i) == '(') {
                isValidStr = Boolean.FALSE;
                nextChar = ")";
                nextIndex = i+1;
            }
            if(nextChar.equals(")") && s.charAt(i) == ')' && nextIndex == i) {
                isValidStr = Boolean.TRUE;
                nextChar = "";
            }
            if(nextChar.equals("") && s.charAt(i) == '{') {
                isValidStr = Boolean.FALSE;
                nextChar = "}";
                nextIndex = i+1;
            }
            if(nextChar.equals("}") && s.charAt(i) == '}' && nextIndex == i) {
                isValidStr = Boolean.TRUE;
                nextChar = "";
            }

            if(nextChar.equals("") && s.charAt(i) == '[') {
                isValidStr = Boolean.FALSE;
                nextChar = "]";
                nextIndex = i+1;
            }
            if(nextChar.equals("]") && s.charAt(i) == ']' && nextIndex == i) {
                isValidStr = Boolean.TRUE;
                nextChar = "";
            }
        }

     */
}

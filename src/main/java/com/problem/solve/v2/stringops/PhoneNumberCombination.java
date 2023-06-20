package com.problem.solve.v2.stringops;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumberCombination {
/*
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() > 4) return res;
        Map<Integer, String> button = new HashMap<>();

        button.put(2,"abc");
        button.put(3,"def");
        button.put(4,"ghi");
        button.put(5,"jkl");
        button.put(6,"mno");
        button.put(7,"pqrs");
        button.put(8,"tuv");
        button.put(9,"wxyz");

        char[] digitsArr = digits.toCharArray();
        if(digitsArr.length ==1) {
            char[] label = button.get(Integer.parseInt(""+digitsArr[0])).toCharArray();
            for(int i=0;i<label.length;i++)
            {
                res.add(""+label[i]);
            }
        }

        for(int i=0; i<digitsArr.length; i++) {
            char[] label = button.get(Integer.parseInt(""+digitsArr[i])).toCharArray();

        }

    }
    */
   static char[][] buttons = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    public static void main(String args[]){
        System.out.println(letterCombinations("234"));
    }
    static List<String> result;

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        result = new ArrayList<>();
        // digits = "23" -> '2'-'0'-2 == 50 -48 -2 = 0
        traverse(1, buttons[digits.charAt(0) - '0' - 2], digits, new StringBuilder());
        return result;
    }

    private static void traverse(int index, char[] button, String digits, StringBuilder sbTemp) {
        for (int i = 0; i < button.length; i++) {
            sbTemp.append(button[i]);
            if (index == digits.length()) {
                result.add(sbTemp.toString());
            } else {
                traverse(index + 1, buttons[digits.charAt(index) - '0' - 2], digits, sbTemp);
            }
            sbTemp.setLength(sbTemp.length() - 1);
        }
    }

    public List<String> letterCombinationsV3(String digits) {
        List<String> ans = new LinkedList<String>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add(0, "");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            int size = ans.size();     // number of nodes/strings already in the queue
            for (int k = 1; k <= size; k++) {
                String t = ans.remove(0);
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
    /*
     * Use peek to fetch first element of array
     * digit=234
     *[adg, adh, adi, aeg, aeh, aei, afg, afh, afi, bdg, bdh, bdi, beg, beh, bei, bfg, bfh, bfi, cdg, cdh, cdi, ceg, ceh, cei, cfg, cfh, cfi]
     *[adg, adh, adi, aeg, aeh, aei, afg, afh, afi, bdg, bdh, bdi, beg, beh, bei, bfg, bfh, bfi, cdg, cdh, cdi, ceg, ceh, cei, cfg, cfh, cfi]
     */
    public static List<String> letterCombinationsV2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i) {
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}

package com.problem.solve.v2.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    */
    public static void main(String args[])
    {
        System.out.println(generateParenthesis(4));
    }
    public static List<String> generateParenthesis(int n) {
        String str="";
        List<String> list = new ArrayList<>();
        buildParenThesis(str,0, 0, n, list);
        return list;
    }
    static void  buildParenThesis(String str,int open,int close,int n, List<String> list) {
        if(str.length() == 2*n) {
            list.add(str);
            return;
        }
        if(open < n) {
            buildParenThesis(str+"(",open+1,close,n, list);
        }
        if(close < open) {
            buildParenThesis(str+")",open,close+1,n, list);
        }
    }

}

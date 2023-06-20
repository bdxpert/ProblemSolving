package com.problem.solve.v2.stack;

import java.util.Stack;

public class ValidPattern {
    public static void main(String args[]) {
//        Input: s = "()[]{}"
//        Output: true
        System.out.println(isValid("(({}(){}()))["));
    }

    public static Boolean isValid(String str)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                if(stack.empty()) return false;
                char charItem = stack.peek();
                if((str.charAt(i) == ')' && charItem == '(') ||
                        (str.charAt(i) == ']' && charItem == '[') ||
                        (str.charAt(i) == '}' && charItem == '{')) {
                   stack.pop();
                } else
                    return false;
            }
        }
        return stack.empty();
    }
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> stack = new Stack<>();
        char[] data = x.toCharArray();
        if(data.length ==1) return false;
        for (int i=0;i<data.length; i++)
        {
            if(data[i] == '{' || data[i] == '(' || data[i]=='[') {
                stack.push(data[i]);
            }
            else {
                if(stack.isEmpty()) return false;

                    char peekData = stack.peek();
                    if((data[i]=='}' && peekData == '{')
                            || (data[i]==')' && peekData == '(') ||(data[i] == ']' && peekData=='['))
                        stack.pop();
                     else {
                        return false;
                    }
            }
        }
        //System.out.println(stack.pop());
        return stack.isEmpty();
    }
}

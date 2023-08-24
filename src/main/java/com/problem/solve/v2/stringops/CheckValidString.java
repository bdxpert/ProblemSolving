package com.problem.solve.v2.stringops;

import java.util.Stack;

//leet code 678. Valid Parenthesis String
public class CheckValidString {
    //String contains only ( & )
    public boolean checkValidStringV1(String s) {
        int openCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                openCount--;
            }
            if (openCount < 0) return false;    // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            // For example: ())(
        }
        return openCount == 0; // Fully match open parentheses with close parentheses
    }
    public static void main(String args[])
    {
        //(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())
        checkValidStringV2("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }
    public static boolean checkValidStringV2(String s) {

        Stack<Integer> brackets, stars;
        brackets = new Stack<>();
        stars = new Stack<>();

        for(int i=0; i<s.length(); i++){

            char bracket = s.charAt(i);

            if(bracket == '('){
                brackets.push(i);
            }
            else if(bracket == '*'){
                stars.push(i);
            }
            else if(!brackets.isEmpty()){
                brackets.pop();
            }
            else if(!stars.isEmpty()){
                stars.pop();
            }
            else{
                return false;
            }

        }

        while(!brackets.isEmpty() && !stars.isEmpty() && brackets.peek() < stars.peek()){
            brackets.pop();
            stars.pop();
        }

        return brackets.isEmpty();
    }
    // validate ()*
    public static boolean checkValidStringWrongV2(String s) {
        Stack<Character> open = new Stack<>();
        Stack<Character> star = new Stack<>();

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                open.push(s.charAt(i));
            } else if(s.charAt(i) == '*') {
                star.push(s.charAt(i));
            } else {
                if(!open.isEmpty())
                    open.pop();
                else if(!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }
        /*

        while(!brackets.isEmpty() && !stars.isEmpty() && brackets.peek() < stars.peek()){
            brackets.pop();
            stars.pop();
        }

        return brackets.isEmpty();

        */
        //Now process leftover opening brackets
        while(!open.isEmpty())
        {
            if(star.isEmpty())
                return false;
            else if(open.peek() < star.peek())
            {
                open.pop();
                star.pop();
            }
            else    //CASE: open.top() > star.top()
                return false;
        }
        return true;
    }
    public boolean checkValidStringV3(String s)
    {
        int right =0,left =0;

        for(int i=0; i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
                left++;
            else
                left--;

            if(ch != ')')
                right++;
            else
                right--;

            if(right < 0)
                break;

            left = Math.max(0 , left);
        }

        return left == 0;
    }
}

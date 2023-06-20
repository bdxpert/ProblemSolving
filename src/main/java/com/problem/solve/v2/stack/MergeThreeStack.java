package com.problem.solve.v2.stack;

import java.util.*;

/*
Merge three stacks into one.

s1 = -5,1,2,3,5
s2 = -3,4,6,7
s3 = 1,5

output (return one stack)
-5,-3,1,1,2,3,4,5,5,6,7

<---Microsoft--->
*/

public class MergeThreeStack {
    public static void main(String args[])
    {
        Stack<Integer> s1 = new Stack<>();
        s1.push(-5);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(5);

        Stack<Integer> s2 = new Stack<>();
        s2.push(-3);
        s2.push(4);
        s2.push(6);
        s2.push(7);

        Stack<Integer> s3 = new Stack<>();
        s3.push(1);
        s3.push(5);

        List<Stack<Integer>> s  = new ArrayList<>();
        s.add(s1);
        s.add(s2);
        s.add(s3);

        Stack<Integer> fStack = (merge3Stack(s));
        fStack.stream().forEach(item-> {
            System.out.println(item);
        });
    }
    static Stack<Integer> merge3Stack(List<Stack<Integer>> stacks)
    {
        Queue<Integer> queue = new PriorityQueue<>();
        for (Stack stack:stacks) {
            while (!stack.isEmpty()) {
                queue.offer((Integer) stack.pop());
            }
        }
//        queue.stream().forEach(item-> {
//            System.out.println(item);
//        });
        Stack<Integer> finalStack = new Stack<>();
        while(!queue.isEmpty()) {
            finalStack.push(queue.poll());
        }
        return finalStack;
    }
}

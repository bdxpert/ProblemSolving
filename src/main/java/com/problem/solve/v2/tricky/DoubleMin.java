package com.problem.solve.v2.tricky;
// reference https://codequotient.com/blog/java-programming-questions-interview/

import java.util.Arrays;

public class DoubleMin {
    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE);
        // this statement will return 0.0
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));

        //what will return 1.0/0.0
        System.out.println(1.0/0.0);


        char[] chars = new char[] {'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
    }
    /*
    Q. If a method throws NullPointerException in the superclass, can we override it with a method that throws RuntimeException?
    Answer: Yes, you can throw a superclass of RuntimeException in overridden method, but you can not do that if it’s a checked Exception.

    Q. What is the difference between CyclicBarrier and CountDownLatch in Java?
    Answer:
    You can reuse CyclicBarrier even if the Barrier is broken, but you can not reuse CountDownLatch in Java.
    */
}
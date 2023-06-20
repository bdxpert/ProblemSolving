package com.problem.solve.v2.stack;

import java.util.Stack;

public class SanMinStack {
    public static void main(String args[]) {
        SanMinStack minStack = new SanMinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public SanMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        //get the minimum
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());

        minStack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    /*
    List<Integer> list;
    PriorityQueue<Integer> pqueue;
    public SanMinStack() {
        list = new ArrayList<>();
        pqueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void push(int val) {
        list.add(val);
        pqueue.offer(val);
    }

    public void pop() {
        Integer n = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        pqueue.remove(n);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return pqueue.peek();
    }

     */
}

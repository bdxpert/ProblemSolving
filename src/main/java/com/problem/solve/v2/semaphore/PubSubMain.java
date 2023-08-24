package com.problem.solve.v2.semaphore;

public class PubSubMain {
    public static void main(String args[]) {
        // creating buffer queue
        SQueue q = new SQueue();
        // starting consumer thread
        new Consumer(q);
        // starting producer thread
        new Producer(q);
    }
}

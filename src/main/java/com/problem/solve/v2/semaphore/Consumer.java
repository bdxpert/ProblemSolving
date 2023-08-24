package com.problem.solve.v2.semaphore;

public class Consumer implements Runnable {
    SQueue q;

    Consumer(SQueue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) // consumer get items
            q.get();
    }
}

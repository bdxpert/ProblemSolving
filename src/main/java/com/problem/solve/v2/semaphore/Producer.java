package com.problem.solve.v2.semaphore;

class Producer implements Runnable {
    SQueue q;

    Producer(SQueue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) q.put(i);
    }
}
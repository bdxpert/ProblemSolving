package com.problem.solve.v2.thread;

public class SanCountConcurrent {
    int count =0;
    static int total = 10;

    void printNum(int index)
    {
            synchronized (this) {
                while (count < total - 1) {
                    while (count % 3 == index) {
                        try {
                            wait();
                        } catch (InterruptedException ex) {

                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + " -- " + count);
                    notifyAll();
                }
            }
        }

    public static void main(String args[]) {
        SanCountConcurrent sanCountConcurrent = new SanCountConcurrent();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sanCountConcurrent.printNum(0);
            }
        },"Thread - 1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sanCountConcurrent.printNum(1);
            }
        },"Thread - 2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                sanCountConcurrent.printNum(2);
            }
        },"Thread - 3").start();
    }
}

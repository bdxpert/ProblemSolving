package com.problem.solve.v2.semaphore;

import java.util.Random;
import java.util.concurrent.*;

public class SemaphoresMain {
    private static int index = 0;

    private static final int SIZE = 50;

    private static Integer[] queue = new Integer[SIZE];

    private static Semaphore semaphore = new Semaphore(1);
    private static Semaphore maxSemaphore = new Semaphore(SIZE);
    private static Semaphore minSemaphore = new Semaphore(0);

    private static Random rand = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(SemaphoresMain::producer);
        executor.submit(SemaphoresMain::producer2);
        executor.submit(SemaphoresMain::consumer);
        executor.submit(SemaphoresMain::consumer2);
    }

    private static Void producer() throws InterruptedException {
        for (;;) {
            Thread.sleep(500);
            maxSemaphore.acquire();
            semaphore.acquire();

            var produced = rand.nextInt() % 5 + 5;
            queue[index++] = produced;

            print();
            System.out.println(" P1: " + produced);

            minSemaphore.release();

            semaphore.release();
        }
    }

    private static  Void producer2() throws InterruptedException {
        for (;;) {
            Thread.sleep(200);
            maxSemaphore.acquire(2);
            semaphore.acquire();

            var next = rand.nextInt() % 5 + 5;
            var next2 = rand.nextInt() % 5 + 5;

            queue[index++] = next;
            queue[index++] = next2;

            print();
            System.out.println(" P2: " + next + "," + next2);

            minSemaphore.release(2);

            semaphore.release();
        }
    }

    private static Void consumer() throws InterruptedException {
        for (;;) {
            Thread.sleep(300);
            minSemaphore.acquire();
            semaphore.acquire();

            var eaten = queue[--index];

            print();
            System.out.println(" C1: " + eaten);

            maxSemaphore.release();
            semaphore.release();
        }
    }

    private static Void consumer2() throws InterruptedException {
        for (;;) {
            Thread.sleep(400);
            minSemaphore.acquire(2);
            semaphore.acquire();

            var eaten = queue[--index];
            var eaten2 = queue[--index];

            print();
            System.out.println(" C2: " + eaten + "," + eaten2);

            maxSemaphore.release(2);
            semaphore.release();
        }
    }


    private static void print(){
        for (int i = 0; i < SIZE; i++) {
            if (i >= index)
                System.out.print(" -");
            else
                System.out.print(" " + queue[i]);
        }
    }
}
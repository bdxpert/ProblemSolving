package com.problem.solve.v2.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockingQueueUsingLock {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final Object[] data = new Object[12];
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public void add(Object x) throws InterruptedException {
        lock.lock();
        try {
//            while (count == items.length) notFull.await();
//            data[tail] = item;
            tail = (tail + 1) % data.length;
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) notEmpty.await();
            Object item = data[head];
            head = (head + 1) % data.length;
            count--;
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }
}

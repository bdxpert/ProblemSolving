package com.problem.solve.v2.blockingqueue;

public class CustomBlockingQueueMain {

    public static void main(String[] args) {
        CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue();
        // Creating producer and consumer threads
        Thread producer = new Thread(new Producer(customBlockingQueue));
        Thread consumer = new Thread(new Consumer(customBlockingQueue));

        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {

    private CustomBlockingQueue customBlockingQueue;

    public Producer(CustomBlockingQueue customBlockingQueue){
        this.customBlockingQueue = customBlockingQueue;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                customBlockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer implements Runnable {
    private CustomBlockingQueue customBlockingQueue;

    public Consumer(CustomBlockingQueue customBlockingQueue) {
        this.customBlockingQueue = customBlockingQueue;
    }
    @Override
    public void run() {
//        IntStream.of(123).map(data -> {
//           return new String(""+data).split("");
//        }).forEach(da->{
//            System.out.println(da);
//        });
        for (int i = 1; i <= 10; i++) {
            try {
                customBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
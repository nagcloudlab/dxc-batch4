package com.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentCollections_Ex {
    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

        Runnable produceTask = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + i + " produced");
                    blockingQueue.put(i);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consumeTask = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + blockingQueue.take() +" consumed");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(produceTask);
        executorService.submit(consumeTask);

    }
}

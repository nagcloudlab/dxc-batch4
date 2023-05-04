package com.example;

class Counter {
    private long count = 0;
    //  thread safe method  ==> synchronized
    public synchronized  void increment() {
        count++;
        /*
            => read existing count from memory
            => increment count by 1
            => write updated count to memory
         */
    }
    public long getCount() {
        return count;
    }
}

public class RaceCondition_Ex {
    public static void main(String[] args) {

        Counter counter = new Counter(); // shared resource

        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        System.out.println(counter.getCount()); // 1000 * 1000 = 1000000

    }
}

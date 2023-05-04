package com.example;

public class ThreadLifeCycle_Ex {
    public static void main(String[] args) {

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < 1000; i++) {
                System.out.println(threadName + " -" + i);
            }
        };

        Thread thread1 = new Thread(task, "foo");
        Thread thread2 = new Thread(task, "bar");
        Thread thread3 = new Thread(task, "baz");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

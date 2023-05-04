package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFramework_Ex {
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task1 - "+Thread.currentThread().getName());
        };
        Runnable task2 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task2 - "+Thread.currentThread().getName());
        };
        Runnable task3 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task3 - "+Thread.currentThread().getName());
        };

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);


    }
}

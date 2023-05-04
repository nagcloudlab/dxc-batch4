package com.example;

/*
    task 1: get name from user, greet   ==> IO
    task 2: display number 1-1          ==> Computations
 */

import java.util.Scanner;

public class App {

    public static void task1() {
        System.out.println("Task-1: initiated");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        scanner.close();
        System.out.println("Task-1: completed");
    }

    public static void task2() {
        System.out.println("Task-2: initiated");
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
        System.out.println("Task-2: completed");
    }

    public static void main(String[] args) {


        Thread thread1 = new Thread(App::task1, "T1");
        Thread thread2 = new Thread(App::task2, "T2");

        thread1.start(); // new-stack
        thread2.start(); // new-stack

        // concurrency vs parallel

        // currency ==> doing several things
        // parallel ==> doing several things at the same time

    }
}

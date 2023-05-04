package com.example;

import java.util.function.Predicate;

public class How_To_Create_Function {
    public static void main(String[] args) {

        Predicate<Integer> isMax = number -> number > 100; // create a function // Lambda Expression
        boolean b = isMax.test(100);  // call the function
        System.out.println(b);

    }
}

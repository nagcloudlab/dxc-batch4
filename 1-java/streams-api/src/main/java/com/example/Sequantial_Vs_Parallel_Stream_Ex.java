package com.example;

import java.util.List;

public class Sequantial_Vs_Parallel_Stream_Ex {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        numbers
//                .stream()
                .parallelStream()
//                .peek(x->System.out.println("before filter :"+x))
                .filter(x -> x % 2 == 0)
//                .peek(x->System.out.println("before map :"+x))
                .map(x -> x * x)
//                .peek(x->System.out.println("after map :"+x))
                .filter(x -> x > 50)
                .forEach(x -> System.out.println("forEach :" + x));


    }
}

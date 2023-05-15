package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class How_To_Create_Stream_Ex {
    public static void main(String[] args) {

        //--------------------------------------------------
        // way-1 : values
        //--------------------------------------------------
//
//        Stream.of(1, 2, 3, 4, 5, 6, 7)
//              .forEach(System.out::println);

        //--------------------------------------------------
        // way-2 : array
        //--------------------------------------------------

//        int[] arr = {1, 2, 3, 4, 5, 6};
//        Arrays.stream(arr).forEach(System.out::println);


        //--------------------------------------------------
        // way-3 : collections
        //--------------------------------------------------
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        numbers.stream().forEach(System.out::println);

        //--------------------------------------------------
        // way-4 : IO i.e file sources , n/w sockets , jdbc results
        //--------------------------------------------------


        //--------------------------------------------------
        // way-5 : by computation
        //--------------------------------------------------

        Random random = new Random();
        // Build Stream
        Stream.generate(() -> {
                    return random.nextInt(100);
                })
                // Intermediate Method(s)
                .filter(i -> i > 0)
                .limit(10)
                .peek(n-> System.out.println("before map:"+n))
                .map(i -> i * i)
                // Terminal Method
                .forEach(System.out::println);


    }

}
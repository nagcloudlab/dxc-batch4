package com.example;

import java.util.function.*;

public class FunctionalInterfaces_Ex {

    public static void main(String[] args) {

        Function<Integer,Integer> function = x -> x * x;
        Consumer<Integer> consumer=x-> System.out.println(x);
        Supplier<Integer> supplier=()-> 10;
        Predicate<Integer> predicate=x-> x>0;

        BiFunction<Integer,Integer,Integer> biFunction= (x,y)-> x+y;
        BiConsumer<Integer,Integer> biConsumer= (x,y)-> System.out.println(x+y);
        BiPredicate<Integer,Integer> biPredicate= (x,y)-> x>0 && y>0;


        UnaryOperator<Integer> unaryOperator=x->x*x;
        BinaryOperator<Integer> binaryOperator= (x,y)-> x+y;
        IntBinaryOperator intBinaryOperator= (x,y)-> x+y;




    }

}

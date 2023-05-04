package com.example;

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class InventoryApp {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple("red", 100),
                new Apple("green", 120),
                new Apple("red", 80)
        );


        System.out.println(
//                filterApples(inventory, apple -> apple.getColor().equals("green"))
//                filterApples(inventory,apple -> apple.getWeight()==100)
//                filterApples(inventory, apple -> apple.getWeight() > 100 && apple.getColor().equals("green"))
        );


    }

    // implementation
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}

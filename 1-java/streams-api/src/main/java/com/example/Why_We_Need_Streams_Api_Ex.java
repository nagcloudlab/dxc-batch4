package com.example;

import com.example.model.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Why_We_Need_Streams_Api_Ex {
    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;  // data

        System.out.println(
                // display Low-caloric ( < 400) dish names in sorted by calorie
//                getLocalCaloricDishNamesV1(menu)
                getLocalCaloricDishNamesV2(menu)
        );

    }

    public  static List<String> getLocalCaloricDishNamesV2(List<Dish> menu) {
        return menu
                .stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public  static List<String> getLocalCaloricDishNamesV1(List<Dish> menu) {
        // filtering low caloric dishes into new list
        List<Dish> lowCaloricDishes=new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        // sorting low caloric dishes
        lowCaloricDishes.sort((d1, d2) -> d1.getCalories() - d2.getCalories());
        // extracting dish names into new list
        List<String> dishNames=new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            dishNames.add(dish.getName());
        }
        return dishNames;
    }

}


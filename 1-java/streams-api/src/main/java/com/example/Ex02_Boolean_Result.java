package com.example;

import com.example.model.Dish;

import java.util.List;

public class Ex02_Boolean_Result {
    public static void main(String[] args) {

        List<Dish> menu=Dish.menu;

//        boolean isVegetarianFriendlyMenu=
//                menu
//                        .stream()
//                        .anyMatch(Dish::isVegetarian);
//        System.out.println(isVegetarianFriendlyMenu);

        //-------------------------------------------------------------

//        boolean isHealthyMenu=
//                menu
//                        .stream()
//                        .allMatch(d->d.getCalories()<1000);
//        System.out.println(isHealthyMenu);
//
//        isHealthyMenu=
//                menu
//                        .stream()
//                        .noneMatch(d->d.getCalories()>=1000);

        //-------------------------------------------------------------


    }
}

package com.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//--------------------------------------------
// third party library about food items
//--------------------------------------------
class FoodUtil {
    static List<String> vegItemDictionary = new ArrayList<>();

    static {
        vegItemDictionary.add("apple");
        vegItemDictionary.add("banana");
        vegItemDictionary.add("potato");
    }

    public static boolean isVegItem(String item) {
        return vegItemDictionary.contains(item);
    }
}

public class MethodReference_Ex {
    public static void main(String[] args) {

        List<String> cart = new ArrayList<>();
        cart.add("banana");
        cart.add("chicken");
        cart.add("fish");
        cart.add("potato");

        //-------------------------------------------
        // imperative way
        //-------------------------------------------
//        Iterator<String> iterator = cart.iterator();
//        while (iterator.hasNext()) {
//            String element = iterator.next();
//            if (!vegItemDictionary.contains(element)) {
//                iterator.remove();
//            }
//        }

        //-------------------------------------------
        // declarative way with function
        //-------------------------------------------

        cart.removeIf(element -> FoodUtil.isVegItem(element)); // Lambda expression
        // or
        cart.removeIf(FoodUtil::isVegItem); // Method reference -> using existing java method as function

        System.out.println(cart);


    }
}

package com.example;

import com.example.entity.Dish;
import com.example.entity.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex01_Filtering_Stream {
    public static void main(String[] args) {

         /*
            How to filter stream elements ?
            Intermediate operations that select some elements and discard others
                based on:
                    - content  => filter(),takeWhile(),dropWhile()
                    - amount   => limit() , skip()
                    - Uniqueness => distinct()

         */

        //-----------------------------------------

        List<Dish> menu = Dish.menu;


//        menu
//                .stream()
//                .filter(Dish::isVegetarian)
//                .forEach(System.out::println);

        //-----------------------------------------

        // Filtering unique elements
//        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//        numbers
//                .stream()
//                .distinct()
//                .forEach(System.out::println);

        //-----------------------------------------

//
//        menu
//                .stream()
//                .filter(dish -> dish.getCalories()>300)
//                .limit(3)
//                .forEach(System.out::println);

        //-----------------------------------------


//        menu
//                .stream()
//                .filter(dish -> dish.getCalories() > 300)
//                .skip(3)
//                .forEach(System.out::println);

        //-----------------------------------------


        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(34234, "E1", 1000.00));
        employees.add(new Employee(14234, "E2", 2000.00));
        employees.add(new Employee(34234, "E3", 5000.00));
        employees.add(new Employee(54234, "E4", 4000.00));
        employees.add(new Employee(44234, "E5", 3000.00));

        employees.sort(Comparator.comparing(Employee::getSalary));

        employees.stream()
                //.filter(employee -> employee.getSalary() > 3000)
                .takeWhile(employee -> employee.getSalary()<=3000) // break
                .forEach(System.out::println);


    }
}

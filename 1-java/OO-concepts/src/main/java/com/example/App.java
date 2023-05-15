package com.example;

import com.example.util.ArrayList;
import com.example.util.LinkedList;
import com.example.util.List;

public class App {
    public static void main(String[] args) {

        //...
        List<String> list=new ArrayList<>();
        list=new LinkedList<>();
        list.forEach(System.out::println);

        //-------------------------------------------

        java.util.List<String> strings=new java.util.ArrayList<>();

    }
}

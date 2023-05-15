package com.example;

import com.example.framework.WebFramework;

public class App {
    public static void main(String[] args) {


        WebFramework webFramework=new WebFramework();
        webFramework.handleHttpRequest("/user/register");

    }
}

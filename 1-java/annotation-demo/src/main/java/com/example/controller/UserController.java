package com.example.controller;

import com.example.framework.RequestMapping;

/**
 *
 * author : dxc
 *
 */
public class UserController {

    @RequestMapping(url = "/user/register")
    public void register(){
        System.out.println("doRegister()");
    }

   @RequestMapping(url = "/user/login")
    public void doLogin(){
        System.out.println("doLogin()");
    }

}

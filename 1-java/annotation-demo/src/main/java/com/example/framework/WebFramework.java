package com.example.framework;

import com.example.controller.UserController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: company / community  e.g spring community
 */
public class WebFramework {

    public void handleHttpRequest(String url) {
        try {
            // Reflection API
            Class<?> clazz = Class.forName("com.example.controller.UserController");
            Object obj = clazz.newInstance();
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                RequestMapping rm = method.getAnnotation(RequestMapping.class);
                if (rm != null) {
                    String mappedUrl = rm.url();
                    if (url.equals(mappedUrl)) {
                        method.invoke(obj);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

}

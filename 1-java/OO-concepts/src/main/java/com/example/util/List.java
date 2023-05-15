package com.example.util;

import java.util.function.Consumer;

public interface List<E> extends Collection<E>{

    // constant variables
    // No constructor

    void add(int index,E o);
    E remove(int index);
    E get(int index);
    E set(int index,E element);

    default void forEach(Consumer<E> c){
        c.accept(null);
    }


}

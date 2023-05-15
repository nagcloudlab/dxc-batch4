package com.example.util;

public interface Collection<E> {
    void add(E o);
    boolean contains(E o);
    boolean remove(E o);
    int size();
    boolean isEmpty();
    void clear();
}

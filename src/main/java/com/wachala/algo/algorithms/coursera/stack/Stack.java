package com.wachala.algo.algorithms.coursera.stack;

public interface Stack<T> {
    T peek();

    T pop();

    int size();

    void push(T item);

    boolean isEmpty();
}

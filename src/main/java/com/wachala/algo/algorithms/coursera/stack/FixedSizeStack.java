package com.wachala.algo.algorithms.coursera.stack;

import com.wachala.algo.algorithms.coursera.stack.util.StackFullException;

import java.util.NoSuchElementException;

public class FixedSizeStack<T> implements Stack<T> {
    private T stack[];
    private int size;
    private int maxSize;

    public FixedSizeStack(int maxSize) {
        stack = (T[]) new Object[maxSize];
        size = 0;
        this.maxSize = maxSize;
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack[size - 1];
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = stack[size - 1];
        stack[size--] = null;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(T item) {
        if (size + 1 < maxSize) {
            stack[++size] = item;
        } else {
            throw new StackFullException("No space available on stack");
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}

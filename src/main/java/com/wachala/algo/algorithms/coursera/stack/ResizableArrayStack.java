package com.wachala.algo.algorithms.coursera.stack;

import java.util.NoSuchElementException;

public class ResizableArrayStack<T> implements Stack<T> {
    private T[] array;
    private int elements;
    private static final int INITIAL_SIZE = 10;

    public ResizableArrayStack() {
        this.array = (T[]) new Object[INITIAL_SIZE];
        elements = 0;
    }

    @Override
    public T peek() {
        return array[elements - 1];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        T item = array[elements - 1];
        array[elements - 1] = null;
        elements--;

        if (elements < 0.25 * array.length) {
            resizeArray(array.length / 2);
        }

        return item;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public void push(T item) {
        if (elements == array.length) {
            resizeArray(array.length * 2);
        }

        array[elements++] = item;
    }

    @Override
    public boolean isEmpty() {
        return elements == 0;
    }

    private void resizeArray(int newSize) {
        T newArray[] = (T[]) new Object[newSize];

        for (int i = 0; i < Math.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }
}

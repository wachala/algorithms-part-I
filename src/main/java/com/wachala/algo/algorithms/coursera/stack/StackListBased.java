package com.wachala.algo.algorithms.coursera.stack;

import java.util.NoSuchElementException;

public class StackListBased<T> implements Stack<T> {
    private ListNode<T> head;
    private int size = 0;

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return head.getValue();
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = head.value;
        head = head.next;
        size--;

        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(T item) {
        ListNode<T> node = new ListNode<>(item);
        node.setNext(head);
        size++;
        head = node;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private class ListNode<E> {
        private E value;
        private ListNode<E> next;

        public E getValue() {
            return value;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }

        public ListNode(E value) {
            this.value = value;
        }
    }

}

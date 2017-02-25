package com.wachala.algo.algorithms.coursera.symbolTable;

import com.wachala.algo.algorithms.coursera.symbolTable.model.BSTNode;
import com.wachala.algo.algorithms.coursera.symbolTable.model.Entry;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private BSTNode<Key, Value> root;

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private BSTNode<Key, Value> put(BSTNode<Key, Value> root, Key key, Value value) {
        if (root == null)
            return new BSTNode<>(key, value);

        int result = root.getKey().compareTo(key);

        if (result > 0)
            root.setLeft(put(root.getLeft(), key, value));
        else if (result < 0)
            root.setRight(put(root.getRight(), key, value));
        else
            root.setValue(value);

        int rank = 1 + size(root.getLeft()) + size(root.getRight());
        root.setRank(rank);

        return root;
    }

    public Iterable<Key> keys() {
        Queue<Key> keys = new LinkedList<>();
        inorderTraversalKeys(root, keys);

        return keys;
    }

    @Override
    public Iterable<Value> values() {
        Queue<Value> values = new LinkedList<>();
        inorderTraversalValues(root, values);

        return values;
    }

    @Override
    public Iterable<Entry<Key, Value>> entrySet() {
        Queue<Entry<Key, Value>> entries = new LinkedList<>();
        inorderTraversalEntries(root, entries);

        return entries;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    @Override
    public int size() {
        return root != null ? size(root) : 0;
    }

    private int rank(Key key, BSTNode<Key, Value> root) {
        if (key == null || root == null) return 0;

        int result = root.getKey().compareTo(key);

        if (result > 0)
            return rank(key, root.getLeft());
        else if (result < 0)
            return 1 + size(root.getLeft()) + rank(key, root.getRight());
        else
            return size(root.getLeft());
    }

    private int size(BSTNode<Key, Value> root) {
        return root != null ? root.getRank() : 0;
    }

    private void inorderTraversalKeys(BSTNode<Key, Value> root, Queue<Key> queue) {
        if (root == null) return;

        inorderTraversalKeys(root.getLeft(), queue);
        queue.offer(root.getKey());
        inorderTraversalKeys(root.getRight(), queue);
    }

    private void inorderTraversalValues(BSTNode<Key, Value> root, Queue<Value> queue) {
        if (root == null) return;

        inorderTraversalValues(root.getLeft(), queue);
        queue.offer(root.getValue());
        inorderTraversalValues(root.getRight(), queue);
    }

    private void inorderTraversalEntries(BSTNode<Key, Value> root, Queue<Entry<Key, Value>> queue) {
        if (root == null) return;

        inorderTraversalEntries(root.getLeft(), queue);

        Entry<Key, Value> entry = new Entry<>(root.getKey(), root.getValue());
        queue.offer(entry);

        inorderTraversalEntries(root.getRight(), queue);
    }

}

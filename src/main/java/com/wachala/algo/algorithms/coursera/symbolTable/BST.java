package com.wachala.algo.algorithms.coursera.symbolTable;

import com.wachala.algo.algorithms.coursera.symbolTable.model.BSTNode;
import com.wachala.algo.algorithms.coursera.symbolTable.model.Entry;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    private BSTNode<Key, Value> root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    @Override
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

    @Override
    public Value get(Key key) {
        if (root == null) return null;
        BSTNode<Key, Value> node = root;

        while (node != null && !node.getKey().equals(key)) {
            int result = node.getKey().compareTo(key);
            if (result > 0) node = node.getLeft();
            else node = node.getRight();
        }

        return node == null ? null : node.getValue();
    }

    @Override
    public Key minKey() {
        return minEntry().getKey();
    }

    @Override
    public Key maxKey() {
        return maxEntry().getKey();
    }

    @Override
    public Entry<Key, Value> minEntry() {
        if (root == null) return null;
        BSTNode<Key, Value> node = root;

        while (node.getLeft() != null) node = node.getLeft();

        return new Entry<>(node.getKey(), node.getValue());
    }

    @Override
    public Entry<Key, Value> maxEntry() {
        if (root == null) return null;
        BSTNode<Key, Value> node = root;

        while (node.getRight() != null) node = node.getRight();

        return new Entry<>(node.getKey(), node.getValue());
    }

    @Override
    public void delete(Key key) {
        root = delete(key, root);
    }

    private BSTNode<Key, Value> delete(Key key, BSTNode<Key, Value> root) {
        if (root == null) return null;

        int result = root.getKey().compareTo(key);

        if (result > 0)
            root.setLeft(delete(key, root.getLeft()));
        else if (result < 0)
            root.setRight(delete(key, root.getRight()));
        else {
            if (root.getLeft() == null) return root.getRight();
            if (root.getRight() == null) return root.getLeft();

            BSTNode<Key, Value> min = min(root);
            min.setRight(root.getRight());
            min.setLeft(root.getLeft());

            root = min;
        }

        int newRank = 1 + size(root.getLeft()) + size(root.getRight());
        root.setRank(newRank);
        return root;
    }

    @Override
    public void deleteMin() {
        if (root == null) return;
        root = deleteMin(root);
    }

    @Override
    public void deleteMax() {
        if (root == null) return;
        root = deleteMax(root);
    }

    private BSTNode<Key, Value> put(BSTNode<Key, Value> root, Key key, Value value) {
        if (root == null) {
            BSTNode<Key, Value> node = new BSTNode<>(key, value);
            node.setRank(1);
            return node;
        }

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

    private BSTNode<Key, Value> deleteMin(BSTNode<Key, Value> root) {
        if (root.getLeft() == null) return root.getRight();

        deleteMin(root.getLeft());
        int newRank = 1 + size(root.getLeft()) + size(root.getRight());
        root.setRank(newRank);

        return root;
    }

    private BSTNode<Key, Value> deleteMax(BSTNode<Key, Value> root) {
        if (root.getRight() == null) return root.getLeft();

        deleteMax(root.getRight());
        int newRank = 1 + size(root.getLeft()) + size(root.getRight());
        root.setRank(newRank);

        return root;
    }

    private BSTNode<Key, Value> min(BSTNode<Key, Value> root) {
        if (root == null) return null;

        BSTNode<Key, Value> minNode = root;
        while (minNode != null && minNode.getLeft() != null) minNode = minNode.getLeft();

        return minNode;
    }

}

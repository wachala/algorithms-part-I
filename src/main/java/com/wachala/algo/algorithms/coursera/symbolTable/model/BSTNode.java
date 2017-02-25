package com.wachala.algo.algorithms.coursera.symbolTable.model;

public class BSTNode<Key extends Comparable<Key>, Value> {
    private Key key;
    private Value value;
    private int rank;
    private BSTNode<Key, Value> left;
    private BSTNode<Key, Value> right;

    public BSTNode(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public BSTNode<Key, Value> getLeft() {
        return left;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setLeft(BSTNode<Key, Value> left) {
        this.left = left;
    }

    public BSTNode<Key, Value> getRight() {
        return right;
    }

    public void setRight(BSTNode<Key, Value> right) {
        this.right = right;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}


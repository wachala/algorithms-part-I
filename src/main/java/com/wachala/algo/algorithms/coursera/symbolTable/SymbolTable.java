package com.wachala.algo.algorithms.coursera.symbolTable;

import com.wachala.algo.algorithms.coursera.symbolTable.model.Entry;

public interface SymbolTable<Key extends Comparable<Key>, Value> {

    void put(Key key, Value value);

    Iterable<Key> keys();

    Iterable<Value> values();

    Iterable<Entry<Key, Value>> entrySet();

    int rank(Key key);

    int size();

    Value get(Key key);

    Key minKey();

    Key maxKey();

    Entry<Key, Value> minEntry();

    Entry<Key, Value> maxEntry();
}

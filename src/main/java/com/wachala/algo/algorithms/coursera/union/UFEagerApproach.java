package com.wachala.algo.algorithms.coursera.union;

public class UFEagerApproach {
    private int components[];

    UFEagerApproach(int N) {
        components = new int[N];

        for (int i = 0; i < N; i++) components[i] = i;
    }

    void union(int first, int second) {
        if (connected(first, second))
            return;

        int firstComponent = components[first];
        int toChange = components[second];

        for (int i = 0; i < components.length; i++) {
            if (components[i] == toChange)
                components[i] = firstComponent;
        }
    }

    boolean connected(int first, int second) {
        return components[first] == components[second];
    }
}

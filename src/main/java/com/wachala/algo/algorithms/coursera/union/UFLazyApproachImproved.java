package com.wachala.algo.algorithms.coursera.union;

public class UFLazyApproachImproved {
    private int components[];
    private int sizes[];

    public UFLazyApproachImproved(int N) {
        components = new int[N];
        sizes = new int[N];

        for (int i = 0; i < N; i++) {
            components[i] = i;
            sizes[i] = 1;
        }
    }

    private int root(int i) {
        while (components[i] != i) {
            components[i] = components[components[i]];
            i = components[i];
        }
        return i;
    }

    public void union(int first, int second) {
        int rootFirst = root(first);
        int rootSecond = root(second);

        if (sizes[rootFirst] < sizes[rootSecond]) {
            components[rootFirst] = rootSecond;
            sizes[rootSecond] += sizes[rootFirst];
        } else {
            components[rootSecond] = rootFirst;
            sizes[rootFirst] += sizes[rootSecond];
        }
    }

    public boolean connected(int first, int second) {
        return root(first) == root(second);
    }

}

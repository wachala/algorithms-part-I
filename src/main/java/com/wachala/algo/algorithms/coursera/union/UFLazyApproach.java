package com.wachala.algo.algorithms.coursera.union;

public class UFLazyApproach {
    private int components[];

    public UFLazyApproach(int N) {
        components = new int[N];
        for (int i = 0; i < N; i++)
            components[i] = i;
    }

    private int root(int i) {
        while (components[i] != i)
            i = components[i];
        return i;
    }

    public void union(int first, int second) {
        int rootFirst = root(first);
        int rootSecond = root(second);

        components[rootFirst] = rootSecond;
    }

    public boolean connected(int first, int second) {
        return root(first) == root(second);
    }

}

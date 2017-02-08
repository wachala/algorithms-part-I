package com.wachala.algo.algorithms.coursera.sorting.quicksort;

import java.util.function.BiPredicate;

public class Quicksort {

    private static final BiPredicate<Comparable, Comparable> isLess = (a, b) -> a.compareTo(b) < 0;

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static int partition(Comparable[] array, int start, int end) {
        int i = start;
        int j = end;

        while (true) {
            while (isLess.test(array[i], array[start])) {
                i++;
                if (i == end) break;
            }

            while (isLess.test(array[start], array[j])) {
                j--;
                if (j == start) break;
            }

            if(i>=j) break;

            swap(array, i, j);
        }

        swap(array, i, start);
        return i;
    }

    private static void sort(Comparable[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIndex = partition(array, start, end);

        sort(array, start, pivotIndex - 1);
        sort(array, pivotIndex + 1, end);
    }

    private static void swap(Comparable[] array, int i, int j){
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

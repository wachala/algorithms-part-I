package com.wachala.algo.algorithms.coursera.sorting.quicksort;

public class QuickSortThreeWayPartitioning {
    public static void sort(Comparable array[]) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(Comparable array[], int start, int end) {
        if (start >= end) {
            return;
        }

        Comparable pivot = array[start];
        int l = start;
        int h = end;
        int i = start;

        while (i <= h) {
            int result = array[i].compareTo(pivot);

            if (result < 0) swap(array, i++, l++);
            else if (result > 0) swap(array, i, h--);
            else i++;
        }

        sort(array, start, l - 1);
        sort(array, h + 1, end);
    }

    private static void swap(Comparable array[], int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

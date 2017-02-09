package com.wachala.algo.algorithms.coursera.sorting.quicksort;

public class QuickSortWithInsertion extends Quicksort {

    private static final int CUTOFF_COEFF = 20;

    private static void sort(Comparable[] array, int start, int end) {
        if(start>=end) {
            return;
        }

        if(end-start<= CUTOFF_COEFF){
            InsertionSort.sort(array,start,end);
            return;
        }

        int partition = partition(array, start, end);
        sort(array, start, partition-1);
        sort(array, partition+1, end);
    }
}
